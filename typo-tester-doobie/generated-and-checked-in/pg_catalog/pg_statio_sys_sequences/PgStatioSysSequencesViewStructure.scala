/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_sequences

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatioSysSequencesViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatioSysSequencesViewRow, val merge: (Row, PgStatioSysSequencesViewRow) => Row)
  extends Relation[PgStatioSysSequencesViewFields, PgStatioSysSequencesViewRow, Row]
    with PgStatioSysSequencesViewFields[Row] { outer =>

  override val relid = new OptField[/* oid */ Long, Row](prefix, "relid", None, Some("oid"))(x => extract(x).relid, (row, value) => merge(row, extract(row).copy(relid = value)))
  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, Some("name"))(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val relname = new OptField[String, Row](prefix, "relname", None, Some("name"))(x => extract(x).relname, (row, value) => merge(row, extract(row).copy(relname = value)))
  override val blksRead = new OptField[Long, Row](prefix, "blks_read", None, Some("int8"))(x => extract(x).blksRead, (row, value) => merge(row, extract(row).copy(blksRead = value)))
  override val blksHit = new OptField[Long, Row](prefix, "blks_hit", None, Some("int8"))(x => extract(x).blksHit, (row, value) => merge(row, extract(row).copy(blksHit = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](relid, schemaname, relname, blksRead, blksHit)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatioSysSequencesViewRow, merge: (NewRow, PgStatioSysSequencesViewRow) => NewRow): PgStatioSysSequencesViewStructure[NewRow] =
    new PgStatioSysSequencesViewStructure(prefix, extract, merge)
}
