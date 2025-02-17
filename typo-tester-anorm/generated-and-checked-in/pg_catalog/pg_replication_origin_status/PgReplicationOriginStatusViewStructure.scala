/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin_status

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgReplicationOriginStatusViewStructure[Row](val prefix: Option[String], val extract: Row => PgReplicationOriginStatusViewRow, val merge: (Row, PgReplicationOriginStatusViewRow) => Row)
  extends Relation[PgReplicationOriginStatusViewFields, PgReplicationOriginStatusViewRow, Row]
    with PgReplicationOriginStatusViewFields[Row] { outer =>

  override val localId = new OptField[/* oid */ Long, Row](prefix, "local_id", None, Some("oid"))(x => extract(x).localId, (row, value) => merge(row, extract(row).copy(localId = value)))
  override val externalId = new OptField[String, Row](prefix, "external_id", None, None)(x => extract(x).externalId, (row, value) => merge(row, extract(row).copy(externalId = value)))
  override val remoteLsn = new OptField[/* pg_lsn */ Long, Row](prefix, "remote_lsn", None, Some("pg_lsn"))(x => extract(x).remoteLsn, (row, value) => merge(row, extract(row).copy(remoteLsn = value)))
  override val localLsn = new OptField[/* pg_lsn */ Long, Row](prefix, "local_lsn", None, Some("pg_lsn"))(x => extract(x).localLsn, (row, value) => merge(row, extract(row).copy(localLsn = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](localId, externalId, remoteLsn, localLsn)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgReplicationOriginStatusViewRow, merge: (NewRow, PgReplicationOriginStatusViewRow) => NewRow): PgReplicationOriginStatusViewStructure[NewRow] =
    new PgReplicationOriginStatusViewStructure(prefix, extract, merge)
}
