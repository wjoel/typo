/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID

object ProductinventoryRepoImpl extends ProductinventoryRepo {
  override def delete(compositeId: ProductinventoryId): ConnectionIO[Boolean] = {
    sql"delete from production.productinventory where productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND locationid = ${fromWrite(compositeId.locationid)(Write.fromPut(LocationId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    sql"""insert into production.productinventory(productid, locationid, shelf, bin, quantity, rowguid, modifieddate)
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2, ${fromWrite(unsaved.shelf)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.bin)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.quantity)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning productid, locationid, shelf, bin, quantity, rowguid, modifieddate::text
       """.query(ProductinventoryRow.read).unique
  }
  override def insert(unsaved: ProductinventoryRowUnsaved): ConnectionIO[ProductinventoryRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const(s"locationid"), fr"${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2")),
      Some((Fragment.const(s"shelf"), fr"${fromWrite(unsaved.shelf)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"bin"), fr"${fromWrite(unsaved.bin)(Write.fromPut(Meta.IntMeta.put))}::int2")),
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"quantity"), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int2"))
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
      sql"""insert into production.productinventory default values
            returning productid, locationid, shelf, bin, quantity, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productinventory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productid, locationid, shelf, bin, quantity, rowguid, modifieddate::text
         """
    }
    q.query(ProductinventoryRow.read).unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductinventoryRow] = {
    sql"select productid, locationid, shelf, bin, quantity, rowguid, modifieddate::text from production.productinventory".query(ProductinventoryRow.read).stream
  }
  override def selectById(compositeId: ProductinventoryId): ConnectionIO[Option[ProductinventoryRow]] = {
    sql"select productid, locationid, shelf, bin, quantity, rowguid, modifieddate::text from production.productinventory where productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND locationid = ${fromWrite(compositeId.locationid)(Write.fromPut(LocationId.put))}".query(ProductinventoryRow.read).option
  }
  override def update(row: ProductinventoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productinventory
          set shelf = ${fromWrite(row.shelf)(Write.fromPut(Meta.StringMeta.put))},
              bin = ${fromWrite(row.bin)(Write.fromPut(Meta.IntMeta.put))}::int2,
              quantity = ${fromWrite(row.quantity)(Write.fromPut(Meta.IntMeta.put))}::int2,
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND locationid = ${fromWrite(compositeId.locationid)(Write.fromPut(LocationId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    sql"""insert into production.productinventory(productid, locationid, shelf, bin, quantity, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2,
            ${fromWrite(unsaved.shelf)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.bin)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.quantity)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (productid, locationid)
          do update set
            shelf = EXCLUDED.shelf,
            bin = EXCLUDED.bin,
            quantity = EXCLUDED.quantity,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productid, locationid, shelf, bin, quantity, rowguid, modifieddate::text
       """.query(ProductinventoryRow.read).unique
  }
}
