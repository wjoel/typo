/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_rewrite

import adventureworks.TypoPgNodeTree
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgRewriteFields[Row] {
  val oid: IdField[PgRewriteId, Row]
  val rulename: Field[String, Row]
  val evClass: Field[/* oid */ Long, Row]
  val evType: Field[String, Row]
  val evEnabled: Field[String, Row]
  val isInstead: Field[Boolean, Row]
  val evQual: Field[TypoPgNodeTree, Row]
  val evAction: Field[TypoPgNodeTree, Row]
}
object PgRewriteFields extends PgRewriteStructure[PgRewriteRow](None, identity, (_, x) => x)
