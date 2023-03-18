package testdb
package hardcoded
package myschema

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PersonId(value: Long) extends AnyVal
object PersonId {
  implicit val ordering: Ordering[PersonId] = Ordering.by(_.value)
  implicit val format: Format[PersonId] = implicitly[Format[Long]].bimap(PersonId.apply, _.value)
  implicit val toStatement: ToStatement[PersonId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PersonId] = implicitly[Column[Long]].map(PersonId.apply)
  implicit val rowParser: RowParser[PersonId] = SqlParser.get[PersonId]("id")
}