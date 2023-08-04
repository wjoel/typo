/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_implementation_info

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SqlImplementationInfoRepo {
  def delete: DeleteBuilder[SqlImplementationInfoFields, SqlImplementationInfoRow]
  def insert(unsaved: SqlImplementationInfoRow)(implicit c: Connection): SqlImplementationInfoRow
  def select: SelectBuilder[SqlImplementationInfoFields, SqlImplementationInfoRow]
  def selectAll(implicit c: Connection): List[SqlImplementationInfoRow]
  def update: UpdateBuilder[SqlImplementationInfoFields, SqlImplementationInfoRow]
}