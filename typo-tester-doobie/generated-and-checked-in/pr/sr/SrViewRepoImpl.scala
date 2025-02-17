/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package sr

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SrViewRepoImpl extends SrViewRepo {
  override def select: SelectBuilder[SrViewFields, SrViewRow] = {
    SelectBuilderSql("pr.sr", SrViewFields, SrViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SrViewRow] = {
    sql"""select "id", scrapreasonid, "name", modifieddate::text from pr.sr""".query(SrViewRow.read).stream
  }
}
