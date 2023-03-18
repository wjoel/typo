package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgPublicationRelId(value: Long) extends AnyVal
object PgPublicationRelId {
  implicit val ordering: Ordering[PgPublicationRelId] = Ordering.by(_.value)
  implicit val format: Format[PgPublicationRelId] = implicitly[Format[Long]].bimap(PgPublicationRelId.apply, _.value)
  implicit val toStatement: ToStatement[PgPublicationRelId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgPublicationRelId] = implicitly[Column[Long]].map(PgPublicationRelId.apply)
  implicit val rowParser: RowParser[PgPublicationRelId] = SqlParser.get[PgPublicationRelId]("oid")
}
