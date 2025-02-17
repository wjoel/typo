/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_settings

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgSettingsViewStructure[Row](val prefix: Option[String], val extract: Row => PgSettingsViewRow, val merge: (Row, PgSettingsViewRow) => Row)
  extends Relation[PgSettingsViewFields, PgSettingsViewRow, Row]
    with PgSettingsViewFields[Row] { outer =>

  override val name = new OptField[String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val setting = new OptField[String, Row](prefix, "setting", None, None)(x => extract(x).setting, (row, value) => merge(row, extract(row).copy(setting = value)))
  override val unit = new OptField[String, Row](prefix, "unit", None, None)(x => extract(x).unit, (row, value) => merge(row, extract(row).copy(unit = value)))
  override val category = new OptField[String, Row](prefix, "category", None, None)(x => extract(x).category, (row, value) => merge(row, extract(row).copy(category = value)))
  override val shortDesc = new OptField[String, Row](prefix, "short_desc", None, None)(x => extract(x).shortDesc, (row, value) => merge(row, extract(row).copy(shortDesc = value)))
  override val extraDesc = new OptField[String, Row](prefix, "extra_desc", None, None)(x => extract(x).extraDesc, (row, value) => merge(row, extract(row).copy(extraDesc = value)))
  override val context = new OptField[String, Row](prefix, "context", None, None)(x => extract(x).context, (row, value) => merge(row, extract(row).copy(context = value)))
  override val vartype = new OptField[String, Row](prefix, "vartype", None, None)(x => extract(x).vartype, (row, value) => merge(row, extract(row).copy(vartype = value)))
  override val source = new OptField[String, Row](prefix, "source", None, None)(x => extract(x).source, (row, value) => merge(row, extract(row).copy(source = value)))
  override val minVal = new OptField[String, Row](prefix, "min_val", None, None)(x => extract(x).minVal, (row, value) => merge(row, extract(row).copy(minVal = value)))
  override val maxVal = new OptField[String, Row](prefix, "max_val", None, None)(x => extract(x).maxVal, (row, value) => merge(row, extract(row).copy(maxVal = value)))
  override val enumvals = new OptField[Array[String], Row](prefix, "enumvals", None, Some("_text"))(x => extract(x).enumvals, (row, value) => merge(row, extract(row).copy(enumvals = value)))
  override val bootVal = new OptField[String, Row](prefix, "boot_val", None, None)(x => extract(x).bootVal, (row, value) => merge(row, extract(row).copy(bootVal = value)))
  override val resetVal = new OptField[String, Row](prefix, "reset_val", None, None)(x => extract(x).resetVal, (row, value) => merge(row, extract(row).copy(resetVal = value)))
  override val sourcefile = new OptField[String, Row](prefix, "sourcefile", None, None)(x => extract(x).sourcefile, (row, value) => merge(row, extract(row).copy(sourcefile = value)))
  override val sourceline = new OptField[Int, Row](prefix, "sourceline", None, Some("int4"))(x => extract(x).sourceline, (row, value) => merge(row, extract(row).copy(sourceline = value)))
  override val pendingRestart = new OptField[Boolean, Row](prefix, "pending_restart", None, None)(x => extract(x).pendingRestart, (row, value) => merge(row, extract(row).copy(pendingRestart = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](name, setting, unit, category, shortDesc, extraDesc, context, vartype, source, minVal, maxVal, enumvals, bootVal, resetVal, sourcefile, sourceline, pendingRestart)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgSettingsViewRow, merge: (NewRow, PgSettingsViewRow) => NewRow): PgSettingsViewStructure[NewRow] =
    new PgSettingsViewStructure(prefix, extract, merge)
}
