/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import typo.dsl.SqlExpr.OptField

trait VstorewithaddressesViewFields[Row] {
  val businessentityid: OptField[BusinessentityId, Row]
  val name: OptField[Name, Row]
  val addresstype: OptField[Name, Row]
  val addressline1: OptField[/* max 60 chars */ String, Row]
  val addressline2: OptField[/* max 60 chars */ String, Row]
  val city: OptField[/* max 30 chars */ String, Row]
  val stateprovincename: OptField[Name, Row]
  val postalcode: OptField[/* max 15 chars */ String, Row]
  val countryregionname: OptField[Name, Row]
}
object VstorewithaddressesViewFields extends VstorewithaddressesViewStructure[VstorewithaddressesViewRow](None, identity, (_, x) => x)
