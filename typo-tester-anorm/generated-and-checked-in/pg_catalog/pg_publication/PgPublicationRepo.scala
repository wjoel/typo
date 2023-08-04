/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgPublicationRepo {
  def delete(oid: PgPublicationId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgPublicationFields, PgPublicationRow]
  def insert(unsaved: PgPublicationRow)(implicit c: Connection): PgPublicationRow
  def select: SelectBuilder[PgPublicationFields, PgPublicationRow]
  def selectAll(implicit c: Connection): List[PgPublicationRow]
  def selectById(oid: PgPublicationId)(implicit c: Connection): Option[PgPublicationRow]
  def selectByIds(oids: Array[PgPublicationId])(implicit c: Connection): List[PgPublicationRow]
  def update(row: PgPublicationRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgPublicationFields, PgPublicationRow]
  def upsert(unsaved: PgPublicationRow)(implicit c: Connection): PgPublicationRow
}