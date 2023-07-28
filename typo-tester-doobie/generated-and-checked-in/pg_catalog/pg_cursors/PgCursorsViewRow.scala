/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cursors

import adventureworks.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgCursorsViewRow(
  name: Option[String],
  statement: Option[String],
  isHoldable: Option[Boolean],
  isBinary: Option[Boolean],
  isScrollable: Option[Boolean],
  creationTime: Option[TypoOffsetDateTime]
)

object PgCursorsViewRow {
  implicit val decoder: Decoder[PgCursorsViewRow] = Decoder.forProduct6[PgCursorsViewRow, Option[String], Option[String], Option[Boolean], Option[Boolean], Option[Boolean], Option[TypoOffsetDateTime]]("name", "statement", "is_holdable", "is_binary", "is_scrollable", "creation_time")(PgCursorsViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(TypoOffsetDateTime.decoder))
  implicit val encoder: Encoder[PgCursorsViewRow] = Encoder.forProduct6[PgCursorsViewRow, Option[String], Option[String], Option[Boolean], Option[Boolean], Option[Boolean], Option[TypoOffsetDateTime]]("name", "statement", "is_holdable", "is_binary", "is_scrollable", "creation_time")(x => (x.name, x.statement, x.isHoldable, x.isBinary, x.isScrollable, x.creationTime))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(TypoOffsetDateTime.encoder))
  implicit val read: Read[PgCursorsViewRow] = new Read[PgCursorsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgCursorsViewRow(
      name = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      statement = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      isHoldable = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 2),
      isBinary = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 3),
      isScrollable = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 4),
      creationTime = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 5)
    )
  )
}
