package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgCastId(value: Long) extends AnyVal
object PgCastId {
  implicit val ordering: Ordering[PgCastId] = Ordering.by(_.value)
  implicit val format: Format[PgCastId] = implicitly[Format[Long]].bimap(PgCastId.apply, _.value)
  implicit val toStatement: ToStatement[PgCastId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgCastId] = implicitly[Column[Long]].map(PgCastId.apply)
  implicit val rowParser: RowParser[PgCastId] = SqlParser.get[PgCastId]("oid")
}
