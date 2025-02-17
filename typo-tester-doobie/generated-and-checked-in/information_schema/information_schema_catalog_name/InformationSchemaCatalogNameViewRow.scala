/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package information_schema_catalog_name

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class InformationSchemaCatalogNameViewRow(
  catalogName: Option[SqlIdentifier]
)

object InformationSchemaCatalogNameViewRow {
  implicit val decoder: Decoder[InformationSchemaCatalogNameViewRow] = Decoder.forProduct1[InformationSchemaCatalogNameViewRow, Option[SqlIdentifier]]("catalog_name")(InformationSchemaCatalogNameViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder))
  implicit val encoder: Encoder[InformationSchemaCatalogNameViewRow] = Encoder.forProduct1[InformationSchemaCatalogNameViewRow, Option[SqlIdentifier]]("catalog_name")(x => (x.catalogName))(Encoder.encodeOption(SqlIdentifier.encoder))
  implicit val read: Read[InformationSchemaCatalogNameViewRow] = new Read[InformationSchemaCatalogNameViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => InformationSchemaCatalogNameViewRow(
      catalogName = SqlIdentifier.get.unsafeGetNullable(rs, i + 0)
    )
  )
}
