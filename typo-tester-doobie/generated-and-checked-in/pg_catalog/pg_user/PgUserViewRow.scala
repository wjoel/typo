/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user

import adventureworks.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgUserViewRow(
  /** Points to [[pg_shadow.PgShadowViewRow.usename]] */
  usename: Option[String],
  /** Points to [[pg_shadow.PgShadowViewRow.usesysid]] */
  usesysid: Option[/* oid */ Long],
  /** Points to [[pg_shadow.PgShadowViewRow.usecreatedb]] */
  usecreatedb: Option[Boolean],
  /** Points to [[pg_shadow.PgShadowViewRow.usesuper]] */
  usesuper: Option[Boolean],
  /** Points to [[pg_shadow.PgShadowViewRow.userepl]] */
  userepl: Option[Boolean],
  /** Points to [[pg_shadow.PgShadowViewRow.usebypassrls]] */
  usebypassrls: Option[Boolean],
  passwd: Option[String],
  /** Points to [[pg_shadow.PgShadowViewRow.valuntil]] */
  valuntil: Option[TypoOffsetDateTime],
  /** Points to [[pg_shadow.PgShadowViewRow.useconfig]] */
  useconfig: Option[Array[String]]
)

object PgUserViewRow {
  implicit val decoder: Decoder[PgUserViewRow] = Decoder.forProduct9[PgUserViewRow, Option[String], Option[/* oid */ Long], Option[Boolean], Option[Boolean], Option[Boolean], Option[Boolean], Option[String], Option[TypoOffsetDateTime], Option[Array[String]]]("usename", "usesysid", "usecreatedb", "usesuper", "userepl", "usebypassrls", "passwd", "valuntil", "useconfig")(PgUserViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(Decoder.decodeArray[String](Decoder.decodeString, implicitly)))
  implicit val encoder: Encoder[PgUserViewRow] = Encoder.forProduct9[PgUserViewRow, Option[String], Option[/* oid */ Long], Option[Boolean], Option[Boolean], Option[Boolean], Option[Boolean], Option[String], Option[TypoOffsetDateTime], Option[Array[String]]]("usename", "usesysid", "usecreatedb", "usesuper", "userepl", "usebypassrls", "passwd", "valuntil", "useconfig")(x => (x.usename, x.usesysid, x.usecreatedb, x.usesuper, x.userepl, x.usebypassrls, x.passwd, x.valuntil, x.useconfig))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly)))
  implicit val read: Read[PgUserViewRow] = new Read[PgUserViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (adventureworks.StringArrayMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgUserViewRow(
      usename = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      usesysid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      usecreatedb = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 2),
      usesuper = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 3),
      userepl = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 4),
      usebypassrls = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 5),
      passwd = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      valuntil = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 7),
      useconfig = adventureworks.StringArrayMeta.get.unsafeGetNullable(rs, i + 8)
    )
  )
}
