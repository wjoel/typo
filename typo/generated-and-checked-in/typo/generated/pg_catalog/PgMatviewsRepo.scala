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

import java.sql.Connection

trait PgMatviewsRepo {
  def selectAll(implicit c: Connection): List[PgMatviewsRow]
  def selectByFieldValues(fieldValues: List[PgMatviewsFieldValue[_]])(implicit c: Connection): List[PgMatviewsRow]
}
