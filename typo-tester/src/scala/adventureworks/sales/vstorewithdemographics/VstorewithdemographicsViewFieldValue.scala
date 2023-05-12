/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithdemographics

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import org.postgresql.util.PGmoney

sealed abstract class VstorewithdemographicsViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VstorewithdemographicsViewFieldValue[T](name: String, value: T) extends VstorewithdemographicsViewFieldOrIdValue(name, value)

object VstorewithdemographicsViewFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VstorewithdemographicsViewFieldValue("businessentityid", value)
  case class name(override val value: Option[Name]) extends VstorewithdemographicsViewFieldValue("name", value)
  case class AnnualSales(override val value: Option[PGmoney]) extends VstorewithdemographicsViewFieldValue("AnnualSales", value)
  case class AnnualRevenue(override val value: Option[PGmoney]) extends VstorewithdemographicsViewFieldValue("AnnualRevenue", value)
  case class BankName(override val value: Option[String]) extends VstorewithdemographicsViewFieldValue("BankName", value)
  case class BusinessType(override val value: Option[String]) extends VstorewithdemographicsViewFieldValue("BusinessType", value)
  case class YearOpened(override val value: Option[Int]) extends VstorewithdemographicsViewFieldValue("YearOpened", value)
  case class Specialty(override val value: Option[String]) extends VstorewithdemographicsViewFieldValue("Specialty", value)
  case class SquareFeet(override val value: Option[Int]) extends VstorewithdemographicsViewFieldValue("SquareFeet", value)
  case class Brands(override val value: Option[String]) extends VstorewithdemographicsViewFieldValue("Brands", value)
  case class Internet(override val value: Option[String]) extends VstorewithdemographicsViewFieldValue("Internet", value)
  case class NumberEmployees(override val value: Option[Int]) extends VstorewithdemographicsViewFieldValue("NumberEmployees", value)
}