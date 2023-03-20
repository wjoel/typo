/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success

case class DomainConstraintsRow(
  constraintCatalog: /* unknown nullability */ Option[String],
  constraintSchema: /* unknown nullability */ Option[String],
  constraintName: /* unknown nullability */ Option[String],
  domainCatalog: /* unknown nullability */ Option[String],
  domainSchema: /* unknown nullability */ Option[String],
  domainName: /* unknown nullability */ Option[String],
  isDeferrable: /* unknown nullability */ Option[String],
  initiallyDeferred: /* unknown nullability */ Option[String]
)

object DomainConstraintsRow {
  implicit val rowParser: RowParser[DomainConstraintsRow] = { row =>
    Success(
      DomainConstraintsRow(
        constraintCatalog = row[/* unknown nullability */ Option[String]]("constraint_catalog"),
        constraintSchema = row[/* unknown nullability */ Option[String]]("constraint_schema"),
        constraintName = row[/* unknown nullability */ Option[String]]("constraint_name"),
        domainCatalog = row[/* unknown nullability */ Option[String]]("domain_catalog"),
        domainSchema = row[/* unknown nullability */ Option[String]]("domain_schema"),
        domainName = row[/* unknown nullability */ Option[String]]("domain_name"),
        isDeferrable = row[/* unknown nullability */ Option[String]]("is_deferrable"),
        initiallyDeferred = row[/* unknown nullability */ Option[String]]("initially_deferred")
      )
    )
  }

  
}
