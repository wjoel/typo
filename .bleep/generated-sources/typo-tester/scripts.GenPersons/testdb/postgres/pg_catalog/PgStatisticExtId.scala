package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgStatisticExtId(value: Long) extends AnyVal
object PgStatisticExtId {
  implicit val ordering: Ordering[PgStatisticExtId] = Ordering.by(_.value)
  implicit val format: Format[PgStatisticExtId] = implicitly[Format[Long]].bimap(PgStatisticExtId.apply, _.value)
  implicit val toStatement: ToStatement[PgStatisticExtId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgStatisticExtId] = implicitly[Column[Long]].map(PgStatisticExtId.apply)
  implicit val rowParser: RowParser[PgStatisticExtId] = SqlParser.get[PgStatisticExtId]("oid")
}
