package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgTimezoneNamesRepo {
  def selectAll(implicit c: Connection): List[PgTimezoneNamesRow]
  def selectByFieldValues(fieldValues: List[PgTimezoneNamesFieldValue[_]])(implicit c: Connection): List[PgTimezoneNamesRow]
}