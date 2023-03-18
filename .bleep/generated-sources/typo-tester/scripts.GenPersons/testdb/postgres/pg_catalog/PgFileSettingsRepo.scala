package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgFileSettingsRepo {
  def selectAll(implicit c: Connection): List[PgFileSettingsRow]
  def selectByFieldValues(fieldValues: List[PgFileSettingsFieldValue[_]])(implicit c: Connection): List[PgFileSettingsRow]
}