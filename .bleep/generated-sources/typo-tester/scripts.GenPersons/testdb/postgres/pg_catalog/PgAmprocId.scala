package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgAmprocId(value: Long) extends AnyVal
object PgAmprocId {
  implicit val ordering: Ordering[PgAmprocId] = Ordering.by(_.value)
  implicit val format: Format[PgAmprocId] = implicitly[Format[Long]].bimap(PgAmprocId.apply, _.value)
  implicit val toStatement: ToStatement[PgAmprocId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgAmprocId] = implicitly[Column[Long]].map(PgAmprocId.apply)
  implicit val rowParser: RowParser[PgAmprocId] = SqlParser.get[PgAmprocId]("oid")
}
