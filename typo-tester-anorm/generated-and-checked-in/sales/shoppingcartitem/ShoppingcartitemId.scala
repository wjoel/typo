/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `sales.shoppingcartitem` */
case class ShoppingcartitemId(value: Int) extends AnyVal
object ShoppingcartitemId {
  implicit val arrayToStatement: ToStatement[Array[ShoppingcartitemId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit val column: Column[ShoppingcartitemId] = implicitly[Column[Int]].map(ShoppingcartitemId.apply)
  implicit val ordering: Ordering[ShoppingcartitemId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[ShoppingcartitemId] = new ParameterMetaData[ShoppingcartitemId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit val reads: Reads[ShoppingcartitemId] = Reads.IntReads.map(ShoppingcartitemId.apply)
  implicit val toStatement: ToStatement[ShoppingcartitemId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val writes: Writes[ShoppingcartitemId] = Writes.IntWrites.contramap(_.value)
}
