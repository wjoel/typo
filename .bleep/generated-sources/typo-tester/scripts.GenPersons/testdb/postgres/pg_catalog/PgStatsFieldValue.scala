package testdb
package postgres
package pg_catalog



sealed abstract class PgStatsFieldValue[T](val name: String, val value: T)

object PgStatsFieldValue {
  case class schemaname(override val value: String) extends PgStatsFieldValue("schemaname", value)
  case class tablename(override val value: String) extends PgStatsFieldValue("tablename", value)
  case class attname(override val value: String) extends PgStatsFieldValue("attname", value)
  case class inherited(override val value: Boolean) extends PgStatsFieldValue("inherited", value)
  case class nullFrac(override val value: Float) extends PgStatsFieldValue("null_frac", value)
  case class avgWidth(override val value: Int) extends PgStatsFieldValue("avg_width", value)
  case class nDistinct(override val value: Float) extends PgStatsFieldValue("n_distinct", value)
  case class mostCommonVals(override val value: /* unknown nullability */ Option[/* anyarray */ String]) extends PgStatsFieldValue("most_common_vals", value)
  case class mostCommonFreqs(override val value: /* unknown nullability */ Option[Array[Float]]) extends PgStatsFieldValue("most_common_freqs", value)
  case class histogramBounds(override val value: /* unknown nullability */ Option[/* anyarray */ String]) extends PgStatsFieldValue("histogram_bounds", value)
  case class correlation(override val value: /* unknown nullability */ Option[Float]) extends PgStatsFieldValue("correlation", value)
  case class mostCommonElems(override val value: /* unknown nullability */ Option[/* anyarray */ String]) extends PgStatsFieldValue("most_common_elems", value)
  case class mostCommonElemFreqs(override val value: /* unknown nullability */ Option[Array[Float]]) extends PgStatsFieldValue("most_common_elem_freqs", value)
  case class elemCountHistogram(override val value: /* unknown nullability */ Option[Array[Float]]) extends PgStatsFieldValue("elem_count_histogram", value)
}