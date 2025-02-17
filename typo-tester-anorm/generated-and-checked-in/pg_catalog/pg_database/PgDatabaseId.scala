/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_database` */
case class PgDatabaseId(value: /* oid */ Long) extends AnyVal
object PgDatabaseId {
  implicit lazy val arrayColumn: Column[Array[PgDatabaseId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgDatabaseId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgDatabaseId, /* oid */ Long] = Bijection[PgDatabaseId, /* oid */ Long](_.value)(PgDatabaseId.apply)
  implicit lazy val column: Column[PgDatabaseId] = implicitly[Column[/* oid */ Long]].map(PgDatabaseId.apply)
  implicit lazy val ordering: Ordering[PgDatabaseId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgDatabaseId] = new ParameterMetaData[PgDatabaseId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit lazy val reads: Reads[PgDatabaseId] = Reads.LongReads.map(PgDatabaseId.apply)
  implicit lazy val toStatement: ToStatement[PgDatabaseId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit lazy val writes: Writes[PgDatabaseId] = Writes.LongWrites.contramap(_.value)
}
