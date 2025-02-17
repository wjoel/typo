/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import adventureworks.TypoInt2Vector
import adventureworks.TypoPgNodeTree
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgStatisticExtFields[Row] {
  val oid: IdField[PgStatisticExtId, Row]
  val stxrelid: Field[/* oid */ Long, Row]
  val stxname: Field[String, Row]
  val stxnamespace: Field[/* oid */ Long, Row]
  val stxowner: Field[/* oid */ Long, Row]
  val stxstattarget: Field[Int, Row]
  val stxkeys: Field[TypoInt2Vector, Row]
  val stxkind: Field[Array[String], Row]
  val stxexprs: OptField[TypoPgNodeTree, Row]
}
object PgStatisticExtFields extends PgStatisticExtStructure[PgStatisticExtRow](None, identity, (_, x) => x)

