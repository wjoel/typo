package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgPolicyId(value: Long) extends AnyVal
object PgPolicyId {
  implicit val ordering: Ordering[PgPolicyId] = Ordering.by(_.value)
  implicit val format: Format[PgPolicyId] = implicitly[Format[Long]].bimap(PgPolicyId.apply, _.value)
  implicit val toStatement: ToStatement[PgPolicyId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgPolicyId] = implicitly[Column[Long]].map(PgPolicyId.apply)
  implicit val rowParser: RowParser[PgPolicyId] = SqlParser.get[PgPolicyId]("oid")
}
