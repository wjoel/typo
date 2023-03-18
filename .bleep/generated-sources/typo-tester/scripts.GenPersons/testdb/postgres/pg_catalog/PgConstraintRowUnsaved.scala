package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgConstraintRowUnsaved(
  conname: String,
  connamespace: Long,
  contype: String,
  condeferrable: Boolean,
  condeferred: Boolean,
  convalidated: Boolean,
  conrelid: Long,
  contypid: Long,
  conindid: Long,
  conparentid: Long,
  confrelid: Long,
  confupdtype: String,
  confdeltype: String,
  confmatchtype: String,
  conislocal: Boolean,
  coninhcount: Int,
  connoinherit: Boolean,
  conkey: Option[Array[Short]],
  confkey: Option[Array[Short]],
  conpfeqop: Option[Array[Long]],
  conppeqop: Option[Array[Long]],
  conffeqop: Option[Array[Long]],
  conexclop: Option[Array[Long]],
  conbin: Option[String]
)
object PgConstraintRowUnsaved {
  implicit val oFormat: OFormat[PgConstraintRowUnsaved] = new OFormat[PgConstraintRowUnsaved]{
    override def writes(o: PgConstraintRowUnsaved): JsObject =
      Json.obj(
        "conname" -> o.conname,
      "connamespace" -> o.connamespace,
      "contype" -> o.contype,
      "condeferrable" -> o.condeferrable,
      "condeferred" -> o.condeferred,
      "convalidated" -> o.convalidated,
      "conrelid" -> o.conrelid,
      "contypid" -> o.contypid,
      "conindid" -> o.conindid,
      "conparentid" -> o.conparentid,
      "confrelid" -> o.confrelid,
      "confupdtype" -> o.confupdtype,
      "confdeltype" -> o.confdeltype,
      "confmatchtype" -> o.confmatchtype,
      "conislocal" -> o.conislocal,
      "coninhcount" -> o.coninhcount,
      "connoinherit" -> o.connoinherit,
      "conkey" -> o.conkey,
      "confkey" -> o.confkey,
      "conpfeqop" -> o.conpfeqop,
      "conppeqop" -> o.conppeqop,
      "conffeqop" -> o.conffeqop,
      "conexclop" -> o.conexclop,
      "conbin" -> o.conbin
      )

    override def reads(json: JsValue): JsResult[PgConstraintRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgConstraintRowUnsaved(
            conname = json.\("conname").as[String],
            connamespace = json.\("connamespace").as[Long],
            contype = json.\("contype").as[String],
            condeferrable = json.\("condeferrable").as[Boolean],
            condeferred = json.\("condeferred").as[Boolean],
            convalidated = json.\("convalidated").as[Boolean],
            conrelid = json.\("conrelid").as[Long],
            contypid = json.\("contypid").as[Long],
            conindid = json.\("conindid").as[Long],
            conparentid = json.\("conparentid").as[Long],
            confrelid = json.\("confrelid").as[Long],
            confupdtype = json.\("confupdtype").as[String],
            confdeltype = json.\("confdeltype").as[String],
            confmatchtype = json.\("confmatchtype").as[String],
            conislocal = json.\("conislocal").as[Boolean],
            coninhcount = json.\("coninhcount").as[Int],
            connoinherit = json.\("connoinherit").as[Boolean],
            conkey = json.\("conkey").toOption.map(_.as[Array[Short]]),
            confkey = json.\("confkey").toOption.map(_.as[Array[Short]]),
            conpfeqop = json.\("conpfeqop").toOption.map(_.as[Array[Long]]),
            conppeqop = json.\("conppeqop").toOption.map(_.as[Array[Long]]),
            conffeqop = json.\("conffeqop").toOption.map(_.as[Array[Long]]),
            conexclop = json.\("conexclop").toOption.map(_.as[Array[Long]]),
            conbin = json.\("conbin").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
