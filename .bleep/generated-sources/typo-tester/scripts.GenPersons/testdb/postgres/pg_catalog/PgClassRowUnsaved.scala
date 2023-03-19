package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgClassRowUnsaved(
  relname: String,
  relnamespace: Long,
  reltype: Long,
  reloftype: Long,
  relowner: Long,
  relam: Long,
  relfilenode: Long,
  reltablespace: Long,
  relpages: Int,
  reltuples: Float,
  relallvisible: Int,
  reltoastrelid: Long,
  relhasindex: Boolean,
  relisshared: Boolean,
  relpersistence: String,
  relkind: String,
  relnatts: Short,
  relchecks: Short,
  relhasrules: Boolean,
  relhastriggers: Boolean,
  relhassubclass: Boolean,
  relrowsecurity: Boolean,
  relforcerowsecurity: Boolean,
  relispopulated: Boolean,
  relreplident: String,
  relispartition: Boolean,
  relrewrite: Long,
  relfrozenxid: String,
  relminmxid: String,
  relacl: Option[Array[String]],
  reloptions: Option[Array[String]],
  relpartbound: Option[String]
)
object PgClassRowUnsaved {
  implicit val oFormat: OFormat[PgClassRowUnsaved] = new OFormat[PgClassRowUnsaved]{
    override def writes(o: PgClassRowUnsaved): JsObject =
      Json.obj(
        "relname" -> o.relname,
      "relnamespace" -> o.relnamespace,
      "reltype" -> o.reltype,
      "reloftype" -> o.reloftype,
      "relowner" -> o.relowner,
      "relam" -> o.relam,
      "relfilenode" -> o.relfilenode,
      "reltablespace" -> o.reltablespace,
      "relpages" -> o.relpages,
      "reltuples" -> o.reltuples,
      "relallvisible" -> o.relallvisible,
      "reltoastrelid" -> o.reltoastrelid,
      "relhasindex" -> o.relhasindex,
      "relisshared" -> o.relisshared,
      "relpersistence" -> o.relpersistence,
      "relkind" -> o.relkind,
      "relnatts" -> o.relnatts,
      "relchecks" -> o.relchecks,
      "relhasrules" -> o.relhasrules,
      "relhastriggers" -> o.relhastriggers,
      "relhassubclass" -> o.relhassubclass,
      "relrowsecurity" -> o.relrowsecurity,
      "relforcerowsecurity" -> o.relforcerowsecurity,
      "relispopulated" -> o.relispopulated,
      "relreplident" -> o.relreplident,
      "relispartition" -> o.relispartition,
      "relrewrite" -> o.relrewrite,
      "relfrozenxid" -> o.relfrozenxid,
      "relminmxid" -> o.relminmxid,
      "relacl" -> o.relacl,
      "reloptions" -> o.reloptions,
      "relpartbound" -> o.relpartbound
      )

    override def reads(json: JsValue): JsResult[PgClassRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgClassRowUnsaved(
            relname = json.\("relname").as[String],
            relnamespace = json.\("relnamespace").as[Long],
            reltype = json.\("reltype").as[Long],
            reloftype = json.\("reloftype").as[Long],
            relowner = json.\("relowner").as[Long],
            relam = json.\("relam").as[Long],
            relfilenode = json.\("relfilenode").as[Long],
            reltablespace = json.\("reltablespace").as[Long],
            relpages = json.\("relpages").as[Int],
            reltuples = json.\("reltuples").as[Float],
            relallvisible = json.\("relallvisible").as[Int],
            reltoastrelid = json.\("reltoastrelid").as[Long],
            relhasindex = json.\("relhasindex").as[Boolean],
            relisshared = json.\("relisshared").as[Boolean],
            relpersistence = json.\("relpersistence").as[String],
            relkind = json.\("relkind").as[String],
            relnatts = json.\("relnatts").as[Short],
            relchecks = json.\("relchecks").as[Short],
            relhasrules = json.\("relhasrules").as[Boolean],
            relhastriggers = json.\("relhastriggers").as[Boolean],
            relhassubclass = json.\("relhassubclass").as[Boolean],
            relrowsecurity = json.\("relrowsecurity").as[Boolean],
            relforcerowsecurity = json.\("relforcerowsecurity").as[Boolean],
            relispopulated = json.\("relispopulated").as[Boolean],
            relreplident = json.\("relreplident").as[String],
            relispartition = json.\("relispartition").as[Boolean],
            relrewrite = json.\("relrewrite").as[Long],
            relfrozenxid = json.\("relfrozenxid").as[String],
            relminmxid = json.\("relminmxid").as[String],
            relacl = json.\("relacl").toOption.map(_.as[Array[String]]),
            reloptions = json.\("reloptions").toOption.map(_.as[Array[String]]),
            relpartbound = json.\("relpartbound").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}