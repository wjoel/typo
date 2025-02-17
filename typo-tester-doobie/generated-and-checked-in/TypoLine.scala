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
import org.postgresql.geometric.PGline

/** This implements a line represented by the linear equation Ax + By + C = 0 */
case class TypoLine(a: Double, b: Double, c: Double)

object TypoLine {
  implicit val arrayGet: Get[Array[TypoLine]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_line"))
    .map(_.map(v => TypoLine(v.asInstanceOf[PGline].a, v.asInstanceOf[PGline].b, v.asInstanceOf[PGline].c)))
  implicit val arrayPut: Put[Array[TypoLine]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_line"), "line")
    .contramap(_.map(v => new PGline(v.a, v.b, v.c)))
  implicit val decoder: Decoder[TypoLine] = Decoder.forProduct3[TypoLine, Double, Double, Double]("a", "b", "c")(TypoLine.apply)(Decoder.decodeDouble, Decoder.decodeDouble, Decoder.decodeDouble)
  implicit val encoder: Encoder[TypoLine] = Encoder.forProduct3[TypoLine, Double, Double, Double]("a", "b", "c")(x => (x.a, x.b, x.c))(Encoder.encodeDouble, Encoder.encodeDouble, Encoder.encodeDouble)
  implicit val get: Get[TypoLine] = Get.Advanced.other[PGline](NonEmptyList.one("line"))
    .map(v => TypoLine(v.a, v.b, v.c))
  implicit val ordering: Ordering[TypoLine] = Ordering.by(x => (x.a, x.b, x.c))
  implicit val put: Put[TypoLine] = Put.Advanced.other[PGline](NonEmptyList.one("line")).contramap(v => new PGline(v.a, v.b, v.c))
}
