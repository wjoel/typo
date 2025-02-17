/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_servers

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ForeignServersViewRepoImpl extends ForeignServersViewRepo {
  override def select: SelectBuilder[ForeignServersViewFields, ForeignServersViewRow] = {
    SelectBuilderSql("information_schema.foreign_servers", ForeignServersViewFields, ForeignServersViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ForeignServersViewRow] = {
    SQL"""select foreign_server_catalog, foreign_server_name, foreign_data_wrapper_catalog, foreign_data_wrapper_name, foreign_server_type, foreign_server_version, authorization_identifier
          from information_schema.foreign_servers
       """.as(ForeignServersViewRow.rowParser(1).*)
  }
}
