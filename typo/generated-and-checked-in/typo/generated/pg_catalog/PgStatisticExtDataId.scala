/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement

case class PgStatisticExtDataId(value: Long) extends AnyVal
object PgStatisticExtDataId {
  implicit val ordering: Ordering[PgStatisticExtDataId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgStatisticExtDataId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgStatisticExtDataId] = implicitly[Column[Long]].map(PgStatisticExtDataId.apply)
  implicit val rowParser: RowParser[PgStatisticExtDataId] = SqlParser.get[PgStatisticExtDataId]("stxoid")
}
