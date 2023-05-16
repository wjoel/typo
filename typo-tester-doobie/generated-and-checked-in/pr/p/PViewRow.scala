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
import java.time.LocalDateTime
import java.util.UUID

case class PViewRow(
  id: Option[Int],
  /** Points to [[production.product.ProductRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.product.ProductRow.name]] */
  name: Option[Name],
  /** Points to [[production.product.ProductRow.productnumber]] */
  productnumber: Option[String],
  /** Points to [[production.product.ProductRow.makeflag]] */
  makeflag: Flag,
  /** Points to [[production.product.ProductRow.finishedgoodsflag]] */
  finishedgoodsflag: Flag,
  /** Points to [[production.product.ProductRow.color]] */
  color: Option[String],
  /** Points to [[production.product.ProductRow.safetystocklevel]] */
  safetystocklevel: Option[Int],
  /** Points to [[production.product.ProductRow.reorderpoint]] */
  reorderpoint: Option[Int],
  /** Points to [[production.product.ProductRow.standardcost]] */
  standardcost: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.listprice]] */
  listprice: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.size]] */
  size: Option[String],
  /** Points to [[production.product.ProductRow.sizeunitmeasurecode]] */
  sizeunitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.product.ProductRow.weightunitmeasurecode]] */
  weightunitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.product.ProductRow.weight]] */
  weight: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.daystomanufacture]] */
  daystomanufacture: Option[Int],
  /** Points to [[production.product.ProductRow.productline]] */
  productline: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.class]] */
  `class`: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.style]] */
  style: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.productsubcategoryid]] */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Points to [[production.product.ProductRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.product.ProductRow.sellstartdate]] */
  sellstartdate: Option[LocalDateTime],
  /** Points to [[production.product.ProductRow.sellenddate]] */
  sellenddate: Option[LocalDateTime],
  /** Points to [[production.product.ProductRow.discontinueddate]] */
  discontinueddate: Option[LocalDateTime],
  /** Points to [[production.product.ProductRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.product.ProductRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)


