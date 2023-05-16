/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.person.businessentity.BusinessentityId

/** Type for the composite primary key of table `person.emailaddress` */
case class EmailaddressId(businessentityid: BusinessentityId, emailaddressid: Int)
object EmailaddressId {
  implicit def ordering: Ordering[EmailaddressId] = Ordering.by(x => (x.businessentityid, x.emailaddressid))
  
}
