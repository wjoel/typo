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

trait PgPartitionedTableRepo {
  def selectAll(implicit c: Connection): List[PgPartitionedTableRow]
  def selectById(partrelid: PgPartitionedTableId)(implicit c: Connection): Option[PgPartitionedTableRow]
  def selectByIds(partrelids: List[PgPartitionedTableId])(implicit c: Connection): List[PgPartitionedTableRow]
  def selectByFieldValues(fieldValues: List[PgPartitionedTableFieldValue[_]])(implicit c: Connection): List[PgPartitionedTableRow]
  def updateFieldValues(partrelid: PgPartitionedTableId, fieldValues: List[PgPartitionedTableFieldValue[_]])(implicit c: Connection): Int
  def insert(partrelid: PgPartitionedTableId, unsaved: PgPartitionedTableRowUnsaved)(implicit c: Connection): Unit
  def delete(partrelid: PgPartitionedTableId)(implicit c: Connection): Boolean
}
