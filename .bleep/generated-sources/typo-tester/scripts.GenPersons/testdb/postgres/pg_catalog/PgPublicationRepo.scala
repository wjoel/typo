package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgPublicationRepo {
  def selectAll(implicit c: Connection): List[PgPublicationRow]
  def selectById(oid: PgPublicationId)(implicit c: Connection): Option[PgPublicationRow]
  def selectByIds(oids: List[PgPublicationId])(implicit c: Connection): List[PgPublicationRow]
  def selectByFieldValues(fieldValues: List[PgPublicationFieldValue[_]])(implicit c: Connection): List[PgPublicationRow]
  def updateFieldValues(oid: PgPublicationId, fieldValues: List[PgPublicationFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgPublicationId, unsaved: PgPublicationRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgPublicationId)(implicit c: Connection): Boolean
  def selectByUnique(pubname: String)(implicit c: Connection): Option[PgPublicationRow]
}
