/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class SpViewStructure[Row](val prefix: Option[String], val extract: Row => SpViewRow, val merge: (Row, SpViewRow) => Row)
  extends Relation[SpViewFields, SpViewRow, Row]
    with SpViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val stateprovinceid = new OptField[StateprovinceId, Row](prefix, "stateprovinceid", None, Some("int4"))(x => extract(x).stateprovinceid, (row, value) => merge(row, extract(row).copy(stateprovinceid = value)))
  override val stateprovincecode = new OptField[/* bpchar */ String, Row](prefix, "stateprovincecode", None, Some("bpchar"))(x => extract(x).stateprovincecode, (row, value) => merge(row, extract(row).copy(stateprovincecode = value)))
  override val countryregioncode = new OptField[CountryregionId, Row](prefix, "countryregioncode", None, None)(x => extract(x).countryregioncode, (row, value) => merge(row, extract(row).copy(countryregioncode = value)))
  override val isonlystateprovinceflag = new Field[Flag, Row](prefix, "isonlystateprovinceflag", None, Some(""""public"."Flag""""))(x => extract(x).isonlystateprovinceflag, (row, value) => merge(row, extract(row).copy(isonlystateprovinceflag = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val territoryid = new OptField[SalesterritoryId, Row](prefix, "territoryid", None, Some("int4"))(x => extract(x).territoryid, (row, value) => merge(row, extract(row).copy(territoryid = value)))
  override val rowguid = new OptField[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, name, territoryid, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SpViewRow, merge: (NewRow, SpViewRow) => NewRow): SpViewStructure[NewRow] =
    new SpViewStructure(prefix, extract, merge)
}
