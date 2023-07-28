/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import java.util.UUID

object AddresstypeRepoImpl extends AddresstypeRepo {
  override def delete(addresstypeid: AddresstypeId): ConnectionIO[Boolean] = {
    sql"delete from person.addresstype where addresstypeid = ${fromWrite(addresstypeid)(Write.fromPut(AddresstypeId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: AddresstypeRow): ConnectionIO[AddresstypeRow] = {
    sql"""insert into person.addresstype(addresstypeid, "name", rowguid, modifieddate)
          values (${fromWrite(unsaved.addresstypeid)(Write.fromPut(AddresstypeId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning addresstypeid, "name", rowguid, modifieddate::text
       """.query(AddresstypeRow.read).unique
  }
  override def insert(unsaved: AddresstypeRowUnsaved): ConnectionIO[AddresstypeRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name"""")),
      unsaved.addresstypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"addresstypeid"), fr"${fromWrite(value: AddresstypeId)(Write.fromPut(AddresstypeId.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.addresstype default values
            returning addresstypeid, "name", rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.addresstype(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning addresstypeid, "name", rowguid, modifieddate::text
         """
    }
    q.query(AddresstypeRow.read).unique
  
  }
  override def selectAll: Stream[ConnectionIO, AddresstypeRow] = {
    sql"""select addresstypeid, "name", rowguid, modifieddate::text from person.addresstype""".query(AddresstypeRow.read).stream
  }
  override def selectById(addresstypeid: AddresstypeId): ConnectionIO[Option[AddresstypeRow]] = {
    sql"""select addresstypeid, "name", rowguid, modifieddate::text from person.addresstype where addresstypeid = ${fromWrite(addresstypeid)(Write.fromPut(AddresstypeId.put))}""".query(AddresstypeRow.read).option
  }
  override def selectByIds(addresstypeids: Array[AddresstypeId]): Stream[ConnectionIO, AddresstypeRow] = {
    sql"""select addresstypeid, "name", rowguid, modifieddate::text from person.addresstype where addresstypeid = ANY(${fromWrite(addresstypeids)(Write.fromPut(AddresstypeId.arrayPut))})""".query(AddresstypeRow.read).stream
  }
  override def update(row: AddresstypeRow): ConnectionIO[Boolean] = {
    val addresstypeid = row.addresstypeid
    sql"""update person.addresstype
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::"public"."Name",
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where addresstypeid = ${fromWrite(addresstypeid)(Write.fromPut(AddresstypeId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: AddresstypeRow): ConnectionIO[AddresstypeRow] = {
    sql"""insert into person.addresstype(addresstypeid, "name", rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.addresstypeid)(Write.fromPut(AddresstypeId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (addresstypeid)
          do update set
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning addresstypeid, "name", rowguid, modifieddate::text
       """.query(AddresstypeRow.read).unique
  }
}
