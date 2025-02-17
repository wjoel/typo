/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package data_type_privileges

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object DataTypePrivilegesViewRepoImpl extends DataTypePrivilegesViewRepo {
  override def select: SelectBuilder[DataTypePrivilegesViewFields, DataTypePrivilegesViewRow] = {
    SelectBuilderSql("information_schema.data_type_privileges", DataTypePrivilegesViewFields, DataTypePrivilegesViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[DataTypePrivilegesViewRow] = {
    SQL"""select object_catalog, object_schema, object_name, object_type, dtd_identifier
          from information_schema.data_type_privileges
       """.as(DataTypePrivilegesViewRow.rowParser(1).*)
  }
}
