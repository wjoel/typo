/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabels

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgSeclabelsViewRepoImpl extends PgSeclabelsViewRepo {
  override def select: SelectBuilder[PgSeclabelsViewFields, PgSeclabelsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_seclabels", PgSeclabelsViewFields, PgSeclabelsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgSeclabelsViewRow] = {
    sql"""select objoid, classoid, objsubid, objtype, objnamespace, objname, provider, "label" from pg_catalog.pg_seclabels""".query(PgSeclabelsViewRow.read).stream
  }
}
