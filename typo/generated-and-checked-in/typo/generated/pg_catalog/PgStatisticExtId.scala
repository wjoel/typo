/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement

case class PgStatisticExtId(value: Long) extends AnyVal
object PgStatisticExtId {
  implicit val ordering: Ordering[PgStatisticExtId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgStatisticExtId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgStatisticExtId] = implicitly[Column[Long]].map(PgStatisticExtId.apply)
  implicit val rowParser: RowParser[PgStatisticExtId] = SqlParser.get[PgStatisticExtId]("oid")
}