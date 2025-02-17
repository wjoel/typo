/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_rel

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class PgPublicationRelStructure[Row](val prefix: Option[String], val extract: Row => PgPublicationRelRow, val merge: (Row, PgPublicationRelRow) => Row)
  extends Relation[PgPublicationRelFields, PgPublicationRelRow, Row]
    with PgPublicationRelFields[Row] { outer =>

  override val oid = new IdField[PgPublicationRelId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val prpubid = new Field[/* oid */ Long, Row](prefix, "prpubid", None, Some("oid"))(x => extract(x).prpubid, (row, value) => merge(row, extract(row).copy(prpubid = value)))
  override val prrelid = new Field[/* oid */ Long, Row](prefix, "prrelid", None, Some("oid"))(x => extract(x).prrelid, (row, value) => merge(row, extract(row).copy(prrelid = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, prpubid, prrelid)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgPublicationRelRow, merge: (NewRow, PgPublicationRelRow) => NewRow): PgPublicationRelStructure[NewRow] =
    new PgPublicationRelStructure(prefix, extract, merge)
}
