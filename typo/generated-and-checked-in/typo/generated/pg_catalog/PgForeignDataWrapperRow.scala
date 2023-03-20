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

case class PgForeignDataWrapperRow(
  oid: PgForeignDataWrapperId,
  fdwname: String,
  fdwowner: Long,
  fdwhandler: Long,
  fdwvalidator: Long,
  fdwacl: Option[Array[String]],
  fdwoptions: Option[Array[String]]
)

object PgForeignDataWrapperRow {
  implicit val rowParser: RowParser[PgForeignDataWrapperRow] = { row =>
    Success(
      PgForeignDataWrapperRow(
        oid = row[PgForeignDataWrapperId]("oid"),
        fdwname = row[String]("fdwname"),
        fdwowner = row[Long]("fdwowner"),
        fdwhandler = row[Long]("fdwhandler"),
        fdwvalidator = row[Long]("fdwvalidator"),
        fdwacl = row[Option[Array[String]]]("fdwacl"),
        fdwoptions = row[Option[Array[String]]]("fdwoptions")
      )
    )
  }

  
}
