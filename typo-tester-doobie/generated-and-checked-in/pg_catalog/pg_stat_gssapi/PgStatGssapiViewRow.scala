/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_gssapi

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatGssapiViewRow(
  pid: Option[Int],
  gssAuthenticated: Option[Boolean],
  principal: Option[String],
  encrypted: Option[Boolean]
)

object PgStatGssapiViewRow {
  implicit val decoder: Decoder[PgStatGssapiViewRow] = Decoder.forProduct4[PgStatGssapiViewRow, Option[Int], Option[Boolean], Option[String], Option[Boolean]]("pid", "gss_authenticated", "principal", "encrypted")(PgStatGssapiViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeBoolean))
  implicit val encoder: Encoder[PgStatGssapiViewRow] = Encoder.forProduct4[PgStatGssapiViewRow, Option[Int], Option[Boolean], Option[String], Option[Boolean]]("pid", "gss_authenticated", "principal", "encrypted")(x => (x.pid, x.gssAuthenticated, x.principal, x.encrypted))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeBoolean))
  implicit val read: Read[PgStatGssapiViewRow] = new Read[PgStatGssapiViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatGssapiViewRow(
      pid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      gssAuthenticated = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 1),
      principal = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      encrypted = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 3)
    )
  )
}
