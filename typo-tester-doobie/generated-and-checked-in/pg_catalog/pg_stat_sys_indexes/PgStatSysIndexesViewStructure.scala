/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_sys_indexes

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatSysIndexesViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatSysIndexesViewRow, val merge: (Row, PgStatSysIndexesViewRow) => Row)
  extends Relation[PgStatSysIndexesViewFields, PgStatSysIndexesViewRow, Row]
    with PgStatSysIndexesViewFields[Row] { outer =>

  override val relid = new OptField[/* oid */ Long, Row](prefix, "relid", None, Some("oid"))(x => extract(x).relid, (row, value) => merge(row, extract(row).copy(relid = value)))
  override val indexrelid = new OptField[/* oid */ Long, Row](prefix, "indexrelid", None, Some("oid"))(x => extract(x).indexrelid, (row, value) => merge(row, extract(row).copy(indexrelid = value)))
  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, Some("name"))(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val relname = new OptField[String, Row](prefix, "relname", None, Some("name"))(x => extract(x).relname, (row, value) => merge(row, extract(row).copy(relname = value)))
  override val indexrelname = new OptField[String, Row](prefix, "indexrelname", None, Some("name"))(x => extract(x).indexrelname, (row, value) => merge(row, extract(row).copy(indexrelname = value)))
  override val idxScan = new OptField[Long, Row](prefix, "idx_scan", None, Some("int8"))(x => extract(x).idxScan, (row, value) => merge(row, extract(row).copy(idxScan = value)))
  override val idxTupRead = new OptField[Long, Row](prefix, "idx_tup_read", None, Some("int8"))(x => extract(x).idxTupRead, (row, value) => merge(row, extract(row).copy(idxTupRead = value)))
  override val idxTupFetch = new OptField[Long, Row](prefix, "idx_tup_fetch", None, Some("int8"))(x => extract(x).idxTupFetch, (row, value) => merge(row, extract(row).copy(idxTupFetch = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](relid, indexrelid, schemaname, relname, indexrelname, idxScan, idxTupRead, idxTupFetch)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatSysIndexesViewRow, merge: (NewRow, PgStatSysIndexesViewRow) => NewRow): PgStatSysIndexesViewStructure[NewRow] =
    new PgStatSysIndexesViewStructure(prefix, extract, merge)
}
