/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelinstructions

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class VproductmodelinstructionsViewRow(
  /** Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[productmodel.ProductmodelRow.name]] */
  name: Option[Name],
  /** Points to [[productmodel.ProductmodelRow.instructions]] */
  instructions: Option[TypoXml],
  LocationID: Option[Int],
  SetupHours: Option[BigDecimal],
  MachineHours: Option[BigDecimal],
  LaborHours: Option[BigDecimal],
  LotSize: Option[Int],
  Step: Option[/* max 1024 chars */ String],
  /** Points to [[productmodel.ProductmodelRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object VproductmodelinstructionsViewRow {
  implicit val decoder: Decoder[VproductmodelinstructionsViewRow] = Decoder.forProduct11[VproductmodelinstructionsViewRow, Option[ProductmodelId], Option[Name], Option[TypoXml], Option[Int], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[Int], Option[/* max 1024 chars */ String], Option[UUID], Option[TypoLocalDateTime]]("productmodelid", "name", "instructions", "LocationID", "SetupHours", "MachineHours", "LaborHours", "LotSize", "Step", "rowguid", "modifieddate")(VproductmodelinstructionsViewRow.apply)(Decoder.decodeOption(ProductmodelId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[VproductmodelinstructionsViewRow] = Encoder.forProduct11[VproductmodelinstructionsViewRow, Option[ProductmodelId], Option[Name], Option[TypoXml], Option[Int], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[Int], Option[/* max 1024 chars */ String], Option[UUID], Option[TypoLocalDateTime]]("productmodelid", "name", "instructions", "LocationID", "SetupHours", "MachineHours", "LaborHours", "LotSize", "Step", "rowguid", "modifieddate")(x => (x.productmodelid, x.name, x.instructions, x.LocationID, x.SetupHours, x.MachineHours, x.LaborHours, x.LotSize, x.Step, x.rowguid, x.modifieddate))(Encoder.encodeOption(ProductmodelId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit val read: Read[VproductmodelinstructionsViewRow] = new Read[VproductmodelinstructionsViewRow](
    gets = List(
      (ProductmodelId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VproductmodelinstructionsViewRow(
      productmodelid = ProductmodelId.get.unsafeGetNullable(rs, i + 0),
      name = Name.get.unsafeGetNullable(rs, i + 1),
      instructions = TypoXml.get.unsafeGetNullable(rs, i + 2),
      LocationID = Meta.IntMeta.get.unsafeGetNullable(rs, i + 3),
      SetupHours = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 4),
      MachineHours = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 5),
      LaborHours = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 6),
      LotSize = Meta.IntMeta.get.unsafeGetNullable(rs, i + 7),
      Step = Meta.StringMeta.get.unsafeGetNullable(rs, i + 8),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 9),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 10)
    )
  )
}
