/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package parameters

import java.sql.Connection
import typo.dsl.SelectBuilder

trait ParametersViewRepo {
  def select: SelectBuilder[ParametersViewFields, ParametersViewRow]
  def selectAll(implicit c: Connection): List[ParametersViewRow]
}
