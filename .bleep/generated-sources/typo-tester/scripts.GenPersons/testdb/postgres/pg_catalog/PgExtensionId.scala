package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgExtensionId(value: Long) extends AnyVal
object PgExtensionId {
  implicit val ordering: Ordering[PgExtensionId] = Ordering.by(_.value)
  implicit val format: Format[PgExtensionId] = implicitly[Format[Long]].bimap(PgExtensionId.apply, _.value)
  implicit val toStatement: ToStatement[PgExtensionId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgExtensionId] = implicitly[Column[Long]].map(PgExtensionId.apply)
  implicit val rowParser: RowParser[PgExtensionId] = SqlParser.get[PgExtensionId]("oid")
}
