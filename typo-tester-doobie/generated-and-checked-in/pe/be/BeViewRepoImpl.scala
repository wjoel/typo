/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object BeViewRepoImpl extends BeViewRepo {
  override def select: SelectBuilder[BeViewFields, BeViewRow] = {
    SelectBuilderSql("pe.be", BeViewFields, BeViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, BeViewRow] = {
    sql"""select "id", businessentityid, rowguid, modifieddate::text from pe.be""".query(BeViewRow.read).stream
  }
}
