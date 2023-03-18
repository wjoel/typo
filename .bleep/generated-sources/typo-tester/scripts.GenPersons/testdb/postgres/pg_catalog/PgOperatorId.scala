package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgOperatorId(value: Long) extends AnyVal
object PgOperatorId {
  implicit val ordering: Ordering[PgOperatorId] = Ordering.by(_.value)
  implicit val format: Format[PgOperatorId] = implicitly[Format[Long]].bimap(PgOperatorId.apply, _.value)
  implicit val toStatement: ToStatement[PgOperatorId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgOperatorId] = implicitly[Column[Long]].map(PgOperatorId.apply)
  implicit val rowParser: RowParser[PgOperatorId] = SqlParser.get[PgOperatorId]("oid")
}
