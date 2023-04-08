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
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PersonphoneRow(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.PersonRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"personphone","column_name":"businessentityid","ordinal_position":1,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: BusinessentityId,
  /** Telephone number identification number.
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"personphone","column_name":"phonenumber","ordinal_position":2,"is_nullable":"NO","data_type":"character varying","character_maximum_length":25,"character_octet_length":100,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Phone","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  phonenumber: Phone,
  /** Kind of phone number. Foreign key to PhoneNumberType.PhoneNumberTypeID.
      Points to [[phonenumbertype.PhonenumbertypeRow.phonenumbertypeid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"personphone","column_name":"phonenumbertypeid","ordinal_position":3,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  phonenumbertypeid: PhonenumbertypeId,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"person","table_name":"personphone","column_name":"modifieddate","ordinal_position":4,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
){
   val compositeId: PersonphoneId = PersonphoneId(businessentityid, phonenumber, phonenumbertypeid)
 }

object PersonphoneRow {
  def rowParser(prefix: String): RowParser[PersonphoneRow] = { row =>
    Success(
      PersonphoneRow(
        businessentityid = row[BusinessentityId](prefix + "businessentityid"),
        phonenumber = row[Phone](prefix + "phonenumber"),
        phonenumbertypeid = row[PhonenumbertypeId](prefix + "phonenumbertypeid"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[PersonphoneRow] = new OFormat[PersonphoneRow]{
    override def writes(o: PersonphoneRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "phonenumber" -> o.phonenumber,
        "phonenumbertypeid" -> o.phonenumbertypeid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PersonphoneRow] = {
      JsResult.fromTry(
        Try(
          PersonphoneRow(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            phonenumber = json.\("phonenumber").as[Phone],
            phonenumbertypeid = json.\("phonenumbertypeid").as[PhonenumbertypeId],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
