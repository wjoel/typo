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

case class PViewRow(
  id: Option[Int],
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.persontype]] */
  persontype: Option[/* bpchar */ String],
  /** Points to [[person.person.PersonRow.namestyle]] */
  namestyle: NameStyle,
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Option[Int],
  /** Points to [[person.person.PersonRow.additionalcontactinfo]] */
  additionalcontactinfo: Option[PgSQLXML],
  /** Points to [[person.person.PersonRow.demographics]] */
  demographics: Option[PgSQLXML],
  /** Points to [[person.person.PersonRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.person.PersonRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)


