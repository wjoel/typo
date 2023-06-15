/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.Defaulted
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.productphoto` which has not been persisted yet */
case class ProductphotoRowUnsaved(
  /** Small image of the product. */
  thumbnailphoto: Option[Array[Byte]],
  /** Small image file name. */
  thumbnailphotofilename: Option[String],
  /** Large image of the product. */
  largephoto: Option[Array[Byte]],
  /** Large image file name. */
  largephotofilename: Option[String],
  /** Default: nextval('production.productphoto_productphotoid_seq'::regclass)
      Primary key for ProductPhoto records. */
  productphotoid: Defaulted[ProductphotoId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productphotoidDefault: => ProductphotoId, modifieddateDefault: => LocalDateTime): ProductphotoRow =
    ProductphotoRow(
      thumbnailphoto = thumbnailphoto,
      thumbnailphotofilename = thumbnailphotofilename,
      largephoto = largephoto,
      largephotofilename = largephotofilename,
      productphotoid = productphotoid match {
                         case Defaulted.UseDefault => productphotoidDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductphotoRowUnsaved {
  implicit val oFormat: OFormat[ProductphotoRowUnsaved] = new OFormat[ProductphotoRowUnsaved]{
    override def writes(o: ProductphotoRowUnsaved): JsObject =
      Json.obj(
        "thumbnailphoto" -> o.thumbnailphoto,
        "thumbnailphotofilename" -> o.thumbnailphotofilename,
        "largephoto" -> o.largephoto,
        "largephotofilename" -> o.largephotofilename,
        "productphotoid" -> o.productphotoid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductphotoRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductphotoRowUnsaved(
            thumbnailphoto = json.\("thumbnailphoto").toOption.map(_.as[Array[Byte]]),
            thumbnailphotofilename = json.\("thumbnailphotofilename").toOption.map(_.as[String]),
            largephoto = json.\("largephoto").toOption.map(_.as[Array[Byte]]),
            largephotofilename = json.\("largephotofilename").toOption.map(_.as[String]),
            productphotoid = json.\("productphotoid").as[Defaulted[ProductphotoId]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}