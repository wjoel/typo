/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_statements

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgPreparedStatementsViewRepoImpl extends PgPreparedStatementsViewRepo {
  override def select: SelectBuilder[PgPreparedStatementsViewFields, PgPreparedStatementsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_prepared_statements", PgPreparedStatementsViewFields, PgPreparedStatementsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgPreparedStatementsViewRow] = {
    SQL"""select "name", "statement", prepare_time::text, parameter_types, from_sql, generic_plans, custom_plans
          from pg_catalog.pg_prepared_statements
       """.as(PgPreparedStatementsViewRow.rowParser(1).*)
  }
}
