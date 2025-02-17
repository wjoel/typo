/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class VemployeeViewStructure[Row](val prefix: Option[String], val extract: Row => VemployeeViewRow, val merge: (Row, VemployeeViewRow) => Row)
  extends Relation[VemployeeViewFields, VemployeeViewRow, Row]
    with VemployeeViewFields[Row] { outer =>

  override val businessentityid = new OptField[BusinessentityId, Row](prefix, "businessentityid", None, Some("int4"))(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val title = new OptField[/* max 8 chars */ String, Row](prefix, "title", None, None)(x => extract(x).title, (row, value) => merge(row, extract(row).copy(title = value)))
  override val firstname = new OptField[Name, Row](prefix, "firstname", None, Some(""""public"."Name""""))(x => extract(x).firstname, (row, value) => merge(row, extract(row).copy(firstname = value)))
  override val middlename = new OptField[Name, Row](prefix, "middlename", None, Some(""""public"."Name""""))(x => extract(x).middlename, (row, value) => merge(row, extract(row).copy(middlename = value)))
  override val lastname = new OptField[Name, Row](prefix, "lastname", None, Some(""""public"."Name""""))(x => extract(x).lastname, (row, value) => merge(row, extract(row).copy(lastname = value)))
  override val suffix = new OptField[/* max 10 chars */ String, Row](prefix, "suffix", None, None)(x => extract(x).suffix, (row, value) => merge(row, extract(row).copy(suffix = value)))
  override val jobtitle = new OptField[/* max 50 chars */ String, Row](prefix, "jobtitle", None, None)(x => extract(x).jobtitle, (row, value) => merge(row, extract(row).copy(jobtitle = value)))
  override val phonenumber = new OptField[Phone, Row](prefix, "phonenumber", None, Some(""""public".Phone"""))(x => extract(x).phonenumber, (row, value) => merge(row, extract(row).copy(phonenumber = value)))
  override val phonenumbertype = new OptField[Name, Row](prefix, "phonenumbertype", None, Some(""""public"."Name""""))(x => extract(x).phonenumbertype, (row, value) => merge(row, extract(row).copy(phonenumbertype = value)))
  override val emailaddress = new OptField[/* max 50 chars */ String, Row](prefix, "emailaddress", None, None)(x => extract(x).emailaddress, (row, value) => merge(row, extract(row).copy(emailaddress = value)))
  override val emailpromotion = new OptField[Int, Row](prefix, "emailpromotion", None, Some("int4"))(x => extract(x).emailpromotion, (row, value) => merge(row, extract(row).copy(emailpromotion = value)))
  override val addressline1 = new OptField[/* max 60 chars */ String, Row](prefix, "addressline1", None, None)(x => extract(x).addressline1, (row, value) => merge(row, extract(row).copy(addressline1 = value)))
  override val addressline2 = new OptField[/* max 60 chars */ String, Row](prefix, "addressline2", None, None)(x => extract(x).addressline2, (row, value) => merge(row, extract(row).copy(addressline2 = value)))
  override val city = new OptField[/* max 30 chars */ String, Row](prefix, "city", None, None)(x => extract(x).city, (row, value) => merge(row, extract(row).copy(city = value)))
  override val stateprovincename = new OptField[Name, Row](prefix, "stateprovincename", None, Some(""""public"."Name""""))(x => extract(x).stateprovincename, (row, value) => merge(row, extract(row).copy(stateprovincename = value)))
  override val postalcode = new OptField[/* max 15 chars */ String, Row](prefix, "postalcode", None, None)(x => extract(x).postalcode, (row, value) => merge(row, extract(row).copy(postalcode = value)))
  override val countryregionname = new OptField[Name, Row](prefix, "countryregionname", None, Some(""""public"."Name""""))(x => extract(x).countryregionname, (row, value) => merge(row, extract(row).copy(countryregionname = value)))
  override val additionalcontactinfo = new OptField[TypoXml, Row](prefix, "additionalcontactinfo", None, Some("xml"))(x => extract(x).additionalcontactinfo, (row, value) => merge(row, extract(row).copy(additionalcontactinfo = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](businessentityid, title, firstname, middlename, lastname, suffix, jobtitle, phonenumber, phonenumbertype, emailaddress, emailpromotion, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname, additionalcontactinfo)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => VemployeeViewRow, merge: (NewRow, VemployeeViewRow) => NewRow): VemployeeViewStructure[NewRow] =
    new VemployeeViewStructure(prefix, extract, merge)
}
