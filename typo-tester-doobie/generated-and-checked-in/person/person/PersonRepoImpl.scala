/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.Defaulted
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

object PersonRepoImpl extends PersonRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"delete from person.person where businessentityid = $businessentityid".update.run.map(_ > 0)
  }
  override def insert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into person.person(businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.persontype}::bpchar, ${unsaved.namestyle}::"public".NameStyle, ${unsaved.title}, ${unsaved.firstname}::"public"."Name", ${unsaved.middlename}::"public"."Name", ${unsaved.lastname}::"public"."Name", ${unsaved.suffix}, ${unsaved.emailpromotion}::int4, ${unsaved.additionalcontactinfo}::xml, ${unsaved.demographics}::xml, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate
       """.query.unique
  }
  override def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${unsaved.businessentityid}::int4")),
      Some((Fragment.const(s"persontype"), fr"${unsaved.persontype}::bpchar")),
      Some((Fragment.const(s"title"), fr"${unsaved.title}")),
      Some((Fragment.const(s"firstname"), fr"""${unsaved.firstname}::"public"."Name"""")),
      Some((Fragment.const(s"middlename"), fr"""${unsaved.middlename}::"public"."Name"""")),
      Some((Fragment.const(s"lastname"), fr"""${unsaved.lastname}::"public"."Name"""")),
      Some((Fragment.const(s"suffix"), fr"${unsaved.suffix}")),
      Some((Fragment.const(s"additionalcontactinfo"), fr"${unsaved.additionalcontactinfo}::xml")),
      Some((Fragment.const(s"demographics"), fr"${unsaved.demographics}::xml")),
      unsaved.namestyle match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"namestyle"), fr"""${value: NameStyle}::"public".NameStyle"""))
      },
      unsaved.emailpromotion match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"emailpromotion"), fr"${value: Int}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.person default values
            returning businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.person(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate
         """
    }
    q.query.unique
  
  }
  override def selectAll: Stream[ConnectionIO, PersonRow] = {
    sql"select businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate from person.person".query[PersonRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[_]]): Stream[ConnectionIO, PersonRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PersonFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case PersonFieldValue.persontype(value) => fr"persontype = $value"
        case PersonFieldValue.namestyle(value) => fr"namestyle = $value"
        case PersonFieldValue.title(value) => fr"title = $value"
        case PersonFieldValue.firstname(value) => fr"firstname = $value"
        case PersonFieldValue.middlename(value) => fr"middlename = $value"
        case PersonFieldValue.lastname(value) => fr"lastname = $value"
        case PersonFieldValue.suffix(value) => fr"suffix = $value"
        case PersonFieldValue.emailpromotion(value) => fr"emailpromotion = $value"
        case PersonFieldValue.additionalcontactinfo(value) => fr"additionalcontactinfo = $value"
        case PersonFieldValue.demographics(value) => fr"demographics = $value"
        case PersonFieldValue.rowguid(value) => fr"rowguid = $value"
        case PersonFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from person.person $where".query[PersonRow].stream
  
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[PersonRow]] = {
    sql"select businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate from person.person where businessentityid = $businessentityid".query[PersonRow].option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, PersonRow] = {
    sql"select businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate from person.person where businessentityid = ANY($businessentityids)".query[PersonRow].stream
  }
  override def update(row: PersonRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.person
          set persontype = ${row.persontype}::bpchar,
              namestyle = ${row.namestyle}::"public".NameStyle,
              title = ${row.title},
              firstname = ${row.firstname}::"public"."Name",
              middlename = ${row.middlename}::"public"."Name",
              lastname = ${row.lastname}::"public"."Name",
              suffix = ${row.suffix},
              emailpromotion = ${row.emailpromotion}::int4,
              additionalcontactinfo = ${row.additionalcontactinfo}::xml,
              demographics = ${row.demographics}::xml,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = $businessentityid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[PersonFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case PersonFieldValue.persontype(value) => fr"persontype = $value"
            case PersonFieldValue.namestyle(value) => fr"namestyle = $value"
            case PersonFieldValue.title(value) => fr"title = $value"
            case PersonFieldValue.firstname(value) => fr"firstname = $value"
            case PersonFieldValue.middlename(value) => fr"middlename = $value"
            case PersonFieldValue.lastname(value) => fr"lastname = $value"
            case PersonFieldValue.suffix(value) => fr"suffix = $value"
            case PersonFieldValue.emailpromotion(value) => fr"emailpromotion = $value"
            case PersonFieldValue.additionalcontactinfo(value) => fr"additionalcontactinfo = $value"
            case PersonFieldValue.demographics(value) => fr"demographics = $value"
            case PersonFieldValue.rowguid(value) => fr"rowguid = $value"
            case PersonFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update person.person
              $updates
              where businessentityid = $businessentityid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into person.person(businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.persontype}::bpchar,
            ${unsaved.namestyle}::"public".NameStyle,
            ${unsaved.title},
            ${unsaved.firstname}::"public"."Name",
            ${unsaved.middlename}::"public"."Name",
            ${unsaved.lastname}::"public"."Name",
            ${unsaved.suffix},
            ${unsaved.emailpromotion}::int4,
            ${unsaved.additionalcontactinfo}::xml,
            ${unsaved.demographics}::xml,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid)
          do update set
            persontype = EXCLUDED.persontype,
            namestyle = EXCLUDED.namestyle,
            title = EXCLUDED.title,
            firstname = EXCLUDED.firstname,
            middlename = EXCLUDED.middlename,
            lastname = EXCLUDED.lastname,
            suffix = EXCLUDED.suffix,
            emailpromotion = EXCLUDED.emailpromotion,
            additionalcontactinfo = EXCLUDED.additionalcontactinfo,
            demographics = EXCLUDED.demographics,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate
       """.query.unique
  }
  implicit val read: Read[PersonRow] =
    new Read[PersonRow](
      gets = List(
        (Get[BusinessentityId], Nullability.NoNulls),
        (Get[/* bpchar */ String], Nullability.NoNulls),
        (Get[NameStyle], Nullability.NoNulls),
        (Get[String], Nullability.Nullable),
        (Get[Name], Nullability.NoNulls),
        (Get[Name], Nullability.Nullable),
        (Get[Name], Nullability.NoNulls),
        (Get[String], Nullability.Nullable),
        (Get[Int], Nullability.NoNulls),
        (Get[TypoXml], Nullability.Nullable),
        (Get[TypoXml], Nullability.Nullable),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PersonRow(
        businessentityid = Get[BusinessentityId].unsafeGetNonNullable(rs, i + 0),
        persontype = Get[/* bpchar */ String].unsafeGetNonNullable(rs, i + 1),
        namestyle = Get[NameStyle].unsafeGetNonNullable(rs, i + 2),
        title = Get[String].unsafeGetNullable(rs, i + 3),
        firstname = Get[Name].unsafeGetNonNullable(rs, i + 4),
        middlename = Get[Name].unsafeGetNullable(rs, i + 5),
        lastname = Get[Name].unsafeGetNonNullable(rs, i + 6),
        suffix = Get[String].unsafeGetNullable(rs, i + 7),
        emailpromotion = Get[Int].unsafeGetNonNullable(rs, i + 8),
        additionalcontactinfo = Get[TypoXml].unsafeGetNullable(rs, i + 9),
        demographics = Get[TypoXml].unsafeGetNullable(rs, i + 10),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 11),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 12)
      )
    )
  

}
