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

case class PgPublicationRelId(value: Long) extends AnyVal
object PgPublicationRelId {
  implicit val ordering: Ordering[PgPublicationRelId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgPublicationRelId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgPublicationRelId] = implicitly[Column[Long]].map(PgPublicationRelId.apply)
  implicit val rowParser: RowParser[PgPublicationRelId] = SqlParser.get[PgPublicationRelId]("oid")
}
