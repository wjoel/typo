/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config_map

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

case class PgTsConfigMapRow(
  mapcfg: /* oid */ Long,
  maptokentype: Int,
  mapseqno: Int,
  mapdict: /* oid */ Long
){
   val compositeId: PgTsConfigMapId = PgTsConfigMapId(mapcfg, maptokentype, mapseqno)
 }

object PgTsConfigMapRow {
  implicit lazy val reads: Reads[PgTsConfigMapRow] = Reads[PgTsConfigMapRow](json => JsResult.fromTry(
      Try(
        PgTsConfigMapRow(
          mapcfg = json.\("mapcfg").as(Reads.LongReads),
          maptokentype = json.\("maptokentype").as(Reads.IntReads),
          mapseqno = json.\("mapseqno").as(Reads.IntReads),
          mapdict = json.\("mapdict").as(Reads.LongReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgTsConfigMapRow] = RowParser[PgTsConfigMapRow] { row =>
    Success(
      PgTsConfigMapRow(
        mapcfg = row(idx + 0)(Column.columnToLong),
        maptokentype = row(idx + 1)(Column.columnToInt),
        mapseqno = row(idx + 2)(Column.columnToInt),
        mapdict = row(idx + 3)(Column.columnToLong)
      )
    )
  }
  implicit lazy val writes: OWrites[PgTsConfigMapRow] = OWrites[PgTsConfigMapRow](o =>
    new JsObject(ListMap[String, JsValue](
      "mapcfg" -> Writes.LongWrites.writes(o.mapcfg),
      "maptokentype" -> Writes.IntWrites.writes(o.maptokentype),
      "mapseqno" -> Writes.IntWrites.writes(o.mapseqno),
      "mapdict" -> Writes.LongWrites.writes(o.mapdict)
    ))
  )
}
