/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import adventureworks.production.productphoto.ProductphotoId
import java.time.LocalDateTime

sealed abstract class PpViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PpViewFieldValue[T](name: String, value: T) extends PpViewFieldOrIdValue(name, value)

object PpViewFieldValue {
  case class id(override val value: Option[Int]) extends PpViewFieldValue("id", value)
  case class productphotoid(override val value: Option[ProductphotoId]) extends PpViewFieldValue("productphotoid", value)
  case class thumbnailphoto(override val value: Option[Byte]) extends PpViewFieldValue("thumbnailphoto", value)
  case class thumbnailphotofilename(override val value: Option[String]) extends PpViewFieldValue("thumbnailphotofilename", value)
  case class largephoto(override val value: Option[Byte]) extends PpViewFieldValue("largephoto", value)
  case class largephotofilename(override val value: Option[String]) extends PpViewFieldValue("largephotofilename", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PpViewFieldValue("modifieddate", value)
}
