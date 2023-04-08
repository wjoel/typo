/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class BillofmaterialsRow(
  /** Primary key for BillOfMaterials records.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"billofmaterialsid","ordinal_position":1,"column_default":"nextval('production.billofmaterials_billofmaterialsid_seq'::regclass)","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  billofmaterialsid: BillofmaterialsId,
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"productassemblyid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"componentid","ordinal_position":3,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  componentid: ProductId,
  /** Date the component started being used in the assembly item.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"startdate","ordinal_position":4,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  startdate: LocalDateTime,
  /** Date the component stopped being used in the assembly item.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"enddate","ordinal_position":5,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  enddate: Option[LocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"unitmeasurecode","ordinal_position":6,"is_nullable":"NO","data_type":"character","character_maximum_length":3,"character_octet_length":12,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID).
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"bomlevel","ordinal_position":7,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  bomlevel: Int,
  /** Quantity of the component needed to create the assembly.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"perassemblyqty","ordinal_position":8,"column_default":"1.00","is_nullable":"NO","data_type":"numeric","numeric_precision":8,"numeric_precision_radix":10,"numeric_scale":2,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  perassemblyqty: BigDecimal,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"modifieddate","ordinal_position":9,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
)

object BillofmaterialsRow {
  def rowParser(prefix: String): RowParser[BillofmaterialsRow] = { row =>
    Success(
      BillofmaterialsRow(
        billofmaterialsid = row[BillofmaterialsId](prefix + "billofmaterialsid"),
        productassemblyid = row[Option[ProductId]](prefix + "productassemblyid"),
        componentid = row[ProductId](prefix + "componentid"),
        startdate = row[LocalDateTime](prefix + "startdate"),
        enddate = row[Option[LocalDateTime]](prefix + "enddate"),
        unitmeasurecode = row[UnitmeasureId](prefix + "unitmeasurecode"),
        bomlevel = row[Int](prefix + "bomlevel"),
        perassemblyqty = row[BigDecimal](prefix + "perassemblyqty"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[BillofmaterialsRow] = new OFormat[BillofmaterialsRow]{
    override def writes(o: BillofmaterialsRow): JsObject =
      Json.obj(
        "billofmaterialsid" -> o.billofmaterialsid,
        "productassemblyid" -> o.productassemblyid,
        "componentid" -> o.componentid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "unitmeasurecode" -> o.unitmeasurecode,
        "bomlevel" -> o.bomlevel,
        "perassemblyqty" -> o.perassemblyqty,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[BillofmaterialsRow] = {
      JsResult.fromTry(
        Try(
          BillofmaterialsRow(
            billofmaterialsid = json.\("billofmaterialsid").as[BillofmaterialsId],
            productassemblyid = json.\("productassemblyid").toOption.map(_.as[ProductId]),
            componentid = json.\("componentid").as[ProductId],
            startdate = json.\("startdate").as[LocalDateTime],
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            unitmeasurecode = json.\("unitmeasurecode").as[UnitmeasureId],
            bomlevel = json.\("bomlevel").as[Int],
            perassemblyqty = json.\("perassemblyqty").as[BigDecimal],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
