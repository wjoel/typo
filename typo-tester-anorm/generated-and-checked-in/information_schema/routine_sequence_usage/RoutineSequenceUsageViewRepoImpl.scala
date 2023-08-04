/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_sequence_usage

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object RoutineSequenceUsageViewRepoImpl extends RoutineSequenceUsageViewRepo {
  override def select: SelectBuilder[RoutineSequenceUsageViewFields, RoutineSequenceUsageViewRow] = {
    SelectBuilderSql("information_schema.routine_sequence_usage", RoutineSequenceUsageViewFields, RoutineSequenceUsageViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[RoutineSequenceUsageViewRow] = {
    SQL"""select specific_catalog, specific_schema, "specific_name", "routine_catalog", "routine_schema", "routine_name", sequence_catalog, sequence_schema, sequence_name
          from information_schema.routine_sequence_usage
       """.as(RoutineSequenceUsageViewRow.rowParser(1).*)
  }
}