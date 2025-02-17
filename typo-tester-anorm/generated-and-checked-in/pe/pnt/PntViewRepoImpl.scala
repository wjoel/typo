/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pnt

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PntViewRepoImpl extends PntViewRepo {
  override def select: SelectBuilder[PntViewFields, PntViewRow] = {
    SelectBuilderSql("pe.pnt", PntViewFields, PntViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PntViewRow] = {
    SQL"""select "id", phonenumbertypeid, "name", modifieddate::text
          from pe.pnt
       """.as(PntViewRow.rowParser(1).*)
  }
}
