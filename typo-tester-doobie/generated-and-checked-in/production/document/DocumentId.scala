/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import doobie.Meta

/** Type for the primary key of table `production.document` */
case class DocumentId(value: String) extends AnyVal
object DocumentId {
  implicit val ordering: Ordering[DocumentId] = Ordering.by(_.value)
  
  implicit val metaArray: Meta[Array[DocumentId]] = Meta[Array[String]].imap(_.map(DocumentId.apply))(_.map(_.value))
  implicit val meta: Meta[DocumentId] = Meta[String].imap(DocumentId.apply)(_.value)
}
