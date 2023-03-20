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

case class PgAuthMembersId(roleid: Long, member: Long)
object PgAuthMembersId {
  implicit val ordering: Ordering[PgAuthMembersId] = Ordering.by(x => (x.roleid, x.member))
  
  implicit val rowParser: RowParser[PgAuthMembersId] = { row =>
    Success(
      PgAuthMembersId(
        roleid = row[Long]("roleid"),
        member = row[Long]("member")
      )
    )
  }

}