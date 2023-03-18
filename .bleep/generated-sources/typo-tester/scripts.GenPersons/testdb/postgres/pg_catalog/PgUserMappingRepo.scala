package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgUserMappingRepo {
  def selectAll(implicit c: Connection): List[PgUserMappingRow]
  def selectById(oid: PgUserMappingId)(implicit c: Connection): Option[PgUserMappingRow]
  def selectByIds(oids: List[PgUserMappingId])(implicit c: Connection): List[PgUserMappingRow]
  def selectByFieldValues(fieldValues: List[PgUserMappingFieldValue[_]])(implicit c: Connection): List[PgUserMappingRow]
  def updateFieldValues(oid: PgUserMappingId, fieldValues: List[PgUserMappingFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgUserMappingId, unsaved: PgUserMappingRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgUserMappingId)(implicit c: Connection): Boolean
  def selectByUnique(umuser: Long, umserver: Long)(implicit c: Connection): Option[PgUserMappingRow]
}
