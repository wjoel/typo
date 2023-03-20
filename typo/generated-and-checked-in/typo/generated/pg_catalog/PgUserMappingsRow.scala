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

case class PgUserMappingsRow(
  /** Points to [[PgUserMappingRow.oid]] */
  umid: Long,
  /** Points to [[PgForeignServerRow.oid]] */
  srvid: Long,
  /** Points to [[PgForeignServerRow.srvname]] */
  srvname: String,
  /** Points to [[PgUserMappingRow.umuser]] */
  umuser: Long,
  usename: /* unknown nullability */ Option[String],
  umoptions: /* unknown nullability */ Option[Array[String]]
)

object PgUserMappingsRow {
  implicit val rowParser: RowParser[PgUserMappingsRow] = { row =>
    Success(
      PgUserMappingsRow(
        umid = row[Long]("umid"),
        srvid = row[Long]("srvid"),
        srvname = row[String]("srvname"),
        umuser = row[Long]("umuser"),
        usename = row[/* unknown nullability */ Option[String]]("usename"),
        umoptions = row[/* unknown nullability */ Option[Array[String]]]("umoptions")
      )
    )
  }

  
}
