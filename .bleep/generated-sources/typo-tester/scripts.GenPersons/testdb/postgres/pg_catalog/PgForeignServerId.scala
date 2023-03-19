package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgForeignServerId(value: Long) extends AnyVal
object PgForeignServerId {
  implicit val ordering: Ordering[PgForeignServerId] = Ordering.by(_.value)
  implicit val format: Format[PgForeignServerId] = implicitly[Format[Long]].bimap(PgForeignServerId.apply, _.value)
  implicit val toStatement: ToStatement[PgForeignServerId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgForeignServerId] = implicitly[Column[Long]].map(PgForeignServerId.apply)
  implicit val rowParser: RowParser[PgForeignServerId] = SqlParser.get[PgForeignServerId]("oid")
}