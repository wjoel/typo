/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bea

import adventureworks.TypoLocalDateTime
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import java.util.UUID
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class BeaViewStructure[Row](val prefix: Option[String], val extract: Row => BeaViewRow, val merge: (Row, BeaViewRow) => Row)
  extends Relation[BeaViewFields, BeaViewRow, Row]
    with BeaViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val businessentityid = new OptField[BusinessentityId, Row](prefix, "businessentityid", None, Some("int4"))(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val addressid = new OptField[AddressId, Row](prefix, "addressid", None, Some("int4"))(x => extract(x).addressid, (row, value) => merge(row, extract(row).copy(addressid = value)))
  override val addresstypeid = new OptField[AddresstypeId, Row](prefix, "addresstypeid", None, Some("int4"))(x => extract(x).addresstypeid, (row, value) => merge(row, extract(row).copy(addresstypeid = value)))
  override val rowguid = new OptField[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, businessentityid, addressid, addresstypeid, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => BeaViewRow, merge: (NewRow, BeaViewRow) => NewRow): BeaViewStructure[NewRow] =
    new BeaViewStructure(prefix, extract, merge)
}
