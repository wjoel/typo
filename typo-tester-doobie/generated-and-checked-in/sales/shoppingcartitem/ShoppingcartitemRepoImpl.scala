/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ShoppingcartitemRepoImpl extends ShoppingcartitemRepo {
  override def delete(shoppingcartitemid: ShoppingcartitemId): ConnectionIO[Boolean] = {
    sql"delete from sales.shoppingcartitem where shoppingcartitemid = ${fromWrite(shoppingcartitemid)(Write.fromPut(ShoppingcartitemId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    DeleteBuilder("sales.shoppingcartitem", ShoppingcartitemFields)
  }
  override def insert(unsaved: ShoppingcartitemRow): ConnectionIO[ShoppingcartitemRow] = {
    sql"""insert into sales.shoppingcartitem(shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate)
          values (${fromWrite(unsaved.shoppingcartitemid)(Write.fromPut(ShoppingcartitemId.put))}::int4, ${fromWrite(unsaved.shoppingcartid)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.quantity)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.datecreated)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated::text, modifieddate::text
       """.query(ShoppingcartitemRow.read).unique
  }
  override def insert(unsaved: ShoppingcartitemRowUnsaved): ConnectionIO[ShoppingcartitemRow] = {
    val fs = List(
      Some((Fragment.const(s"shoppingcartid"), fr"${fromWrite(unsaved.shoppingcartid)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"productid"), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      unsaved.shoppingcartitemid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shoppingcartitemid"), fr"${fromWrite(value: ShoppingcartitemId)(Write.fromPut(ShoppingcartitemId.put))}::int4"))
      },
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"quantity"), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
      },
      unsaved.datecreated match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"datecreated"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.shoppingcartitem default values
            returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated::text, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.shoppingcartitem(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated::text, modifieddate::text
         """
    }
    q.query(ShoppingcartitemRow.read).unique
    
  }
  override def select: SelectBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    SelectBuilderSql("sales.shoppingcartitem", ShoppingcartitemFields, ShoppingcartitemRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ShoppingcartitemRow] = {
    sql"select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated::text, modifieddate::text from sales.shoppingcartitem".query(ShoppingcartitemRow.read).stream
  }
  override def selectById(shoppingcartitemid: ShoppingcartitemId): ConnectionIO[Option[ShoppingcartitemRow]] = {
    sql"select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated::text, modifieddate::text from sales.shoppingcartitem where shoppingcartitemid = ${fromWrite(shoppingcartitemid)(Write.fromPut(ShoppingcartitemId.put))}".query(ShoppingcartitemRow.read).option
  }
  override def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId]): Stream[ConnectionIO, ShoppingcartitemRow] = {
    sql"select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated::text, modifieddate::text from sales.shoppingcartitem where shoppingcartitemid = ANY(${fromWrite(shoppingcartitemids)(Write.fromPut(ShoppingcartitemId.arrayPut))})".query(ShoppingcartitemRow.read).stream
  }
  override def update(row: ShoppingcartitemRow): ConnectionIO[Boolean] = {
    val shoppingcartitemid = row.shoppingcartitemid
    sql"""update sales.shoppingcartitem
          set shoppingcartid = ${fromWrite(row.shoppingcartid)(Write.fromPut(Meta.StringMeta.put))},
              quantity = ${fromWrite(row.quantity)(Write.fromPut(Meta.IntMeta.put))}::int4,
              productid = ${fromWrite(row.productid)(Write.fromPut(ProductId.put))}::int4,
              datecreated = ${fromWrite(row.datecreated)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where shoppingcartitemid = ${fromWrite(shoppingcartitemid)(Write.fromPut(ShoppingcartitemId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    UpdateBuilder("sales.shoppingcartitem", ShoppingcartitemFields, ShoppingcartitemRow.read)
  }
  override def upsert(unsaved: ShoppingcartitemRow): ConnectionIO[ShoppingcartitemRow] = {
    sql"""insert into sales.shoppingcartitem(shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate)
          values (
            ${fromWrite(unsaved.shoppingcartitemid)(Write.fromPut(ShoppingcartitemId.put))}::int4,
            ${fromWrite(unsaved.shoppingcartid)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.quantity)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.datecreated)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (shoppingcartitemid)
          do update set
            shoppingcartid = EXCLUDED.shoppingcartid,
            quantity = EXCLUDED.quantity,
            productid = EXCLUDED.productid,
            datecreated = EXCLUDED.datecreated,
            modifieddate = EXCLUDED.modifieddate
          returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated::text, modifieddate::text
       """.query(ShoppingcartitemRow.read).unique
  }
}
