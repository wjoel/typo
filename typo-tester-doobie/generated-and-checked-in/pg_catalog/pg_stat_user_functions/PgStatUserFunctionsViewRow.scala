/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_functions

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatUserFunctionsViewRow(
  funcid: Option[/* oid */ Long],
  schemaname: Option[String],
  funcname: Option[String],
  calls: Option[Long],
  totalTime: Option[Double],
  selfTime: Option[Double]
)

object PgStatUserFunctionsViewRow {
  implicit val decoder: Decoder[PgStatUserFunctionsViewRow] = Decoder.forProduct6[PgStatUserFunctionsViewRow, Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Double], Option[Double]]("funcid", "schemaname", "funcname", "calls", "total_time", "self_time")(PgStatUserFunctionsViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeDouble), Decoder.decodeOption(Decoder.decodeDouble))
  implicit val encoder: Encoder[PgStatUserFunctionsViewRow] = Encoder.forProduct6[PgStatUserFunctionsViewRow, Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Double], Option[Double]]("funcid", "schemaname", "funcname", "calls", "total_time", "self_time")(x => (x.funcid, x.schemaname, x.funcname, x.calls, x.totalTime, x.selfTime))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeDouble), Encoder.encodeOption(Encoder.encodeDouble))
  implicit val read: Read[PgStatUserFunctionsViewRow] = new Read[PgStatUserFunctionsViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.DoubleMeta.get, Nullability.Nullable),
      (Meta.DoubleMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatUserFunctionsViewRow(
      funcid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      funcname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      calls = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      totalTime = Meta.DoubleMeta.get.unsafeGetNullable(rs, i + 4),
      selfTime = Meta.DoubleMeta.get.unsafeGetNullable(rs, i + 5)
    )
  )
}
