package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgTransformRepo {
  def selectAll(implicit c: Connection): List[PgTransformRow]
  def selectById(oid: PgTransformId)(implicit c: Connection): Option[PgTransformRow]
  def selectByIds(oids: List[PgTransformId])(implicit c: Connection): List[PgTransformRow]
  def selectByFieldValues(fieldValues: List[PgTransformFieldValue[_]])(implicit c: Connection): List[PgTransformRow]
  def updateFieldValues(oid: PgTransformId, fieldValues: List[PgTransformFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgTransformId, unsaved: PgTransformRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgTransformId)(implicit c: Connection): Boolean
  def selectByUnique(trftype: Long, trflang: Long)(implicit c: Connection): Option[PgTransformRow]
}
