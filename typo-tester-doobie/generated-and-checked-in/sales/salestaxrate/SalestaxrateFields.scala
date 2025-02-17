/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.TypoLocalDateTime
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait SalestaxrateFields[Row] {
  val salestaxrateid: IdField[SalestaxrateId, Row]
  val stateprovinceid: Field[StateprovinceId, Row]
  val taxtype: Field[Int, Row]
  val taxrate: Field[BigDecimal, Row]
  val name: Field[Name, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SalestaxrateFields extends SalestaxrateStructure[SalestaxrateRow](None, identity, (_, x) => x)

