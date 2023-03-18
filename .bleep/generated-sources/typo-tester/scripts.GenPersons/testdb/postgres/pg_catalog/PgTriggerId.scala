package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgTriggerId(value: Long) extends AnyVal
object PgTriggerId {
  implicit val ordering: Ordering[PgTriggerId] = Ordering.by(_.value)
  implicit val format: Format[PgTriggerId] = implicitly[Format[Long]].bimap(PgTriggerId.apply, _.value)
  implicit val toStatement: ToStatement[PgTriggerId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgTriggerId] = implicitly[Column[Long]].map(PgTriggerId.apply)
  implicit val rowParser: RowParser[PgTriggerId] = SqlParser.get[PgTriggerId]("oid")
}
