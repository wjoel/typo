package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgDefaultAclId(value: Long) extends AnyVal
object PgDefaultAclId {
  implicit val ordering: Ordering[PgDefaultAclId] = Ordering.by(_.value)
  implicit val format: Format[PgDefaultAclId] = implicitly[Format[Long]].bimap(PgDefaultAclId.apply, _.value)
  implicit val toStatement: ToStatement[PgDefaultAclId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgDefaultAclId] = implicitly[Column[Long]].map(PgDefaultAclId.apply)
  implicit val rowParser: RowParser[PgDefaultAclId] = SqlParser.get[PgDefaultAclId]("oid")
}