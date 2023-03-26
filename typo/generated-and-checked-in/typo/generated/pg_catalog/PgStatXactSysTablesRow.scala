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
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatXactSysTablesRow(
  /** Points to [[PgStatXactAllTablesRow.relid]] */
  relid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"relid","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.schemaname]] */
  schemaname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"schemaname","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.relname]] */
  relname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"relname","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.seqScan]] */
  seqScan: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"seq_scan","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.seqTupRead]] */
  seqTupRead: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"seq_tup_read","ordinal_position":5,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.idxScan]] */
  idxScan: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"idx_scan","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.idxTupFetch]] */
  idxTupFetch: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"idx_tup_fetch","ordinal_position":7,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.nTupIns]] */
  nTupIns: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"n_tup_ins","ordinal_position":8,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.nTupUpd]] */
  nTupUpd: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"n_tup_upd","ordinal_position":9,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.nTupDel]] */
  nTupDel: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"n_tup_del","ordinal_position":10,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  /** Points to [[PgStatXactAllTablesRow.nTupHotUpd]] */
  nTupHotUpd: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_xact_sys_tables","column_name":"n_tup_hot_upd","ordinal_position":11,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatXactSysTablesRow {
  def rowParser(prefix: String): RowParser[PgStatXactSysTablesRow] = { row =>
    Success(
      PgStatXactSysTablesRow(
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
        nTupHotUpd = row[Option[Long]](prefix + "n_tup_hot_upd")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatXactSysTablesRow] = new OFormat[PgStatXactSysTablesRow]{
    override def writes(o: PgStatXactSysTablesRow): JsObject =
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

    override def reads(json: JsValue): JsResult[PgStatXactSysTablesRow] = {
      JsResult.fromTry(
        Try(
          PgStatXactSysTablesRow(
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
            nTupHotUpd = json.\("n_tup_hot_upd").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
