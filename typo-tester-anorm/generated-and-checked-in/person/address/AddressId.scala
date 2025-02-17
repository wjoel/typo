/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `person.address` */
case class AddressId(value: Int) extends AnyVal
object AddressId {
  implicit lazy val arrayColumn: Column[Array[AddressId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[AddressId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[AddressId, Int] = Bijection[AddressId, Int](_.value)(AddressId.apply)
  implicit lazy val column: Column[AddressId] = implicitly[Column[Int]].map(AddressId.apply)
  implicit lazy val ordering: Ordering[AddressId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[AddressId] = new ParameterMetaData[AddressId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit lazy val reads: Reads[AddressId] = Reads.IntReads.map(AddressId.apply)
  implicit lazy val toStatement: ToStatement[AddressId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit lazy val writes: Writes[AddressId] = Writes.IntWrites.contramap(_.value)
}
