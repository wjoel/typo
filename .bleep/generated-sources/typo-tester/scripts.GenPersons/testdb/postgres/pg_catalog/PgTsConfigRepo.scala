package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgTsConfigRepo {
  def selectAll(implicit c: Connection): List[PgTsConfigRow]
  def selectById(oid: PgTsConfigId)(implicit c: Connection): Option[PgTsConfigRow]
  def selectByIds(oids: List[PgTsConfigId])(implicit c: Connection): List[PgTsConfigRow]
  def selectByFieldValues(fieldValues: List[PgTsConfigFieldValue[_]])(implicit c: Connection): List[PgTsConfigRow]
  def updateFieldValues(oid: PgTsConfigId, fieldValues: List[PgTsConfigFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgTsConfigId, unsaved: PgTsConfigRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgTsConfigId)(implicit c: Connection): Boolean
  def selectByUnique(cfgname: String, cfgnamespace: Long)(implicit c: Connection): Option[PgTsConfigRow]
}
