/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
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

case class ProductmodelRow(
  /** Primary key for ProductModel records. */
  productmodelid: ProductmodelId,
  /** Product model description. */
  name: Name,
  /** Detailed product catalog information in xml format. */
  catalogdescription: Option[TypoXml],
  /** Manufacturing instructions in xml format. */
  instructions: Option[TypoXml],
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object ProductmodelRow {
  implicit lazy val reads: Reads[ProductmodelRow] = Reads[ProductmodelRow](json => JsResult.fromTry(
      Try(
        ProductmodelRow(
          productmodelid = json.\("productmodelid").as(ProductmodelId.reads),
          name = json.\("name").as(Name.reads),
          catalogdescription = json.\("catalogdescription").toOption.map(_.as(TypoXml.reads)),
          instructions = json.\("instructions").toOption.map(_.as(TypoXml.reads)),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductmodelRow] = RowParser[ProductmodelRow] { row =>
    Success(
      ProductmodelRow(
        productmodelid = row(idx + 0)(ProductmodelId.column),
        name = row(idx + 1)(Name.column),
        catalogdescription = row(idx + 2)(Column.columnToOption(TypoXml.column)),
        instructions = row(idx + 3)(Column.columnToOption(TypoXml.column)),
        rowguid = row(idx + 4)(Column.columnToUUID),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ProductmodelRow] = OWrites[ProductmodelRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> ProductmodelId.writes.writes(o.productmodelid),
      "name" -> Name.writes.writes(o.name),
      "catalogdescription" -> Writes.OptionWrites(TypoXml.writes).writes(o.catalogdescription),
      "instructions" -> Writes.OptionWrites(TypoXml.writes).writes(o.instructions),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
