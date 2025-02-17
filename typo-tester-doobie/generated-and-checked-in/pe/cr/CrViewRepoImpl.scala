/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package cr

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object CrViewRepoImpl extends CrViewRepo {
  override def select: SelectBuilder[CrViewFields, CrViewRow] = {
    SelectBuilderSql("pe.cr", CrViewFields, CrViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CrViewRow] = {
    sql"""select countryregioncode, "name", modifieddate::text from pe.cr""".query(CrViewRow.read).stream
  }
}
