package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatSysTablesRow(
  /** Points to [[PgStatAllTablesRow.relid]] */
  relid: Option[Long],
  /** Points to [[PgStatAllTablesRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[PgStatAllTablesRow.relname]] */
  relname: Option[String],
  /** Points to [[PgStatAllTablesRow.seqScan]] */
  seqScan: Option[Long],
  /** Points to [[PgStatAllTablesRow.seqTupRead]] */
  seqTupRead: Option[Long],
  /** Points to [[PgStatAllTablesRow.idxScan]] */
  idxScan: Option[Long],
  /** Points to [[PgStatAllTablesRow.idxTupFetch]] */
  idxTupFetch: Option[Long],
  /** Points to [[PgStatAllTablesRow.nTupIns]] */
  nTupIns: Option[Long],
  /** Points to [[PgStatAllTablesRow.nTupUpd]] */
  nTupUpd: Option[Long],
  /** Points to [[PgStatAllTablesRow.nTupDel]] */
  nTupDel: Option[Long],
  /** Points to [[PgStatAllTablesRow.nTupHotUpd]] */
  nTupHotUpd: Option[Long],
  /** Points to [[PgStatAllTablesRow.nLiveTup]] */
  nLiveTup: Option[Long],
  /** Points to [[PgStatAllTablesRow.nDeadTup]] */
  nDeadTup: Option[Long],
  /** Points to [[PgStatAllTablesRow.nModSinceAnalyze]] */
  nModSinceAnalyze: Option[Long],
  /** Points to [[PgStatAllTablesRow.nInsSinceVacuum]] */
  nInsSinceVacuum: Option[Long],
  /** Points to [[PgStatAllTablesRow.lastVacuum]] */
  lastVacuum: Option[LocalDateTime],
  /** Points to [[PgStatAllTablesRow.lastAutovacuum]] */
  lastAutovacuum: Option[LocalDateTime],
  /** Points to [[PgStatAllTablesRow.lastAnalyze]] */
  lastAnalyze: Option[LocalDateTime],
  /** Points to [[PgStatAllTablesRow.lastAutoanalyze]] */
  lastAutoanalyze: Option[LocalDateTime],
  /** Points to [[PgStatAllTablesRow.vacuumCount]] */
  vacuumCount: Option[Long],
  /** Points to [[PgStatAllTablesRow.autovacuumCount]] */
  autovacuumCount: Option[Long],
  /** Points to [[PgStatAllTablesRow.analyzeCount]] */
  analyzeCount: Option[Long],
  /** Points to [[PgStatAllTablesRow.autoanalyzeCount]] */
  autoanalyzeCount: Option[Long]
)

object PgStatSysTablesRow {
  implicit val rowParser: RowParser[PgStatSysTablesRow] = { row =>
    Success(
      PgStatSysTablesRow(
        relid = row[Option[Long]]("relid"),
        schemaname = row[Option[String]]("schemaname"),
        relname = row[Option[String]]("relname"),
        seqScan = row[Option[Long]]("seq_scan"),
        seqTupRead = row[Option[Long]]("seq_tup_read"),
        idxScan = row[Option[Long]]("idx_scan"),
        idxTupFetch = row[Option[Long]]("idx_tup_fetch"),
        nTupIns = row[Option[Long]]("n_tup_ins"),
        nTupUpd = row[Option[Long]]("n_tup_upd"),
        nTupDel = row[Option[Long]]("n_tup_del"),
        nTupHotUpd = row[Option[Long]]("n_tup_hot_upd"),
        nLiveTup = row[Option[Long]]("n_live_tup"),
        nDeadTup = row[Option[Long]]("n_dead_tup"),
        nModSinceAnalyze = row[Option[Long]]("n_mod_since_analyze"),
        nInsSinceVacuum = row[Option[Long]]("n_ins_since_vacuum"),
        lastVacuum = row[Option[LocalDateTime]]("last_vacuum"),
        lastAutovacuum = row[Option[LocalDateTime]]("last_autovacuum"),
        lastAnalyze = row[Option[LocalDateTime]]("last_analyze"),
        lastAutoanalyze = row[Option[LocalDateTime]]("last_autoanalyze"),
        vacuumCount = row[Option[Long]]("vacuum_count"),
        autovacuumCount = row[Option[Long]]("autovacuum_count"),
        analyzeCount = row[Option[Long]]("analyze_count"),
        autoanalyzeCount = row[Option[Long]]("autoanalyze_count")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatSysTablesRow] = new OFormat[PgStatSysTablesRow]{
    override def writes(o: PgStatSysTablesRow): JsObject =
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
      "n_tup_hot_upd" -> o.nTupHotUpd,
      "n_live_tup" -> o.nLiveTup,
      "n_dead_tup" -> o.nDeadTup,
      "n_mod_since_analyze" -> o.nModSinceAnalyze,
      "n_ins_since_vacuum" -> o.nInsSinceVacuum,
      "last_vacuum" -> o.lastVacuum,
      "last_autovacuum" -> o.lastAutovacuum,
      "last_analyze" -> o.lastAnalyze,
      "last_autoanalyze" -> o.lastAutoanalyze,
      "vacuum_count" -> o.vacuumCount,
      "autovacuum_count" -> o.autovacuumCount,
      "analyze_count" -> o.analyzeCount,
      "autoanalyze_count" -> o.autoanalyzeCount
      )

    override def reads(json: JsValue): JsResult[PgStatSysTablesRow] = {
      JsResult.fromTry(
        Try(
          PgStatSysTablesRow(
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
            nTupHotUpd = json.\("n_tup_hot_upd").toOption.map(_.as[Long]),
            nLiveTup = json.\("n_live_tup").toOption.map(_.as[Long]),
            nDeadTup = json.\("n_dead_tup").toOption.map(_.as[Long]),
            nModSinceAnalyze = json.\("n_mod_since_analyze").toOption.map(_.as[Long]),
            nInsSinceVacuum = json.\("n_ins_since_vacuum").toOption.map(_.as[Long]),
            lastVacuum = json.\("last_vacuum").toOption.map(_.as[LocalDateTime]),
            lastAutovacuum = json.\("last_autovacuum").toOption.map(_.as[LocalDateTime]),
            lastAnalyze = json.\("last_analyze").toOption.map(_.as[LocalDateTime]),
            lastAutoanalyze = json.\("last_autoanalyze").toOption.map(_.as[LocalDateTime]),
            vacuumCount = json.\("vacuum_count").toOption.map(_.as[Long]),
            autovacuumCount = json.\("autovacuum_count").toOption.map(_.as[Long]),
            analyzeCount = json.\("analyze_count").toOption.map(_.as[Long]),
            autoanalyzeCount = json.\("autoanalyze_count").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}