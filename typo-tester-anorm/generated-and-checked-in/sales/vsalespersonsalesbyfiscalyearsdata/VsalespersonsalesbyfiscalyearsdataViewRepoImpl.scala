/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyearsdata

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VsalespersonsalesbyfiscalyearsdataViewRepoImpl extends VsalespersonsalesbyfiscalyearsdataViewRepo {
  override def select: SelectBuilder[VsalespersonsalesbyfiscalyearsdataViewFields, VsalespersonsalesbyfiscalyearsdataViewRow] = {
    SelectBuilderSql("sales.vsalespersonsalesbyfiscalyearsdata", VsalespersonsalesbyfiscalyearsdataViewFields, VsalespersonsalesbyfiscalyearsdataViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VsalespersonsalesbyfiscalyearsdataViewRow] = {
    SQL"""select salespersonid, fullname, jobtitle, salesterritory, salestotal, fiscalyear
          from sales.vsalespersonsalesbyfiscalyearsdata
       """.as(VsalespersonsalesbyfiscalyearsdataViewRow.rowParser(1).*)
  }
}
