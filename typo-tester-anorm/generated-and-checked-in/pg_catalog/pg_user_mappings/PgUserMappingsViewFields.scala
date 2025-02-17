/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mappings

import typo.dsl.SqlExpr.OptField

trait PgUserMappingsViewFields[Row] {
  val umid: OptField[/* oid */ Long, Row]
  val srvid: OptField[/* oid */ Long, Row]
  val srvname: OptField[String, Row]
  val umuser: OptField[/* oid */ Long, Row]
  val usename: OptField[String, Row]
  val umoptions: OptField[Array[String], Row]
}
object PgUserMappingsViewFields extends PgUserMappingsViewStructure[PgUserMappingsViewRow](None, identity, (_, x) => x)

