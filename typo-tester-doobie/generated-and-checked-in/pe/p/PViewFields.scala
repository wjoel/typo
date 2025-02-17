/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package p

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait PViewFields[Row] {
  val id: OptField[Int, Row]
  val businessentityid: OptField[BusinessentityId, Row]
  val persontype: OptField[/* bpchar */ String, Row]
  val namestyle: Field[NameStyle, Row]
  val title: OptField[/* max 8 chars */ String, Row]
  val firstname: OptField[Name, Row]
  val middlename: OptField[Name, Row]
  val lastname: OptField[Name, Row]
  val suffix: OptField[/* max 10 chars */ String, Row]
  val emailpromotion: OptField[Int, Row]
  val additionalcontactinfo: OptField[TypoXml, Row]
  val demographics: OptField[TypoXml, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object PViewFields extends PViewStructure[PViewRow](None, identity, (_, x) => x)

