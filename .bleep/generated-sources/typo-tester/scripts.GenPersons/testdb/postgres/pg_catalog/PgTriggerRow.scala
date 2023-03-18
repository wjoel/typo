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

case class PgTriggerRow(
  oid: Long,
  tgrelid: Long,
  tgparentid: Long,
  tgname: String,
  tgfoid: Long,
  tgtype: Short,
  tgenabled: String,
  tgisinternal: Boolean,
  tgconstrrelid: Long,
  tgconstrindid: Long,
  tgconstraint: Long,
  tgdeferrable: Boolean,
  tginitdeferred: Boolean,
  tgnargs: Short,
  tgattr: String,
  tgargs: String,
  tgqual: Option[String],
  tgoldtable: Option[String],
  tgnewtable: Option[String]
)

object PgTriggerRow {
  implicit val rowParser: RowParser[PgTriggerRow] = { row =>
    Success(
      PgTriggerRow(
        oid = row[Long]("oid"),
        tgrelid = row[Long]("tgrelid"),
        tgparentid = row[Long]("tgparentid"),
        tgname = row[String]("tgname"),
        tgfoid = row[Long]("tgfoid"),
        tgtype = row[Short]("tgtype"),
        tgenabled = row[String]("tgenabled"),
        tgisinternal = row[Boolean]("tgisinternal"),
        tgconstrrelid = row[Long]("tgconstrrelid"),
        tgconstrindid = row[Long]("tgconstrindid"),
        tgconstraint = row[Long]("tgconstraint"),
        tgdeferrable = row[Boolean]("tgdeferrable"),
        tginitdeferred = row[Boolean]("tginitdeferred"),
        tgnargs = row[Short]("tgnargs"),
        tgattr = row[String]("tgattr"),
        tgargs = row[String]("tgargs"),
        tgqual = row[Option[String]]("tgqual"),
        tgoldtable = row[Option[String]]("tgoldtable"),
        tgnewtable = row[Option[String]]("tgnewtable")
      )
    )
  }

  implicit val oFormat: OFormat[PgTriggerRow] = new OFormat[PgTriggerRow]{
    override def writes(o: PgTriggerRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "tgrelid" -> o.tgrelid,
      "tgparentid" -> o.tgparentid,
      "tgname" -> o.tgname,
      "tgfoid" -> o.tgfoid,
      "tgtype" -> o.tgtype,
      "tgenabled" -> o.tgenabled,
      "tgisinternal" -> o.tgisinternal,
      "tgconstrrelid" -> o.tgconstrrelid,
      "tgconstrindid" -> o.tgconstrindid,
      "tgconstraint" -> o.tgconstraint,
      "tgdeferrable" -> o.tgdeferrable,
      "tginitdeferred" -> o.tginitdeferred,
      "tgnargs" -> o.tgnargs,
      "tgattr" -> o.tgattr,
      "tgargs" -> o.tgargs,
      "tgqual" -> o.tgqual,
      "tgoldtable" -> o.tgoldtable,
      "tgnewtable" -> o.tgnewtable
      )

    override def reads(json: JsValue): JsResult[PgTriggerRow] = {
      JsResult.fromTry(
        Try(
          PgTriggerRow(
            oid = json.\("oid").as[Long],
            tgrelid = json.\("tgrelid").as[Long],
            tgparentid = json.\("tgparentid").as[Long],
            tgname = json.\("tgname").as[String],
            tgfoid = json.\("tgfoid").as[Long],
            tgtype = json.\("tgtype").as[Short],
            tgenabled = json.\("tgenabled").as[String],
            tgisinternal = json.\("tgisinternal").as[Boolean],
            tgconstrrelid = json.\("tgconstrrelid").as[Long],
            tgconstrindid = json.\("tgconstrindid").as[Long],
            tgconstraint = json.\("tgconstraint").as[Long],
            tgdeferrable = json.\("tgdeferrable").as[Boolean],
            tginitdeferred = json.\("tginitdeferred").as[Boolean],
            tgnargs = json.\("tgnargs").as[Short],
            tgattr = json.\("tgattr").as[String],
            tgargs = json.\("tgargs").as[String],
            tgqual = json.\("tgqual").toOption.map(_.as[String]),
            tgoldtable = json.\("tgoldtable").toOption.map(_.as[String]),
            tgnewtable = json.\("tgnewtable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}