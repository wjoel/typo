/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VstorewithaddressesViewRepoImpl extends VstorewithaddressesViewRepo {
  override def select: SelectBuilder[VstorewithaddressesViewFields, VstorewithaddressesViewRow] = {
    SelectBuilderSql("sales.vstorewithaddresses", VstorewithaddressesViewFields, VstorewithaddressesViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VstorewithaddressesViewRow] = {
    SQL"""select businessentityid, "name", addresstype, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname
          from sales.vstorewithaddresses
       """.as(VstorewithaddressesViewRow.rowParser(1).*)
  }
}
