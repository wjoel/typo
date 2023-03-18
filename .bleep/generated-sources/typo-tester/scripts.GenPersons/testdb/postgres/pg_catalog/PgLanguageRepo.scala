package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgLanguageRepo {
  def selectAll(implicit c: Connection): List[PgLanguageRow]
  def selectById(oid: PgLanguageId)(implicit c: Connection): Option[PgLanguageRow]
  def selectByIds(oids: List[PgLanguageId])(implicit c: Connection): List[PgLanguageRow]
  def selectByFieldValues(fieldValues: List[PgLanguageFieldValue[_]])(implicit c: Connection): List[PgLanguageRow]
  def updateFieldValues(oid: PgLanguageId, fieldValues: List[PgLanguageFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgLanguageId, unsaved: PgLanguageRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgLanguageId)(implicit c: Connection): Boolean
  def selectByUnique(lanname: String)(implicit c: Connection): Option[PgLanguageRow]
}
