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

case class PgRewriteId(value: Long) extends AnyVal
object PgRewriteId {
  implicit val ordering: Ordering[PgRewriteId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgRewriteId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgRewriteId] = implicitly[Column[Long]].map(PgRewriteId.apply)
  implicit val rowParser: RowParser[PgRewriteId] = SqlParser.get[PgRewriteId]("oid")
}
