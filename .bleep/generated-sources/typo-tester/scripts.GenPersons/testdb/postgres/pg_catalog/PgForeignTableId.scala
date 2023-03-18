package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgForeignTableId(value: Long) extends AnyVal
object PgForeignTableId {
  implicit val ordering: Ordering[PgForeignTableId] = Ordering.by(_.value)
  implicit val format: Format[PgForeignTableId] = implicitly[Format[Long]].bimap(PgForeignTableId.apply, _.value)
  implicit val toStatement: ToStatement[PgForeignTableId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgForeignTableId] = implicitly[Column[Long]].map(PgForeignTableId.apply)
  implicit val rowParser: RowParser[PgForeignTableId] = SqlParser.get[PgForeignTableId]("ftrelid")
}
