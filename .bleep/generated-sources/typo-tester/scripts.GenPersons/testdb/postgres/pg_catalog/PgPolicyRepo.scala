package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgPolicyRepo {
  def selectAll(implicit c: Connection): List[PgPolicyRow]
  def selectById(oid: PgPolicyId)(implicit c: Connection): Option[PgPolicyRow]
  def selectByIds(oids: List[PgPolicyId])(implicit c: Connection): List[PgPolicyRow]
  def selectByFieldValues(fieldValues: List[PgPolicyFieldValue[_]])(implicit c: Connection): List[PgPolicyRow]
  def updateFieldValues(oid: PgPolicyId, fieldValues: List[PgPolicyFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgPolicyId, unsaved: PgPolicyRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgPolicyId)(implicit c: Connection): Boolean
  def selectByUnique(polrelid: Long, polname: String)(implicit c: Connection): Option[PgPolicyRow]
}
