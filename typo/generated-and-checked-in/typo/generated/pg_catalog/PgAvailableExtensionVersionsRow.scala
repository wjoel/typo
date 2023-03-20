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

case class PgAvailableExtensionVersionsRow(
  name: /* unknown nullability */ Option[String],
  version: /* unknown nullability */ Option[String],
  installed: /* unknown nullability */ Option[Boolean],
  superuser: /* unknown nullability */ Option[Boolean],
  trusted: /* unknown nullability */ Option[Boolean],
  relocatable: /* unknown nullability */ Option[Boolean],
  schema: /* unknown nullability */ Option[String],
  requires: /* unknown nullability */ Option[Array[String]],
  comment: /* unknown nullability */ Option[String]
)

object PgAvailableExtensionVersionsRow {
  implicit val rowParser: RowParser[PgAvailableExtensionVersionsRow] = { row =>
    Success(
      PgAvailableExtensionVersionsRow(
        name = row[/* unknown nullability */ Option[String]]("name"),
        version = row[/* unknown nullability */ Option[String]]("version"),
        installed = row[/* unknown nullability */ Option[Boolean]]("installed"),
        superuser = row[/* unknown nullability */ Option[Boolean]]("superuser"),
        trusted = row[/* unknown nullability */ Option[Boolean]]("trusted"),
        relocatable = row[/* unknown nullability */ Option[Boolean]]("relocatable"),
        schema = row[/* unknown nullability */ Option[String]]("schema"),
        requires = row[/* unknown nullability */ Option[Array[String]]]("requires"),
        comment = row[/* unknown nullability */ Option[String]]("comment")
      )
    )
  }

  
}
