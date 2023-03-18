package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTypeRowUnsaved(
  typname: String,
  typnamespace: Long,
  typowner: Long,
  typlen: Short,
  typbyval: Boolean,
  typtype: String,
  typcategory: String,
  typispreferred: Boolean,
  typisdefined: Boolean,
  typdelim: String,
  typrelid: Long,
  typsubscript: String,
  typelem: Long,
  typarray: Long,
  typinput: String,
  typoutput: String,
  typreceive: String,
  typsend: String,
  typmodin: String,
  typmodout: String,
  typanalyze: String,
  typalign: String,
  typstorage: String,
  typnotnull: Boolean,
  typbasetype: Long,
  typtypmod: Int,
  typndims: Int,
  typcollation: Long,
  typdefaultbin: Option[String],
  typdefault: Option[String],
  typacl: Option[Array[String]]
)
object PgTypeRowUnsaved {
  implicit val oFormat: OFormat[PgTypeRowUnsaved] = new OFormat[PgTypeRowUnsaved]{
    override def writes(o: PgTypeRowUnsaved): JsObject =
      Json.obj(
        "typname" -> o.typname,
      "typnamespace" -> o.typnamespace,
      "typowner" -> o.typowner,
      "typlen" -> o.typlen,
      "typbyval" -> o.typbyval,
      "typtype" -> o.typtype,
      "typcategory" -> o.typcategory,
      "typispreferred" -> o.typispreferred,
      "typisdefined" -> o.typisdefined,
      "typdelim" -> o.typdelim,
      "typrelid" -> o.typrelid,
      "typsubscript" -> o.typsubscript,
      "typelem" -> o.typelem,
      "typarray" -> o.typarray,
      "typinput" -> o.typinput,
      "typoutput" -> o.typoutput,
      "typreceive" -> o.typreceive,
      "typsend" -> o.typsend,
      "typmodin" -> o.typmodin,
      "typmodout" -> o.typmodout,
      "typanalyze" -> o.typanalyze,
      "typalign" -> o.typalign,
      "typstorage" -> o.typstorage,
      "typnotnull" -> o.typnotnull,
      "typbasetype" -> o.typbasetype,
      "typtypmod" -> o.typtypmod,
      "typndims" -> o.typndims,
      "typcollation" -> o.typcollation,
      "typdefaultbin" -> o.typdefaultbin,
      "typdefault" -> o.typdefault,
      "typacl" -> o.typacl
      )

    override def reads(json: JsValue): JsResult[PgTypeRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgTypeRowUnsaved(
            typname = json.\("typname").as[String],
            typnamespace = json.\("typnamespace").as[Long],
            typowner = json.\("typowner").as[Long],
            typlen = json.\("typlen").as[Short],
            typbyval = json.\("typbyval").as[Boolean],
            typtype = json.\("typtype").as[String],
            typcategory = json.\("typcategory").as[String],
            typispreferred = json.\("typispreferred").as[Boolean],
            typisdefined = json.\("typisdefined").as[Boolean],
            typdelim = json.\("typdelim").as[String],
            typrelid = json.\("typrelid").as[Long],
            typsubscript = json.\("typsubscript").as[String],
            typelem = json.\("typelem").as[Long],
            typarray = json.\("typarray").as[Long],
            typinput = json.\("typinput").as[String],
            typoutput = json.\("typoutput").as[String],
            typreceive = json.\("typreceive").as[String],
            typsend = json.\("typsend").as[String],
            typmodin = json.\("typmodin").as[String],
            typmodout = json.\("typmodout").as[String],
            typanalyze = json.\("typanalyze").as[String],
            typalign = json.\("typalign").as[String],
            typstorage = json.\("typstorage").as[String],
            typnotnull = json.\("typnotnull").as[Boolean],
            typbasetype = json.\("typbasetype").as[Long],
            typtypmod = json.\("typtypmod").as[Int],
            typndims = json.\("typndims").as[Int],
            typcollation = json.\("typcollation").as[Long],
            typdefaultbin = json.\("typdefaultbin").toOption.map(_.as[String]),
            typdefault = json.\("typdefault").toOption.map(_.as[String]),
            typacl = json.\("typacl").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
