package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgProcRow(
  oid: Long,
  proname: String,
  pronamespace: Long,
  proowner: Long,
  prolang: Long,
  procost: Float,
  prorows: Float,
  provariadic: Long,
  prosupport: String,
  prokind: String,
  prosecdef: Boolean,
  proleakproof: Boolean,
  proisstrict: Boolean,
  proretset: Boolean,
  provolatile: String,
  proparallel: String,
  pronargs: Short,
  pronargdefaults: Short,
  prorettype: Long,
  proargtypes: String,
  proallargtypes: Option[Array[Long]],
  proargmodes: Option[Array[String]],
  proargnames: Option[Array[String]],
  proargdefaults: Option[String],
  protrftypes: Option[Array[Long]],
  prosrc: String,
  probin: Option[String],
  prosqlbody: Option[String],
  proconfig: Option[Array[String]],
  proacl: Option[Array[String]]
)

object PgProcRow {
  implicit val rowParser: RowParser[PgProcRow] = { row =>
    Success(
      PgProcRow(
        oid = row[Long]("oid"),
        proname = row[String]("proname"),
        pronamespace = row[Long]("pronamespace"),
        proowner = row[Long]("proowner"),
        prolang = row[Long]("prolang"),
        procost = row[Float]("procost"),
        prorows = row[Float]("prorows"),
        provariadic = row[Long]("provariadic"),
        prosupport = row[String]("prosupport"),
        prokind = row[String]("prokind"),
        prosecdef = row[Boolean]("prosecdef"),
        proleakproof = row[Boolean]("proleakproof"),
        proisstrict = row[Boolean]("proisstrict"),
        proretset = row[Boolean]("proretset"),
        provolatile = row[String]("provolatile"),
        proparallel = row[String]("proparallel"),
        pronargs = row[Short]("pronargs"),
        pronargdefaults = row[Short]("pronargdefaults"),
        prorettype = row[Long]("prorettype"),
        proargtypes = row[String]("proargtypes"),
        proallargtypes = row[Option[Array[Long]]]("proallargtypes"),
        proargmodes = row[Option[Array[String]]]("proargmodes"),
        proargnames = row[Option[Array[String]]]("proargnames"),
        proargdefaults = row[Option[String]]("proargdefaults"),
        protrftypes = row[Option[Array[Long]]]("protrftypes"),
        prosrc = row[String]("prosrc"),
        probin = row[Option[String]]("probin"),
        prosqlbody = row[Option[String]]("prosqlbody"),
        proconfig = row[Option[Array[String]]]("proconfig"),
        proacl = row[Option[Array[String]]]("proacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgProcRow] = new OFormat[PgProcRow]{
    override def writes(o: PgProcRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "proname" -> o.proname,
      "pronamespace" -> o.pronamespace,
      "proowner" -> o.proowner,
      "prolang" -> o.prolang,
      "procost" -> o.procost,
      "prorows" -> o.prorows,
      "provariadic" -> o.provariadic,
      "prosupport" -> o.prosupport,
      "prokind" -> o.prokind,
      "prosecdef" -> o.prosecdef,
      "proleakproof" -> o.proleakproof,
      "proisstrict" -> o.proisstrict,
      "proretset" -> o.proretset,
      "provolatile" -> o.provolatile,
      "proparallel" -> o.proparallel,
      "pronargs" -> o.pronargs,
      "pronargdefaults" -> o.pronargdefaults,
      "prorettype" -> o.prorettype,
      "proargtypes" -> o.proargtypes,
      "proallargtypes" -> o.proallargtypes,
      "proargmodes" -> o.proargmodes,
      "proargnames" -> o.proargnames,
      "proargdefaults" -> o.proargdefaults,
      "protrftypes" -> o.protrftypes,
      "prosrc" -> o.prosrc,
      "probin" -> o.probin,
      "prosqlbody" -> o.prosqlbody,
      "proconfig" -> o.proconfig,
      "proacl" -> o.proacl
      )

    override def reads(json: JsValue): JsResult[PgProcRow] = {
      JsResult.fromTry(
        Try(
          PgProcRow(
            oid = json.\("oid").as[Long],
            proname = json.\("proname").as[String],
            pronamespace = json.\("pronamespace").as[Long],
            proowner = json.\("proowner").as[Long],
            prolang = json.\("prolang").as[Long],
            procost = json.\("procost").as[Float],
            prorows = json.\("prorows").as[Float],
            provariadic = json.\("provariadic").as[Long],
            prosupport = json.\("prosupport").as[String],
            prokind = json.\("prokind").as[String],
            prosecdef = json.\("prosecdef").as[Boolean],
            proleakproof = json.\("proleakproof").as[Boolean],
            proisstrict = json.\("proisstrict").as[Boolean],
            proretset = json.\("proretset").as[Boolean],
            provolatile = json.\("provolatile").as[String],
            proparallel = json.\("proparallel").as[String],
            pronargs = json.\("pronargs").as[Short],
            pronargdefaults = json.\("pronargdefaults").as[Short],
            prorettype = json.\("prorettype").as[Long],
            proargtypes = json.\("proargtypes").as[String],
            proallargtypes = json.\("proallargtypes").toOption.map(_.as[Array[Long]]),
            proargmodes = json.\("proargmodes").toOption.map(_.as[Array[String]]),
            proargnames = json.\("proargnames").toOption.map(_.as[Array[String]]),
            proargdefaults = json.\("proargdefaults").toOption.map(_.as[String]),
            protrftypes = json.\("protrftypes").toOption.map(_.as[Array[Long]]),
            prosrc = json.\("prosrc").as[String],
            probin = json.\("probin").toOption.map(_.as[String]),
            prosqlbody = json.\("prosqlbody").toOption.map(_.as[String]),
            proconfig = json.\("proconfig").toOption.map(_.as[Array[String]]),
            proacl = json.\("proacl").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}