/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_views

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgViewsViewRepoImpl extends PgViewsViewRepo {
  override def select: SelectBuilder[PgViewsViewFields, PgViewsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_views", PgViewsViewFields, PgViewsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgViewsViewRow] = {
    SQL"""select schemaname, viewname, viewowner, definition
          from pg_catalog.pg_views
       """.as(PgViewsViewRow.rowParser(1).*)
  }
}
