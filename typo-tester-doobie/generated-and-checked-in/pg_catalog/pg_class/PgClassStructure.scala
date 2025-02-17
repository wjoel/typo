/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_class

import adventureworks.TypoAclItem
import adventureworks.TypoPgNodeTree
import adventureworks.TypoXid
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgClassStructure[Row](val prefix: Option[String], val extract: Row => PgClassRow, val merge: (Row, PgClassRow) => Row)
  extends Relation[PgClassFields, PgClassRow, Row]
    with PgClassFields[Row] { outer =>

  override val oid = new IdField[PgClassId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val relname = new Field[String, Row](prefix, "relname", None, Some("name"))(x => extract(x).relname, (row, value) => merge(row, extract(row).copy(relname = value)))
  override val relnamespace = new Field[/* oid */ Long, Row](prefix, "relnamespace", None, Some("oid"))(x => extract(x).relnamespace, (row, value) => merge(row, extract(row).copy(relnamespace = value)))
  override val reltype = new Field[/* oid */ Long, Row](prefix, "reltype", None, Some("oid"))(x => extract(x).reltype, (row, value) => merge(row, extract(row).copy(reltype = value)))
  override val reloftype = new Field[/* oid */ Long, Row](prefix, "reloftype", None, Some("oid"))(x => extract(x).reloftype, (row, value) => merge(row, extract(row).copy(reloftype = value)))
  override val relowner = new Field[/* oid */ Long, Row](prefix, "relowner", None, Some("oid"))(x => extract(x).relowner, (row, value) => merge(row, extract(row).copy(relowner = value)))
  override val relam = new Field[/* oid */ Long, Row](prefix, "relam", None, Some("oid"))(x => extract(x).relam, (row, value) => merge(row, extract(row).copy(relam = value)))
  override val relfilenode = new Field[/* oid */ Long, Row](prefix, "relfilenode", None, Some("oid"))(x => extract(x).relfilenode, (row, value) => merge(row, extract(row).copy(relfilenode = value)))
  override val reltablespace = new Field[/* oid */ Long, Row](prefix, "reltablespace", None, Some("oid"))(x => extract(x).reltablespace, (row, value) => merge(row, extract(row).copy(reltablespace = value)))
  override val relpages = new Field[Int, Row](prefix, "relpages", None, Some("int4"))(x => extract(x).relpages, (row, value) => merge(row, extract(row).copy(relpages = value)))
  override val reltuples = new Field[Float, Row](prefix, "reltuples", None, Some("float4"))(x => extract(x).reltuples, (row, value) => merge(row, extract(row).copy(reltuples = value)))
  override val relallvisible = new Field[Int, Row](prefix, "relallvisible", None, Some("int4"))(x => extract(x).relallvisible, (row, value) => merge(row, extract(row).copy(relallvisible = value)))
  override val reltoastrelid = new Field[/* oid */ Long, Row](prefix, "reltoastrelid", None, Some("oid"))(x => extract(x).reltoastrelid, (row, value) => merge(row, extract(row).copy(reltoastrelid = value)))
  override val relhasindex = new Field[Boolean, Row](prefix, "relhasindex", None, None)(x => extract(x).relhasindex, (row, value) => merge(row, extract(row).copy(relhasindex = value)))
  override val relisshared = new Field[Boolean, Row](prefix, "relisshared", None, None)(x => extract(x).relisshared, (row, value) => merge(row, extract(row).copy(relisshared = value)))
  override val relpersistence = new Field[String, Row](prefix, "relpersistence", None, Some("char"))(x => extract(x).relpersistence, (row, value) => merge(row, extract(row).copy(relpersistence = value)))
  override val relkind = new Field[String, Row](prefix, "relkind", None, Some("char"))(x => extract(x).relkind, (row, value) => merge(row, extract(row).copy(relkind = value)))
  override val relnatts = new Field[Int, Row](prefix, "relnatts", None, Some("int2"))(x => extract(x).relnatts, (row, value) => merge(row, extract(row).copy(relnatts = value)))
  override val relchecks = new Field[Int, Row](prefix, "relchecks", None, Some("int2"))(x => extract(x).relchecks, (row, value) => merge(row, extract(row).copy(relchecks = value)))
  override val relhasrules = new Field[Boolean, Row](prefix, "relhasrules", None, None)(x => extract(x).relhasrules, (row, value) => merge(row, extract(row).copy(relhasrules = value)))
  override val relhastriggers = new Field[Boolean, Row](prefix, "relhastriggers", None, None)(x => extract(x).relhastriggers, (row, value) => merge(row, extract(row).copy(relhastriggers = value)))
  override val relhassubclass = new Field[Boolean, Row](prefix, "relhassubclass", None, None)(x => extract(x).relhassubclass, (row, value) => merge(row, extract(row).copy(relhassubclass = value)))
  override val relrowsecurity = new Field[Boolean, Row](prefix, "relrowsecurity", None, None)(x => extract(x).relrowsecurity, (row, value) => merge(row, extract(row).copy(relrowsecurity = value)))
  override val relforcerowsecurity = new Field[Boolean, Row](prefix, "relforcerowsecurity", None, None)(x => extract(x).relforcerowsecurity, (row, value) => merge(row, extract(row).copy(relforcerowsecurity = value)))
  override val relispopulated = new Field[Boolean, Row](prefix, "relispopulated", None, None)(x => extract(x).relispopulated, (row, value) => merge(row, extract(row).copy(relispopulated = value)))
  override val relreplident = new Field[String, Row](prefix, "relreplident", None, Some("char"))(x => extract(x).relreplident, (row, value) => merge(row, extract(row).copy(relreplident = value)))
  override val relispartition = new Field[Boolean, Row](prefix, "relispartition", None, None)(x => extract(x).relispartition, (row, value) => merge(row, extract(row).copy(relispartition = value)))
  override val relrewrite = new Field[/* oid */ Long, Row](prefix, "relrewrite", None, Some("oid"))(x => extract(x).relrewrite, (row, value) => merge(row, extract(row).copy(relrewrite = value)))
  override val relfrozenxid = new Field[TypoXid, Row](prefix, "relfrozenxid", None, Some("xid"))(x => extract(x).relfrozenxid, (row, value) => merge(row, extract(row).copy(relfrozenxid = value)))
  override val relminmxid = new Field[TypoXid, Row](prefix, "relminmxid", None, Some("xid"))(x => extract(x).relminmxid, (row, value) => merge(row, extract(row).copy(relminmxid = value)))
  override val relacl = new OptField[Array[TypoAclItem], Row](prefix, "relacl", None, Some("_aclitem"))(x => extract(x).relacl, (row, value) => merge(row, extract(row).copy(relacl = value)))
  override val reloptions = new OptField[Array[String], Row](prefix, "reloptions", None, Some("_text"))(x => extract(x).reloptions, (row, value) => merge(row, extract(row).copy(reloptions = value)))
  override val relpartbound = new OptField[TypoPgNodeTree, Row](prefix, "relpartbound", None, Some("pg_node_tree"))(x => extract(x).relpartbound, (row, value) => merge(row, extract(row).copy(relpartbound = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgClassRow, merge: (NewRow, PgClassRow) => NewRow): PgClassStructure[NewRow] =
    new PgClassStructure(prefix, extract, merge)
}
