package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgOperatorRepo {
  def selectAll(implicit c: Connection): List[PgOperatorRow]
  def selectById(oid: PgOperatorId)(implicit c: Connection): Option[PgOperatorRow]
  def selectByIds(oids: List[PgOperatorId])(implicit c: Connection): List[PgOperatorRow]
  def selectByFieldValues(fieldValues: List[PgOperatorFieldValue[_]])(implicit c: Connection): List[PgOperatorRow]
  def updateFieldValues(oid: PgOperatorId, fieldValues: List[PgOperatorFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgOperatorId, unsaved: PgOperatorRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgOperatorId)(implicit c: Connection): Boolean
  def selectByUnique(oprname: String, oprleft: Long, oprright: Long, oprnamespace: Long)(implicit c: Connection): Option[PgOperatorRow]
}
