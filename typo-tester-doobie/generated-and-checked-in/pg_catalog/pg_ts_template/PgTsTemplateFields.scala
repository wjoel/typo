/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_template

import adventureworks.TypoRegproc
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgTsTemplateFields[Row] {
  val oid: IdField[PgTsTemplateId, Row]
  val tmplname: Field[String, Row]
  val tmplnamespace: Field[/* oid */ Long, Row]
  val tmplinit: Field[TypoRegproc, Row]
  val tmpllexize: Field[TypoRegproc, Row]
}
object PgTsTemplateFields extends PgTsTemplateStructure[PgTsTemplateRow](None, identity, (_, x) => x)

