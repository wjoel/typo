package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgCollationId(value: Long) extends AnyVal
object PgCollationId {
  implicit val ordering: Ordering[PgCollationId] = Ordering.by(_.value)
  implicit val format: Format[PgCollationId] = implicitly[Format[Long]].bimap(PgCollationId.apply, _.value)
  implicit val toStatement: ToStatement[PgCollationId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgCollationId] = implicitly[Column[Long]].map(PgCollationId.apply)
  implicit val rowParser: RowParser[PgCollationId] = SqlParser.get[PgCollationId]("oid")
}
