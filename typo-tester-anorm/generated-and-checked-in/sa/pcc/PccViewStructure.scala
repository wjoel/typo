/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package pcc

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.creditcard.CreditcardId
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PccViewStructure[Row](val prefix: Option[String], val extract: Row => PccViewRow, val merge: (Row, PccViewRow) => Row)
  extends Relation[PccViewFields, PccViewRow, Row]
    with PccViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val businessentityid = new OptField[BusinessentityId, Row](prefix, "businessentityid", None, Some("int4"))(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val creditcardid = new OptField[CreditcardId, Row](prefix, "creditcardid", None, Some("int4"))(x => extract(x).creditcardid, (row, value) => merge(row, extract(row).copy(creditcardid = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, businessentityid, creditcardid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PccViewRow, merge: (NewRow, PccViewRow) => NewRow): PccViewStructure[NewRow] =
    new PccViewStructure(prefix, extract, merge)
}
