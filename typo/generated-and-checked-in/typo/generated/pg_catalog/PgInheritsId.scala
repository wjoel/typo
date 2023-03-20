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

import anorm.RowParser
import anorm.Success

case class PgInheritsId(inhrelid: Long, inhseqno: Int)
object PgInheritsId {
  implicit val ordering: Ordering[PgInheritsId] = Ordering.by(x => (x.inhrelid, x.inhseqno))
  
  implicit val rowParser: RowParser[PgInheritsId] = { row =>
    Success(
      PgInheritsId(
        inhrelid = row[Long]("inhrelid"),
        inhseqno = row[Int]("inhseqno")
      )
    )
  }

}
