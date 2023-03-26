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

case class PgStatReplicationSlotsRow(
  /** Points to [[PgReplicationSlotsRow.slotName]] */
  slotName: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"slot_name","ordinal_position":1,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  spillTxns: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"spill_txns","ordinal_position":2,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  spillCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"spill_count","ordinal_position":3,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  spillBytes: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"spill_bytes","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  streamTxns: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"stream_txns","ordinal_position":5,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  streamCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"stream_count","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  streamBytes: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"stream_bytes","ordinal_position":7,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  totalTxns: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"total_txns","ordinal_position":8,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  totalBytes: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"total_bytes","ordinal_position":9,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  statsReset: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication_slots","column_name":"stats_reset","ordinal_position":10,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatReplicationSlotsRow {
  def rowParser(prefix: String): RowParser[PgStatReplicationSlotsRow] = { row =>
    Success(
      PgStatReplicationSlotsRow(
        slotName = row[Option[String]](prefix + "slot_name"),
        spillTxns = row[Option[Long]](prefix + "spill_txns"),
        spillCount = row[Option[Long]](prefix + "spill_count"),
        spillBytes = row[Option[Long]](prefix + "spill_bytes"),
        streamTxns = row[Option[Long]](prefix + "stream_txns"),
        streamCount = row[Option[Long]](prefix + "stream_count"),
        streamBytes = row[Option[Long]](prefix + "stream_bytes"),
        totalTxns = row[Option[Long]](prefix + "total_txns"),
        totalBytes = row[Option[Long]](prefix + "total_bytes"),
        statsReset = row[Option[ZonedDateTime]](prefix + "stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatReplicationSlotsRow] = new OFormat[PgStatReplicationSlotsRow]{
    override def writes(o: PgStatReplicationSlotsRow): JsObject =
      Json.obj(
        "slot_name" -> o.slotName,
      "spill_txns" -> o.spillTxns,
      "spill_count" -> o.spillCount,
      "spill_bytes" -> o.spillBytes,
      "stream_txns" -> o.streamTxns,
      "stream_count" -> o.streamCount,
      "stream_bytes" -> o.streamBytes,
      "total_txns" -> o.totalTxns,
      "total_bytes" -> o.totalBytes,
      "stats_reset" -> o.statsReset
      )

    override def reads(json: JsValue): JsResult[PgStatReplicationSlotsRow] = {
      JsResult.fromTry(
        Try(
          PgStatReplicationSlotsRow(
            slotName = json.\("slot_name").toOption.map(_.as[String]),
            spillTxns = json.\("spill_txns").toOption.map(_.as[Long]),
            spillCount = json.\("spill_count").toOption.map(_.as[Long]),
            spillBytes = json.\("spill_bytes").toOption.map(_.as[Long]),
            streamTxns = json.\("stream_txns").toOption.map(_.as[Long]),
            streamCount = json.\("stream_count").toOption.map(_.as[Long]),
            streamBytes = json.\("stream_bytes").toOption.map(_.as[Long]),
            totalTxns = json.\("total_txns").toOption.map(_.as[Long]),
            totalBytes = json.\("total_bytes").toOption.map(_.as[Long]),
            statsReset = json.\("stats_reset").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
