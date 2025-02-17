/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats_ext

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatsExtViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatsExtViewRow, val merge: (Row, PgStatsExtViewRow) => Row)
  extends Relation[PgStatsExtViewFields, PgStatsExtViewRow, Row]
    with PgStatsExtViewFields[Row] { outer =>

  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, Some("name"))(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val tablename = new OptField[String, Row](prefix, "tablename", None, Some("name"))(x => extract(x).tablename, (row, value) => merge(row, extract(row).copy(tablename = value)))
  override val statisticsSchemaname = new OptField[String, Row](prefix, "statistics_schemaname", None, Some("name"))(x => extract(x).statisticsSchemaname, (row, value) => merge(row, extract(row).copy(statisticsSchemaname = value)))
  override val statisticsName = new OptField[String, Row](prefix, "statistics_name", None, Some("name"))(x => extract(x).statisticsName, (row, value) => merge(row, extract(row).copy(statisticsName = value)))
  override val statisticsOwner = new OptField[String, Row](prefix, "statistics_owner", None, Some("name"))(x => extract(x).statisticsOwner, (row, value) => merge(row, extract(row).copy(statisticsOwner = value)))
  override val attnames = new OptField[Array[String], Row](prefix, "attnames", None, Some("_name"))(x => extract(x).attnames, (row, value) => merge(row, extract(row).copy(attnames = value)))
  override val exprs = new OptField[Array[String], Row](prefix, "exprs", None, Some("_text"))(x => extract(x).exprs, (row, value) => merge(row, extract(row).copy(exprs = value)))
  override val kinds = new OptField[Array[String], Row](prefix, "kinds", None, Some("_char"))(x => extract(x).kinds, (row, value) => merge(row, extract(row).copy(kinds = value)))
  override val nDistinct = new OptField[String, Row](prefix, "n_distinct", None, None)(x => extract(x).nDistinct, (row, value) => merge(row, extract(row).copy(nDistinct = value)))
  override val dependencies = new OptField[String, Row](prefix, "dependencies", None, None)(x => extract(x).dependencies, (row, value) => merge(row, extract(row).copy(dependencies = value)))
  override val mostCommonVals = new OptField[Array[String], Row](prefix, "most_common_vals", None, Some("_text"))(x => extract(x).mostCommonVals, (row, value) => merge(row, extract(row).copy(mostCommonVals = value)))
  override val mostCommonValNulls = new OptField[Array[Boolean], Row](prefix, "most_common_val_nulls", None, Some("_bool"))(x => extract(x).mostCommonValNulls, (row, value) => merge(row, extract(row).copy(mostCommonValNulls = value)))
  override val mostCommonFreqs = new OptField[Array[Double], Row](prefix, "most_common_freqs", None, Some("_float8"))(x => extract(x).mostCommonFreqs, (row, value) => merge(row, extract(row).copy(mostCommonFreqs = value)))
  override val mostCommonBaseFreqs = new OptField[Array[Double], Row](prefix, "most_common_base_freqs", None, Some("_float8"))(x => extract(x).mostCommonBaseFreqs, (row, value) => merge(row, extract(row).copy(mostCommonBaseFreqs = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](schemaname, tablename, statisticsSchemaname, statisticsName, statisticsOwner, attnames, exprs, kinds, nDistinct, dependencies, mostCommonVals, mostCommonValNulls, mostCommonFreqs, mostCommonBaseFreqs)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatsExtViewRow, merge: (NewRow, PgStatsExtViewRow) => NewRow): PgStatsExtViewStructure[NewRow] =
    new PgStatsExtViewStructure(prefix, extract, merge)
}
