/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tables

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgTablesViewStructure[Row](val prefix: Option[String], val extract: Row => PgTablesViewRow, val merge: (Row, PgTablesViewRow) => Row)
  extends Relation[PgTablesViewFields, PgTablesViewRow, Row]
    with PgTablesViewFields[Row] { outer =>

  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, Some("name"))(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val tablename = new OptField[String, Row](prefix, "tablename", None, Some("name"))(x => extract(x).tablename, (row, value) => merge(row, extract(row).copy(tablename = value)))
  override val tableowner = new OptField[String, Row](prefix, "tableowner", None, Some("name"))(x => extract(x).tableowner, (row, value) => merge(row, extract(row).copy(tableowner = value)))
  override val tablespace = new OptField[String, Row](prefix, "tablespace", None, Some("name"))(x => extract(x).tablespace, (row, value) => merge(row, extract(row).copy(tablespace = value)))
  override val hasindexes = new OptField[Boolean, Row](prefix, "hasindexes", None, None)(x => extract(x).hasindexes, (row, value) => merge(row, extract(row).copy(hasindexes = value)))
  override val hasrules = new OptField[Boolean, Row](prefix, "hasrules", None, None)(x => extract(x).hasrules, (row, value) => merge(row, extract(row).copy(hasrules = value)))
  override val hastriggers = new OptField[Boolean, Row](prefix, "hastriggers", None, None)(x => extract(x).hastriggers, (row, value) => merge(row, extract(row).copy(hastriggers = value)))
  override val rowsecurity = new OptField[Boolean, Row](prefix, "rowsecurity", None, None)(x => extract(x).rowsecurity, (row, value) => merge(row, extract(row).copy(rowsecurity = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](schemaname, tablename, tableowner, tablespace, hasindexes, hasrules, hastriggers, rowsecurity)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgTablesViewRow, merge: (NewRow, PgTablesViewRow) => NewRow): PgTablesViewStructure[NewRow] =
    new PgTablesViewStructure(prefix, extract, merge)
}
