/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ProductphotoRow(
  /** Primary key for ProductPhoto records. */
  productphotoid: ProductphotoId,
  /** Small image of the product. */
  thumbnailphoto: Option[Array[Byte]],
  /** Small image file name. */
  thumbnailphotofilename: Option[String],
  /** Large image of the product. */
  largephoto: Option[Array[Byte]],
  /** Large image file name. */
  largephotofilename: Option[String],
  modifieddate: LocalDateTime
)

object ProductphotoRow {
  implicit val oFormat: OFormat[ProductphotoRow] = new OFormat[ProductphotoRow]{
    override def writes(o: ProductphotoRow): JsObject =
      Json.obj(
        "productphotoid" -> o.productphotoid,
        "thumbnailphoto" -> o.thumbnailphoto,
        "thumbnailphotofilename" -> o.thumbnailphotofilename,
        "largephoto" -> o.largephoto,
        "largephotofilename" -> o.largephotofilename,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductphotoRow] = {
      JsResult.fromTry(
        Try(
          ProductphotoRow(
            productphotoid = json.\("productphotoid").as[ProductphotoId],
            thumbnailphoto = json.\("thumbnailphoto").toOption.map(_.as[Array[Byte]]),
            thumbnailphotofilename = json.\("thumbnailphotofilename").toOption.map(_.as[String]),
            largephoto = json.\("largephoto").toOption.map(_.as[Array[Byte]]),
            largephotofilename = json.\("largephotofilename").toOption.map(_.as[String]),
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
