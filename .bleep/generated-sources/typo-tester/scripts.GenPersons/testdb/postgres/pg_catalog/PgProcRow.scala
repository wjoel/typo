/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgProcRow(
  oid: PgProcId,
  proname: String,
  pronamespace: Long,
  proowner: Long,
  prolang: Long,
  procost: Float,
  prorows: Float,
  provariadic: Long,
  prosupport: PGobject,
  prokind: String,
  prosecdef: Boolean,
  proleakproof: Boolean,
  proisstrict: Boolean,
  proretset: Boolean,
  provolatile: String,
  proparallel: String,
  pronargs: Int,
  pronargdefaults: Int,
  prorettype: Long,
  proargtypes: PGobject,
  proallargtypes: Option[Array[Long]],
  proargmodes: Option[Array[String]],
  proargnames: Option[Array[String]],
  proargdefaults: Option[PGobject],
  protrftypes: Option[Array[Long]],
  prosrc: String,
  probin: Option[String],
  prosqlbody: Option[PGobject],
  proconfig: Option[Array[String]],
  proacl: Option[Array[PGobject]]
)

object PgProcRow {
  def rowParser(prefix: String): RowParser[PgProcRow] = { row =>
    Success(
      PgProcRow(
        oid = row[PgProcId](prefix + "oid"),
        proname = row[String](prefix + "proname"),
        pronamespace = row[Long](prefix + "pronamespace"),
        proowner = row[Long](prefix + "proowner"),
        prolang = row[Long](prefix + "prolang"),
        procost = row[Float](prefix + "procost"),
        prorows = row[Float](prefix + "prorows"),
        provariadic = row[Long](prefix + "provariadic"),
        prosupport = row[PGobject](prefix + "prosupport"),
        prokind = row[String](prefix + "prokind"),
        prosecdef = row[Boolean](prefix + "prosecdef"),
        proleakproof = row[Boolean](prefix + "proleakproof"),
        proisstrict = row[Boolean](prefix + "proisstrict"),
        proretset = row[Boolean](prefix + "proretset"),
        provolatile = row[String](prefix + "provolatile"),
        proparallel = row[String](prefix + "proparallel"),
        pronargs = row[Int](prefix + "pronargs"),
        pronargdefaults = row[Int](prefix + "pronargdefaults"),
        prorettype = row[Long](prefix + "prorettype"),
        proargtypes = row[PGobject](prefix + "proargtypes"),
        proallargtypes = row[Option[Array[Long]]](prefix + "proallargtypes"),
        proargmodes = row[Option[Array[String]]](prefix + "proargmodes"),
        proargnames = row[Option[Array[String]]](prefix + "proargnames"),
        proargdefaults = row[Option[PGobject]](prefix + "proargdefaults"),
        protrftypes = row[Option[Array[Long]]](prefix + "protrftypes"),
        prosrc = row[String](prefix + "prosrc"),
        probin = row[Option[String]](prefix + "probin"),
        prosqlbody = row[Option[PGobject]](prefix + "prosqlbody"),
        proconfig = row[Option[Array[String]]](prefix + "proconfig"),
        proacl = row[Option[Array[PGobject]]](prefix + "proacl")
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
            oid = json.\("oid").as[PgProcId],
            proname = json.\("proname").as[String],
            pronamespace = json.\("pronamespace").as[Long],
            proowner = json.\("proowner").as[Long],
            prolang = json.\("prolang").as[Long],
            procost = json.\("procost").as[Float],
            prorows = json.\("prorows").as[Float],
            provariadic = json.\("provariadic").as[Long],
            prosupport = json.\("prosupport").as[PGobject],
            prokind = json.\("prokind").as[String],
            prosecdef = json.\("prosecdef").as[Boolean],
            proleakproof = json.\("proleakproof").as[Boolean],
            proisstrict = json.\("proisstrict").as[Boolean],
            proretset = json.\("proretset").as[Boolean],
            provolatile = json.\("provolatile").as[String],
            proparallel = json.\("proparallel").as[String],
            pronargs = json.\("pronargs").as[Int],
            pronargdefaults = json.\("pronargdefaults").as[Int],
            prorettype = json.\("prorettype").as[Long],
            proargtypes = json.\("proargtypes").as[PGobject],
            proallargtypes = json.\("proallargtypes").toOption.map(_.as[Array[Long]]),
            proargmodes = json.\("proargmodes").toOption.map(_.as[Array[String]]),
            proargnames = json.\("proargnames").toOption.map(_.as[Array[String]]),
            proargdefaults = json.\("proargdefaults").toOption.map(_.as[PGobject]),
            protrftypes = json.\("protrftypes").toOption.map(_.as[Array[Long]]),
            prosrc = json.\("prosrc").as[String],
            probin = json.\("probin").toOption.map(_.as[String]),
            prosqlbody = json.\("prosqlbody").toOption.map(_.as[PGobject]),
            proconfig = json.\("proconfig").toOption.map(_.as[Array[String]]),
            proacl = json.\("proacl").toOption.map(_.as[Array[PGobject]])
          )
        )
      )
    }
  }
}
