package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgConstraintId(value: Long) extends AnyVal
object PgConstraintId {
  implicit val ordering: Ordering[PgConstraintId] = Ordering.by(_.value)
  implicit val format: Format[PgConstraintId] = implicitly[Format[Long]].bimap(PgConstraintId.apply, _.value)
  implicit val toStatement: ToStatement[PgConstraintId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgConstraintId] = implicitly[Column[Long]].map(PgConstraintId.apply)
  implicit val rowParser: RowParser[PgConstraintId] = SqlParser.get[PgConstraintId]("oid")
}
