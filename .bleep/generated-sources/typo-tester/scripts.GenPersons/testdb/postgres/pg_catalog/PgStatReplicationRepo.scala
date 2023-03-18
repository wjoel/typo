package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgStatReplicationRepo {
  def selectAll(implicit c: Connection): List[PgStatReplicationRow]
  def selectByFieldValues(fieldValues: List[PgStatReplicationFieldValue[_]])(implicit c: Connection): List[PgStatReplicationRow]
}