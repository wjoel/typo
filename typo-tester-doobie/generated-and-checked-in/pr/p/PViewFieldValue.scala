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

sealed abstract class PViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PViewFieldValue[T](name: String, value: T) extends PViewFieldOrIdValue(name, value)

object PViewFieldValue {
  case class id(override val value: Option[Int]) extends PViewFieldValue("id", value)
  case class productid(override val value: Option[ProductId]) extends PViewFieldValue("productid", value)
  case class name(override val value: Option[Name]) extends PViewFieldValue("name", value)
  case class productnumber(override val value: Option[String]) extends PViewFieldValue("productnumber", value)
  case class makeflag(override val value: Flag) extends PViewFieldValue("makeflag", value)
  case class finishedgoodsflag(override val value: Flag) extends PViewFieldValue("finishedgoodsflag", value)
  case class color(override val value: Option[String]) extends PViewFieldValue("color", value)
  case class safetystocklevel(override val value: Option[Int]) extends PViewFieldValue("safetystocklevel", value)
  case class reorderpoint(override val value: Option[Int]) extends PViewFieldValue("reorderpoint", value)
  case class standardcost(override val value: Option[BigDecimal]) extends PViewFieldValue("standardcost", value)
  case class listprice(override val value: Option[BigDecimal]) extends PViewFieldValue("listprice", value)
  case class size(override val value: Option[String]) extends PViewFieldValue("size", value)
  case class sizeunitmeasurecode(override val value: Option[UnitmeasureId]) extends PViewFieldValue("sizeunitmeasurecode", value)
  case class weightunitmeasurecode(override val value: Option[UnitmeasureId]) extends PViewFieldValue("weightunitmeasurecode", value)
  case class weight(override val value: Option[BigDecimal]) extends PViewFieldValue("weight", value)
  case class daystomanufacture(override val value: Option[Int]) extends PViewFieldValue("daystomanufacture", value)
  case class productline(override val value: Option[/* bpchar */ String]) extends PViewFieldValue("productline", value)
  case class `class`(override val value: Option[/* bpchar */ String]) extends PViewFieldValue("class", value)
  case class style(override val value: Option[/* bpchar */ String]) extends PViewFieldValue("style", value)
  case class productsubcategoryid(override val value: Option[ProductsubcategoryId]) extends PViewFieldValue("productsubcategoryid", value)
  case class productmodelid(override val value: Option[ProductmodelId]) extends PViewFieldValue("productmodelid", value)
  case class sellstartdate(override val value: Option[LocalDateTime]) extends PViewFieldValue("sellstartdate", value)
  case class sellenddate(override val value: Option[LocalDateTime]) extends PViewFieldValue("sellenddate", value)
  case class discontinueddate(override val value: Option[LocalDateTime]) extends PViewFieldValue("discontinueddate", value)
  case class rowguid(override val value: Option[UUID]) extends PViewFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PViewFieldValue("modifieddate", value)
}
