package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgLanguageId(value: Long) extends AnyVal
object PgLanguageId {
  implicit val ordering: Ordering[PgLanguageId] = Ordering.by(_.value)
  implicit val format: Format[PgLanguageId] = implicitly[Format[Long]].bimap(PgLanguageId.apply, _.value)
  implicit val toStatement: ToStatement[PgLanguageId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgLanguageId] = implicitly[Column[Long]].map(PgLanguageId.apply)
  implicit val rowParser: RowParser[PgLanguageId] = SqlParser.get[PgLanguageId]("oid")
}
