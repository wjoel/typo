package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgReplicationOriginRepo {
  def selectAll(implicit c: Connection): List[PgReplicationOriginRow]
  def selectById(roident: PgReplicationOriginId)(implicit c: Connection): Option[PgReplicationOriginRow]
  def selectByIds(roidents: List[PgReplicationOriginId])(implicit c: Connection): List[PgReplicationOriginRow]
  def selectByFieldValues(fieldValues: List[PgReplicationOriginFieldValue[_]])(implicit c: Connection): List[PgReplicationOriginRow]
  def updateFieldValues(roident: PgReplicationOriginId, fieldValues: List[PgReplicationOriginFieldValue[_]])(implicit c: Connection): Int
  def insert(roident: PgReplicationOriginId, unsaved: PgReplicationOriginRowUnsaved)(implicit c: Connection): Unit
  def delete(roident: PgReplicationOriginId)(implicit c: Connection): Boolean
  def selectByUnique(roname: String)(implicit c: Connection): Option[PgReplicationOriginRow]
}
