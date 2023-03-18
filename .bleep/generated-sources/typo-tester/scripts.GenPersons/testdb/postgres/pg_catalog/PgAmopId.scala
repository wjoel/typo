package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgAmopId(value: Long) extends AnyVal
object PgAmopId {
  implicit val ordering: Ordering[PgAmopId] = Ordering.by(_.value)
  implicit val format: Format[PgAmopId] = implicitly[Format[Long]].bimap(PgAmopId.apply, _.value)
  implicit val toStatement: ToStatement[PgAmopId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgAmopId] = implicitly[Column[Long]].map(PgAmopId.apply)
  implicit val rowParser: RowParser[PgAmopId] = SqlParser.get[PgAmopId]("oid")
}
