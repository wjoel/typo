/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
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

object PersonphoneRepoImpl extends PersonphoneRepo {
  override def delete(compositeId: PersonphoneId): ConnectionIO[Boolean] = {
    sql"delete from person.personphone where businessentityid = ${compositeId.businessentityid} AND phonenumber = ${compositeId.phonenumber} AND phonenumbertypeid = ${compositeId.phonenumbertypeid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PersonphoneRow): ConnectionIO[PersonphoneRow] = {
    sql"""insert into person.personphone(businessentityid, phonenumber, phonenumbertypeid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.phonenumber}::"public".Phone, ${unsaved.phonenumbertypeid}::int4, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, phonenumber, phonenumbertypeid, modifieddate
       """.query.unique
  }
  override def insert(unsaved: PersonphoneRowUnsaved): ConnectionIO[PersonphoneRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${unsaved.businessentityid}::int4")),
      Some((Fragment.const(s"phonenumber"), fr"""${unsaved.phonenumber}::"public".Phone""")),
      Some((Fragment.const(s"phonenumbertypeid"), fr"${unsaved.phonenumbertypeid}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.personphone default values
            returning businessentityid, phonenumber, phonenumbertypeid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.personphone(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, phonenumber, phonenumbertypeid, modifieddate
         """
    }
    q.query.unique
  
  }
  override def selectAll: Stream[ConnectionIO, PersonphoneRow] = {
    sql"select businessentityid, phonenumber, phonenumbertypeid, modifieddate from person.personphone".query[PersonphoneRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PersonphoneFieldOrIdValue[_]]): Stream[ConnectionIO, PersonphoneRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PersonphoneFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case PersonphoneFieldValue.phonenumber(value) => fr"phonenumber = $value"
        case PersonphoneFieldValue.phonenumbertypeid(value) => fr"phonenumbertypeid = $value"
        case PersonphoneFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from person.personphone $where".query[PersonphoneRow].stream
  
  }
  override def selectById(compositeId: PersonphoneId): ConnectionIO[Option[PersonphoneRow]] = {
    sql"select businessentityid, phonenumber, phonenumbertypeid, modifieddate from person.personphone where businessentityid = ${compositeId.businessentityid} AND phonenumber = ${compositeId.phonenumber} AND phonenumbertypeid = ${compositeId.phonenumbertypeid}".query[PersonphoneRow].option
  }
  override def update(row: PersonphoneRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.personphone
          set modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND phonenumber = ${compositeId.phonenumber} AND phonenumbertypeid = ${compositeId.phonenumbertypeid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(compositeId: PersonphoneId, fieldValues: List[PersonphoneFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case PersonphoneFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update person.personphone
              $updates
              where businessentityid = ${compositeId.businessentityid} AND phonenumber = ${compositeId.phonenumber} AND phonenumbertypeid = ${compositeId.phonenumbertypeid}
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: PersonphoneRow): ConnectionIO[PersonphoneRow] = {
    sql"""insert into person.personphone(businessentityid, phonenumber, phonenumbertypeid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.phonenumber}::"public".Phone,
            ${unsaved.phonenumbertypeid}::int4,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, phonenumber, phonenumbertypeid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, phonenumber, phonenumbertypeid, modifieddate
       """.query.unique
  }
  implicit val read: Read[PersonphoneRow] =
    new Read[PersonphoneRow](
      gets = List(
        (Get[BusinessentityId], Nullability.NoNulls),
        (Get[Phone], Nullability.NoNulls),
        (Get[PhonenumbertypeId], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PersonphoneRow(
        businessentityid = Get[BusinessentityId].unsafeGetNonNullable(rs, i + 0),
        phonenumber = Get[Phone].unsafeGetNonNullable(rs, i + 1),
        phonenumbertypeid = Get[PhonenumbertypeId].unsafeGetNonNullable(rs, i + 2),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 3)
      )
    )
  

}