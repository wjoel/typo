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

import java.sql.Connection

trait RoleUdtGrantsRepo {
  def selectAll(implicit c: Connection): List[RoleUdtGrantsRow]
  def selectByFieldValues(fieldValues: List[RoleUdtGrantsFieldValue[_]])(implicit c: Connection): List[RoleUdtGrantsRow]
}
