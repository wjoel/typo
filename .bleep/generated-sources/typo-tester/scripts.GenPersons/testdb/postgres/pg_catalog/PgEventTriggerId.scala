package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgEventTriggerId(value: Long) extends AnyVal
object PgEventTriggerId {
  implicit val ordering: Ordering[PgEventTriggerId] = Ordering.by(_.value)
  implicit val format: Format[PgEventTriggerId] = implicitly[Format[Long]].bimap(PgEventTriggerId.apply, _.value)
  implicit val toStatement: ToStatement[PgEventTriggerId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgEventTriggerId] = implicitly[Column[Long]].map(PgEventTriggerId.apply)
  implicit val rowParser: RowParser[PgEventTriggerId] = SqlParser.get[PgEventTriggerId]("oid")
}