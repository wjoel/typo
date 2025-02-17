/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import adventureworks.TypoAclItem
import adventureworks.TypoOidVector
import adventureworks.TypoPgNodeTree
import adventureworks.TypoRegproc
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgProcFields[Row] {
  val oid: IdField[PgProcId, Row]
  val proname: Field[String, Row]
  val pronamespace: Field[/* oid */ Long, Row]
  val proowner: Field[/* oid */ Long, Row]
  val prolang: Field[/* oid */ Long, Row]
  val procost: Field[Float, Row]
  val prorows: Field[Float, Row]
  val provariadic: Field[/* oid */ Long, Row]
  val prosupport: Field[TypoRegproc, Row]
  val prokind: Field[String, Row]
  val prosecdef: Field[Boolean, Row]
  val proleakproof: Field[Boolean, Row]
  val proisstrict: Field[Boolean, Row]
  val proretset: Field[Boolean, Row]
  val provolatile: Field[String, Row]
  val proparallel: Field[String, Row]
  val pronargs: Field[Int, Row]
  val pronargdefaults: Field[Int, Row]
  val prorettype: Field[/* oid */ Long, Row]
  val proargtypes: Field[TypoOidVector, Row]
  val proallargtypes: OptField[Array[/* oid */ Long], Row]
  val proargmodes: OptField[Array[String], Row]
  val proargnames: OptField[Array[String], Row]
  val proargdefaults: OptField[TypoPgNodeTree, Row]
  val protrftypes: OptField[Array[/* oid */ Long], Row]
  val prosrc: Field[String, Row]
  val probin: OptField[String, Row]
  val prosqlbody: OptField[TypoPgNodeTree, Row]
  val proconfig: OptField[Array[String], Row]
  val proacl: OptField[Array[TypoAclItem], Row]
}
object PgProcFields extends PgProcStructure[PgProcRow](None, identity, (_, x) => x)

