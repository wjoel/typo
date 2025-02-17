/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package ct

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object CtViewRepoImpl extends CtViewRepo {
  override def select: SelectBuilder[CtViewFields, CtViewRow] = {
    SelectBuilderSql("pe.ct", CtViewFields, CtViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CtViewRow] = {
    SQL"""select "id", contacttypeid, "name", modifieddate::text
          from pe.ct
       """.as(CtViewRow.rowParser(1).*)
  }
}
