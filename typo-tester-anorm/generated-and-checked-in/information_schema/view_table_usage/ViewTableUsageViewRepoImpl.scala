/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_table_usage

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ViewTableUsageViewRepoImpl extends ViewTableUsageViewRepo {
  override def select: SelectBuilder[ViewTableUsageViewFields, ViewTableUsageViewRow] = {
    SelectBuilderSql("information_schema.view_table_usage", ViewTableUsageViewFields, ViewTableUsageViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ViewTableUsageViewRow] = {
    SQL"""select view_catalog, view_schema, view_name, table_catalog, table_schema, "table_name"
          from information_schema.view_table_usage
       """.as(ViewTableUsageViewRow.rowParser(1).*)
  }
}