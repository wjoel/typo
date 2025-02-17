/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrapper_options

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object ForeignDataWrapperOptionsViewRepoImpl extends ForeignDataWrapperOptionsViewRepo {
  override def select: SelectBuilder[ForeignDataWrapperOptionsViewFields, ForeignDataWrapperOptionsViewRow] = {
    SelectBuilderSql("information_schema.foreign_data_wrapper_options", ForeignDataWrapperOptionsViewFields, ForeignDataWrapperOptionsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ForeignDataWrapperOptionsViewRow] = {
    sql"select foreign_data_wrapper_catalog, foreign_data_wrapper_name, option_name, option_value from information_schema.foreign_data_wrapper_options".query(ForeignDataWrapperOptionsViewRow.read).stream
  }
}
