/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import cats.data.NonEmptyList
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.geometric.PGpoint
import org.postgresql.geometric.PGpolygon
import typo.dsl.Bijection

/** Polygon datatype in PostgreSQL */
case class TypoPolygon(points: List[TypoPoint])

object TypoPolygon {
  implicit val arrayGet: Get[Array[TypoPolygon]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_polygon"))
    .map(_.map(v => TypoPolygon(v.asInstanceOf[PGpolygon].points.map(p => TypoPoint(p.x, p.y)).toList)))
  implicit val arrayPut: Put[Array[TypoPolygon]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_polygon"), "polygon")
    .contramap(_.map(v => new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray)))
  implicit val bijection: Bijection[TypoPolygon, List[TypoPoint]] = Bijection[TypoPolygon, List[TypoPoint]](_.points)(TypoPolygon.apply)
  implicit val decoder: Decoder[TypoPolygon] = Decoder[List[TypoPoint]].map(TypoPolygon.apply)
  implicit val encoder: Encoder[TypoPolygon] = Encoder[List[TypoPoint]].contramap(_.points)
  implicit val get: Get[TypoPolygon] = Get.Advanced.other[PGpolygon](NonEmptyList.one("polygon"))
    .map(v => TypoPolygon(v.points.map(p => TypoPoint(p.x, p.y)).toList))
  implicit def ordering(implicit O0: Ordering[List[TypoPoint]]): Ordering[TypoPolygon] = Ordering.by(_.points)
  implicit val put: Put[TypoPolygon] = Put.Advanced.other[PGpolygon](NonEmptyList.one("polygon")).contramap(v => new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray))
}
