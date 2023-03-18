package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgClassId(value: Long) extends AnyVal
object PgClassId {
  implicit val ordering: Ordering[PgClassId] = Ordering.by(_.value)
  implicit val format: Format[PgClassId] = implicitly[Format[Long]].bimap(PgClassId.apply, _.value)
  implicit val toStatement: ToStatement[PgClassId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgClassId] = implicitly[Column[Long]].map(PgClassId.apply)
  implicit val rowParser: RowParser[PgClassId] = SqlParser.get[PgClassId]("oid")
}
