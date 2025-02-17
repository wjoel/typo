/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pr

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PrViewRepoImpl extends PrViewRepo {
  override def select: SelectBuilder[PrViewFields, PrViewRow] = {
    SelectBuilderSql("pr.pr", PrViewFields, PrViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PrViewRow] = {
    SQL"""select "id", productreviewid, productid, reviewername, reviewdate::text, emailaddress, rating, "comments", modifieddate::text
          from pr.pr
       """.as(PrViewRow.rowParser(1).*)
  }
}
