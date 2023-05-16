/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sp

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class SpViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class SpViewFieldValue[T](name: String, value: T) extends SpViewFieldOrIdValue(name, value)

object SpViewFieldValue {
  case class id(override val value: Option[Int]) extends SpViewFieldValue("id", value)
  case class businessentityid(override val value: Option[BusinessentityId]) extends SpViewFieldValue("businessentityid", value)
  case class territoryid(override val value: Option[SalesterritoryId]) extends SpViewFieldValue("territoryid", value)
  case class salesquota(override val value: Option[BigDecimal]) extends SpViewFieldValue("salesquota", value)
  case class bonus(override val value: Option[BigDecimal]) extends SpViewFieldValue("bonus", value)
  case class commissionpct(override val value: Option[BigDecimal]) extends SpViewFieldValue("commissionpct", value)
  case class salesytd(override val value: Option[BigDecimal]) extends SpViewFieldValue("salesytd", value)
  case class saleslastyear(override val value: Option[BigDecimal]) extends SpViewFieldValue("saleslastyear", value)
  case class rowguid(override val value: Option[UUID]) extends SpViewFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends SpViewFieldValue("modifieddate", value)
}
