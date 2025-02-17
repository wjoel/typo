/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.culture` */
case class CultureId(value: /* bpchar */ String) extends AnyVal
object CultureId {
  implicit lazy val arrayColumn: Column[Array[CultureId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[CultureId]] = implicitly[ToStatement[Array[/* bpchar */ String]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CultureId, /* bpchar */ String] = Bijection[CultureId, /* bpchar */ String](_.value)(CultureId.apply)
  implicit lazy val column: Column[CultureId] = implicitly[Column[/* bpchar */ String]].map(CultureId.apply)
  implicit lazy val ordering: Ordering[CultureId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[CultureId] = new ParameterMetaData[CultureId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* bpchar */ String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* bpchar */ String]].jdbcType
  }
  implicit lazy val reads: Reads[CultureId] = Reads.StringReads.map(CultureId.apply)
  implicit lazy val toStatement: ToStatement[CultureId] = implicitly[ToStatement[/* bpchar */ String]].contramap(_.value)
  implicit lazy val writes: Writes[CultureId] = Writes.StringWrites.contramap(_.value)
}
