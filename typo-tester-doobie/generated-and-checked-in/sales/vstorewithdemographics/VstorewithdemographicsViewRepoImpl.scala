/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithdemographics

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VstorewithdemographicsViewRepoImpl extends VstorewithdemographicsViewRepo {
  override def select: SelectBuilder[VstorewithdemographicsViewFields, VstorewithdemographicsViewRow] = {
    SelectBuilderSql("sales.vstorewithdemographics", VstorewithdemographicsViewFields, VstorewithdemographicsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VstorewithdemographicsViewRow] = {
    sql"""select businessentityid, "name", AnnualSales::numeric, AnnualRevenue::numeric, BankName, BusinessType, YearOpened, Specialty, SquareFeet, Brands, Internet, NumberEmployees from sales.vstorewithdemographics""".query(VstorewithdemographicsViewRow.read).stream
  }
}
