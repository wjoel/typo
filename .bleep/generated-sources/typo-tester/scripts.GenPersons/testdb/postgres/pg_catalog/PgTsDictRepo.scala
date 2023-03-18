package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgTsDictRepo {
  def selectAll(implicit c: Connection): List[PgTsDictRow]
  def selectById(oid: PgTsDictId)(implicit c: Connection): Option[PgTsDictRow]
  def selectByIds(oids: List[PgTsDictId])(implicit c: Connection): List[PgTsDictRow]
  def selectByFieldValues(fieldValues: List[PgTsDictFieldValue[_]])(implicit c: Connection): List[PgTsDictRow]
  def updateFieldValues(oid: PgTsDictId, fieldValues: List[PgTsDictFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgTsDictId, unsaved: PgTsDictRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgTsDictId)(implicit c: Connection): Boolean
  def selectByUnique(dictname: String, dictnamespace: Long)(implicit c: Connection): Option[PgTsDictRow]
}
