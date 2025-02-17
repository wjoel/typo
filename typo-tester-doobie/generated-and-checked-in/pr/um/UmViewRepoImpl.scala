/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package um

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object UmViewRepoImpl extends UmViewRepo {
  override def select: SelectBuilder[UmViewFields, UmViewRow] = {
    SelectBuilderSql("pr.um", UmViewFields, UmViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, UmViewRow] = {
    sql"""select "id", unitmeasurecode, "name", modifieddate::text from pr.um""".query(UmViewRow.read).stream
  }
}
