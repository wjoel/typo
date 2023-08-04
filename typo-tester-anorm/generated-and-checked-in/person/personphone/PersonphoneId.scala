/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `person.personphone` */
case class PersonphoneId(businessentityid: BusinessentityId, phonenumber: Phone, phonenumbertypeid: PhonenumbertypeId)
object PersonphoneId {
  implicit lazy val ordering: Ordering[PersonphoneId] = Ordering.by(x => (x.businessentityid, x.phonenumber, x.phonenumbertypeid))
  implicit lazy val reads: Reads[PersonphoneId] = Reads[PersonphoneId](json => JsResult.fromTry(
      Try(
        PersonphoneId(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          phonenumber = json.\("phonenumber").as(Phone.reads),
          phonenumbertypeid = json.\("phonenumbertypeid").as(PhonenumbertypeId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[PersonphoneId] = OWrites[PersonphoneId](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "phonenumber" -> Phone.writes.writes(o.phonenumber),
      "phonenumbertypeid" -> PhonenumbertypeId.writes.writes(o.phonenumbertypeid)
    ))
  )
}
