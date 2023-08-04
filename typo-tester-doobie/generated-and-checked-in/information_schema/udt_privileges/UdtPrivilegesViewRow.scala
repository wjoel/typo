/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package udt_privileges

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class UdtPrivilegesViewRow(
  grantor: Option[SqlIdentifier],
  grantee: Option[SqlIdentifier],
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  privilegeType: Option[CharacterData],
  isGrantable: Option[YesOrNo]
)

object UdtPrivilegesViewRow {
  implicit val decoder: Decoder[UdtPrivilegesViewRow] = Decoder.forProduct7[UdtPrivilegesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[YesOrNo]]("grantor", "grantee", "udt_catalog", "udt_schema", "udt_name", "privilege_type", "is_grantable")(UdtPrivilegesViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(YesOrNo.decoder))
  implicit val encoder: Encoder[UdtPrivilegesViewRow] = Encoder.forProduct7[UdtPrivilegesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[YesOrNo]]("grantor", "grantee", "udt_catalog", "udt_schema", "udt_name", "privilege_type", "is_grantable")(x => (x.grantor, x.grantee, x.udtCatalog, x.udtSchema, x.udtName, x.privilegeType, x.isGrantable))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(YesOrNo.encoder))
  implicit val read: Read[UdtPrivilegesViewRow] = new Read[UdtPrivilegesViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (YesOrNo.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => UdtPrivilegesViewRow(
      grantor = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      grantee = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      udtCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      udtSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      udtName = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      privilegeType = CharacterData.get.unsafeGetNullable(rs, i + 5),
      isGrantable = YesOrNo.get.unsafeGetNullable(rs, i + 6)
    )
  )
}