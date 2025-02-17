/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package bom

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object BomViewRepoImpl extends BomViewRepo {
  override def select: SelectBuilder[BomViewFields, BomViewRow] = {
    SelectBuilderSql("pr.bom", BomViewFields, BomViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[BomViewRow] = {
    SQL"""select "id", billofmaterialsid, productassemblyid, componentid, startdate::text, enddate::text, unitmeasurecode, bomlevel, perassemblyqty, modifieddate::text
          from pr."bom"
       """.as(BomViewRow.rowParser(1).*)
  }
}
