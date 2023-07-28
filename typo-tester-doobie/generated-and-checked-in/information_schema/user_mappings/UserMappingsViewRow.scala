/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_mappings

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class UserMappingsViewRow(
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[SqlIdentifier],
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.foreignServerName]] */
  foreignServerName: Option[SqlIdentifier]
)

object UserMappingsViewRow {
  implicit val decoder: Decoder[UserMappingsViewRow] = Decoder.forProduct3[UserMappingsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("authorization_identifier", "foreign_server_catalog", "foreign_server_name")(UserMappingsViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[UserMappingsViewRow] = Encoder.forProduct3[UserMappingsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("authorization_identifier", "foreign_server_catalog", "foreign_server_name")(x => (x.authorizationIdentifier, x.foreignServerCatalog, x.foreignServerName))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[UserMappingsViewRow] = new Read[UserMappingsViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => UserMappingsViewRow(
      authorizationIdentifier = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      foreignServerCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      foreignServerName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2)
    )
  )
}
