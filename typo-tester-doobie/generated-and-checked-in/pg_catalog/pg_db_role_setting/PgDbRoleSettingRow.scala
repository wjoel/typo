/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_db_role_setting

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgDbRoleSettingRow(
  setdatabase: /* oid */ Long,
  setrole: /* oid */ Long,
  setconfig: Option[Array[String]]
){
   val compositeId: PgDbRoleSettingId = PgDbRoleSettingId(setdatabase, setrole)
 }

object PgDbRoleSettingRow {
  implicit val decoder: Decoder[PgDbRoleSettingRow] = Decoder.forProduct3[PgDbRoleSettingRow, /* oid */ Long, /* oid */ Long, Option[Array[String]]]("setdatabase", "setrole", "setconfig")(PgDbRoleSettingRow.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeOption(Decoder.decodeArray[String](Decoder.decodeString, implicitly)))
  implicit val encoder: Encoder[PgDbRoleSettingRow] = Encoder.forProduct3[PgDbRoleSettingRow, /* oid */ Long, /* oid */ Long, Option[Array[String]]]("setdatabase", "setrole", "setconfig")(x => (x.setdatabase, x.setrole, x.setconfig))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeOption(Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly)))
  implicit val read: Read[PgDbRoleSettingRow] = new Read[PgDbRoleSettingRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (adventureworks.StringArrayMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgDbRoleSettingRow(
      setdatabase = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      setrole = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      setconfig = adventureworks.StringArrayMeta.get.unsafeGetNullable(rs, i + 2)
    )
  )
}
