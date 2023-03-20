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

case class PgIndexId(value: Long) extends AnyVal
object PgIndexId {
  implicit val ordering: Ordering[PgIndexId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgIndexId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgIndexId] = implicitly[Column[Long]].map(PgIndexId.apply)
  implicit val rowParser: RowParser[PgIndexId] = SqlParser.get[PgIndexId]("indexrelid")
}