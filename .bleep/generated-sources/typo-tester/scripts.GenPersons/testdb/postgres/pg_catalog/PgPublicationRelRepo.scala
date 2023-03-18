package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgPublicationRelRepo {
  def selectAll(implicit c: Connection): List[PgPublicationRelRow]
  def selectById(oid: PgPublicationRelId)(implicit c: Connection): Option[PgPublicationRelRow]
  def selectByIds(oids: List[PgPublicationRelId])(implicit c: Connection): List[PgPublicationRelRow]
  def selectByFieldValues(fieldValues: List[PgPublicationRelFieldValue[_]])(implicit c: Connection): List[PgPublicationRelRow]
  def updateFieldValues(oid: PgPublicationRelId, fieldValues: List[PgPublicationRelFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgPublicationRelId, unsaved: PgPublicationRelRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgPublicationRelId)(implicit c: Connection): Boolean
  def selectByUnique(prrelid: Long, prpubid: Long)(implicit c: Connection): Option[PgPublicationRelRow]
}
