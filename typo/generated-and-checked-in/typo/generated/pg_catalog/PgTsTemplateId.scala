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

case class PgTsTemplateId(value: Long) extends AnyVal
object PgTsTemplateId {
  implicit val ordering: Ordering[PgTsTemplateId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgTsTemplateId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgTsTemplateId] = implicitly[Column[Long]].map(PgTsTemplateId.apply)
  implicit val rowParser: RowParser[PgTsTemplateId] = SqlParser.get[PgTsTemplateId]("oid")
}