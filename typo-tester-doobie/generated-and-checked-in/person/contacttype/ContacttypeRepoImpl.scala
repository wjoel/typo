/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream

object ContacttypeRepoImpl extends ContacttypeRepo {
  override def delete(contacttypeid: ContacttypeId): ConnectionIO[Boolean] = {
    sql"delete from person.contacttype where contacttypeid = ${fromWrite(contacttypeid)(Write.fromPut(ContacttypeId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ContacttypeRow): ConnectionIO[ContacttypeRow] = {
    sql"""insert into person.contacttype(contacttypeid, "name", modifieddate)
          values (${fromWrite(unsaved.contacttypeid)(Write.fromPut(ContacttypeId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning contacttypeid, "name", modifieddate::text
       """.query(ContacttypeRow.read).unique
  }
  override def insert(unsaved: ContacttypeRowUnsaved): ConnectionIO[ContacttypeRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name"""")),
      unsaved.contacttypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"contacttypeid"), fr"${fromWrite(value: ContacttypeId)(Write.fromPut(ContacttypeId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.contacttype default values
            returning contacttypeid, "name", modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.contacttype(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning contacttypeid, "name", modifieddate::text
         """
    }
    q.query(ContacttypeRow.read).unique
  
  }
  override def selectAll: Stream[ConnectionIO, ContacttypeRow] = {
    sql"""select contacttypeid, "name", modifieddate::text from person.contacttype""".query(ContacttypeRow.read).stream
  }
  override def selectById(contacttypeid: ContacttypeId): ConnectionIO[Option[ContacttypeRow]] = {
    sql"""select contacttypeid, "name", modifieddate::text from person.contacttype where contacttypeid = ${fromWrite(contacttypeid)(Write.fromPut(ContacttypeId.put))}""".query(ContacttypeRow.read).option
  }
  override def selectByIds(contacttypeids: Array[ContacttypeId]): Stream[ConnectionIO, ContacttypeRow] = {
    sql"""select contacttypeid, "name", modifieddate::text from person.contacttype where contacttypeid = ANY(${fromWrite(contacttypeids)(Write.fromPut(ContacttypeId.arrayPut))})""".query(ContacttypeRow.read).stream
  }
  override def update(row: ContacttypeRow): ConnectionIO[Boolean] = {
    val contacttypeid = row.contacttypeid
    sql"""update person.contacttype
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::"public"."Name",
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where contacttypeid = ${fromWrite(contacttypeid)(Write.fromPut(ContacttypeId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ContacttypeRow): ConnectionIO[ContacttypeRow] = {
    sql"""insert into person.contacttype(contacttypeid, "name", modifieddate)
          values (
            ${fromWrite(unsaved.contacttypeid)(Write.fromPut(ContacttypeId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (contacttypeid)
          do update set
            "name" = EXCLUDED."name",
            modifieddate = EXCLUDED.modifieddate
          returning contacttypeid, "name", modifieddate::text
       """.query(ContacttypeRow.read).unique
  }
}
