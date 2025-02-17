/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import adventureworks.TypoRegproc
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgOperatorFields[Row] {
  val oid: IdField[PgOperatorId, Row]
  val oprname: Field[String, Row]
  val oprnamespace: Field[/* oid */ Long, Row]
  val oprowner: Field[/* oid */ Long, Row]
  val oprkind: Field[String, Row]
  val oprcanmerge: Field[Boolean, Row]
  val oprcanhash: Field[Boolean, Row]
  val oprleft: Field[/* oid */ Long, Row]
  val oprright: Field[/* oid */ Long, Row]
  val oprresult: Field[/* oid */ Long, Row]
  val oprcom: Field[/* oid */ Long, Row]
  val oprnegate: Field[/* oid */ Long, Row]
  val oprcode: Field[TypoRegproc, Row]
  val oprrest: Field[TypoRegproc, Row]
  val oprjoin: Field[TypoRegproc, Row]
}
object PgOperatorFields extends PgOperatorStructure[PgOperatorRow](None, identity, (_, x) => x)

