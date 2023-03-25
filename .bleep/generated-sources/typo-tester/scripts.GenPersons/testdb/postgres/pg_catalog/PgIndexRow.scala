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

case class PgIndexRow(
  indexrelid: PgIndexId,
  indrelid: Long,
  indnatts: Int,
  indnkeyatts: Int,
  indisunique: Boolean,
  indisprimary: Boolean,
  indisexclusion: Boolean,
  indimmediate: Boolean,
  indisclustered: Boolean,
  indisvalid: Boolean,
  indcheckxmin: Boolean,
  indisready: Boolean,
  indislive: Boolean,
  indisreplident: Boolean,
  indkey: PGobject,
  indcollation: PGobject,
  indclass: PGobject,
  indoption: PGobject,
  indexprs: Option[PGobject],
  indpred: Option[PGobject]
)

object PgIndexRow {
  def rowParser(prefix: String): RowParser[PgIndexRow] = { row =>
    Success(
      PgIndexRow(
        indexrelid = row[PgIndexId](prefix + "indexrelid"),
        indrelid = row[Long](prefix + "indrelid"),
        indnatts = row[Int](prefix + "indnatts"),
        indnkeyatts = row[Int](prefix + "indnkeyatts"),
        indisunique = row[Boolean](prefix + "indisunique"),
        indisprimary = row[Boolean](prefix + "indisprimary"),
        indisexclusion = row[Boolean](prefix + "indisexclusion"),
        indimmediate = row[Boolean](prefix + "indimmediate"),
        indisclustered = row[Boolean](prefix + "indisclustered"),
        indisvalid = row[Boolean](prefix + "indisvalid"),
        indcheckxmin = row[Boolean](prefix + "indcheckxmin"),
        indisready = row[Boolean](prefix + "indisready"),
        indislive = row[Boolean](prefix + "indislive"),
        indisreplident = row[Boolean](prefix + "indisreplident"),
        indkey = row[PGobject](prefix + "indkey"),
        indcollation = row[PGobject](prefix + "indcollation"),
        indclass = row[PGobject](prefix + "indclass"),
        indoption = row[PGobject](prefix + "indoption"),
        indexprs = row[Option[PGobject]](prefix + "indexprs"),
        indpred = row[Option[PGobject]](prefix + "indpred")
      )
    )
  }

  implicit val oFormat: OFormat[PgIndexRow] = new OFormat[PgIndexRow]{
    override def writes(o: PgIndexRow): JsObject =
      Json.obj(
        "indexrelid" -> o.indexrelid,
      "indrelid" -> o.indrelid,
      "indnatts" -> o.indnatts,
      "indnkeyatts" -> o.indnkeyatts,
      "indisunique" -> o.indisunique,
      "indisprimary" -> o.indisprimary,
      "indisexclusion" -> o.indisexclusion,
      "indimmediate" -> o.indimmediate,
      "indisclustered" -> o.indisclustered,
      "indisvalid" -> o.indisvalid,
      "indcheckxmin" -> o.indcheckxmin,
      "indisready" -> o.indisready,
      "indislive" -> o.indislive,
      "indisreplident" -> o.indisreplident,
      "indkey" -> o.indkey,
      "indcollation" -> o.indcollation,
      "indclass" -> o.indclass,
      "indoption" -> o.indoption,
      "indexprs" -> o.indexprs,
      "indpred" -> o.indpred
      )

    override def reads(json: JsValue): JsResult[PgIndexRow] = {
      JsResult.fromTry(
        Try(
          PgIndexRow(
            indexrelid = json.\("indexrelid").as[PgIndexId],
            indrelid = json.\("indrelid").as[Long],
            indnatts = json.\("indnatts").as[Int],
            indnkeyatts = json.\("indnkeyatts").as[Int],
            indisunique = json.\("indisunique").as[Boolean],
            indisprimary = json.\("indisprimary").as[Boolean],
            indisexclusion = json.\("indisexclusion").as[Boolean],
            indimmediate = json.\("indimmediate").as[Boolean],
            indisclustered = json.\("indisclustered").as[Boolean],
            indisvalid = json.\("indisvalid").as[Boolean],
            indcheckxmin = json.\("indcheckxmin").as[Boolean],
            indisready = json.\("indisready").as[Boolean],
            indislive = json.\("indislive").as[Boolean],
            indisreplident = json.\("indisreplident").as[Boolean],
            indkey = json.\("indkey").as[PGobject],
            indcollation = json.\("indcollation").as[PGobject],
            indclass = json.\("indclass").as[PGobject],
            indoption = json.\("indoption").as[PGobject],
            indexprs = json.\("indexprs").toOption.map(_.as[PGobject]),
            indpred = json.\("indpred").toOption.map(_.as[PGobject])
          )
        )
      )
    }
  }
}
