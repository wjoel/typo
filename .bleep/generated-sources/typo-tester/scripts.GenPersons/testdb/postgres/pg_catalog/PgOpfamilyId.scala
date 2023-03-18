package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgOpfamilyId(value: Long) extends AnyVal
object PgOpfamilyId {
  implicit val ordering: Ordering[PgOpfamilyId] = Ordering.by(_.value)
  implicit val format: Format[PgOpfamilyId] = implicitly[Format[Long]].bimap(PgOpfamilyId.apply, _.value)
  implicit val toStatement: ToStatement[PgOpfamilyId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgOpfamilyId] = implicitly[Column[Long]].map(PgOpfamilyId.apply)
  implicit val rowParser: RowParser[PgOpfamilyId] = SqlParser.get[PgOpfamilyId]("oid")
}
