/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `person.contacttype` which has not been persisted yet */
case class ContacttypeRowUnsaved(
  /** Contact type description. */
  name: Name,
  /** Default: nextval('person.contacttype_contacttypeid_seq'::regclass)
      Primary key for ContactType records. */
  contacttypeid: Defaulted[ContacttypeId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(contacttypeidDefault: => ContacttypeId, modifieddateDefault: => TypoLocalDateTime): ContacttypeRow =
    ContacttypeRow(
      name = name,
      contacttypeid = contacttypeid match {
                        case Defaulted.UseDefault => contacttypeidDefault
                        case Defaulted.Provided(value) => value
                      },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ContacttypeRowUnsaved {
  implicit lazy val reads: Reads[ContacttypeRowUnsaved] = Reads[ContacttypeRowUnsaved](json => JsResult.fromTry(
      Try(
        ContacttypeRowUnsaved(
          name = json.\("name").as(Name.reads),
          contacttypeid = json.\("contacttypeid").as(Defaulted.reads(ContacttypeId.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ContacttypeRowUnsaved] = OWrites[ContacttypeRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Name.writes.writes(o.name),
      "contacttypeid" -> Defaulted.writes(ContacttypeId.writes).writes(o.contacttypeid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
