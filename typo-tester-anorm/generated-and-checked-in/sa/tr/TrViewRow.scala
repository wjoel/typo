/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package tr

import adventureworks.TypoLocalDateTime
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import adventureworks.sales.salestaxrate.SalestaxrateId
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

case class TrViewRow(
  id: Option[Int],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.salestaxrateid]] */
  salestaxrateid: Option[SalestaxrateId],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.stateprovinceid]] */
  stateprovinceid: Option[StateprovinceId],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.taxtype]] */
  taxtype: Option[Int],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.taxrate]] */
  taxrate: Option[BigDecimal],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.name]] */
  name: Option[Name],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.salestaxrate.SalestaxrateRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object TrViewRow {
  implicit lazy val reads: Reads[TrViewRow] = Reads[TrViewRow](json => JsResult.fromTry(
      Try(
        TrViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          salestaxrateid = json.\("salestaxrateid").toOption.map(_.as(SalestaxrateId.reads)),
          stateprovinceid = json.\("stateprovinceid").toOption.map(_.as(StateprovinceId.reads)),
          taxtype = json.\("taxtype").toOption.map(_.as(Reads.IntReads)),
          taxrate = json.\("taxrate").toOption.map(_.as(Reads.bigDecReads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TrViewRow] = RowParser[TrViewRow] { row =>
    Success(
      TrViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        salestaxrateid = row(idx + 1)(Column.columnToOption(SalestaxrateId.column)),
        stateprovinceid = row(idx + 2)(Column.columnToOption(StateprovinceId.column)),
        taxtype = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        taxrate = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        name = row(idx + 5)(Column.columnToOption(Name.column)),
        rowguid = row(idx + 6)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 7)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[TrViewRow] = OWrites[TrViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "salestaxrateid" -> Writes.OptionWrites(SalestaxrateId.writes).writes(o.salestaxrateid),
      "stateprovinceid" -> Writes.OptionWrites(StateprovinceId.writes).writes(o.stateprovinceid),
      "taxtype" -> Writes.OptionWrites(Writes.IntWrites).writes(o.taxtype),
      "taxrate" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.taxrate),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
