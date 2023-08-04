/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_aggregate

import adventureworks.TypoRegproc
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

case class PgAggregateRow(
  aggfnoid: PgAggregateId,
  aggkind: String,
  aggnumdirectargs: Int,
  aggtransfn: TypoRegproc,
  aggfinalfn: TypoRegproc,
  aggcombinefn: TypoRegproc,
  aggserialfn: TypoRegproc,
  aggdeserialfn: TypoRegproc,
  aggmtransfn: TypoRegproc,
  aggminvtransfn: TypoRegproc,
  aggmfinalfn: TypoRegproc,
  aggfinalextra: Boolean,
  aggmfinalextra: Boolean,
  aggfinalmodify: String,
  aggmfinalmodify: String,
  aggsortop: /* oid */ Long,
  aggtranstype: /* oid */ Long,
  aggtransspace: Int,
  aggmtranstype: /* oid */ Long,
  aggmtransspace: Int,
  agginitval: Option[String],
  aggminitval: Option[String]
)

object PgAggregateRow {
  implicit lazy val reads: Reads[PgAggregateRow] = Reads[PgAggregateRow](json => JsResult.fromTry(
      Try(
        PgAggregateRow(
          aggfnoid = json.\("aggfnoid").as(PgAggregateId.reads),
          aggkind = json.\("aggkind").as(Reads.StringReads),
          aggnumdirectargs = json.\("aggnumdirectargs").as(Reads.IntReads),
          aggtransfn = json.\("aggtransfn").as(TypoRegproc.reads),
          aggfinalfn = json.\("aggfinalfn").as(TypoRegproc.reads),
          aggcombinefn = json.\("aggcombinefn").as(TypoRegproc.reads),
          aggserialfn = json.\("aggserialfn").as(TypoRegproc.reads),
          aggdeserialfn = json.\("aggdeserialfn").as(TypoRegproc.reads),
          aggmtransfn = json.\("aggmtransfn").as(TypoRegproc.reads),
          aggminvtransfn = json.\("aggminvtransfn").as(TypoRegproc.reads),
          aggmfinalfn = json.\("aggmfinalfn").as(TypoRegproc.reads),
          aggfinalextra = json.\("aggfinalextra").as(Reads.BooleanReads),
          aggmfinalextra = json.\("aggmfinalextra").as(Reads.BooleanReads),
          aggfinalmodify = json.\("aggfinalmodify").as(Reads.StringReads),
          aggmfinalmodify = json.\("aggmfinalmodify").as(Reads.StringReads),
          aggsortop = json.\("aggsortop").as(Reads.LongReads),
          aggtranstype = json.\("aggtranstype").as(Reads.LongReads),
          aggtransspace = json.\("aggtransspace").as(Reads.IntReads),
          aggmtranstype = json.\("aggmtranstype").as(Reads.LongReads),
          aggmtransspace = json.\("aggmtransspace").as(Reads.IntReads),
          agginitval = json.\("agginitval").toOption.map(_.as(Reads.StringReads)),
          aggminitval = json.\("aggminitval").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgAggregateRow] = RowParser[PgAggregateRow] { row =>
    Success(
      PgAggregateRow(
        aggfnoid = row(idx + 0)(PgAggregateId.column),
        aggkind = row(idx + 1)(Column.columnToString),
        aggnumdirectargs = row(idx + 2)(Column.columnToInt),
        aggtransfn = row(idx + 3)(TypoRegproc.column),
        aggfinalfn = row(idx + 4)(TypoRegproc.column),
        aggcombinefn = row(idx + 5)(TypoRegproc.column),
        aggserialfn = row(idx + 6)(TypoRegproc.column),
        aggdeserialfn = row(idx + 7)(TypoRegproc.column),
        aggmtransfn = row(idx + 8)(TypoRegproc.column),
        aggminvtransfn = row(idx + 9)(TypoRegproc.column),
        aggmfinalfn = row(idx + 10)(TypoRegproc.column),
        aggfinalextra = row(idx + 11)(Column.columnToBoolean),
        aggmfinalextra = row(idx + 12)(Column.columnToBoolean),
        aggfinalmodify = row(idx + 13)(Column.columnToString),
        aggmfinalmodify = row(idx + 14)(Column.columnToString),
        aggsortop = row(idx + 15)(Column.columnToLong),
        aggtranstype = row(idx + 16)(Column.columnToLong),
        aggtransspace = row(idx + 17)(Column.columnToInt),
        aggmtranstype = row(idx + 18)(Column.columnToLong),
        aggmtransspace = row(idx + 19)(Column.columnToInt),
        agginitval = row(idx + 20)(Column.columnToOption(Column.columnToString)),
        aggminitval = row(idx + 21)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PgAggregateRow] = OWrites[PgAggregateRow](o =>
    new JsObject(ListMap[String, JsValue](
      "aggfnoid" -> PgAggregateId.writes.writes(o.aggfnoid),
      "aggkind" -> Writes.StringWrites.writes(o.aggkind),
      "aggnumdirectargs" -> Writes.IntWrites.writes(o.aggnumdirectargs),
      "aggtransfn" -> TypoRegproc.writes.writes(o.aggtransfn),
      "aggfinalfn" -> TypoRegproc.writes.writes(o.aggfinalfn),
      "aggcombinefn" -> TypoRegproc.writes.writes(o.aggcombinefn),
      "aggserialfn" -> TypoRegproc.writes.writes(o.aggserialfn),
      "aggdeserialfn" -> TypoRegproc.writes.writes(o.aggdeserialfn),
      "aggmtransfn" -> TypoRegproc.writes.writes(o.aggmtransfn),
      "aggminvtransfn" -> TypoRegproc.writes.writes(o.aggminvtransfn),
      "aggmfinalfn" -> TypoRegproc.writes.writes(o.aggmfinalfn),
      "aggfinalextra" -> Writes.BooleanWrites.writes(o.aggfinalextra),
      "aggmfinalextra" -> Writes.BooleanWrites.writes(o.aggmfinalextra),
      "aggfinalmodify" -> Writes.StringWrites.writes(o.aggfinalmodify),
      "aggmfinalmodify" -> Writes.StringWrites.writes(o.aggmfinalmodify),
      "aggsortop" -> Writes.LongWrites.writes(o.aggsortop),
      "aggtranstype" -> Writes.LongWrites.writes(o.aggtranstype),
      "aggtransspace" -> Writes.IntWrites.writes(o.aggtransspace),
      "aggmtranstype" -> Writes.LongWrites.writes(o.aggmtranstype),
      "aggmtransspace" -> Writes.IntWrites.writes(o.aggmtransspace),
      "agginitval" -> Writes.OptionWrites(Writes.StringWrites).writes(o.agginitval),
      "aggminitval" -> Writes.OptionWrites(Writes.StringWrites).writes(o.aggminitval)
    ))
  )
}
