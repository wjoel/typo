/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
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

object ProductdescriptionRepoImpl extends ProductdescriptionRepo {
  override def delete(productdescriptionid: ProductdescriptionId): ConnectionIO[Boolean] = {
    sql"delete from production.productdescription where productdescriptionid = ${fromWrite(productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    DeleteBuilder("production.productdescription", ProductdescriptionFields)
  }
  override def insert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow] = {
    sql"""insert into production.productdescription(productdescriptionid, description, rowguid, modifieddate)
          values (${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4, ${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning productdescriptionid, description, rowguid, modifieddate::text
       """.query(ProductdescriptionRow.read).unique
  }
  override def insert(unsaved: ProductdescriptionRowUnsaved): ConnectionIO[ProductdescriptionRow] = {
    val fs = List(
      Some((Fragment.const(s"description"), fr"${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))}")),
      unsaved.productdescriptionid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"productdescriptionid"), fr"${fromWrite(value: ProductdescriptionId)(Write.fromPut(ProductdescriptionId.put))}::int4"))
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
      sql"""insert into production.productdescription default values
            returning productdescriptionid, description, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productdescription(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productdescriptionid, description, rowguid, modifieddate::text
         """
    }
    q.query(ProductdescriptionRow.read).unique
    
  }
  override def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    SelectBuilderSql("production.productdescription", ProductdescriptionFields, ProductdescriptionRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductdescriptionRow] = {
    sql"select productdescriptionid, description, rowguid, modifieddate::text from production.productdescription".query(ProductdescriptionRow.read).stream
  }
  override def selectById(productdescriptionid: ProductdescriptionId): ConnectionIO[Option[ProductdescriptionRow]] = {
    sql"select productdescriptionid, description, rowguid, modifieddate::text from production.productdescription where productdescriptionid = ${fromWrite(productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}".query(ProductdescriptionRow.read).option
  }
  override def selectByIds(productdescriptionids: Array[ProductdescriptionId]): Stream[ConnectionIO, ProductdescriptionRow] = {
    sql"select productdescriptionid, description, rowguid, modifieddate::text from production.productdescription where productdescriptionid = ANY(${fromWrite(productdescriptionids)(Write.fromPut(ProductdescriptionId.arrayPut))})".query(ProductdescriptionRow.read).stream
  }
  override def update(row: ProductdescriptionRow): ConnectionIO[Boolean] = {
    val productdescriptionid = row.productdescriptionid
    sql"""update production.productdescription
          set description = ${fromWrite(row.description)(Write.fromPut(Meta.StringMeta.put))},
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where productdescriptionid = ${fromWrite(productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    UpdateBuilder("production.productdescription", ProductdescriptionFields, ProductdescriptionRow.read)
  }
  override def upsert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow] = {
    sql"""insert into production.productdescription(productdescriptionid, description, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4,
            ${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (productdescriptionid)
          do update set
            description = EXCLUDED.description,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productdescriptionid, description, rowguid, modifieddate::text
       """.query(ProductdescriptionRow.read).unique
  }
}
