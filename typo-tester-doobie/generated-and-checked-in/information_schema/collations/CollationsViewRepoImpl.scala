/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collations

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object CollationsViewRepoImpl extends CollationsViewRepo {
  override def select: SelectBuilder[CollationsViewFields, CollationsViewRow] = {
    SelectBuilderSql("information_schema.collations", CollationsViewFields, CollationsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CollationsViewRow] = {
    sql"""select "collation_catalog", "collation_schema", "collation_name", pad_attribute from information_schema.collations""".query(CollationsViewRow.read).stream
  }
}
