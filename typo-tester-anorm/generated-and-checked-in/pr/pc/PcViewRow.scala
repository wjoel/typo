/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import adventureworks.TypoLocalDateTime
import adventureworks.production.productcategory.ProductcategoryId
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

case class PcViewRow(
  id: Option[Int],
  /** Points to [[production.productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: Option[ProductcategoryId],
  /** Points to [[production.productcategory.ProductcategoryRow.name]] */
  name: Option[Name],
  /** Points to [[production.productcategory.ProductcategoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productcategory.ProductcategoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PcViewRow {
  implicit lazy val reads: Reads[PcViewRow] = Reads[PcViewRow](json => JsResult.fromTry(
      Try(
        PcViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          productcategoryid = json.\("productcategoryid").toOption.map(_.as(ProductcategoryId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PcViewRow] = RowParser[PcViewRow] { row =>
    Success(
      PcViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        productcategoryid = row(idx + 1)(Column.columnToOption(ProductcategoryId.column)),
        name = row(idx + 2)(Column.columnToOption(Name.column)),
        rowguid = row(idx + 3)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 4)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PcViewRow] = OWrites[PcViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "productcategoryid" -> Writes.OptionWrites(ProductcategoryId.writes).writes(o.productcategoryid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
