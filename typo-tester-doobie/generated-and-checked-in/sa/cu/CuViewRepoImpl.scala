/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cu

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object CuViewRepoImpl extends CuViewRepo {
  override def select: SelectBuilder[CuViewFields, CuViewRow] = {
    SelectBuilderSql("sa.cu", CuViewFields, CuViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CuViewRow] = {
    sql"""select "id", currencycode, "name", modifieddate::text from sa.cu""".query(CuViewRow.read).stream
  }
}
