package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgOpclassId(value: Long) extends AnyVal
object PgOpclassId {
  implicit val ordering: Ordering[PgOpclassId] = Ordering.by(_.value)
  implicit val format: Format[PgOpclassId] = implicitly[Format[Long]].bimap(PgOpclassId.apply, _.value)
  implicit val toStatement: ToStatement[PgOpclassId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgOpclassId] = implicitly[Column[Long]].map(PgOpclassId.apply)
  implicit val rowParser: RowParser[PgOpclassId] = SqlParser.get[PgOpclassId]("oid")
}
