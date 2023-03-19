package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgDatabaseId(value: Long) extends AnyVal
object PgDatabaseId {
  implicit val ordering: Ordering[PgDatabaseId] = Ordering.by(_.value)
  implicit val format: Format[PgDatabaseId] = implicitly[Format[Long]].bimap(PgDatabaseId.apply, _.value)
  implicit val toStatement: ToStatement[PgDatabaseId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgDatabaseId] = implicitly[Column[Long]].map(PgDatabaseId.apply)
  implicit val rowParser: RowParser[PgDatabaseId] = SqlParser.get[PgDatabaseId]("oid")
}