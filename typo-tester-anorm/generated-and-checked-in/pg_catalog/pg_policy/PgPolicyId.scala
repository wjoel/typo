/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_policy

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_policy` */
case class PgPolicyId(value: /* oid */ Long) extends AnyVal
object PgPolicyId {
  implicit lazy val arrayColumn: Column[Array[PgPolicyId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgPolicyId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgPolicyId, /* oid */ Long] = Bijection[PgPolicyId, /* oid */ Long](_.value)(PgPolicyId.apply)
  implicit lazy val column: Column[PgPolicyId] = implicitly[Column[/* oid */ Long]].map(PgPolicyId.apply)
  implicit lazy val ordering: Ordering[PgPolicyId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgPolicyId] = new ParameterMetaData[PgPolicyId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit lazy val reads: Reads[PgPolicyId] = Reads.LongReads.map(PgPolicyId.apply)
  implicit lazy val toStatement: ToStatement[PgPolicyId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit lazy val writes: Writes[PgPolicyId] = Writes.LongWrites.contramap(_.value)
}
