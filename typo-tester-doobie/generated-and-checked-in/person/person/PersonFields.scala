/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PersonFields[Row] {
  val businessentityid: IdField[BusinessentityId, Row]
  val persontype: Field[/* bpchar */ String, Row]
  val namestyle: Field[NameStyle, Row]
  val title: OptField[/* max 8 chars */ String, Row]
  val firstname: Field[Name, Row]
  val middlename: OptField[Name, Row]
  val lastname: Field[Name, Row]
  val suffix: OptField[/* max 10 chars */ String, Row]
  val emailpromotion: Field[Int, Row]
  val additionalcontactinfo: OptField[TypoXml, Row]
  val demographics: OptField[TypoXml, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object PersonFields extends PersonStructure[PersonRow](None, identity, (_, x) => x)

