/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import java.util.UUID
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class StViewStructure[Row](val prefix: Option[String], val extract: Row => StViewRow, val merge: (Row, StViewRow) => Row)
  extends Relation[StViewFields, StViewRow, Row]
    with StViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val territoryid = new OptField[SalesterritoryId, Row](prefix, "territoryid", None, Some("int4"))(x => extract(x).territoryid, (row, value) => merge(row, extract(row).copy(territoryid = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val countryregioncode = new OptField[CountryregionId, Row](prefix, "countryregioncode", None, None)(x => extract(x).countryregioncode, (row, value) => merge(row, extract(row).copy(countryregioncode = value)))
  override val group = new OptField[/* max 50 chars */ String, Row](prefix, "group", None, None)(x => extract(x).group, (row, value) => merge(row, extract(row).copy(group = value)))
  override val salesytd = new OptField[BigDecimal, Row](prefix, "salesytd", None, Some("numeric"))(x => extract(x).salesytd, (row, value) => merge(row, extract(row).copy(salesytd = value)))
  override val saleslastyear = new OptField[BigDecimal, Row](prefix, "saleslastyear", None, Some("numeric"))(x => extract(x).saleslastyear, (row, value) => merge(row, extract(row).copy(saleslastyear = value)))
  override val costytd = new OptField[BigDecimal, Row](prefix, "costytd", None, Some("numeric"))(x => extract(x).costytd, (row, value) => merge(row, extract(row).copy(costytd = value)))
  override val costlastyear = new OptField[BigDecimal, Row](prefix, "costlastyear", None, Some("numeric"))(x => extract(x).costlastyear, (row, value) => merge(row, extract(row).copy(costlastyear = value)))
  override val rowguid = new OptField[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, territoryid, name, countryregioncode, group, salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => StViewRow, merge: (NewRow, StViewRow) => NewRow): StViewStructure[NewRow] =
    new StViewStructure(prefix, extract, merge)
}
