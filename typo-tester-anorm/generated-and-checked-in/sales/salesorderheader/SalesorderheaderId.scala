/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `sales.salesorderheader` */
case class SalesorderheaderId(value: Int) extends AnyVal
object SalesorderheaderId {
  implicit val arrayToStatement: ToStatement[Array[SalesorderheaderId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit val column: Column[SalesorderheaderId] = implicitly[Column[Int]].map(SalesorderheaderId.apply)
  implicit val ordering: Ordering[SalesorderheaderId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[SalesorderheaderId] = new ParameterMetaData[SalesorderheaderId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit val reads: Reads[SalesorderheaderId] = Reads.IntReads.map(SalesorderheaderId.apply)
  implicit val toStatement: ToStatement[SalesorderheaderId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val writes: Writes[SalesorderheaderId] = Writes.IntWrites.contramap(_.value)
}
