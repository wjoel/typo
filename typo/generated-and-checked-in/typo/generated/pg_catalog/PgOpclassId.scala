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

case class PgOpclassId(value: Long) extends AnyVal
object PgOpclassId {
  implicit val ordering: Ordering[PgOpclassId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgOpclassId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgOpclassId] = implicitly[Column[Long]].map(PgOpclassId.apply)
  implicit val rowParser: RowParser[PgOpclassId] = SqlParser.get[PgOpclassId]("oid")
}