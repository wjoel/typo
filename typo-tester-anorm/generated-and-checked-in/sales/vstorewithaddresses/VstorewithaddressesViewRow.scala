/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class VstorewithaddressesViewRow(
  /** Points to [[person.businessentityaddress.BusinessentityaddressRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.stateprovince.StateprovinceRow.name]] */
  name: Option[Name],
  addresstype: Option[Name],
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.city]] */
  city: Option[/* max 30 chars */ String],
  stateprovincename: Option[Name],
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: Option[/* max 15 chars */ String],
  countryregionname: Option[Name]
)

object VstorewithaddressesViewRow {
  implicit lazy val reads: Reads[VstorewithaddressesViewRow] = Reads[VstorewithaddressesViewRow](json => JsResult.fromTry(
      Try(
        VstorewithaddressesViewRow(
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          addresstype = json.\("addresstype").toOption.map(_.as(Name.reads)),
          addressline1 = json.\("addressline1").toOption.map(_.as(Reads.StringReads)),
          addressline2 = json.\("addressline2").toOption.map(_.as(Reads.StringReads)),
          city = json.\("city").toOption.map(_.as(Reads.StringReads)),
          stateprovincename = json.\("stateprovincename").toOption.map(_.as(Name.reads)),
          postalcode = json.\("postalcode").toOption.map(_.as(Reads.StringReads)),
          countryregionname = json.\("countryregionname").toOption.map(_.as(Name.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VstorewithaddressesViewRow] = RowParser[VstorewithaddressesViewRow] { row =>
    Success(
      VstorewithaddressesViewRow(
        businessentityid = row(idx + 0)(Column.columnToOption(BusinessentityId.column)),
        name = row(idx + 1)(Column.columnToOption(Name.column)),
        addresstype = row(idx + 2)(Column.columnToOption(Name.column)),
        addressline1 = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        addressline2 = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        city = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        stateprovincename = row(idx + 6)(Column.columnToOption(Name.column)),
        postalcode = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        countryregionname = row(idx + 8)(Column.columnToOption(Name.column))
      )
    )
  }
  implicit lazy val writes: OWrites[VstorewithaddressesViewRow] = OWrites[VstorewithaddressesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "addresstype" -> Writes.OptionWrites(Name.writes).writes(o.addresstype),
      "addressline1" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline1),
      "addressline2" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline2),
      "city" -> Writes.OptionWrites(Writes.StringWrites).writes(o.city),
      "stateprovincename" -> Writes.OptionWrites(Name.writes).writes(o.stateprovincename),
      "postalcode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.postalcode),
      "countryregionname" -> Writes.OptionWrites(Name.writes).writes(o.countryregionname)
    ))
  )
}
