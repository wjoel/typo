/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `person.password` which has not been persisted yet */
case class PasswordRowUnsaved(
  /** Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Password for the e-mail account. */
  passwordhash: /* max 128 chars */ String,
  /** Random value concatenated with the password string before the password is hashed. */
  passwordsalt: /* max 10 chars */ String,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): PasswordRow =
    PasswordRow(
      businessentityid = businessentityid,
      passwordhash = passwordhash,
      passwordsalt = passwordsalt,
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
object PasswordRowUnsaved {
  implicit val decoder: Decoder[PasswordRowUnsaved] = Decoder.forProduct5[PasswordRowUnsaved, BusinessentityId, /* max 128 chars */ String, /* max 10 chars */ String, Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")(PasswordRowUnsaved.apply)(BusinessentityId.decoder, Decoder.decodeString, Decoder.decodeString, Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[PasswordRowUnsaved] = Encoder.forProduct5[PasswordRowUnsaved, BusinessentityId, /* max 128 chars */ String, /* max 10 chars */ String, Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")(x => (x.businessentityid, x.passwordhash, x.passwordsalt, x.rowguid, x.modifieddate))(BusinessentityId.encoder, Encoder.encodeString, Encoder.encodeString, Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
