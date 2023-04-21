/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SalesterritoryRow(
  /** Primary key for SalesTerritory records. */
  territoryid: SalesterritoryId,
  /** Sales territory description */
  name: Name,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Geographic area to which the sales territory belong. */
  group: String,
  /** Sales in the territory year to date. */
  salesytd: BigDecimal,
  /** Sales in the territory the previous year. */
  saleslastyear: BigDecimal,
  /** Business costs in the territory year to date. */
  costytd: BigDecimal,
  /** Business costs in the territory the previous year. */
  costlastyear: BigDecimal,
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object SalesterritoryRow {
  implicit val oFormat: OFormat[SalesterritoryRow] = new OFormat[SalesterritoryRow]{
    override def writes(o: SalesterritoryRow): JsObject =
      Json.obj(
        "territoryid" -> o.territoryid,
        "name" -> o.name,
        "countryregioncode" -> o.countryregioncode,
        "group" -> o.group,
        "salesytd" -> o.salesytd,
        "saleslastyear" -> o.saleslastyear,
        "costytd" -> o.costytd,
        "costlastyear" -> o.costlastyear,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalesterritoryRow] = {
      JsResult.fromTry(
        Try(
          SalesterritoryRow(
            territoryid = json.\("territoryid").as[SalesterritoryId],
            name = json.\("name").as[Name],
            countryregioncode = json.\("countryregioncode").as[CountryregionId],
            group = json.\("group").as[String],
            salesytd = json.\("salesytd").as[BigDecimal],
            saleslastyear = json.\("saleslastyear").as[BigDecimal],
            costytd = json.\("costytd").as[BigDecimal],
            costlastyear = json.\("costlastyear").as[BigDecimal],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
