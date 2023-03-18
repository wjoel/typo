package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgAggregateRowUnsaved(
  aggkind: String,
  aggnumdirectargs: Short,
  aggtransfn: String,
  aggfinalfn: String,
  aggcombinefn: String,
  aggserialfn: String,
  aggdeserialfn: String,
  aggmtransfn: String,
  aggminvtransfn: String,
  aggmfinalfn: String,
  aggfinalextra: Boolean,
  aggmfinalextra: Boolean,
  aggfinalmodify: String,
  aggmfinalmodify: String,
  aggsortop: Long,
  aggtranstype: Long,
  aggtransspace: Int,
  aggmtranstype: Long,
  aggmtransspace: Int,
  agginitval: Option[String],
  aggminitval: Option[String]
)
object PgAggregateRowUnsaved {
  implicit val oFormat: OFormat[PgAggregateRowUnsaved] = new OFormat[PgAggregateRowUnsaved]{
    override def writes(o: PgAggregateRowUnsaved): JsObject =
      Json.obj(
        "aggkind" -> o.aggkind,
      "aggnumdirectargs" -> o.aggnumdirectargs,
      "aggtransfn" -> o.aggtransfn,
      "aggfinalfn" -> o.aggfinalfn,
      "aggcombinefn" -> o.aggcombinefn,
      "aggserialfn" -> o.aggserialfn,
      "aggdeserialfn" -> o.aggdeserialfn,
      "aggmtransfn" -> o.aggmtransfn,
      "aggminvtransfn" -> o.aggminvtransfn,
      "aggmfinalfn" -> o.aggmfinalfn,
      "aggfinalextra" -> o.aggfinalextra,
      "aggmfinalextra" -> o.aggmfinalextra,
      "aggfinalmodify" -> o.aggfinalmodify,
      "aggmfinalmodify" -> o.aggmfinalmodify,
      "aggsortop" -> o.aggsortop,
      "aggtranstype" -> o.aggtranstype,
      "aggtransspace" -> o.aggtransspace,
      "aggmtranstype" -> o.aggmtranstype,
      "aggmtransspace" -> o.aggmtransspace,
      "agginitval" -> o.agginitval,
      "aggminitval" -> o.aggminitval
      )

    override def reads(json: JsValue): JsResult[PgAggregateRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgAggregateRowUnsaved(
            aggkind = json.\("aggkind").as[String],
            aggnumdirectargs = json.\("aggnumdirectargs").as[Short],
            aggtransfn = json.\("aggtransfn").as[String],
            aggfinalfn = json.\("aggfinalfn").as[String],
            aggcombinefn = json.\("aggcombinefn").as[String],
            aggserialfn = json.\("aggserialfn").as[String],
            aggdeserialfn = json.\("aggdeserialfn").as[String],
            aggmtransfn = json.\("aggmtransfn").as[String],
            aggminvtransfn = json.\("aggminvtransfn").as[String],
            aggmfinalfn = json.\("aggmfinalfn").as[String],
            aggfinalextra = json.\("aggfinalextra").as[Boolean],
            aggmfinalextra = json.\("aggmfinalextra").as[Boolean],
            aggfinalmodify = json.\("aggfinalmodify").as[String],
            aggmfinalmodify = json.\("aggmfinalmodify").as[String],
            aggsortop = json.\("aggsortop").as[Long],
            aggtranstype = json.\("aggtranstype").as[Long],
            aggtransspace = json.\("aggtransspace").as[Int],
            aggmtranstype = json.\("aggmtranstype").as[Long],
            aggmtransspace = json.\("aggmtransspace").as[Int],
            agginitval = json.\("agginitval").toOption.map(_.as[String]),
            aggminitval = json.\("aggminitval").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
