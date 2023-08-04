/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_collation

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgCollationFields[Row] {
  val oid: IdField[PgCollationId, Row]
  val collname: Field[String, Row]
  val collnamespace: Field[/* oid */ Long, Row]
  val collowner: Field[/* oid */ Long, Row]
  val collprovider: Field[String, Row]
  val collisdeterministic: Field[Boolean, Row]
  val collencoding: Field[Int, Row]
  val collcollate: Field[String, Row]
  val collctype: Field[String, Row]
  val collversion: OptField[String, Row]
}
object PgCollationFields extends PgCollationStructure[PgCollationRow](None, identity, (_, x) => x)
