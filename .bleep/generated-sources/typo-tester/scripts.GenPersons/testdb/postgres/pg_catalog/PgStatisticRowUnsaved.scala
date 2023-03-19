package testdb
package postgres
package pg_catalog

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatisticRowUnsaved(
  stanullfrac: Float,
  stawidth: Int,
  stadistinct: Float,
  stakind1: Short,
  stakind2: Short,
  stakind3: Short,
  stakind4: Short,
  stakind5: Short,
  staop1: Long,
  staop2: Long,
  staop3: Long,
  staop4: Long,
  staop5: Long,
  stacoll1: Long,
  stacoll2: Long,
  stacoll3: Long,
  stacoll4: Long,
  stacoll5: Long,
  stanumbers1: Option[Array[Float]],
  stanumbers2: Option[Array[Float]],
  stanumbers3: Option[Array[Float]],
  stanumbers4: Option[Array[Float]],
  stanumbers5: Option[Array[Float]],
  stavalues1: Option[String],
  stavalues2: Option[String],
  stavalues3: Option[String],
  stavalues4: Option[String],
  stavalues5: Option[String]
)
object PgStatisticRowUnsaved {
  implicit val oFormat: OFormat[PgStatisticRowUnsaved] = new OFormat[PgStatisticRowUnsaved]{
    override def writes(o: PgStatisticRowUnsaved): JsObject =
      Json.obj(
        "stanullfrac" -> o.stanullfrac,
      "stawidth" -> o.stawidth,
      "stadistinct" -> o.stadistinct,
      "stakind1" -> o.stakind1,
      "stakind2" -> o.stakind2,
      "stakind3" -> o.stakind3,
      "stakind4" -> o.stakind4,
      "stakind5" -> o.stakind5,
      "staop1" -> o.staop1,
      "staop2" -> o.staop2,
      "staop3" -> o.staop3,
      "staop4" -> o.staop4,
      "staop5" -> o.staop5,
      "stacoll1" -> o.stacoll1,
      "stacoll2" -> o.stacoll2,
      "stacoll3" -> o.stacoll3,
      "stacoll4" -> o.stacoll4,
      "stacoll5" -> o.stacoll5,
      "stanumbers1" -> o.stanumbers1,
      "stanumbers2" -> o.stanumbers2,
      "stanumbers3" -> o.stanumbers3,
      "stanumbers4" -> o.stanumbers4,
      "stanumbers5" -> o.stanumbers5,
      "stavalues1" -> o.stavalues1,
      "stavalues2" -> o.stavalues2,
      "stavalues3" -> o.stavalues3,
      "stavalues4" -> o.stavalues4,
      "stavalues5" -> o.stavalues5
      )

    override def reads(json: JsValue): JsResult[PgStatisticRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgStatisticRowUnsaved(
            stanullfrac = json.\("stanullfrac").as[Float],
            stawidth = json.\("stawidth").as[Int],
            stadistinct = json.\("stadistinct").as[Float],
            stakind1 = json.\("stakind1").as[Short],
            stakind2 = json.\("stakind2").as[Short],
            stakind3 = json.\("stakind3").as[Short],
            stakind4 = json.\("stakind4").as[Short],
            stakind5 = json.\("stakind5").as[Short],
            staop1 = json.\("staop1").as[Long],
            staop2 = json.\("staop2").as[Long],
            staop3 = json.\("staop3").as[Long],
            staop4 = json.\("staop4").as[Long],
            staop5 = json.\("staop5").as[Long],
            stacoll1 = json.\("stacoll1").as[Long],
            stacoll2 = json.\("stacoll2").as[Long],
            stacoll3 = json.\("stacoll3").as[Long],
            stacoll4 = json.\("stacoll4").as[Long],
            stacoll5 = json.\("stacoll5").as[Long],
            stanumbers1 = json.\("stanumbers1").toOption.map(_.as[Array[Float]]),
            stanumbers2 = json.\("stanumbers2").toOption.map(_.as[Array[Float]]),
            stanumbers3 = json.\("stanumbers3").toOption.map(_.as[Array[Float]]),
            stanumbers4 = json.\("stanumbers4").toOption.map(_.as[Array[Float]]),
            stanumbers5 = json.\("stanumbers5").toOption.map(_.as[Array[Float]]),
            stavalues1 = json.\("stavalues1").toOption.map(_.as[String]),
            stavalues2 = json.\("stavalues2").toOption.map(_.as[String]),
            stavalues3 = json.\("stavalues3").toOption.map(_.as[String]),
            stavalues4 = json.\("stavalues4").toOption.map(_.as[String]),
            stavalues5 = json.\("stavalues5").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}