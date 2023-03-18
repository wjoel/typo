package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgLargeobjectMetadataRepo {
  def selectAll(implicit c: Connection): List[PgLargeobjectMetadataRow]
  def selectById(oid: PgLargeobjectMetadataId)(implicit c: Connection): Option[PgLargeobjectMetadataRow]
  def selectByIds(oids: List[PgLargeobjectMetadataId])(implicit c: Connection): List[PgLargeobjectMetadataRow]
  def selectByFieldValues(fieldValues: List[PgLargeobjectMetadataFieldValue[_]])(implicit c: Connection): List[PgLargeobjectMetadataRow]
  def updateFieldValues(oid: PgLargeobjectMetadataId, fieldValues: List[PgLargeobjectMetadataFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgLargeobjectMetadataId, unsaved: PgLargeobjectMetadataRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgLargeobjectMetadataId)(implicit c: Connection): Boolean
}
