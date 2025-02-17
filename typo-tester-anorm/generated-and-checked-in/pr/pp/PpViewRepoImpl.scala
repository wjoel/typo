/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PpViewRepoImpl extends PpViewRepo {
  override def select: SelectBuilder[PpViewFields, PpViewRow] = {
    SelectBuilderSql("pr.pp", PpViewFields, PpViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PpViewRow] = {
    SQL"""select "id", productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate::text
          from pr.pp
       """.as(PpViewRow.rowParser(1).*)
  }
}
