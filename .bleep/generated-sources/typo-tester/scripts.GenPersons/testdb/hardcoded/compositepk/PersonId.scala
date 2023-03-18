package testdb
package hardcoded
package compositepk

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PersonId(one: Long, two: Option[String])
object PersonId {
  implicit val ordering: Ordering[PersonId] = Ordering.by(x => (x.one, x.two))
  implicit val oFormat: OFormat[PersonId] = new OFormat[PersonId]{
    override def writes(o: PersonId): JsObject =
      Json.obj(
        "one" -> o.one,
      "two" -> o.two
      )

    override def reads(json: JsValue): JsResult[PersonId] = {
      JsResult.fromTry(
        Try(
          PersonId(
            one = json.\("one").as[Long],
            two = json.\("two").toOption.map(_.as[String])
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PersonId] = { row =>
    Success(
      PersonId(
        one = row[Long]("one"),
        two = row[Option[String]]("two")
      )
    )
  }

}