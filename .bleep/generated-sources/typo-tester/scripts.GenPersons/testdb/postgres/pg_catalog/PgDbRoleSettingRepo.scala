package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgDbRoleSettingRepo {
  def selectAll(implicit c: Connection): List[PgDbRoleSettingRow]
  def selectById(compositeId: PgDbRoleSettingId)(implicit c: Connection): Option[PgDbRoleSettingRow]
  def selectByFieldValues(fieldValues: List[PgDbRoleSettingFieldValue[_]])(implicit c: Connection): List[PgDbRoleSettingRow]
  def updateFieldValues(compositeId: PgDbRoleSettingId, fieldValues: List[PgDbRoleSettingFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgDbRoleSettingId, unsaved: PgDbRoleSettingRowUnsaved)(implicit c: Connection): Unit
  def delete(compositeId: PgDbRoleSettingId)(implicit c: Connection): Boolean
}
