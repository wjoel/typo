/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.location` */
case class LocationId(value: Int) extends AnyVal
object LocationId {
  implicit lazy val arrayColumn: Column[Array[LocationId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[LocationId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[LocationId, Int] = Bijection[LocationId, Int](_.value)(LocationId.apply)
  implicit lazy val column: Column[LocationId] = implicitly[Column[Int]].map(LocationId.apply)
  implicit lazy val ordering: Ordering[LocationId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[LocationId] = new ParameterMetaData[LocationId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit lazy val reads: Reads[LocationId] = Reads.IntReads.map(LocationId.apply)
  implicit lazy val toStatement: ToStatement[LocationId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit lazy val writes: Writes[LocationId] = Writes.IntWrites.contramap(_.value)
}
