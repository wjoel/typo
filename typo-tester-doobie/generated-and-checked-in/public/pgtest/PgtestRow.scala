/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtest

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
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json

case class PgtestRow(
  box: TypoBox,
  circle: TypoCircle,
  line: TypoLine,
  lseg: TypoLineSegment,
  path: TypoPath,
  point: TypoPoint,
  polygon: TypoPolygon,
  interval: TypoInterval,
  money: TypoMoney,
  xml: TypoXml,
  json: TypoJson,
  jsonb: TypoJsonb,
  hstore: TypoHStore,
  inet: TypoInet,
  boxes: Array[TypoBox],
  circlees: Array[TypoCircle],
  linees: Array[TypoLine],
  lseges: Array[TypoLineSegment],
  pathes: Array[TypoPath],
  pointes: Array[TypoPoint],
  polygones: Array[TypoPolygon],
  intervales: Array[TypoInterval],
  moneyes: Array[TypoMoney],
  xmles: Array[TypoXml],
  jsones: Array[TypoJson],
  jsonbes: Array[TypoJsonb],
  hstores: Array[TypoHStore],
  inets: Array[TypoInet]
)

object PgtestRow {
  implicit val decoder: Decoder[PgtestRow] =
    (c: HCursor) =>
      for {
        box <- c.downField("box").as[TypoBox]
        circle <- c.downField("circle").as[TypoCircle]
        line <- c.downField("line").as[TypoLine]
        lseg <- c.downField("lseg").as[TypoLineSegment]
        path <- c.downField("path").as[TypoPath]
        point <- c.downField("point").as[TypoPoint]
        polygon <- c.downField("polygon").as[TypoPolygon]
        interval <- c.downField("interval").as[TypoInterval]
        money <- c.downField("money").as[TypoMoney]
        xml <- c.downField("xml").as[TypoXml]
        json <- c.downField("json").as[TypoJson]
        jsonb <- c.downField("jsonb").as[TypoJsonb]
        hstore <- c.downField("hstore").as[TypoHStore]
        inet <- c.downField("inet").as[TypoInet]
        boxes <- c.downField("boxes").as[Array[TypoBox]]
        circlees <- c.downField("circlees").as[Array[TypoCircle]]
        linees <- c.downField("linees").as[Array[TypoLine]]
        lseges <- c.downField("lseges").as[Array[TypoLineSegment]]
        pathes <- c.downField("pathes").as[Array[TypoPath]]
        pointes <- c.downField("pointes").as[Array[TypoPoint]]
        polygones <- c.downField("polygones").as[Array[TypoPolygon]]
        intervales <- c.downField("intervales").as[Array[TypoInterval]]
        moneyes <- c.downField("moneyes").as[Array[TypoMoney]]
        xmles <- c.downField("xmles").as[Array[TypoXml]]
        jsones <- c.downField("jsones").as[Array[TypoJson]]
        jsonbes <- c.downField("jsonbes").as[Array[TypoJsonb]]
        hstores <- c.downField("hstores").as[Array[TypoHStore]]
        inets <- c.downField("inets").as[Array[TypoInet]]
      } yield PgtestRow(box, circle, line, lseg, path, point, polygon, interval, money, xml, json, jsonb, hstore, inet, boxes, circlees, linees, lseges, pathes, pointes, polygones, intervales, moneyes, xmles, jsones, jsonbes, hstores, inets)
  implicit val encoder: Encoder[PgtestRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "box" := row.box,
        "circle" := row.circle,
        "line" := row.line,
        "lseg" := row.lseg,
        "path" := row.path,
        "point" := row.point,
        "polygon" := row.polygon,
        "interval" := row.interval,
        "money" := row.money,
        "xml" := row.xml,
        "json" := row.json,
        "jsonb" := row.jsonb,
        "hstore" := row.hstore,
        "inet" := row.inet,
        "boxes" := row.boxes,
        "circlees" := row.circlees,
        "linees" := row.linees,
        "lseges" := row.lseges,
        "pathes" := row.pathes,
        "pointes" := row.pointes,
        "polygones" := row.polygones,
        "intervales" := row.intervales,
        "moneyes" := row.moneyes,
        "xmles" := row.xmles,
        "jsones" := row.jsones,
        "jsonbes" := row.jsonbes,
        "hstores" := row.hstores,
        "inets" := row.inets
      )}
}
