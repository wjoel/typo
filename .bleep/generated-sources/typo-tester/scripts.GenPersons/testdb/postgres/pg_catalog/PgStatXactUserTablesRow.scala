/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatXactUserTablesRow(
  relid: Option[Long],
  schemaname: Option[String],
  relname: Option[String],
  seqScan: Option[Long],
  seqTupRead: Option[Long],
  idxScan: Option[Long],
  idxTupFetch: Option[Long],
  nTupIns: Option[Long],
  nTupUpd: Option[Long],
  nTupDel: Option[Long],
  nTupHotUpd: Option[Long]
)

object PgStatXactUserTablesRow {
  def rowParser(prefix: String): RowParser[PgStatXactUserTablesRow] = { row =>
    Success(
      PgStatXactUserTablesRow(
        relid = row[Option[Long]](prefix + "relid"),
        schemaname = row[Option[String]](prefix + "schemaname"),
        relname = row[Option[String]](prefix + "relname"),
        seqScan = row[Option[Long]](prefix + "seq_scan"),
        seqTupRead = row[Option[Long]](prefix + "seq_tup_read"),
        idxScan = row[Option[Long]](prefix + "idx_scan"),
        idxTupFetch = row[Option[Long]](prefix + "idx_tup_fetch"),
        nTupIns = row[Option[Long]](prefix + "n_tup_ins"),
        nTupUpd = row[Option[Long]](prefix + "n_tup_upd"),
        nTupDel = row[Option[Long]](prefix + "n_tup_del"),
        nTupHotUpd = row[Option[Long]](prefix + "n_tup_hot_upd")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatXactUserTablesRow] = new OFormat[PgStatXactUserTablesRow]{
    override def writes(o: PgStatXactUserTablesRow): JsObject =
      Json.obj(
        "relid" -> o.relid,
      "schemaname" -> o.schemaname,
      "relname" -> o.relname,
      "seq_scan" -> o.seqScan,
      "seq_tup_read" -> o.seqTupRead,
      "idx_scan" -> o.idxScan,
      "idx_tup_fetch" -> o.idxTupFetch,
      "n_tup_ins" -> o.nTupIns,
      "n_tup_upd" -> o.nTupUpd,
      "n_tup_del" -> o.nTupDel,
      "n_tup_hot_upd" -> o.nTupHotUpd
      )

    override def reads(json: JsValue): JsResult[PgStatXactUserTablesRow] = {
      JsResult.fromTry(
        Try(
          PgStatXactUserTablesRow(
            relid = json.\("relid").toOption.map(_.as[Long]),
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            relname = json.\("relname").toOption.map(_.as[String]),
            seqScan = json.\("seq_scan").toOption.map(_.as[Long]),
            seqTupRead = json.\("seq_tup_read").toOption.map(_.as[Long]),
            idxScan = json.\("idx_scan").toOption.map(_.as[Long]),
            idxTupFetch = json.\("idx_tup_fetch").toOption.map(_.as[Long]),
            nTupIns = json.\("n_tup_ins").toOption.map(_.as[Long]),
            nTupUpd = json.\("n_tup_upd").toOption.map(_.as[Long]),
            nTupDel = json.\("n_tup_del").toOption.map(_.as[Long]),
            nTupHotUpd = json.\("n_tup_hot_upd").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
