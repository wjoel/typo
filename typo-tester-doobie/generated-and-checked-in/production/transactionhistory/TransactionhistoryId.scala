/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import doobie.Meta

/** Type for the primary key of table `production.transactionhistory` */
case class TransactionhistoryId(value: Int) extends AnyVal
object TransactionhistoryId {
  implicit val ordering: Ordering[TransactionhistoryId] = Ordering.by(_.value)
  
  implicit val metaArray: Meta[Array[TransactionhistoryId]] = Meta[Array[Int]].imap(_.map(TransactionhistoryId.apply))(_.map(_.value))
  implicit val meta: Meta[TransactionhistoryId] = Meta[Int].imap(TransactionhistoryId.apply)(_.value)
}
