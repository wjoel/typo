/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import java.time.LocalDateTime

case class CreditcardRow(
  /** Primary key for CreditCard records. */
  creditcardid: CreditcardId,
  /** Credit card name. */
  cardtype: String,
  /** Credit card number. */
  cardnumber: String,
  /** Credit card expiration month. */
  expmonth: Int,
  /** Credit card expiration year. */
  expyear: Int,
  modifieddate: LocalDateTime
)


