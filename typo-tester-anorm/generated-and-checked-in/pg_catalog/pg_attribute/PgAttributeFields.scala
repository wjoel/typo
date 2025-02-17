/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attribute

import adventureworks.TypoAclItem
import adventureworks.TypoAnyArray
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgAttributeFields[Row] {
  val attrelid: IdField[/* oid */ Long, Row]
  val attname: Field[String, Row]
  val atttypid: Field[/* oid */ Long, Row]
  val attstattarget: Field[Int, Row]
  val attlen: Field[Int, Row]
  val attnum: IdField[Int, Row]
  val attndims: Field[Int, Row]
  val attcacheoff: Field[Int, Row]
  val atttypmod: Field[Int, Row]
  val attbyval: Field[Boolean, Row]
  val attalign: Field[String, Row]
  val attstorage: Field[String, Row]
  val attcompression: Field[String, Row]
  val attnotnull: Field[Boolean, Row]
  val atthasdef: Field[Boolean, Row]
  val atthasmissing: Field[Boolean, Row]
  val attidentity: Field[String, Row]
  val attgenerated: Field[String, Row]
  val attisdropped: Field[Boolean, Row]
  val attislocal: Field[Boolean, Row]
  val attinhcount: Field[Int, Row]
  val attcollation: Field[/* oid */ Long, Row]
  val attacl: OptField[Array[TypoAclItem], Row]
  val attoptions: OptField[Array[String], Row]
  val attfdwoptions: OptField[Array[String], Row]
  val attmissingval: OptField[TypoAnyArray, Row]
}
object PgAttributeFields extends PgAttributeStructure[PgAttributeRow](None, identity, (_, x) => x)

