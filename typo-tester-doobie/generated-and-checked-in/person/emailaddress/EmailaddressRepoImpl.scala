/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object EmailaddressRepoImpl extends EmailaddressRepo {
  override def delete(compositeId: EmailaddressId): ConnectionIO[Boolean] = {
    sql"delete from person.emailaddress where businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND emailaddressid = ${fromWrite(compositeId.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow] = {
    DeleteBuilder("person.emailaddress", EmailaddressFields)
  }
  override def insert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {
    sql"""insert into person.emailaddress(businessentityid, emailaddressid, emailaddress, rowguid, modifieddate)
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text
       """.query(EmailaddressRow.read).unique
  }
  override def insert(unsaved: EmailaddressRowUnsaved): ConnectionIO[EmailaddressRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s"emailaddress"), fr"${fromWrite(unsaved.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))}")),
      unsaved.emailaddressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"emailaddressid"), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
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
      sql"""insert into person.emailaddress default values
            returning businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.emailaddress(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text
         """
    }
    q.query(EmailaddressRow.read).unique
    
  }
  override def select: SelectBuilder[EmailaddressFields, EmailaddressRow] = {
    SelectBuilderSql("person.emailaddress", EmailaddressFields, EmailaddressRow.read)
  }
  override def selectAll: Stream[ConnectionIO, EmailaddressRow] = {
    sql"select businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text from person.emailaddress".query(EmailaddressRow.read).stream
  }
  override def selectById(compositeId: EmailaddressId): ConnectionIO[Option[EmailaddressRow]] = {
    sql"select businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text from person.emailaddress where businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND emailaddressid = ${fromWrite(compositeId.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}".query(EmailaddressRow.read).option
  }
  override def update(row: EmailaddressRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.emailaddress
          set emailaddress = ${fromWrite(row.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))},
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND emailaddressid = ${fromWrite(compositeId.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[EmailaddressFields, EmailaddressRow] = {
    UpdateBuilder("person.emailaddress", EmailaddressFields, EmailaddressRow.read)
  }
  override def upsert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {
    sql"""insert into person.emailaddress(businessentityid, emailaddressid, emailaddress, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (businessentityid, emailaddressid)
          do update set
            emailaddress = EXCLUDED.emailaddress,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text
       """.query(EmailaddressRow.read).unique
  }
}
