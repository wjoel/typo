/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
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

object ProductRepoImpl extends ProductRepo {
  override def delete(productid: ProductId): ConnectionIO[Boolean] = {
    sql"delete from production.product where productid = ${fromWrite(productid)(Write.fromPut(ProductId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductFields, ProductRow] = {
    DeleteBuilder("production.product", ProductFields)
  }
  override def insert(unsaved: ProductRow): ConnectionIO[ProductRow] = {
    sql"""insert into production.product(productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate)
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.productnumber)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.makeflag)(Write.fromPut(Flag.put))}::"public"."Flag", ${fromWrite(unsaved.finishedgoodsflag)(Write.fromPut(Flag.put))}::"public"."Flag", ${fromWrite(unsaved.color)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.safetystocklevel)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.reorderpoint)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.size)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.sizeunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar, ${fromWrite(unsaved.weightunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar, ${fromWrite(unsaved.weight)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.daystomanufacture)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.productline)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.`class`)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.style)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.productsubcategoryid)(Write.fromPutOption(ProductsubcategoryId.put))}::int4, ${fromWrite(unsaved.productmodelid)(Write.fromPutOption(ProductmodelId.put))}::int4, ${fromWrite(unsaved.sellstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.sellenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.discontinueddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate::text, sellenddate::text, discontinueddate::text, rowguid, modifieddate::text
       """.query(ProductRow.read).unique
  }
  override def insert(unsaved: ProductRowUnsaved): ConnectionIO[ProductRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name"""")),
      Some((Fragment.const(s"productnumber"), fr"${fromWrite(unsaved.productnumber)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"color"), fr"${fromWrite(unsaved.color)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"safetystocklevel"), fr"${fromWrite(unsaved.safetystocklevel)(Write.fromPut(Meta.IntMeta.put))}::int2")),
      Some((Fragment.const(s"reorderpoint"), fr"${fromWrite(unsaved.reorderpoint)(Write.fromPut(Meta.IntMeta.put))}::int2")),
      Some((Fragment.const(s"standardcost"), fr"${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s"listprice"), fr"${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s""""size""""), fr"${fromWrite(unsaved.size)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"sizeunitmeasurecode"), fr"${fromWrite(unsaved.sizeunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar")),
      Some((Fragment.const(s"weightunitmeasurecode"), fr"${fromWrite(unsaved.weightunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar")),
      Some((Fragment.const(s"weight"), fr"${fromWrite(unsaved.weight)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s"daystomanufacture"), fr"${fromWrite(unsaved.daystomanufacture)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const(s"productline"), fr"${fromWrite(unsaved.productline)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const(s""""class""""), fr"${fromWrite(unsaved.`class`)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const(s""""style""""), fr"${fromWrite(unsaved.style)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const(s"productsubcategoryid"), fr"${fromWrite(unsaved.productsubcategoryid)(Write.fromPutOption(ProductsubcategoryId.put))}::int4")),
      Some((Fragment.const(s"productmodelid"), fr"${fromWrite(unsaved.productmodelid)(Write.fromPutOption(ProductmodelId.put))}::int4")),
      Some((Fragment.const(s"sellstartdate"), fr"${fromWrite(unsaved.sellstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s"sellenddate"), fr"${fromWrite(unsaved.sellenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s"discontinueddate"), fr"${fromWrite(unsaved.discontinueddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      unsaved.productid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"productid"), fr"${fromWrite(value: ProductId)(Write.fromPut(ProductId.put))}::int4"))
      },
      unsaved.makeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"makeflag"), fr"""${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::"public"."Flag""""))
      },
      unsaved.finishedgoodsflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"finishedgoodsflag"), fr"""${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::"public"."Flag""""))
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
      sql"""insert into production.product default values
            returning productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate::text, sellenddate::text, discontinueddate::text, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.product(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate::text, sellenddate::text, discontinueddate::text, rowguid, modifieddate::text
         """
    }
    q.query(ProductRow.read).unique
    
  }
  override def select: SelectBuilder[ProductFields, ProductRow] = {
    SelectBuilderSql("production.product", ProductFields, ProductRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductRow] = {
    sql"""select productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate::text, sellenddate::text, discontinueddate::text, rowguid, modifieddate::text from production.product""".query(ProductRow.read).stream
  }
  override def selectById(productid: ProductId): ConnectionIO[Option[ProductRow]] = {
    sql"""select productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate::text, sellenddate::text, discontinueddate::text, rowguid, modifieddate::text from production.product where productid = ${fromWrite(productid)(Write.fromPut(ProductId.put))}""".query(ProductRow.read).option
  }
  override def selectByIds(productids: Array[ProductId]): Stream[ConnectionIO, ProductRow] = {
    sql"""select productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate::text, sellenddate::text, discontinueddate::text, rowguid, modifieddate::text from production.product where productid = ANY(${fromWrite(productids)(Write.fromPut(ProductId.arrayPut))})""".query(ProductRow.read).stream
  }
  override def update(row: ProductRow): ConnectionIO[Boolean] = {
    val productid = row.productid
    sql"""update production.product
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::"public"."Name",
              productnumber = ${fromWrite(row.productnumber)(Write.fromPut(Meta.StringMeta.put))},
              makeflag = ${fromWrite(row.makeflag)(Write.fromPut(Flag.put))}::"public"."Flag",
              finishedgoodsflag = ${fromWrite(row.finishedgoodsflag)(Write.fromPut(Flag.put))}::"public"."Flag",
              color = ${fromWrite(row.color)(Write.fromPutOption(Meta.StringMeta.put))},
              safetystocklevel = ${fromWrite(row.safetystocklevel)(Write.fromPut(Meta.IntMeta.put))}::int2,
              reorderpoint = ${fromWrite(row.reorderpoint)(Write.fromPut(Meta.IntMeta.put))}::int2,
              standardcost = ${fromWrite(row.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              listprice = ${fromWrite(row.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "size" = ${fromWrite(row.size)(Write.fromPutOption(Meta.StringMeta.put))},
              sizeunitmeasurecode = ${fromWrite(row.sizeunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar,
              weightunitmeasurecode = ${fromWrite(row.weightunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar,
              weight = ${fromWrite(row.weight)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              daystomanufacture = ${fromWrite(row.daystomanufacture)(Write.fromPut(Meta.IntMeta.put))}::int4,
              productline = ${fromWrite(row.productline)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
              "class" = ${fromWrite(row.`class`)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
              "style" = ${fromWrite(row.style)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
              productsubcategoryid = ${fromWrite(row.productsubcategoryid)(Write.fromPutOption(ProductsubcategoryId.put))}::int4,
              productmodelid = ${fromWrite(row.productmodelid)(Write.fromPutOption(ProductmodelId.put))}::int4,
              sellstartdate = ${fromWrite(row.sellstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              sellenddate = ${fromWrite(row.sellenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              discontinueddate = ${fromWrite(row.discontinueddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where productid = ${fromWrite(productid)(Write.fromPut(ProductId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductFields, ProductRow] = {
    UpdateBuilder("production.product", ProductFields, ProductRow.read)
  }
  override def upsert(unsaved: ProductRow): ConnectionIO[ProductRow] = {
    sql"""insert into production.product(productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.productnumber)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.makeflag)(Write.fromPut(Flag.put))}::"public"."Flag",
            ${fromWrite(unsaved.finishedgoodsflag)(Write.fromPut(Flag.put))}::"public"."Flag",
            ${fromWrite(unsaved.color)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.safetystocklevel)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.reorderpoint)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.size)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.sizeunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar,
            ${fromWrite(unsaved.weightunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar,
            ${fromWrite(unsaved.weight)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.daystomanufacture)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.productline)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.`class`)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.style)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.productsubcategoryid)(Write.fromPutOption(ProductsubcategoryId.put))}::int4,
            ${fromWrite(unsaved.productmodelid)(Write.fromPutOption(ProductmodelId.put))}::int4,
            ${fromWrite(unsaved.sellstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.sellenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.discontinueddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (productid)
          do update set
            "name" = EXCLUDED."name",
            productnumber = EXCLUDED.productnumber,
            makeflag = EXCLUDED.makeflag,
            finishedgoodsflag = EXCLUDED.finishedgoodsflag,
            color = EXCLUDED.color,
            safetystocklevel = EXCLUDED.safetystocklevel,
            reorderpoint = EXCLUDED.reorderpoint,
            standardcost = EXCLUDED.standardcost,
            listprice = EXCLUDED.listprice,
            "size" = EXCLUDED."size",
            sizeunitmeasurecode = EXCLUDED.sizeunitmeasurecode,
            weightunitmeasurecode = EXCLUDED.weightunitmeasurecode,
            weight = EXCLUDED.weight,
            daystomanufacture = EXCLUDED.daystomanufacture,
            productline = EXCLUDED.productline,
            "class" = EXCLUDED."class",
            "style" = EXCLUDED."style",
            productsubcategoryid = EXCLUDED.productsubcategoryid,
            productmodelid = EXCLUDED.productmodelid,
            sellstartdate = EXCLUDED.sellstartdate,
            sellenddate = EXCLUDED.sellenddate,
            discontinueddate = EXCLUDED.discontinueddate,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate::text, sellenddate::text, discontinueddate::text, rowguid, modifieddate::text
       """.query(ProductRow.read).unique
  }
}
