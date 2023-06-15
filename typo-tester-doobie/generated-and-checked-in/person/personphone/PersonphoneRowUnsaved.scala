/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

/** This class corresponds to a row in table `person.personphone` which has not been persisted yet */
case class PersonphoneRowUnsaved(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Telephone number identification number. */
  phonenumber: Phone,
  /** Kind of phone number. Foreign key to PhoneNumberType.PhoneNumberTypeID.
      Points to [[phonenumbertype.PhonenumbertypeRow.phonenumbertypeid]] */
  phonenumbertypeid: PhonenumbertypeId,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): PersonphoneRow =
    PersonphoneRow(
      businessentityid = businessentityid,
      phonenumber = phonenumber,
      phonenumbertypeid = phonenumbertypeid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PersonphoneRowUnsaved {
  implicit val decoder: Decoder[PersonphoneRowUnsaved] =
    (c: HCursor) =>
      for {
        businessentityid <- c.downField("businessentityid").as[BusinessentityId]
        phonenumber <- c.downField("phonenumber").as[Phone]
        phonenumbertypeid <- c.downField("phonenumbertypeid").as[PhonenumbertypeId]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield PersonphoneRowUnsaved(businessentityid, phonenumber, phonenumbertypeid, modifieddate)
  implicit val encoder: Encoder[PersonphoneRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "businessentityid" := row.businessentityid,
        "phonenumber" := row.phonenumber,
        "phonenumbertypeid" := row.phonenumbertypeid,
        "modifieddate" := row.modifieddate
      )}
}