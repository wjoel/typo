package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgAttrdefRepo {
  def selectAll(implicit c: Connection): List[PgAttrdefRow]
  def selectById(oid: PgAttrdefId)(implicit c: Connection): Option[PgAttrdefRow]
  def selectByIds(oids: List[PgAttrdefId])(implicit c: Connection): List[PgAttrdefRow]
  def selectByFieldValues(fieldValues: List[PgAttrdefFieldValue[_]])(implicit c: Connection): List[PgAttrdefRow]
  def updateFieldValues(oid: PgAttrdefId, fieldValues: List[PgAttrdefFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgAttrdefId, unsaved: PgAttrdefRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgAttrdefId)(implicit c: Connection): Boolean
  def selectByUnique(adrelid: Long, adnum: Short)(implicit c: Connection): Option[PgAttrdefRow]
}
