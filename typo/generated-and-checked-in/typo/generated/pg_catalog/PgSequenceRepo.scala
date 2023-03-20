/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import java.sql.Connection

trait PgSequenceRepo {
  def selectAll(implicit c: Connection): List[PgSequenceRow]
  def selectById(seqrelid: PgSequenceId)(implicit c: Connection): Option[PgSequenceRow]
  def selectByIds(seqrelids: List[PgSequenceId])(implicit c: Connection): List[PgSequenceRow]
  def selectByFieldValues(fieldValues: List[PgSequenceFieldValue[_]])(implicit c: Connection): List[PgSequenceRow]
  def updateFieldValues(seqrelid: PgSequenceId, fieldValues: List[PgSequenceFieldValue[_]])(implicit c: Connection): Int
  def insert(seqrelid: PgSequenceId, unsaved: PgSequenceRowUnsaved)(implicit c: Connection): Unit
  def delete(seqrelid: PgSequenceId)(implicit c: Connection): Boolean
}
