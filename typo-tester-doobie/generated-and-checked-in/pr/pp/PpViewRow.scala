/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import adventureworks.production.productphoto.ProductphotoId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

case class PpViewRow(
  id: Option[Int],
  /** Points to [[production.productphoto.ProductphotoRow.productphotoid]] */
  productphotoid: Option[ProductphotoId],
  /** Points to [[production.productphoto.ProductphotoRow.thumbnailphoto]] */
  thumbnailphoto: Option[Byte],
  /** Points to [[production.productphoto.ProductphotoRow.thumbnailphotofilename]] */
  thumbnailphotofilename: Option[String],
  /** Points to [[production.productphoto.ProductphotoRow.largephoto]] */
  largephoto: Option[Byte],
  /** Points to [[production.productphoto.ProductphotoRow.largephotofilename]] */
  largephotofilename: Option[String],
  /** Points to [[production.productphoto.ProductphotoRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PpViewRow {
  implicit val decoder: Decoder[PpViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        productphotoid <- c.downField("productphotoid").as[Option[ProductphotoId]]
        thumbnailphoto <- c.downField("thumbnailphoto").as[Option[Byte]]
        thumbnailphotofilename <- c.downField("thumbnailphotofilename").as[Option[String]]
        largephoto <- c.downField("largephoto").as[Option[Byte]]
        largephotofilename <- c.downField("largephotofilename").as[Option[String]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield PpViewRow(id, productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate)
  implicit val encoder: Encoder[PpViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "productphotoid" := row.productphotoid,
        "thumbnailphoto" := row.thumbnailphoto,
        "thumbnailphotofilename" := row.thumbnailphotofilename,
        "largephoto" := row.largephoto,
        "largephotofilename" := row.largephotofilename,
        "modifieddate" := row.modifieddate
      )}
}