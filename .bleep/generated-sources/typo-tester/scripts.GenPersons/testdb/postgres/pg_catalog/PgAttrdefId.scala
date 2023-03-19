package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgAttrdefId(value: Long) extends AnyVal
object PgAttrdefId {
  implicit val ordering: Ordering[PgAttrdefId] = Ordering.by(_.value)
  implicit val format: Format[PgAttrdefId] = implicitly[Format[Long]].bimap(PgAttrdefId.apply, _.value)
  implicit val toStatement: ToStatement[PgAttrdefId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgAttrdefId] = implicitly[Column[Long]].map(PgAttrdefId.apply)
  implicit val rowParser: RowParser[PgAttrdefId] = SqlParser.get[PgAttrdefId]("oid")
}