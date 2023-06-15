/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtestnull

import adventureworks.TypoBox
import adventureworks.TypoCircle
import adventureworks.TypoHStore
import adventureworks.TypoInet
import adventureworks.TypoInterval
import adventureworks.TypoJson
import adventureworks.TypoJsonb
import adventureworks.TypoLine
import adventureworks.TypoLineSegment
import adventureworks.TypoMoney
import adventureworks.TypoPath
import adventureworks.TypoPoint
import adventureworks.TypoPolygon
import adventureworks.TypoXml
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgtestnullRow(
  box: Option[TypoBox],
  circle: Option[TypoCircle],
  line: Option[TypoLine],
  lseg: Option[TypoLineSegment],
  path: Option[TypoPath],
  point: Option[TypoPoint],
  polygon: Option[TypoPolygon],
  interval: Option[TypoInterval],
  money: Option[TypoMoney],
  xml: Option[TypoXml],
  json: Option[TypoJson],
  jsonb: Option[TypoJsonb],
  hstore: Option[TypoHStore],
  inet: Option[TypoInet],
  boxes: Option[Array[TypoBox]],
  circlees: Option[Array[TypoCircle]],
  linees: Option[Array[TypoLine]],
  lseges: Option[Array[TypoLineSegment]],
  pathes: Option[Array[TypoPath]],
  pointes: Option[Array[TypoPoint]],
  polygones: Option[Array[TypoPolygon]],
  intervales: Option[Array[TypoInterval]],
  moneyes: Option[Array[TypoMoney]],
  xmles: Option[Array[TypoXml]],
  jsones: Option[Array[TypoJson]],
  jsonbes: Option[Array[TypoJsonb]],
  hstores: Option[Array[TypoHStore]],
  inets: Option[Array[TypoInet]]
)

object PgtestnullRow {
  implicit val oFormat: OFormat[PgtestnullRow] = new OFormat[PgtestnullRow]{
    override def writes(o: PgtestnullRow): JsObject =
      Json.obj(
        "box" -> o.box,
        "circle" -> o.circle,
        "line" -> o.line,
        "lseg" -> o.lseg,
        "path" -> o.path,
        "point" -> o.point,
        "polygon" -> o.polygon,
        "interval" -> o.interval,
        "money" -> o.money,
        "xml" -> o.xml,
        "json" -> o.json,
        "jsonb" -> o.jsonb,
        "hstore" -> o.hstore,
        "inet" -> o.inet,
        "boxes" -> o.boxes,
        "circlees" -> o.circlees,
        "linees" -> o.linees,
        "lseges" -> o.lseges,
        "pathes" -> o.pathes,
        "pointes" -> o.pointes,
        "polygones" -> o.polygones,
        "intervales" -> o.intervales,
        "moneyes" -> o.moneyes,
        "xmles" -> o.xmles,
        "jsones" -> o.jsones,
        "jsonbes" -> o.jsonbes,
        "hstores" -> o.hstores,
        "inets" -> o.inets
      )
  
    override def reads(json: JsValue): JsResult[PgtestnullRow] = {
      JsResult.fromTry(
        Try(
          PgtestnullRow(
            box = json.\("box").toOption.map(_.as[TypoBox]),
            circle = json.\("circle").toOption.map(_.as[TypoCircle]),
            line = json.\("line").toOption.map(_.as[TypoLine]),
            lseg = json.\("lseg").toOption.map(_.as[TypoLineSegment]),
            path = json.\("path").toOption.map(_.as[TypoPath]),
            point = json.\("point").toOption.map(_.as[TypoPoint]),
            polygon = json.\("polygon").toOption.map(_.as[TypoPolygon]),
            interval = json.\("interval").toOption.map(_.as[TypoInterval]),
            money = json.\("money").toOption.map(_.as[TypoMoney]),
            xml = json.\("xml").toOption.map(_.as[TypoXml]),
            json = json.\("json").toOption.map(_.as[TypoJson]),
            jsonb = json.\("jsonb").toOption.map(_.as[TypoJsonb]),
            hstore = json.\("hstore").toOption.map(_.as[TypoHStore]),
            inet = json.\("inet").toOption.map(_.as[TypoInet]),
            boxes = json.\("boxes").toOption.map(_.as[Array[TypoBox]]),
            circlees = json.\("circlees").toOption.map(_.as[Array[TypoCircle]]),
            linees = json.\("linees").toOption.map(_.as[Array[TypoLine]]),
            lseges = json.\("lseges").toOption.map(_.as[Array[TypoLineSegment]]),
            pathes = json.\("pathes").toOption.map(_.as[Array[TypoPath]]),
            pointes = json.\("pointes").toOption.map(_.as[Array[TypoPoint]]),
            polygones = json.\("polygones").toOption.map(_.as[Array[TypoPolygon]]),
            intervales = json.\("intervales").toOption.map(_.as[Array[TypoInterval]]),
            moneyes = json.\("moneyes").toOption.map(_.as[Array[TypoMoney]]),
            xmles = json.\("xmles").toOption.map(_.as[Array[TypoXml]]),
            jsones = json.\("jsones").toOption.map(_.as[Array[TypoJson]]),
            jsonbes = json.\("jsonbes").toOption.map(_.as[Array[TypoJsonb]]),
            hstores = json.\("hstores").toOption.map(_.as[Array[TypoHStore]]),
            inets = json.\("inets").toOption.map(_.as[Array[TypoInet]])
          )
        )
      )
    }
  }
}
