/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import doobie.Meta

/** Type for the primary key of table `sales.currencyrate` */
case class CurrencyrateId(value: Int) extends AnyVal
object CurrencyrateId {
  implicit val ordering: Ordering[CurrencyrateId] = Ordering.by(_.value)
  
  implicit val metaArray: Meta[Array[CurrencyrateId]] = Meta[Array[Int]].imap(_.map(CurrencyrateId.apply))(_.map(_.value))
  implicit val meta: Meta[CurrencyrateId] = Meta[Int].imap(CurrencyrateId.apply)(_.value)
}
