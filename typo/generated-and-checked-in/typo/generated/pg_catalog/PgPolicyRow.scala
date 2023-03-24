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
import org.postgresql.util.PGobject

case class PgPolicyRow(
  oid: PgPolicyId,
  polname: String,
  polrelid: Long,
  polcmd: String,
  polpermissive: Boolean,
  polroles: Array[Long],
  polqual: Option[PGobject],
  polwithcheck: Option[PGobject]
)

object PgPolicyRow {
  implicit val rowParser: RowParser[PgPolicyRow] = { row =>
    Success(
      PgPolicyRow(
        oid = row[PgPolicyId]("oid"),
        polname = row[String]("polname"),
        polrelid = row[Long]("polrelid"),
        polcmd = row[String]("polcmd"),
        polpermissive = row[Boolean]("polpermissive"),
        polroles = row[Array[Long]]("polroles"),
        polqual = row[Option[PGobject]]("polqual"),
        polwithcheck = row[Option[PGobject]]("polwithcheck")
      )
    )
  }

  
}
