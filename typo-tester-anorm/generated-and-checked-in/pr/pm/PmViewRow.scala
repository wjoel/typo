/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.production.productmodel.ProductmodelId
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

case class PmViewRow(
  id: Option[Int],
  /** Points to [[production.productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.productmodel.ProductmodelRow.name]] */
  name: Option[Name],
  /** Points to [[production.productmodel.ProductmodelRow.catalogdescription]] */
  catalogdescription: Option[TypoXml],
  /** Points to [[production.productmodel.ProductmodelRow.instructions]] */
  instructions: Option[TypoXml],
  /** Points to [[production.productmodel.ProductmodelRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PmViewRow {
  implicit lazy val reads: Reads[PmViewRow] = Reads[PmViewRow](json => JsResult.fromTry(
      Try(
        PmViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          productmodelid = json.\("productmodelid").toOption.map(_.as(ProductmodelId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          catalogdescription = json.\("catalogdescription").toOption.map(_.as(TypoXml.reads)),
          instructions = json.\("instructions").toOption.map(_.as(TypoXml.reads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PmViewRow] = RowParser[PmViewRow] { row =>
    Success(
      PmViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        productmodelid = row(idx + 1)(Column.columnToOption(ProductmodelId.column)),
        name = row(idx + 2)(Column.columnToOption(Name.column)),
        catalogdescription = row(idx + 3)(Column.columnToOption(TypoXml.column)),
        instructions = row(idx + 4)(Column.columnToOption(TypoXml.column)),
        rowguid = row(idx + 5)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PmViewRow] = OWrites[PmViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "productmodelid" -> Writes.OptionWrites(ProductmodelId.writes).writes(o.productmodelid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "catalogdescription" -> Writes.OptionWrites(TypoXml.writes).writes(o.catalogdescription),
      "instructions" -> Writes.OptionWrites(TypoXml.writes).writes(o.instructions),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
