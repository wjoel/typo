/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_partitioned_table

import adventureworks.TypoInt2Vector
import adventureworks.TypoOidVector
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

case class PgPartitionedTableRow(
  partrelid: PgPartitionedTableId,
  partstrat: String,
  partnatts: Int,
  partdefid: /* oid */ Long,
  partattrs: TypoInt2Vector,
  partclass: TypoOidVector,
  partcollation: TypoOidVector,
  partexprs: Option[TypoPgNodeTree]
)

object PgPartitionedTableRow {
  implicit val reads: Reads[PgPartitionedTableRow] = Reads[PgPartitionedTableRow](json => JsResult.fromTry(
      Try(
        PgPartitionedTableRow(
          partrelid = json.\("partrelid").as(PgPartitionedTableId.reads),
          partstrat = json.\("partstrat").as(Reads.StringReads),
          partnatts = json.\("partnatts").as(Reads.IntReads),
          partdefid = json.\("partdefid").as(Reads.LongReads),
          partattrs = json.\("partattrs").as(TypoInt2Vector.reads),
          partclass = json.\("partclass").as(TypoOidVector.reads),
          partcollation = json.\("partcollation").as(TypoOidVector.reads),
          partexprs = json.\("partexprs").toOption.map(_.as(TypoPgNodeTree.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgPartitionedTableRow] = RowParser[PgPartitionedTableRow] { row =>
    Success(
      PgPartitionedTableRow(
        partrelid = row(idx + 0)(PgPartitionedTableId.column),
        partstrat = row(idx + 1)(Column.columnToString),
        partnatts = row(idx + 2)(Column.columnToInt),
        partdefid = row(idx + 3)(Column.columnToLong),
        partattrs = row(idx + 4)(TypoInt2Vector.column),
        partclass = row(idx + 5)(TypoOidVector.column),
        partcollation = row(idx + 6)(TypoOidVector.column),
        partexprs = row(idx + 7)(Column.columnToOption(TypoPgNodeTree.column))
      )
    )
  }
  implicit val writes: OWrites[PgPartitionedTableRow] = OWrites[PgPartitionedTableRow](o =>
    new JsObject(ListMap[String, JsValue](
      "partrelid" -> PgPartitionedTableId.writes.writes(o.partrelid),
      "partstrat" -> Writes.StringWrites.writes(o.partstrat),
      "partnatts" -> Writes.IntWrites.writes(o.partnatts),
      "partdefid" -> Writes.LongWrites.writes(o.partdefid),
      "partattrs" -> TypoInt2Vector.writes.writes(o.partattrs),
      "partclass" -> TypoOidVector.writes.writes(o.partclass),
      "partcollation" -> TypoOidVector.writes.writes(o.partcollation),
      "partexprs" -> Writes.OptionWrites(TypoPgNodeTree.writes).writes(o.partexprs)
    ))
  )
}
