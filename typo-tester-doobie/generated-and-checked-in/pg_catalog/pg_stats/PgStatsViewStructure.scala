/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats

import adventureworks.TypoAnyArray
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatsViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatsViewRow, val merge: (Row, PgStatsViewRow) => Row)
  extends Relation[PgStatsViewFields, PgStatsViewRow, Row]
    with PgStatsViewFields[Row] { outer =>

  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, Some("name"))(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val tablename = new OptField[String, Row](prefix, "tablename", None, Some("name"))(x => extract(x).tablename, (row, value) => merge(row, extract(row).copy(tablename = value)))
  override val attname = new OptField[String, Row](prefix, "attname", None, Some("name"))(x => extract(x).attname, (row, value) => merge(row, extract(row).copy(attname = value)))
  override val inherited = new OptField[Boolean, Row](prefix, "inherited", None, None)(x => extract(x).inherited, (row, value) => merge(row, extract(row).copy(inherited = value)))
  override val nullFrac = new OptField[Float, Row](prefix, "null_frac", None, Some("float4"))(x => extract(x).nullFrac, (row, value) => merge(row, extract(row).copy(nullFrac = value)))
  override val avgWidth = new OptField[Int, Row](prefix, "avg_width", None, Some("int4"))(x => extract(x).avgWidth, (row, value) => merge(row, extract(row).copy(avgWidth = value)))
  override val nDistinct = new OptField[Float, Row](prefix, "n_distinct", None, Some("float4"))(x => extract(x).nDistinct, (row, value) => merge(row, extract(row).copy(nDistinct = value)))
  override val mostCommonVals = new OptField[TypoAnyArray, Row](prefix, "most_common_vals", None, Some("anyarray"))(x => extract(x).mostCommonVals, (row, value) => merge(row, extract(row).copy(mostCommonVals = value)))
  override val mostCommonFreqs = new OptField[Array[Float], Row](prefix, "most_common_freqs", None, Some("_float4"))(x => extract(x).mostCommonFreqs, (row, value) => merge(row, extract(row).copy(mostCommonFreqs = value)))
  override val histogramBounds = new OptField[TypoAnyArray, Row](prefix, "histogram_bounds", None, Some("anyarray"))(x => extract(x).histogramBounds, (row, value) => merge(row, extract(row).copy(histogramBounds = value)))
  override val correlation = new OptField[Float, Row](prefix, "correlation", None, Some("float4"))(x => extract(x).correlation, (row, value) => merge(row, extract(row).copy(correlation = value)))
  override val mostCommonElems = new OptField[TypoAnyArray, Row](prefix, "most_common_elems", None, Some("anyarray"))(x => extract(x).mostCommonElems, (row, value) => merge(row, extract(row).copy(mostCommonElems = value)))
  override val mostCommonElemFreqs = new OptField[Array[Float], Row](prefix, "most_common_elem_freqs", None, Some("_float4"))(x => extract(x).mostCommonElemFreqs, (row, value) => merge(row, extract(row).copy(mostCommonElemFreqs = value)))
  override val elemCountHistogram = new OptField[Array[Float], Row](prefix, "elem_count_histogram", None, Some("_float4"))(x => extract(x).elemCountHistogram, (row, value) => merge(row, extract(row).copy(elemCountHistogram = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](schemaname, tablename, attname, inherited, nullFrac, avgWidth, nDistinct, mostCommonVals, mostCommonFreqs, histogramBounds, correlation, mostCommonElems, mostCommonElemFreqs, elemCountHistogram)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatsViewRow, merge: (NewRow, PgStatsViewRow) => NewRow): PgStatsViewStructure[NewRow] =
    new PgStatsViewStructure(prefix, extract, merge)
}