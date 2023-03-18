package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgTypeId(value: Long) extends AnyVal
object PgTypeId {
  implicit val ordering: Ordering[PgTypeId] = Ordering.by(_.value)
  implicit val format: Format[PgTypeId] = implicitly[Format[Long]].bimap(PgTypeId.apply, _.value)
  implicit val toStatement: ToStatement[PgTypeId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgTypeId] = implicitly[Column[Long]].map(PgTypeId.apply)
  implicit val rowParser: RowParser[PgTypeId] = SqlParser.get[PgTypeId]("oid")
}
