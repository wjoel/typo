/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package check_constraints

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object CheckConstraintsViewRepoImpl extends CheckConstraintsViewRepo {
  override def select: SelectBuilder[CheckConstraintsViewFields, CheckConstraintsViewRow] = {
    SelectBuilderSql("information_schema.check_constraints", CheckConstraintsViewFields, CheckConstraintsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CheckConstraintsViewRow] = {
    SQL"""select "constraint_catalog", "constraint_schema", "constraint_name", check_clause
          from information_schema.check_constraints
       """.as(CheckConstraintsViewRow.rowParser(1).*)
  }
}