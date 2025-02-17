/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class CrcViewRow(
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.countryregioncode]] */
  countryregioncode: Option[CountryregionId],
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.currencycode]] */
  currencycode: Option[CurrencyId],
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object CrcViewRow {
  implicit lazy val reads: Reads[CrcViewRow] = Reads[CrcViewRow](json => JsResult.fromTry(
      Try(
        CrcViewRow(
          countryregioncode = json.\("countryregioncode").toOption.map(_.as(CountryregionId.reads)),
          currencycode = json.\("currencycode").toOption.map(_.as(CurrencyId.reads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CrcViewRow] = RowParser[CrcViewRow] { row =>
    Success(
      CrcViewRow(
        countryregioncode = row(idx + 0)(Column.columnToOption(CountryregionId.column)),
        currencycode = row(idx + 1)(Column.columnToOption(CurrencyId.column)),
        modifieddate = row(idx + 2)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[CrcViewRow] = OWrites[CrcViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "countryregioncode" -> Writes.OptionWrites(CountryregionId.writes).writes(o.countryregioncode),
      "currencycode" -> Writes.OptionWrites(CurrencyId.writes).writes(o.currencycode),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
