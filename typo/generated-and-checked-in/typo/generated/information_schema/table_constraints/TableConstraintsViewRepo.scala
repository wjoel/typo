/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema
package table_constraints

import java.sql.Connection

trait TableConstraintsViewRepo {
  def selectAll(implicit c: Connection): List[TableConstraintsViewRow]
  def selectByFieldValues(fieldValues: List[TableConstraintsViewFieldOrIdValue[_]])(implicit c: Connection): List[TableConstraintsViewRow]
}
