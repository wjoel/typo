/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VstorewithaddressesViewRepoImpl extends VstorewithaddressesViewRepo {
  override def select: SelectBuilder[VstorewithaddressesViewFields, VstorewithaddressesViewRow] = {
    SelectBuilderSql("sales.vstorewithaddresses", VstorewithaddressesViewFields, VstorewithaddressesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VstorewithaddressesViewRow] = {
    sql"""select businessentityid, "name", addresstype, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname from sales.vstorewithaddresses""".query(VstorewithaddressesViewRow.read).stream
  }
}
