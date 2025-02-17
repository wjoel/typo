/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sop

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SopViewRepoImpl extends SopViewRepo {
  override def select: SelectBuilder[SopViewFields, SopViewRow] = {
    SelectBuilderSql("sa.sop", SopViewFields, SopViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SopViewRow] = {
    SQL"""select "id", specialofferid, productid, rowguid, modifieddate::text
          from sa.sop
       """.as(SopViewRow.rowParser(1).*)
  }
}
