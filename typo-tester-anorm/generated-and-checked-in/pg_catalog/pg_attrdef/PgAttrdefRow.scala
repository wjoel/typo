/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attrdef

import adventureworks.TypoPgNodeTree
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

case class PgAttrdefRow(
  oid: PgAttrdefId,
  adrelid: /* oid */ Long,
  adnum: Int,
  adbin: TypoPgNodeTree
)

object PgAttrdefRow {
  implicit val reads: Reads[PgAttrdefRow] = Reads[PgAttrdefRow](json => JsResult.fromTry(
      Try(
        PgAttrdefRow(
          oid = json.\("oid").as(PgAttrdefId.reads),
          adrelid = json.\("adrelid").as(Reads.LongReads),
          adnum = json.\("adnum").as(Reads.IntReads),
          adbin = json.\("adbin").as(TypoPgNodeTree.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgAttrdefRow] = RowParser[PgAttrdefRow] { row =>
    Success(
      PgAttrdefRow(
        oid = row(idx + 0)(PgAttrdefId.column),
        adrelid = row(idx + 1)(Column.columnToLong),
        adnum = row(idx + 2)(Column.columnToInt),
        adbin = row(idx + 3)(TypoPgNodeTree.column)
      )
    )
  }
  implicit val writes: OWrites[PgAttrdefRow] = OWrites[PgAttrdefRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgAttrdefId.writes.writes(o.oid),
      "adrelid" -> Writes.LongWrites.writes(o.adrelid),
      "adnum" -> Writes.IntWrites.writes(o.adnum),
      "adbin" -> TypoPgNodeTree.writes.writes(o.adbin)
    ))
  )
}
