package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgStatisticExtDataId(value: Long) extends AnyVal
object PgStatisticExtDataId {
  implicit val ordering: Ordering[PgStatisticExtDataId] = Ordering.by(_.value)
  implicit val format: Format[PgStatisticExtDataId] = implicitly[Format[Long]].bimap(PgStatisticExtDataId.apply, _.value)
  implicit val toStatement: ToStatement[PgStatisticExtDataId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgStatisticExtDataId] = implicitly[Column[Long]].map(PgStatisticExtDataId.apply)
  implicit val rowParser: RowParser[PgStatisticExtDataId] = SqlParser.get[PgStatisticExtDataId]("stxoid")
}
