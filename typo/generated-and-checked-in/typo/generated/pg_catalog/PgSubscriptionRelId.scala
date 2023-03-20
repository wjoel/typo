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

case class PgSubscriptionRelId(srrelid: Long, srsubid: Long)
object PgSubscriptionRelId {
  implicit val ordering: Ordering[PgSubscriptionRelId] = Ordering.by(x => (x.srrelid, x.srsubid))
  
  implicit val rowParser: RowParser[PgSubscriptionRelId] = { row =>
    Success(
      PgSubscriptionRelId(
        srrelid = row[Long]("srrelid"),
        srsubid = row[Long]("srsubid")
      )
    )
  }

}