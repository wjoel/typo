/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_constraint

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

case class PgConstraintRow(
  oid: PgConstraintId,
  conname: String,
  connamespace: /* oid */ Long,
  contype: String,
  condeferrable: Boolean,
  condeferred: Boolean,
  convalidated: Boolean,
  conrelid: /* oid */ Long,
  contypid: /* oid */ Long,
  conindid: /* oid */ Long,
  conparentid: /* oid */ Long,
  confrelid: /* oid */ Long,
  confupdtype: String,
  confdeltype: String,
  confmatchtype: String,
  conislocal: Boolean,
  coninhcount: Int,
  connoinherit: Boolean,
  conkey: Option[Array[Int]],
  confkey: Option[Array[Int]],
  conpfeqop: Option[Array[/* oid */ Long]],
  conppeqop: Option[Array[/* oid */ Long]],
  conffeqop: Option[Array[/* oid */ Long]],
  conexclop: Option[Array[/* oid */ Long]],
  conbin: Option[TypoPgNodeTree]
)

object PgConstraintRow {
  implicit val reads: Reads[PgConstraintRow] = Reads[PgConstraintRow](json => JsResult.fromTry(
      Try(
        PgConstraintRow(
          oid = json.\("oid").as(PgConstraintId.reads),
          conname = json.\("conname").as(Reads.StringReads),
          connamespace = json.\("connamespace").as(Reads.LongReads),
          contype = json.\("contype").as(Reads.StringReads),
          condeferrable = json.\("condeferrable").as(Reads.BooleanReads),
          condeferred = json.\("condeferred").as(Reads.BooleanReads),
          convalidated = json.\("convalidated").as(Reads.BooleanReads),
          conrelid = json.\("conrelid").as(Reads.LongReads),
          contypid = json.\("contypid").as(Reads.LongReads),
          conindid = json.\("conindid").as(Reads.LongReads),
          conparentid = json.\("conparentid").as(Reads.LongReads),
          confrelid = json.\("confrelid").as(Reads.LongReads),
          confupdtype = json.\("confupdtype").as(Reads.StringReads),
          confdeltype = json.\("confdeltype").as(Reads.StringReads),
          confmatchtype = json.\("confmatchtype").as(Reads.StringReads),
          conislocal = json.\("conislocal").as(Reads.BooleanReads),
          coninhcount = json.\("coninhcount").as(Reads.IntReads),
          connoinherit = json.\("connoinherit").as(Reads.BooleanReads),
          conkey = json.\("conkey").toOption.map(_.as(Reads.ArrayReads[Int](Reads.IntReads, implicitly))),
          confkey = json.\("confkey").toOption.map(_.as(Reads.ArrayReads[Int](Reads.IntReads, implicitly))),
          conpfeqop = json.\("conpfeqop").toOption.map(_.as(Reads.ArrayReads[Long](Reads.LongReads, implicitly))),
          conppeqop = json.\("conppeqop").toOption.map(_.as(Reads.ArrayReads[Long](Reads.LongReads, implicitly))),
          conffeqop = json.\("conffeqop").toOption.map(_.as(Reads.ArrayReads[Long](Reads.LongReads, implicitly))),
          conexclop = json.\("conexclop").toOption.map(_.as(Reads.ArrayReads[Long](Reads.LongReads, implicitly))),
          conbin = json.\("conbin").toOption.map(_.as(TypoPgNodeTree.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgConstraintRow] = RowParser[PgConstraintRow] { row =>
    Success(
      PgConstraintRow(
        oid = row(idx + 0)(PgConstraintId.column),
        conname = row(idx + 1)(Column.columnToString),
        connamespace = row(idx + 2)(Column.columnToLong),
        contype = row(idx + 3)(Column.columnToString),
        condeferrable = row(idx + 4)(Column.columnToBoolean),
        condeferred = row(idx + 5)(Column.columnToBoolean),
        convalidated = row(idx + 6)(Column.columnToBoolean),
        conrelid = row(idx + 7)(Column.columnToLong),
        contypid = row(idx + 8)(Column.columnToLong),
        conindid = row(idx + 9)(Column.columnToLong),
        conparentid = row(idx + 10)(Column.columnToLong),
        confrelid = row(idx + 11)(Column.columnToLong),
        confupdtype = row(idx + 12)(Column.columnToString),
        confdeltype = row(idx + 13)(Column.columnToString),
        confmatchtype = row(idx + 14)(Column.columnToString),
        conislocal = row(idx + 15)(Column.columnToBoolean),
        coninhcount = row(idx + 16)(Column.columnToInt),
        connoinherit = row(idx + 17)(Column.columnToBoolean),
        conkey = row(idx + 18)(Column.columnToOption(Column.columnToArray[Int](Column.columnToInt, implicitly))),
        confkey = row(idx + 19)(Column.columnToOption(Column.columnToArray[Int](Column.columnToInt, implicitly))),
        conpfeqop = row(idx + 20)(Column.columnToOption(Column.columnToArray[Long](Column.columnToLong, implicitly))),
        conppeqop = row(idx + 21)(Column.columnToOption(Column.columnToArray[Long](Column.columnToLong, implicitly))),
        conffeqop = row(idx + 22)(Column.columnToOption(Column.columnToArray[Long](Column.columnToLong, implicitly))),
        conexclop = row(idx + 23)(Column.columnToOption(Column.columnToArray[Long](Column.columnToLong, implicitly))),
        conbin = row(idx + 24)(Column.columnToOption(TypoPgNodeTree.column))
      )
    )
  }
  implicit val writes: OWrites[PgConstraintRow] = OWrites[PgConstraintRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgConstraintId.writes.writes(o.oid),
      "conname" -> Writes.StringWrites.writes(o.conname),
      "connamespace" -> Writes.LongWrites.writes(o.connamespace),
      "contype" -> Writes.StringWrites.writes(o.contype),
      "condeferrable" -> Writes.BooleanWrites.writes(o.condeferrable),
      "condeferred" -> Writes.BooleanWrites.writes(o.condeferred),
      "convalidated" -> Writes.BooleanWrites.writes(o.convalidated),
      "conrelid" -> Writes.LongWrites.writes(o.conrelid),
      "contypid" -> Writes.LongWrites.writes(o.contypid),
      "conindid" -> Writes.LongWrites.writes(o.conindid),
      "conparentid" -> Writes.LongWrites.writes(o.conparentid),
      "confrelid" -> Writes.LongWrites.writes(o.confrelid),
      "confupdtype" -> Writes.StringWrites.writes(o.confupdtype),
      "confdeltype" -> Writes.StringWrites.writes(o.confdeltype),
      "confmatchtype" -> Writes.StringWrites.writes(o.confmatchtype),
      "conislocal" -> Writes.BooleanWrites.writes(o.conislocal),
      "coninhcount" -> Writes.IntWrites.writes(o.coninhcount),
      "connoinherit" -> Writes.BooleanWrites.writes(o.connoinherit),
      "conkey" -> Writes.OptionWrites(Writes.arrayWrites[Int](implicitly, Writes.IntWrites)).writes(o.conkey),
      "confkey" -> Writes.OptionWrites(Writes.arrayWrites[Int](implicitly, Writes.IntWrites)).writes(o.confkey),
      "conpfeqop" -> Writes.OptionWrites(Writes.arrayWrites[Long](implicitly, Writes.LongWrites)).writes(o.conpfeqop),
      "conppeqop" -> Writes.OptionWrites(Writes.arrayWrites[Long](implicitly, Writes.LongWrites)).writes(o.conppeqop),
      "conffeqop" -> Writes.OptionWrites(Writes.arrayWrites[Long](implicitly, Writes.LongWrites)).writes(o.conffeqop),
      "conexclop" -> Writes.OptionWrites(Writes.arrayWrites[Long](implicitly, Writes.LongWrites)).writes(o.conexclop),
      "conbin" -> Writes.OptionWrites(TypoPgNodeTree.writes).writes(o.conbin)
    ))
  )
}
