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

case class PgClassId(value: Long) extends AnyVal
object PgClassId {
  implicit val ordering: Ordering[PgClassId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgClassId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgClassId] = implicitly[Column[Long]].map(PgClassId.apply)
  implicit val rowParser: RowParser[PgClassId] = SqlParser.get[PgClassId]("oid")
}
