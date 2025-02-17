/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object CrcViewRepoImpl extends CrcViewRepo {
  override def select: SelectBuilder[CrcViewFields, CrcViewRow] = {
    SelectBuilderSql("sa.crc", CrcViewFields, CrcViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CrcViewRow] = {
    sql"select countryregioncode, currencycode, modifieddate::text from sa.crc".query(CrcViewRow.read).stream
  }
}
