package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgTsConfigId(value: Long) extends AnyVal
object PgTsConfigId {
  implicit val ordering: Ordering[PgTsConfigId] = Ordering.by(_.value)
  implicit val format: Format[PgTsConfigId] = implicitly[Format[Long]].bimap(PgTsConfigId.apply, _.value)
  implicit val toStatement: ToStatement[PgTsConfigId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgTsConfigId] = implicitly[Column[Long]].map(PgTsConfigId.apply)
  implicit val rowParser: RowParser[PgTsConfigId] = SqlParser.get[PgTsConfigId]("oid")
}
