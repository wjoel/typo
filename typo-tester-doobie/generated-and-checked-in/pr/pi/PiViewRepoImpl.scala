/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pi

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PiViewRepoImpl extends PiViewRepo {
  override def select: SelectBuilder[PiViewFields, PiViewRow] = {
    SelectBuilderSql("pr.pi", PiViewFields, PiViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PiViewRow] = {
    sql"""select "id", productid, locationid, shelf, bin, quantity, rowguid, modifieddate::text from pr.pi""".query(PiViewRow.read).stream
  }
}
