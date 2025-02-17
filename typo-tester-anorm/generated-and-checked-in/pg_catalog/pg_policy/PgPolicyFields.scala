/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_policy

import adventureworks.TypoPgNodeTree
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgPolicyFields[Row] {
  val oid: IdField[PgPolicyId, Row]
  val polname: Field[String, Row]
  val polrelid: Field[/* oid */ Long, Row]
  val polcmd: Field[String, Row]
  val polpermissive: Field[Boolean, Row]
  val polroles: Field[Array[/* oid */ Long], Row]
  val polqual: OptField[TypoPgNodeTree, Row]
  val polwithcheck: OptField[TypoPgNodeTree, Row]
}
object PgPolicyFields extends PgPolicyStructure[PgPolicyRow](None, identity, (_, x) => x)

