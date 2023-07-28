/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream

object ProductvendorRepoImpl extends ProductvendorRepo {
  override def delete(compositeId: ProductvendorId): ConnectionIO[Boolean] = {
    sql"delete from purchasing.productvendor where productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductvendorRow): ConnectionIO[ProductvendorRow] = {
    sql"""insert into purchasing.productvendor(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.averageleadtime)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.standardprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.lastreceiptcost)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.lastreceiptdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.minorderqty)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.maxorderqty)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.onorderqty)(Write.fromPutOption(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
       """.query(ProductvendorRow.read).unique
  }
  override def insert(unsaved: ProductvendorRowUnsaved): ConnectionIO[ProductvendorRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const(s"businessentityid"), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s"averageleadtime"), fr"${fromWrite(unsaved.averageleadtime)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const(s"standardprice"), fr"${fromWrite(unsaved.standardprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s"lastreceiptcost"), fr"${fromWrite(unsaved.lastreceiptcost)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s"lastreceiptdate"), fr"${fromWrite(unsaved.lastreceiptdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s"minorderqty"), fr"${fromWrite(unsaved.minorderqty)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const(s"maxorderqty"), fr"${fromWrite(unsaved.maxorderqty)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const(s"onorderqty"), fr"${fromWrite(unsaved.onorderqty)(Write.fromPutOption(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const(s"unitmeasurecode"), fr"${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into purchasing.productvendor default values
            returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into purchasing.productvendor(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
         """
    }
    q.query(ProductvendorRow.read).unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductvendorRow] = {
    sql"select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text from purchasing.productvendor".query(ProductvendorRow.read).stream
  }
  override def selectById(compositeId: ProductvendorId): ConnectionIO[Option[ProductvendorRow]] = {
    sql"select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text from purchasing.productvendor where productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))}".query(ProductvendorRow.read).option
  }
  override def update(row: ProductvendorRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update purchasing.productvendor
          set averageleadtime = ${fromWrite(row.averageleadtime)(Write.fromPut(Meta.IntMeta.put))}::int4,
              standardprice = ${fromWrite(row.standardprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              lastreceiptcost = ${fromWrite(row.lastreceiptcost)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              lastreceiptdate = ${fromWrite(row.lastreceiptdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              minorderqty = ${fromWrite(row.minorderqty)(Write.fromPut(Meta.IntMeta.put))}::int4,
              maxorderqty = ${fromWrite(row.maxorderqty)(Write.fromPut(Meta.IntMeta.put))}::int4,
              onorderqty = ${fromWrite(row.onorderqty)(Write.fromPutOption(Meta.IntMeta.put))}::int4,
              unitmeasurecode = ${fromWrite(row.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductvendorRow): ConnectionIO[ProductvendorRow] = {
    sql"""insert into purchasing.productvendor(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.averageleadtime)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.standardprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.lastreceiptcost)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.lastreceiptdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.minorderqty)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.maxorderqty)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.onorderqty)(Write.fromPutOption(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (productid, businessentityid)
          do update set
            averageleadtime = EXCLUDED.averageleadtime,
            standardprice = EXCLUDED.standardprice,
            lastreceiptcost = EXCLUDED.lastreceiptcost,
            lastreceiptdate = EXCLUDED.lastreceiptdate,
            minorderqty = EXCLUDED.minorderqty,
            maxorderqty = EXCLUDED.maxorderqty,
            onorderqty = EXCLUDED.onorderqty,
            unitmeasurecode = EXCLUDED.unitmeasurecode,
            modifieddate = EXCLUDED.modifieddate
          returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
       """.query(ProductvendorRow.read).unique
  }
}
