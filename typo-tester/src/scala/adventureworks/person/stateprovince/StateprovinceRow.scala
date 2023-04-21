/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class StateprovinceRow(
  /** Primary key for StateProvince records. */
  stateprovinceid: StateprovinceId,
  /** ISO standard state or province code. */
  stateprovincecode: /* bpchar */ String,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** 0 = StateProvinceCode exists. 1 = StateProvinceCode unavailable, using CountryRegionCode. */
  isonlystateprovinceflag: Flag,
  /** State or province description. */
  name: Name,
  /** ID of the territory in which the state or province is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object StateprovinceRow {
  implicit val oFormat: OFormat[StateprovinceRow] = new OFormat[StateprovinceRow]{
    override def writes(o: StateprovinceRow): JsObject =
      Json.obj(
        "stateprovinceid" -> o.stateprovinceid,
        "stateprovincecode" -> o.stateprovincecode,
        "countryregioncode" -> o.countryregioncode,
        "isonlystateprovinceflag" -> o.isonlystateprovinceflag,
        "name" -> o.name,
        "territoryid" -> o.territoryid,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[StateprovinceRow] = {
      JsResult.fromTry(
        Try(
          StateprovinceRow(
            stateprovinceid = json.\("stateprovinceid").as[StateprovinceId],
            stateprovincecode = json.\("stateprovincecode").as[/* bpchar */ String],
            countryregioncode = json.\("countryregioncode").as[CountryregionId],
            isonlystateprovinceflag = json.\("isonlystateprovinceflag").as[Flag],
            name = json.\("name").as[Name],
            territoryid = json.\("territoryid").as[SalesterritoryId],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
