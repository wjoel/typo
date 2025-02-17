/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_parser

import adventureworks.TypoRegproc
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class PgTsParserStructure[Row](val prefix: Option[String], val extract: Row => PgTsParserRow, val merge: (Row, PgTsParserRow) => Row)
  extends Relation[PgTsParserFields, PgTsParserRow, Row]
    with PgTsParserFields[Row] { outer =>

  override val oid = new IdField[PgTsParserId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val prsname = new Field[String, Row](prefix, "prsname", None, Some("name"))(x => extract(x).prsname, (row, value) => merge(row, extract(row).copy(prsname = value)))
  override val prsnamespace = new Field[/* oid */ Long, Row](prefix, "prsnamespace", None, Some("oid"))(x => extract(x).prsnamespace, (row, value) => merge(row, extract(row).copy(prsnamespace = value)))
  override val prsstart = new Field[TypoRegproc, Row](prefix, "prsstart", None, Some("regproc"))(x => extract(x).prsstart, (row, value) => merge(row, extract(row).copy(prsstart = value)))
  override val prstoken = new Field[TypoRegproc, Row](prefix, "prstoken", None, Some("regproc"))(x => extract(x).prstoken, (row, value) => merge(row, extract(row).copy(prstoken = value)))
  override val prsend = new Field[TypoRegproc, Row](prefix, "prsend", None, Some("regproc"))(x => extract(x).prsend, (row, value) => merge(row, extract(row).copy(prsend = value)))
  override val prsheadline = new Field[TypoRegproc, Row](prefix, "prsheadline", None, Some("regproc"))(x => extract(x).prsheadline, (row, value) => merge(row, extract(row).copy(prsheadline = value)))
  override val prslextype = new Field[TypoRegproc, Row](prefix, "prslextype", None, Some("regproc"))(x => extract(x).prslextype, (row, value) => merge(row, extract(row).copy(prslextype = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgTsParserRow, merge: (NewRow, PgTsParserRow) => NewRow): PgTsParserStructure[NewRow] =
    new PgTsParserStructure(prefix, extract, merge)
}
