/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import doobie.Meta

/** Type for the primary key of table `sales.salestaxrate` */
case class SalestaxrateId(value: Int) extends AnyVal
object SalestaxrateId {
  implicit val ordering: Ordering[SalestaxrateId] = Ordering.by(_.value)
  
  implicit val metaArray: Meta[Array[SalestaxrateId]] = Meta[Array[Int]].imap(_.map(SalestaxrateId.apply))(_.map(_.value))
  implicit val meta: Meta[SalestaxrateId] = Meta[Int].imap(SalestaxrateId.apply)(_.value)
}
