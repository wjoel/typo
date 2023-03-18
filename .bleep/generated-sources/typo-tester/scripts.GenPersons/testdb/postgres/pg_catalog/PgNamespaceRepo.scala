package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgNamespaceRepo {
  def selectAll(implicit c: Connection): List[PgNamespaceRow]
  def selectById(oid: PgNamespaceId)(implicit c: Connection): Option[PgNamespaceRow]
  def selectByIds(oids: List[PgNamespaceId])(implicit c: Connection): List[PgNamespaceRow]
  def selectByFieldValues(fieldValues: List[PgNamespaceFieldValue[_]])(implicit c: Connection): List[PgNamespaceRow]
  def updateFieldValues(oid: PgNamespaceId, fieldValues: List[PgNamespaceFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgNamespaceId, unsaved: PgNamespaceRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgNamespaceId)(implicit c: Connection): Boolean
  def selectByUnique(nspname: String)(implicit c: Connection): Option[PgNamespaceRow]
}
