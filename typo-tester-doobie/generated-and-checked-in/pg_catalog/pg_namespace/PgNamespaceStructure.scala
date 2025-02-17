/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_namespace

import adventureworks.TypoAclItem
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgNamespaceStructure[Row](val prefix: Option[String], val extract: Row => PgNamespaceRow, val merge: (Row, PgNamespaceRow) => Row)
  extends Relation[PgNamespaceFields, PgNamespaceRow, Row]
    with PgNamespaceFields[Row] { outer =>

  override val oid = new IdField[PgNamespaceId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val nspname = new Field[String, Row](prefix, "nspname", None, Some("name"))(x => extract(x).nspname, (row, value) => merge(row, extract(row).copy(nspname = value)))
  override val nspowner = new Field[/* oid */ Long, Row](prefix, "nspowner", None, Some("oid"))(x => extract(x).nspowner, (row, value) => merge(row, extract(row).copy(nspowner = value)))
  override val nspacl = new OptField[Array[TypoAclItem], Row](prefix, "nspacl", None, Some("_aclitem"))(x => extract(x).nspacl, (row, value) => merge(row, extract(row).copy(nspacl = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, nspname, nspowner, nspacl)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgNamespaceRow, merge: (NewRow, PgNamespaceRow) => NewRow): PgNamespaceStructure[NewRow] =
    new PgNamespaceStructure(prefix, extract, merge)
}
