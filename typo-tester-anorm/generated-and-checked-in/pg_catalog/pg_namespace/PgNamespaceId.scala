/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_namespace

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_namespace` */
case class PgNamespaceId(value: /* oid */ Long) extends AnyVal
object PgNamespaceId {
  implicit val arrayToStatement: ToStatement[Array[PgNamespaceId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgNamespaceId] = implicitly[Column[/* oid */ Long]].map(PgNamespaceId.apply)
  implicit val ordering: Ordering[PgNamespaceId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgNamespaceId] = new ParameterMetaData[PgNamespaceId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgNamespaceId] = Reads.LongReads.map(PgNamespaceId.apply)
  implicit val toStatement: ToStatement[PgNamespaceId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgNamespaceId] = Writes.LongWrites.contramap(_.value)
}
