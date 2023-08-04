/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `purchasing.purchaseorderheader` */
case class PurchaseorderheaderId(value: Int) extends AnyVal
object PurchaseorderheaderId {
  implicit lazy val arrayToStatement: ToStatement[Array[PurchaseorderheaderId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PurchaseorderheaderId, Int] = Bijection[PurchaseorderheaderId, Int](_.value)(PurchaseorderheaderId.apply)
  implicit lazy val column: Column[PurchaseorderheaderId] = implicitly[Column[Int]].map(PurchaseorderheaderId.apply)
  implicit lazy val ordering: Ordering[PurchaseorderheaderId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PurchaseorderheaderId] = new ParameterMetaData[PurchaseorderheaderId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit lazy val reads: Reads[PurchaseorderheaderId] = Reads.IntReads.map(PurchaseorderheaderId.apply)
  implicit lazy val toStatement: ToStatement[PurchaseorderheaderId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit lazy val writes: Writes[PurchaseorderheaderId] = Writes.IntWrites.contramap(_.value)
}
