/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait ProductcategoryFields[Row] {
  val productcategoryid: IdField[ProductcategoryId, Row]
  val name: Field[Name, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object ProductcategoryFields extends ProductcategoryStructure[ProductcategoryRow](None, identity, (_, x) => x)

