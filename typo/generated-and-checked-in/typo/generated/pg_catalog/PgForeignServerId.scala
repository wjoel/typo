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

case class PgForeignServerId(value: Long) extends AnyVal
object PgForeignServerId {
  implicit val ordering: Ordering[PgForeignServerId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgForeignServerId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgForeignServerId] = implicitly[Column[Long]].map(PgForeignServerId.apply)
  implicit val rowParser: RowParser[PgForeignServerId] = SqlParser.get[PgForeignServerId]("oid")
}
