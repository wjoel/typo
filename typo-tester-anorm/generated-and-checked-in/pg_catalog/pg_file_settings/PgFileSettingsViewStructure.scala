/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_file_settings

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgFileSettingsViewStructure[Row](val prefix: Option[String], val extract: Row => PgFileSettingsViewRow, val merge: (Row, PgFileSettingsViewRow) => Row)
  extends Relation[PgFileSettingsViewFields, PgFileSettingsViewRow, Row]
    with PgFileSettingsViewFields[Row] { outer =>

  override val sourcefile = new OptField[String, Row](prefix, "sourcefile", None, None)(x => extract(x).sourcefile, (row, value) => merge(row, extract(row).copy(sourcefile = value)))
  override val sourceline = new OptField[Int, Row](prefix, "sourceline", None, Some("int4"))(x => extract(x).sourceline, (row, value) => merge(row, extract(row).copy(sourceline = value)))
  override val seqno = new OptField[Int, Row](prefix, "seqno", None, Some("int4"))(x => extract(x).seqno, (row, value) => merge(row, extract(row).copy(seqno = value)))
  override val name = new OptField[String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val setting = new OptField[String, Row](prefix, "setting", None, None)(x => extract(x).setting, (row, value) => merge(row, extract(row).copy(setting = value)))
  override val applied = new OptField[Boolean, Row](prefix, "applied", None, None)(x => extract(x).applied, (row, value) => merge(row, extract(row).copy(applied = value)))
  override val error = new OptField[String, Row](prefix, "error", None, None)(x => extract(x).error, (row, value) => merge(row, extract(row).copy(error = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](sourcefile, sourceline, seqno, name, setting, applied, error)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgFileSettingsViewRow, merge: (NewRow, PgFileSettingsViewRow) => NewRow): PgFileSettingsViewStructure[NewRow] =
    new PgFileSettingsViewStructure(prefix, extract, merge)
}
