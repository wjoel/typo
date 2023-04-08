/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VsalespersonRow(
  /** Points to [[person.person.PersonRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"businessentityid","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.title]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"title","ordinal_position":2,"is_nullable":"YES","data_type":"character varying","character_maximum_length":8,"character_octet_length":32,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  title: Option[String],
  /** Points to [[person.person.PersonRow.firstname]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"firstname","ordinal_position":3,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"middlename","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"lastname","ordinal_position":5,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"suffix","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_maximum_length":10,"character_octet_length":40,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  suffix: Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"jobtitle","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  jobtitle: Option[String],
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"phonenumber","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_maximum_length":25,"character_octet_length":100,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Phone","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  phonenumber: Option[Phone],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"phonenumbertype","ordinal_position":9,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  phonenumbertype: Option[Name],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"emailaddress","ordinal_position":10,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  emailaddress: Option[String],
  /** Points to [[person.person.PersonRow.emailpromotion]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"emailpromotion","ordinal_position":11,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  emailpromotion: Option[Int],
  /** Points to [[person.address.AddressRow.addressline1]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"addressline1","ordinal_position":12,"is_nullable":"YES","data_type":"character varying","character_maximum_length":60,"character_octet_length":240,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  addressline1: Option[String],
  /** Points to [[person.address.AddressRow.addressline2]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"addressline2","ordinal_position":13,"is_nullable":"YES","data_type":"character varying","character_maximum_length":60,"character_octet_length":240,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  addressline2: Option[String],
  /** Points to [[person.address.AddressRow.city]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"city","ordinal_position":14,"is_nullable":"YES","data_type":"character varying","character_maximum_length":30,"character_octet_length":120,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  city: Option[String],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"stateprovincename","ordinal_position":15,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  stateprovincename: Option[Name],
  /** Points to [[person.address.AddressRow.postalcode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"postalcode","ordinal_position":16,"is_nullable":"YES","data_type":"character varying","character_maximum_length":15,"character_octet_length":60,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  postalcode: Option[String],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"countryregionname","ordinal_position":17,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  countryregionname: Option[Name],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"territoryname","ordinal_position":18,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  territoryname: Option[Name],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"territorygroup","ordinal_position":19,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  territorygroup: Option[String],
  /** Points to [[salesperson.SalespersonRow.salesquota]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"salesquota","ordinal_position":20,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  salesquota: Option[BigDecimal],
  /** Points to [[salesperson.SalespersonRow.salesytd]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"salesytd","ordinal_position":21,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  salesytd: Option[BigDecimal],
  /** Points to [[salesperson.SalespersonRow.saleslastyear]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vsalesperson","column_name":"saleslastyear","ordinal_position":22,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  saleslastyear: Option[BigDecimal]
)

object VsalespersonRow {
  def rowParser(prefix: String): RowParser[VsalespersonRow] = { row =>
    Success(
      VsalespersonRow(
        businessentityid = row[Option[BusinessentityId]](prefix + "businessentityid"),
        title = row[Option[String]](prefix + "title"),
        firstname = row[Option[Name]](prefix + "firstname"),
        middlename = row[Option[Name]](prefix + "middlename"),
        lastname = row[Option[Name]](prefix + "lastname"),
        suffix = row[Option[String]](prefix + "suffix"),
        jobtitle = row[Option[String]](prefix + "jobtitle"),
        phonenumber = row[Option[Phone]](prefix + "phonenumber"),
        phonenumbertype = row[Option[Name]](prefix + "phonenumbertype"),
        emailaddress = row[Option[String]](prefix + "emailaddress"),
        emailpromotion = row[Option[Int]](prefix + "emailpromotion"),
        addressline1 = row[Option[String]](prefix + "addressline1"),
        addressline2 = row[Option[String]](prefix + "addressline2"),
        city = row[Option[String]](prefix + "city"),
        stateprovincename = row[Option[Name]](prefix + "stateprovincename"),
        postalcode = row[Option[String]](prefix + "postalcode"),
        countryregionname = row[Option[Name]](prefix + "countryregionname"),
        territoryname = row[Option[Name]](prefix + "territoryname"),
        territorygroup = row[Option[String]](prefix + "territorygroup"),
        salesquota = row[Option[BigDecimal]](prefix + "salesquota"),
        salesytd = row[Option[BigDecimal]](prefix + "salesytd"),
        saleslastyear = row[Option[BigDecimal]](prefix + "saleslastyear")
      )
    )
  }

  implicit val oFormat: OFormat[VsalespersonRow] = new OFormat[VsalespersonRow]{
    override def writes(o: VsalespersonRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "title" -> o.title,
        "firstname" -> o.firstname,
        "middlename" -> o.middlename,
        "lastname" -> o.lastname,
        "suffix" -> o.suffix,
        "jobtitle" -> o.jobtitle,
        "phonenumber" -> o.phonenumber,
        "phonenumbertype" -> o.phonenumbertype,
        "emailaddress" -> o.emailaddress,
        "emailpromotion" -> o.emailpromotion,
        "addressline1" -> o.addressline1,
        "addressline2" -> o.addressline2,
        "city" -> o.city,
        "stateprovincename" -> o.stateprovincename,
        "postalcode" -> o.postalcode,
        "countryregionname" -> o.countryregionname,
        "territoryname" -> o.territoryname,
        "territorygroup" -> o.territorygroup,
        "salesquota" -> o.salesquota,
        "salesytd" -> o.salesytd,
        "saleslastyear" -> o.saleslastyear
      )
  
    override def reads(json: JsValue): JsResult[VsalespersonRow] = {
      JsResult.fromTry(
        Try(
          VsalespersonRow(
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            title = json.\("title").toOption.map(_.as[String]),
            firstname = json.\("firstname").toOption.map(_.as[Name]),
            middlename = json.\("middlename").toOption.map(_.as[Name]),
            lastname = json.\("lastname").toOption.map(_.as[Name]),
            suffix = json.\("suffix").toOption.map(_.as[String]),
            jobtitle = json.\("jobtitle").toOption.map(_.as[String]),
            phonenumber = json.\("phonenumber").toOption.map(_.as[Phone]),
            phonenumbertype = json.\("phonenumbertype").toOption.map(_.as[Name]),
            emailaddress = json.\("emailaddress").toOption.map(_.as[String]),
            emailpromotion = json.\("emailpromotion").toOption.map(_.as[Int]),
            addressline1 = json.\("addressline1").toOption.map(_.as[String]),
            addressline2 = json.\("addressline2").toOption.map(_.as[String]),
            city = json.\("city").toOption.map(_.as[String]),
            stateprovincename = json.\("stateprovincename").toOption.map(_.as[Name]),
            postalcode = json.\("postalcode").toOption.map(_.as[String]),
            countryregionname = json.\("countryregionname").toOption.map(_.as[Name]),
            territoryname = json.\("territoryname").toOption.map(_.as[Name]),
            territorygroup = json.\("territorygroup").toOption.map(_.as[String]),
            salesquota = json.\("salesquota").toOption.map(_.as[BigDecimal]),
            salesytd = json.\("salesytd").toOption.map(_.as[BigDecimal]),
            saleslastyear = json.\("saleslastyear").toOption.map(_.as[BigDecimal])
          )
        )
      )
    }
  }
}
