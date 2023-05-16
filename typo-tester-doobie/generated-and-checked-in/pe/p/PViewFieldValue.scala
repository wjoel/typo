/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package p

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import java.time.LocalDateTime
import java.util.UUID
import org.postgresql.jdbc.PgSQLXML

sealed abstract class PViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PViewFieldValue[T](name: String, value: T) extends PViewFieldOrIdValue(name, value)

object PViewFieldValue {
  case class id(override val value: Option[Int]) extends PViewFieldValue("id", value)
  case class businessentityid(override val value: Option[BusinessentityId]) extends PViewFieldValue("businessentityid", value)
  case class persontype(override val value: Option[/* bpchar */ String]) extends PViewFieldValue("persontype", value)
  case class namestyle(override val value: NameStyle) extends PViewFieldValue("namestyle", value)
  case class title(override val value: Option[String]) extends PViewFieldValue("title", value)
  case class firstname(override val value: Option[Name]) extends PViewFieldValue("firstname", value)
  case class middlename(override val value: Option[Name]) extends PViewFieldValue("middlename", value)
  case class lastname(override val value: Option[Name]) extends PViewFieldValue("lastname", value)
  case class suffix(override val value: Option[String]) extends PViewFieldValue("suffix", value)
  case class emailpromotion(override val value: Option[Int]) extends PViewFieldValue("emailpromotion", value)
  case class additionalcontactinfo(override val value: Option[PgSQLXML]) extends PViewFieldValue("additionalcontactinfo", value)
  case class demographics(override val value: Option[PgSQLXML]) extends PViewFieldValue("demographics", value)
  case class rowguid(override val value: Option[UUID]) extends PViewFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PViewFieldValue("modifieddate", value)
}
