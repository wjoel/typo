package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgRangeId(value: Long) extends AnyVal
object PgRangeId {
  implicit val ordering: Ordering[PgRangeId] = Ordering.by(_.value)
  implicit val format: Format[PgRangeId] = implicitly[Format[Long]].bimap(PgRangeId.apply, _.value)
  implicit val toStatement: ToStatement[PgRangeId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgRangeId] = implicitly[Column[Long]].map(PgRangeId.apply)
  implicit val rowParser: RowParser[PgRangeId] = SqlParser.get[PgRangeId]("rngtypid")
}
