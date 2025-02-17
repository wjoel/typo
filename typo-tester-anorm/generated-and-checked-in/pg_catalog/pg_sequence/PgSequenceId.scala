/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequence

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_sequence` */
case class PgSequenceId(value: /* oid */ Long) extends AnyVal
object PgSequenceId {
  implicit lazy val arrayColumn: Column[Array[PgSequenceId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgSequenceId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgSequenceId, /* oid */ Long] = Bijection[PgSequenceId, /* oid */ Long](_.value)(PgSequenceId.apply)
  implicit lazy val column: Column[PgSequenceId] = implicitly[Column[/* oid */ Long]].map(PgSequenceId.apply)
  implicit lazy val ordering: Ordering[PgSequenceId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgSequenceId] = new ParameterMetaData[PgSequenceId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit lazy val reads: Reads[PgSequenceId] = Reads.LongReads.map(PgSequenceId.apply)
  implicit lazy val toStatement: ToStatement[PgSequenceId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit lazy val writes: Writes[PgSequenceId] = Writes.LongWrites.contramap(_.value)
}
