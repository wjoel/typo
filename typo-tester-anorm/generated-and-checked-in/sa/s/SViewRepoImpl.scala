/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package s

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SViewRepoImpl extends SViewRepo {
  override def select: SelectBuilder[SViewFields, SViewRow] = {
    SelectBuilderSql("sa.s", SViewFields, SViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SViewRow] = {
    SQL"""select "id", businessentityid, "name", salespersonid, demographics, rowguid, modifieddate::text
          from sa.s
       """.as(SViewRow.rowParser(1).*)
  }
}
