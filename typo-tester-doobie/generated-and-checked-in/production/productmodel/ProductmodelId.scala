/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import doobie.Meta

/** Type for the primary key of table `production.productmodel` */
case class ProductmodelId(value: Int) extends AnyVal
object ProductmodelId {
  implicit val ordering: Ordering[ProductmodelId] = Ordering.by(_.value)
  
  implicit val metaArray: Meta[Array[ProductmodelId]] = Meta[Array[Int]].imap(_.map(ProductmodelId.apply))(_.map(_.value))
  implicit val meta: Meta[ProductmodelId] = Meta[Int].imap(ProductmodelId.apply)(_.value)
}
