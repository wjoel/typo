/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class ShipmethodRow(
  /** Primary key for ShipMethod records. */
  shipmethodid: ShipmethodId,
  /** Shipping company name. */
  name: Name,
  /** Minimum shipping charge. */
  shipbase: BigDecimal,
  /** Shipping charge per pound. */
  shiprate: BigDecimal,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object ShipmethodRow {
  implicit lazy val reads: Reads[ShipmethodRow] = Reads[ShipmethodRow](json => JsResult.fromTry(
      Try(
        ShipmethodRow(
          shipmethodid = json.\("shipmethodid").as(ShipmethodId.reads),
          name = json.\("name").as(Name.reads),
          shipbase = json.\("shipbase").as(Reads.bigDecReads),
          shiprate = json.\("shiprate").as(Reads.bigDecReads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ShipmethodRow] = RowParser[ShipmethodRow] { row =>
    Success(
      ShipmethodRow(
        shipmethodid = row(idx + 0)(ShipmethodId.column),
        name = row(idx + 1)(Name.column),
        shipbase = row(idx + 2)(Column.columnToScalaBigDecimal),
        shiprate = row(idx + 3)(Column.columnToScalaBigDecimal),
        rowguid = row(idx + 4)(Column.columnToUUID),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ShipmethodRow] = OWrites[ShipmethodRow](o =>
    new JsObject(ListMap[String, JsValue](
      "shipmethodid" -> ShipmethodId.writes.writes(o.shipmethodid),
      "name" -> Name.writes.writes(o.name),
      "shipbase" -> Writes.BigDecimalWrites.writes(o.shipbase),
      "shiprate" -> Writes.BigDecimalWrites.writes(o.shiprate),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
