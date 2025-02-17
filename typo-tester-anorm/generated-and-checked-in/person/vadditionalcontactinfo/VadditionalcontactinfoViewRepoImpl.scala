/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vadditionalcontactinfo

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VadditionalcontactinfoViewRepoImpl extends VadditionalcontactinfoViewRepo {
  override def select: SelectBuilder[VadditionalcontactinfoViewFields, VadditionalcontactinfoViewRow] = {
    SelectBuilderSql("person.vadditionalcontactinfo", VadditionalcontactinfoViewFields, VadditionalcontactinfoViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VadditionalcontactinfoViewRow] = {
    SQL"""select businessentityid, firstname, middlename, lastname, telephonenumber, telephonespecialinstructions, street, city, stateprovince, postalcode, countryregion, homeaddressspecialinstructions, emailaddress, emailspecialinstructions, emailtelephonenumber, rowguid, modifieddate::text
          from person.vadditionalcontactinfo
       """.as(VadditionalcontactinfoViewRow.rowParser(1).*)
  }
}
