package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgTransformId(value: Long) extends AnyVal
object PgTransformId {
  implicit val ordering: Ordering[PgTransformId] = Ordering.by(_.value)
  implicit val format: Format[PgTransformId] = implicitly[Format[Long]].bimap(PgTransformId.apply, _.value)
  implicit val toStatement: ToStatement[PgTransformId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgTransformId] = implicitly[Column[Long]].map(PgTransformId.apply)
  implicit val rowParser: RowParser[PgTransformId] = SqlParser.get[PgTransformId]("oid")
}
