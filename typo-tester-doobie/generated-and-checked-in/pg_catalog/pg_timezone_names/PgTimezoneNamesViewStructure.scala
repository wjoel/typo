/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_timezone_names

import adventureworks.TypoInterval
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgTimezoneNamesViewStructure[Row](val prefix: Option[String], val extract: Row => PgTimezoneNamesViewRow, val merge: (Row, PgTimezoneNamesViewRow) => Row)
  extends Relation[PgTimezoneNamesViewFields, PgTimezoneNamesViewRow, Row]
    with PgTimezoneNamesViewFields[Row] { outer =>

  override val name = new OptField[String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val abbrev = new OptField[String, Row](prefix, "abbrev", None, None)(x => extract(x).abbrev, (row, value) => merge(row, extract(row).copy(abbrev = value)))
  override val utcOffset = new OptField[TypoInterval, Row](prefix, "utc_offset", None, Some("interval"))(x => extract(x).utcOffset, (row, value) => merge(row, extract(row).copy(utcOffset = value)))
  override val isDst = new OptField[Boolean, Row](prefix, "is_dst", None, None)(x => extract(x).isDst, (row, value) => merge(row, extract(row).copy(isDst = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](name, abbrev, utcOffset, isDst)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgTimezoneNamesViewRow, merge: (NewRow, PgTimezoneNamesViewRow) => NewRow): PgTimezoneNamesViewStructure[NewRow] =
    new PgTimezoneNamesViewStructure(prefix, extract, merge)
}
