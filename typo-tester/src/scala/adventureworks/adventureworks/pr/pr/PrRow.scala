/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pr

import adventureworks.production.product.ProductId
import adventureworks.production.productreview.ProductreviewId
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PrRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[production.productreview.ProductreviewRow.productreviewid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"productreviewid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productreviewid: Option[ProductreviewId],
  /** Points to [[production.productreview.ProductreviewRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"productid","ordinal_position":3,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productid: Option[ProductId],
  /** Points to [[production.productreview.ProductreviewRow.reviewername]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"reviewername","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  reviewername: Option[Name],
  /** Points to [[production.productreview.ProductreviewRow.reviewdate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"reviewdate","ordinal_position":5,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  reviewdate: Option[LocalDateTime],
  /** Points to [[production.productreview.ProductreviewRow.emailaddress]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"emailaddress","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  emailaddress: Option[String],
  /** Points to [[production.productreview.ProductreviewRow.rating]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"rating","ordinal_position":7,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rating: Option[Int],
  /** Points to [[production.productreview.ProductreviewRow.comments]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"comments","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3850,"character_octet_length":15400,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  comments: Option[String],
  /** Points to [[production.productreview.ProductreviewRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"pr","column_name":"modifieddate","ordinal_position":9,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object PrRow {
  def rowParser(prefix: String): RowParser[PrRow] = { row =>
    Success(
      PrRow(
        id = row[Option[Int]](prefix + "id"),
        productreviewid = row[Option[ProductreviewId]](prefix + "productreviewid"),
        productid = row[Option[ProductId]](prefix + "productid"),
        reviewername = row[Option[Name]](prefix + "reviewername"),
        reviewdate = row[Option[LocalDateTime]](prefix + "reviewdate"),
        emailaddress = row[Option[String]](prefix + "emailaddress"),
        rating = row[Option[Int]](prefix + "rating"),
        comments = row[Option[String]](prefix + "comments"),
        modifieddate = row[Option[LocalDateTime]](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[PrRow] = new OFormat[PrRow]{
    override def writes(o: PrRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productreviewid" -> o.productreviewid,
        "productid" -> o.productid,
        "reviewername" -> o.reviewername,
        "reviewdate" -> o.reviewdate,
        "emailaddress" -> o.emailaddress,
        "rating" -> o.rating,
        "comments" -> o.comments,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PrRow] = {
      JsResult.fromTry(
        Try(
          PrRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productreviewid = json.\("productreviewid").toOption.map(_.as[ProductreviewId]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            reviewername = json.\("reviewername").toOption.map(_.as[Name]),
            reviewdate = json.\("reviewdate").toOption.map(_.as[LocalDateTime]),
            emailaddress = json.\("emailaddress").toOption.map(_.as[String]),
            rating = json.\("rating").toOption.map(_.as[Int]),
            comments = json.\("comments").toOption.map(_.as[String]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
