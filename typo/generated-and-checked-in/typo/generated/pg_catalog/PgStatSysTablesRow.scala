/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.ZonedDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatSysTablesRow(
  /** Points to [[PgStatAllTablesRow.relid]] */
  relid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"relid","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.schemaname]] */
  schemaname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"schemaname","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.relname]] */
  relname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"relname","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.seqScan]] */
  seqScan: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"seq_scan","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.seqTupRead]] */
  seqTupRead: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"seq_tup_read","ordinal_position":5,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.idxScan]] */
  idxScan: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"idx_scan","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.idxTupFetch]] */
  idxTupFetch: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"idx_tup_fetch","ordinal_position":7,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.nTupIns]] */
  nTupIns: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"n_tup_ins","ordinal_position":8,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.nTupUpd]] */
  nTupUpd: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"n_tup_upd","ordinal_position":9,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.nTupDel]] */
  nTupDel: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"n_tup_del","ordinal_position":10,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.nTupHotUpd]] */
  nTupHotUpd: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"n_tup_hot_upd","ordinal_position":11,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.nLiveTup]] */
  nLiveTup: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"n_live_tup","ordinal_position":12,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.nDeadTup]] */
  nDeadTup: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"n_dead_tup","ordinal_position":13,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.nModSinceAnalyze]] */
  nModSinceAnalyze: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"n_mod_since_analyze","ordinal_position":14,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.nInsSinceVacuum]] */
  nInsSinceVacuum: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"n_ins_since_vacuum","ordinal_position":15,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.lastVacuum]] */
  lastVacuum: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"last_vacuum","ordinal_position":16,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.lastAutovacuum]] */
  lastAutovacuum: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"last_autovacuum","ordinal_position":17,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.lastAnalyze]] */
  lastAnalyze: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"last_analyze","ordinal_position":18,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.lastAutoanalyze]] */
  lastAutoanalyze: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"last_autoanalyze","ordinal_position":19,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.vacuumCount]] */
  vacuumCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"vacuum_count","ordinal_position":20,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.autovacuumCount]] */
  autovacuumCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"autovacuum_count","ordinal_position":21,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.analyzeCount]] */
  analyzeCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"analyze_count","ordinal_position":22,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatAllTablesRow.autoanalyzeCount]] */
  autoanalyzeCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_sys_tables","column_name":"autoanalyze_count","ordinal_position":23,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"23","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatSysTablesRow {
  def rowParser(prefix: String): RowParser[PgStatSysTablesRow] = { row =>
    Success(
      PgStatSysTablesRow(
        relid = row[Option[/* oid */ Long]](prefix + "relid"),
        schemaname = row[Option[String]](prefix + "schemaname"),
        relname = row[Option[String]](prefix + "relname"),
        seqScan = row[Option[Long]](prefix + "seq_scan"),
        seqTupRead = row[Option[Long]](prefix + "seq_tup_read"),
        idxScan = row[Option[Long]](prefix + "idx_scan"),
        idxTupFetch = row[Option[Long]](prefix + "idx_tup_fetch"),
        nTupIns = row[Option[Long]](prefix + "n_tup_ins"),
        nTupUpd = row[Option[Long]](prefix + "n_tup_upd"),
        nTupDel = row[Option[Long]](prefix + "n_tup_del"),
        nTupHotUpd = row[Option[Long]](prefix + "n_tup_hot_upd"),
        nLiveTup = row[Option[Long]](prefix + "n_live_tup"),
        nDeadTup = row[Option[Long]](prefix + "n_dead_tup"),
        nModSinceAnalyze = row[Option[Long]](prefix + "n_mod_since_analyze"),
        nInsSinceVacuum = row[Option[Long]](prefix + "n_ins_since_vacuum"),
        lastVacuum = row[Option[ZonedDateTime]](prefix + "last_vacuum"),
        lastAutovacuum = row[Option[ZonedDateTime]](prefix + "last_autovacuum"),
        lastAnalyze = row[Option[ZonedDateTime]](prefix + "last_analyze"),
        lastAutoanalyze = row[Option[ZonedDateTime]](prefix + "last_autoanalyze"),
        vacuumCount = row[Option[Long]](prefix + "vacuum_count"),
        autovacuumCount = row[Option[Long]](prefix + "autovacuum_count"),
        analyzeCount = row[Option[Long]](prefix + "analyze_count"),
        autoanalyzeCount = row[Option[Long]](prefix + "autoanalyze_count")
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
            relid = json.\("relid").toOption.map(_.as[/* oid */ Long]),
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
            lastVacuum = json.\("last_vacuum").toOption.map(_.as[ZonedDateTime]),
            lastAutovacuum = json.\("last_autovacuum").toOption.map(_.as[ZonedDateTime]),
            lastAnalyze = json.\("last_analyze").toOption.map(_.as[ZonedDateTime]),
            lastAutoanalyze = json.\("last_autoanalyze").toOption.map(_.as[ZonedDateTime]),
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
