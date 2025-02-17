/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_authid

import adventureworks.TypoOffsetDateTime
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgAuthidStructure[Row](val prefix: Option[String], val extract: Row => PgAuthidRow, val merge: (Row, PgAuthidRow) => Row)
  extends Relation[PgAuthidFields, PgAuthidRow, Row]
    with PgAuthidFields[Row] { outer =>

  override val oid = new IdField[PgAuthidId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val rolname = new Field[String, Row](prefix, "rolname", None, Some("name"))(x => extract(x).rolname, (row, value) => merge(row, extract(row).copy(rolname = value)))
  override val rolsuper = new Field[Boolean, Row](prefix, "rolsuper", None, None)(x => extract(x).rolsuper, (row, value) => merge(row, extract(row).copy(rolsuper = value)))
  override val rolinherit = new Field[Boolean, Row](prefix, "rolinherit", None, None)(x => extract(x).rolinherit, (row, value) => merge(row, extract(row).copy(rolinherit = value)))
  override val rolcreaterole = new Field[Boolean, Row](prefix, "rolcreaterole", None, None)(x => extract(x).rolcreaterole, (row, value) => merge(row, extract(row).copy(rolcreaterole = value)))
  override val rolcreatedb = new Field[Boolean, Row](prefix, "rolcreatedb", None, None)(x => extract(x).rolcreatedb, (row, value) => merge(row, extract(row).copy(rolcreatedb = value)))
  override val rolcanlogin = new Field[Boolean, Row](prefix, "rolcanlogin", None, None)(x => extract(x).rolcanlogin, (row, value) => merge(row, extract(row).copy(rolcanlogin = value)))
  override val rolreplication = new Field[Boolean, Row](prefix, "rolreplication", None, None)(x => extract(x).rolreplication, (row, value) => merge(row, extract(row).copy(rolreplication = value)))
  override val rolbypassrls = new Field[Boolean, Row](prefix, "rolbypassrls", None, None)(x => extract(x).rolbypassrls, (row, value) => merge(row, extract(row).copy(rolbypassrls = value)))
  override val rolconnlimit = new Field[Int, Row](prefix, "rolconnlimit", None, Some("int4"))(x => extract(x).rolconnlimit, (row, value) => merge(row, extract(row).copy(rolconnlimit = value)))
  override val rolpassword = new OptField[String, Row](prefix, "rolpassword", None, None)(x => extract(x).rolpassword, (row, value) => merge(row, extract(row).copy(rolpassword = value)))
  override val rolvaliduntil = new OptField[TypoOffsetDateTime, Row](prefix, "rolvaliduntil", Some("text"), Some("timestamptz"))(x => extract(x).rolvaliduntil, (row, value) => merge(row, extract(row).copy(rolvaliduntil = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgAuthidRow, merge: (NewRow, PgAuthidRow) => NewRow): PgAuthidStructure[NewRow] =
    new PgAuthidStructure(prefix, extract, merge)
}
