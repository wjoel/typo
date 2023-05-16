/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import java.util.UUID

case class PaViewRow(
  id: Option[Int],
  /** Points to [[person.password.PasswordRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.password.PasswordRow.passwordhash]] */
  passwordhash: Option[String],
  /** Points to [[person.password.PasswordRow.passwordsalt]] */
  passwordsalt: Option[String],
  /** Points to [[person.password.PasswordRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.password.PasswordRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)


