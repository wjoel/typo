/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_implementation_info

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SqlImplementationInfoRepoImpl extends SqlImplementationInfoRepo {
  override def delete: DeleteBuilder[SqlImplementationInfoFields, SqlImplementationInfoRow] = {
    DeleteBuilder("information_schema.sql_implementation_info", SqlImplementationInfoFields)
  }
  override def insert(unsaved: SqlImplementationInfoRow)(implicit c: Connection): SqlImplementationInfoRow = {
    SQL"""insert into information_schema.sql_implementation_info(implementation_info_id, implementation_info_name, integer_value, character_value, "comments")
          values (${unsaved.implementationInfoId}::information_schema.character_data, ${unsaved.implementationInfoName}::information_schema.character_data, ${unsaved.integerValue}::information_schema.cardinal_number, ${unsaved.characterValue}::information_schema.character_data, ${unsaved.comments}::information_schema.character_data)
          returning implementation_info_id, implementation_info_name, integer_value, character_value, "comments"
       """
      .executeInsert(SqlImplementationInfoRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[SqlImplementationInfoFields, SqlImplementationInfoRow] = {
    SelectBuilderSql("information_schema.sql_implementation_info", SqlImplementationInfoFields, SqlImplementationInfoRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SqlImplementationInfoRow] = {
    SQL"""select implementation_info_id, implementation_info_name, integer_value, character_value, "comments"
          from information_schema.sql_implementation_info
       """.as(SqlImplementationInfoRow.rowParser(1).*)
  }
  override def update: UpdateBuilder[SqlImplementationInfoFields, SqlImplementationInfoRow] = {
    UpdateBuilder("information_schema.sql_implementation_info", SqlImplementationInfoFields, SqlImplementationInfoRow.rowParser)
  }
}
