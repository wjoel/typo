/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collations

import java.sql.Connection
import typo.dsl.SelectBuilder

trait CollationsViewRepo {
  def select: SelectBuilder[CollationsViewFields, CollationsViewRow]
  def selectAll(implicit c: Connection): List[CollationsViewRow]
}
