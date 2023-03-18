package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgAmId(value: Long) extends AnyVal
object PgAmId {
  implicit val ordering: Ordering[PgAmId] = Ordering.by(_.value)
  implicit val format: Format[PgAmId] = implicitly[Format[Long]].bimap(PgAmId.apply, _.value)
  implicit val toStatement: ToStatement[PgAmId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgAmId] = implicitly[Column[Long]].map(PgAmId.apply)
  implicit val rowParser: RowParser[PgAmId] = SqlParser.get[PgAmId]("oid")
}
