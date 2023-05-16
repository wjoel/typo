/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package p

import adventureworks.production.product.ProductId
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

object PViewRepoImpl extends PViewRepo {
  override def selectAll: Stream[ConnectionIO, PViewRow] = {
    sql"""select "id", productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate from pr."p"""".query[PViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PViewFieldOrIdValue[_]]): Stream[ConnectionIO, PViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PViewFieldValue.id(value) => fr""""id" = $value"""
        case PViewFieldValue.productid(value) => fr"productid = $value"
        case PViewFieldValue.name(value) => fr""""name" = $value"""
        case PViewFieldValue.productnumber(value) => fr"productnumber = $value"
        case PViewFieldValue.makeflag(value) => fr"makeflag = $value"
        case PViewFieldValue.finishedgoodsflag(value) => fr"finishedgoodsflag = $value"
        case PViewFieldValue.color(value) => fr"color = $value"
        case PViewFieldValue.safetystocklevel(value) => fr"safetystocklevel = $value"
        case PViewFieldValue.reorderpoint(value) => fr"reorderpoint = $value"
        case PViewFieldValue.standardcost(value) => fr"standardcost = $value"
        case PViewFieldValue.listprice(value) => fr"listprice = $value"
        case PViewFieldValue.size(value) => fr""""size" = $value"""
        case PViewFieldValue.sizeunitmeasurecode(value) => fr"sizeunitmeasurecode = $value"
        case PViewFieldValue.weightunitmeasurecode(value) => fr"weightunitmeasurecode = $value"
        case PViewFieldValue.weight(value) => fr"weight = $value"
        case PViewFieldValue.daystomanufacture(value) => fr"daystomanufacture = $value"
        case PViewFieldValue.productline(value) => fr"productline = $value"
        case PViewFieldValue.`class`(value) => fr""""class" = $value"""
        case PViewFieldValue.style(value) => fr""""style" = $value"""
        case PViewFieldValue.productsubcategoryid(value) => fr"productsubcategoryid = $value"
        case PViewFieldValue.productmodelid(value) => fr"productmodelid = $value"
        case PViewFieldValue.sellstartdate(value) => fr"sellstartdate = $value"
        case PViewFieldValue.sellenddate(value) => fr"sellenddate = $value"
        case PViewFieldValue.discontinueddate(value) => fr"discontinueddate = $value"
        case PViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case PViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"""select * from pr."p" $where""".query[PViewRow].stream
  
  }
  implicit val read: Read[PViewRow] =
    new Read[PViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[ProductId], Nullability.Nullable),
        (Get[Name], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[Flag], Nullability.NoNulls),
        (Get[Flag], Nullability.NoNulls),
        (Get[String], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[UnitmeasureId], Nullability.Nullable),
        (Get[UnitmeasureId], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[/* bpchar */ String], Nullability.Nullable),
        (Get[/* bpchar */ String], Nullability.Nullable),
        (Get[/* bpchar */ String], Nullability.Nullable),
        (Get[ProductsubcategoryId], Nullability.Nullable),
        (Get[ProductmodelId], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        productid = Get[ProductId].unsafeGetNullable(rs, i + 1),
        name = Get[Name].unsafeGetNullable(rs, i + 2),
        productnumber = Get[String].unsafeGetNullable(rs, i + 3),
        makeflag = Get[Flag].unsafeGetNonNullable(rs, i + 4),
        finishedgoodsflag = Get[Flag].unsafeGetNonNullable(rs, i + 5),
        color = Get[String].unsafeGetNullable(rs, i + 6),
        safetystocklevel = Get[Int].unsafeGetNullable(rs, i + 7),
        reorderpoint = Get[Int].unsafeGetNullable(rs, i + 8),
        standardcost = Get[BigDecimal].unsafeGetNullable(rs, i + 9),
        listprice = Get[BigDecimal].unsafeGetNullable(rs, i + 10),
        size = Get[String].unsafeGetNullable(rs, i + 11),
        sizeunitmeasurecode = Get[UnitmeasureId].unsafeGetNullable(rs, i + 12),
        weightunitmeasurecode = Get[UnitmeasureId].unsafeGetNullable(rs, i + 13),
        weight = Get[BigDecimal].unsafeGetNullable(rs, i + 14),
        daystomanufacture = Get[Int].unsafeGetNullable(rs, i + 15),
        productline = Get[/* bpchar */ String].unsafeGetNullable(rs, i + 16),
        `class` = Get[/* bpchar */ String].unsafeGetNullable(rs, i + 17),
        style = Get[/* bpchar */ String].unsafeGetNullable(rs, i + 18),
        productsubcategoryid = Get[ProductsubcategoryId].unsafeGetNullable(rs, i + 19),
        productmodelid = Get[ProductmodelId].unsafeGetNullable(rs, i + 20),
        sellstartdate = Get[LocalDateTime].unsafeGetNullable(rs, i + 21),
        sellenddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 22),
        discontinueddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 23),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 24),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 25)
      )
    )
  

}
