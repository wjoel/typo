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

import anorm.RowParser
import anorm.Success

case class PgLargeobjectId(loid: Long, pageno: Int)
object PgLargeobjectId {
  implicit val ordering: Ordering[PgLargeobjectId] = Ordering.by(x => (x.loid, x.pageno))
  
  implicit val rowParser: RowParser[PgLargeobjectId] = { row =>
    Success(
      PgLargeobjectId(
        loid = row[Long]("loid"),
        pageno = row[Int]("pageno")
      )
    )
  }

}