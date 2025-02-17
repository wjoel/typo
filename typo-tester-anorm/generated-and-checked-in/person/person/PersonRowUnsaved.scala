/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `person.person` which has not been persisted yet */
case class PersonRowUnsaved(
  /** Primary key for Person records.
      Points to [[businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary type of person: SC = Store Contact, IN = Individual (retail) customer, SP = Sales person, EM = Employee (non-sales), VC = Vendor contact, GC = General contact */
  persontype: /* bpchar */ String,
  /** A courtesy title. For example, Mr. or Ms. */
  title: Option[/* max 8 chars */ String],
  /** First name of the person. */
  firstname: Name,
  /** Middle name or middle initial of the person. */
  middlename: Option[Name],
  /** Last name of the person. */
  lastname: Name,
  /** Surname suffix. For example, Sr. or Jr. */
  suffix: Option[/* max 10 chars */ String],
  /** Additional contact information about the person stored in xml format. */
  additionalcontactinfo: Option[TypoXml],
  /** Personal information such as hobbies, and income collected from online shoppers. Used for sales analysis. */
  demographics: Option[TypoXml],
  /** Default: false
      0 = The data in FirstName and LastName are stored in western style (first name, last name) order.  1 = Eastern style (last name, first name) order. */
  namestyle: Defaulted[NameStyle] = Defaulted.UseDefault,
  /** Default: 0
      0 = Contact does not wish to receive e-mail promotions, 1 = Contact does wish to receive e-mail promotions from AdventureWorks, 2 = Contact does wish to receive e-mail promotions from AdventureWorks and selected partners. */
  emailpromotion: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(namestyleDefault: => NameStyle, emailpromotionDefault: => Int, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): PersonRow =
    PersonRow(
      businessentityid = businessentityid,
      persontype = persontype,
      title = title,
      firstname = firstname,
      middlename = middlename,
      lastname = lastname,
      suffix = suffix,
      additionalcontactinfo = additionalcontactinfo,
      demographics = demographics,
      namestyle = namestyle match {
                    case Defaulted.UseDefault => namestyleDefault
                    case Defaulted.Provided(value) => value
                  },
      emailpromotion = emailpromotion match {
                         case Defaulted.UseDefault => emailpromotionDefault
                         case Defaulted.Provided(value) => value
                       },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PersonRowUnsaved {
  implicit lazy val reads: Reads[PersonRowUnsaved] = Reads[PersonRowUnsaved](json => JsResult.fromTry(
      Try(
        PersonRowUnsaved(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          persontype = json.\("persontype").as(Reads.StringReads),
          title = json.\("title").toOption.map(_.as(Reads.StringReads)),
          firstname = json.\("firstname").as(Name.reads),
          middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
          lastname = json.\("lastname").as(Name.reads),
          suffix = json.\("suffix").toOption.map(_.as(Reads.StringReads)),
          additionalcontactinfo = json.\("additionalcontactinfo").toOption.map(_.as(TypoXml.reads)),
          demographics = json.\("demographics").toOption.map(_.as(TypoXml.reads)),
          namestyle = json.\("namestyle").as(Defaulted.reads(NameStyle.reads)),
          emailpromotion = json.\("emailpromotion").as(Defaulted.reads(Reads.IntReads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[PersonRowUnsaved] = OWrites[PersonRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "persontype" -> Writes.StringWrites.writes(o.persontype),
      "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
      "firstname" -> Name.writes.writes(o.firstname),
      "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
      "lastname" -> Name.writes.writes(o.lastname),
      "suffix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.suffix),
      "additionalcontactinfo" -> Writes.OptionWrites(TypoXml.writes).writes(o.additionalcontactinfo),
      "demographics" -> Writes.OptionWrites(TypoXml.writes).writes(o.demographics),
      "namestyle" -> Defaulted.writes(NameStyle.writes).writes(o.namestyle),
      "emailpromotion" -> Defaulted.writes(Writes.IntWrites).writes(o.emailpromotion),
      "rowguid" -> Defaulted.writes(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
