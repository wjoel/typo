/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amop

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_amop` */
case class PgAmopId(value: /* oid */ Long) extends AnyVal
object PgAmopId {
  implicit lazy val arrayColumn: Column[Array[PgAmopId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgAmopId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgAmopId, /* oid */ Long] = Bijection[PgAmopId, /* oid */ Long](_.value)(PgAmopId.apply)
  implicit lazy val column: Column[PgAmopId] = implicitly[Column[/* oid */ Long]].map(PgAmopId.apply)
  implicit lazy val ordering: Ordering[PgAmopId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgAmopId] = new ParameterMetaData[PgAmopId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit lazy val reads: Reads[PgAmopId] = Reads.LongReads.map(PgAmopId.apply)
  implicit lazy val toStatement: ToStatement[PgAmopId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit lazy val writes: Writes[PgAmopId] = Writes.LongWrites.contramap(_.value)
}
