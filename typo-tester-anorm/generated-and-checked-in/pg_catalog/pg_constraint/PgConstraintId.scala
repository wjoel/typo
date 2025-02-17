/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_constraint

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_constraint` */
case class PgConstraintId(value: /* oid */ Long) extends AnyVal
object PgConstraintId {
  implicit lazy val arrayColumn: Column[Array[PgConstraintId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgConstraintId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgConstraintId, /* oid */ Long] = Bijection[PgConstraintId, /* oid */ Long](_.value)(PgConstraintId.apply)
  implicit lazy val column: Column[PgConstraintId] = implicitly[Column[/* oid */ Long]].map(PgConstraintId.apply)
  implicit lazy val ordering: Ordering[PgConstraintId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgConstraintId] = new ParameterMetaData[PgConstraintId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit lazy val reads: Reads[PgConstraintId] = Reads.LongReads.map(PgConstraintId.apply)
  implicit lazy val toStatement: ToStatement[PgConstraintId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit lazy val writes: Writes[PgConstraintId] = Writes.LongWrites.contramap(_.value)
}
