package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgProcId(value: Long) extends AnyVal
object PgProcId {
  implicit val ordering: Ordering[PgProcId] = Ordering.by(_.value)
  implicit val format: Format[PgProcId] = implicitly[Format[Long]].bimap(PgProcId.apply, _.value)
  implicit val toStatement: ToStatement[PgProcId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgProcId] = implicitly[Column[Long]].map(PgProcId.apply)
  implicit val rowParser: RowParser[PgProcId] = SqlParser.get[PgProcId]("oid")
}
