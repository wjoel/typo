/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VstorewithcontactsViewRepoImpl extends VstorewithcontactsViewRepo {
  override def select: SelectBuilder[VstorewithcontactsViewFields, VstorewithcontactsViewRow] = {
    SelectBuilderSql("sales.vstorewithcontacts", VstorewithcontactsViewFields, VstorewithcontactsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VstorewithcontactsViewRow] = {
    SQL"""select businessentityid, "name", contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion
          from sales.vstorewithcontacts
       """.as(VstorewithcontactsViewRow.rowParser(1).*)
  }
}
