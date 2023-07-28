/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesreason

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class SalesreasonRow(
  /** Primary key for SalesReason records. */
  salesreasonid: SalesreasonId,
  /** Sales reason description. */
  name: Name,
  /** Category the sales reason belongs to. */
  reasontype: Name,
  modifieddate: TypoLocalDateTime
)

object SalesreasonRow {
  implicit val reads: Reads[SalesreasonRow] = Reads[SalesreasonRow](json => JsResult.fromTry(
      Try(
        SalesreasonRow(
          salesreasonid = json.\("salesreasonid").as(SalesreasonId.reads),
          name = json.\("name").as(Name.reads),
          reasontype = json.\("reasontype").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalesreasonRow] = RowParser[SalesreasonRow] { row =>
    Success(
      SalesreasonRow(
        salesreasonid = row(idx + 0)(SalesreasonId.column),
        name = row(idx + 1)(Name.column),
        reasontype = row(idx + 2)(Name.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit val writes: OWrites[SalesreasonRow] = OWrites[SalesreasonRow](o =>
    new JsObject(ListMap[String, JsValue](
      "salesreasonid" -> SalesreasonId.writes.writes(o.salesreasonid),
      "name" -> Name.writes.writes(o.name),
      "reasontype" -> Name.writes.writes(o.reasontype),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
