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
import org.postgresql.jdbc.PgSQLXML
import org.postgresql.util.PGobject

/** XML */
case class TypoXml(value: String)

object TypoXml {
  implicit val arrayGet: Get[Array[TypoXml]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_xml"))
    .map(_.map(v => TypoXml(v.asInstanceOf[PGobject].getValue)))
  implicit val arrayPut: Put[Array[TypoXml]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_xml"), "xml")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("xml")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit val decoder: Decoder[TypoXml] = Decoder.forProduct1[TypoXml, String]("value")(TypoXml.apply)(Decoder.decodeString)
  implicit val encoder: Encoder[TypoXml] = Encoder.forProduct1[TypoXml, String]("value")(x => (x.value))(Encoder.encodeString)
  implicit val get: Get[TypoXml] = Get.Advanced.other[PgSQLXML](NonEmptyList.one("xml"))
    .map(v => TypoXml(v.getString))
  implicit val put: Put[TypoXml] = Put.Advanced.other[String](NonEmptyList.one("xml")).contramap(v => v.value)
}
