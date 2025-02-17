/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package transforms

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object TransformsViewRepoImpl extends TransformsViewRepo {
  override def select: SelectBuilder[TransformsViewFields, TransformsViewRow] = {
    SelectBuilderSql("information_schema.transforms", TransformsViewFields, TransformsViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[TransformsViewRow] = {
    SQL"""select udt_catalog, udt_schema, udt_name, specific_catalog, specific_schema, "specific_name", group_name, transform_type
          from information_schema."transforms"
       """.as(TransformsViewRow.rowParser(1).*)
  }
}
