package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgAttributeRowUnsaved(
  attname: String,
  atttypid: Long,
  attstattarget: Int,
  attlen: Short,
  attndims: Int,
  attcacheoff: Int,
  atttypmod: Int,
  attbyval: Boolean,
  attalign: String,
  attstorage: String,
  attcompression: String,
  attnotnull: Boolean,
  atthasdef: Boolean,
  atthasmissing: Boolean,
  attidentity: String,
  attgenerated: String,
  attisdropped: Boolean,
  attislocal: Boolean,
  attinhcount: Int,
  attcollation: Long,
  attacl: Option[Array[String]],
  attoptions: Option[Array[String]],
  attfdwoptions: Option[Array[String]],
  attmissingval: Option[String]
)
object PgAttributeRowUnsaved {
  implicit val oFormat: OFormat[PgAttributeRowUnsaved] = new OFormat[PgAttributeRowUnsaved]{
    override def writes(o: PgAttributeRowUnsaved): JsObject =
      Json.obj(
        "attname" -> o.attname,
      "atttypid" -> o.atttypid,
      "attstattarget" -> o.attstattarget,
      "attlen" -> o.attlen,
      "attndims" -> o.attndims,
      "attcacheoff" -> o.attcacheoff,
      "atttypmod" -> o.atttypmod,
      "attbyval" -> o.attbyval,
      "attalign" -> o.attalign,
      "attstorage" -> o.attstorage,
      "attcompression" -> o.attcompression,
      "attnotnull" -> o.attnotnull,
      "atthasdef" -> o.atthasdef,
      "atthasmissing" -> o.atthasmissing,
      "attidentity" -> o.attidentity,
      "attgenerated" -> o.attgenerated,
      "attisdropped" -> o.attisdropped,
      "attislocal" -> o.attislocal,
      "attinhcount" -> o.attinhcount,
      "attcollation" -> o.attcollation,
      "attacl" -> o.attacl,
      "attoptions" -> o.attoptions,
      "attfdwoptions" -> o.attfdwoptions,
      "attmissingval" -> o.attmissingval
      )

    override def reads(json: JsValue): JsResult[PgAttributeRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgAttributeRowUnsaved(
            attname = json.\("attname").as[String],
            atttypid = json.\("atttypid").as[Long],
            attstattarget = json.\("attstattarget").as[Int],
            attlen = json.\("attlen").as[Short],
            attndims = json.\("attndims").as[Int],
            attcacheoff = json.\("attcacheoff").as[Int],
            atttypmod = json.\("atttypmod").as[Int],
            attbyval = json.\("attbyval").as[Boolean],
            attalign = json.\("attalign").as[String],
            attstorage = json.\("attstorage").as[String],
            attcompression = json.\("attcompression").as[String],
            attnotnull = json.\("attnotnull").as[Boolean],
            atthasdef = json.\("atthasdef").as[Boolean],
            atthasmissing = json.\("atthasmissing").as[Boolean],
            attidentity = json.\("attidentity").as[String],
            attgenerated = json.\("attgenerated").as[String],
            attisdropped = json.\("attisdropped").as[Boolean],
            attislocal = json.\("attislocal").as[Boolean],
            attinhcount = json.\("attinhcount").as[Int],
            attcollation = json.\("attcollation").as[Long],
            attacl = json.\("attacl").toOption.map(_.as[Array[String]]),
            attoptions = json.\("attoptions").toOption.map(_.as[Array[String]]),
            attfdwoptions = json.\("attfdwoptions").toOption.map(_.as[Array[String]]),
            attmissingval = json.\("attmissingval").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
