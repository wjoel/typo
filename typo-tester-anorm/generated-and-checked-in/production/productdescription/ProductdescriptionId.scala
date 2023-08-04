/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.productdescription` */
case class ProductdescriptionId(value: Int) extends AnyVal
object ProductdescriptionId {
  implicit lazy val arrayToStatement: ToStatement[Array[ProductdescriptionId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductdescriptionId, Int] = Bijection[ProductdescriptionId, Int](_.value)(ProductdescriptionId.apply)
  implicit lazy val column: Column[ProductdescriptionId] = implicitly[Column[Int]].map(ProductdescriptionId.apply)
  implicit lazy val ordering: Ordering[ProductdescriptionId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ProductdescriptionId] = new ParameterMetaData[ProductdescriptionId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit lazy val reads: Reads[ProductdescriptionId] = Reads.IntReads.map(ProductdescriptionId.apply)
  implicit lazy val toStatement: ToStatement[ProductdescriptionId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit lazy val writes: Writes[ProductdescriptionId] = Writes.IntWrites.contramap(_.value)
}
