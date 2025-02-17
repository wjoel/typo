/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `sales.customer` which has not been persisted yet */
case class CustomerRowUnsaved(
  /** Foreign key to Person.BusinessEntityID
      Points to [[person.person.PersonRow.businessentityid]] */
  personid: Option[BusinessentityId],
  /** Foreign key to Store.BusinessEntityID
      Points to [[store.StoreRow.businessentityid]] */
  storeid: Option[BusinessentityId],
  /** ID of the territory in which the customer is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Default: nextval('sales.customer_customerid_seq'::regclass)
      Primary key. */
  customerid: Defaulted[CustomerId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(customeridDefault: => CustomerId, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): CustomerRow =
    CustomerRow(
      personid = personid,
      storeid = storeid,
      territoryid = territoryid,
      customerid = customerid match {
                     case Defaulted.UseDefault => customeridDefault
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
object CustomerRowUnsaved {
  implicit val decoder: Decoder[CustomerRowUnsaved] = Decoder.forProduct6[CustomerRowUnsaved, Option[BusinessentityId], Option[BusinessentityId], Option[SalesterritoryId], Defaulted[CustomerId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("personid", "storeid", "territoryid", "customerid", "rowguid", "modifieddate")(CustomerRowUnsaved.apply)(Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(SalesterritoryId.decoder), Defaulted.decoder(CustomerId.decoder), Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit val encoder: Encoder[CustomerRowUnsaved] = Encoder.forProduct6[CustomerRowUnsaved, Option[BusinessentityId], Option[BusinessentityId], Option[SalesterritoryId], Defaulted[CustomerId], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("personid", "storeid", "territoryid", "customerid", "rowguid", "modifieddate")(x => (x.personid, x.storeid, x.territoryid, x.customerid, x.rowguid, x.modifieddate))(Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(SalesterritoryId.encoder), Defaulted.encoder(CustomerId.encoder), Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
