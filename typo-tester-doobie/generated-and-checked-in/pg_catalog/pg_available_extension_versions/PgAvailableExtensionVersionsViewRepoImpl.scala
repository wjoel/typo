/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_available_extension_versions

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgAvailableExtensionVersionsViewRepoImpl extends PgAvailableExtensionVersionsViewRepo {
  override def select: SelectBuilder[PgAvailableExtensionVersionsViewFields, PgAvailableExtensionVersionsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_available_extension_versions", PgAvailableExtensionVersionsViewFields, PgAvailableExtensionVersionsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgAvailableExtensionVersionsViewRow] = {
    sql"""select "name", "version", installed, superuser, "trusted", relocatable, "schema", requires, "comment" from pg_catalog.pg_available_extension_versions""".query(PgAvailableExtensionVersionsViewRow.read).stream
  }
}
