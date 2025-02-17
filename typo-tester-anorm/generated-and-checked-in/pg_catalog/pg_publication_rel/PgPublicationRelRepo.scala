/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_rel

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgPublicationRelRepo {
  def delete(oid: PgPublicationRelId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgPublicationRelFields, PgPublicationRelRow]
  def insert(unsaved: PgPublicationRelRow)(implicit c: Connection): PgPublicationRelRow
  def select: SelectBuilder[PgPublicationRelFields, PgPublicationRelRow]
  def selectAll(implicit c: Connection): List[PgPublicationRelRow]
  def selectById(oid: PgPublicationRelId)(implicit c: Connection): Option[PgPublicationRelRow]
  def selectByIds(oids: Array[PgPublicationRelId])(implicit c: Connection): List[PgPublicationRelRow]
  def update(row: PgPublicationRelRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgPublicationRelFields, PgPublicationRelRow]
  def upsert(unsaved: PgPublicationRelRow)(implicit c: Connection): PgPublicationRelRow
}
