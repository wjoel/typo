package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgReplicationOriginRepoImpl extends PgReplicationOriginRepo {
  override def selectAll(implicit c: Connection): List[PgReplicationOriginRow] = {
    SQL"""select roident, roname from pg_catalog.pg_replication_origin""".as(PgReplicationOriginRow.rowParser.*)
  }
  override def selectById(roident: PgReplicationOriginId)(implicit c: Connection): Option[PgReplicationOriginRow] = {
    SQL"""select roident, roname from pg_catalog.pg_replication_origin where roident = $roident""".as(PgReplicationOriginRow.rowParser.singleOpt)
  }
  override def selectByIds(roidents: List[PgReplicationOriginId])(implicit c: Connection): List[PgReplicationOriginRow] = {
    SQL"""select roident, roname from pg_catalog.pg_replication_origin where roident in $roidents""".as(PgReplicationOriginRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgReplicationOriginFieldValue[_]])(implicit c: Connection): List[PgReplicationOriginRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgReplicationOriginFieldValue.roident(value) => NamedParameter("roident", ParameterValue.from(value))
          case PgReplicationOriginFieldValue.roname(value) => NamedParameter("roname", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_replication_origin where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgReplicationOriginRow.rowParser.*)
    }

  }
  override def updateFieldValues(roident: PgReplicationOriginId, fieldValues: List[PgReplicationOriginFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgReplicationOriginFieldValue.roident(value) => NamedParameter("roident", ParameterValue.from(value))
          case PgReplicationOriginFieldValue.roname(value) => NamedParameter("roname", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_replication_origin
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where roident = $roident"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(roident: PgReplicationOriginId, unsaved: PgReplicationOriginRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("roname", ParameterValue.from(unsaved.roname)))
    ).flatten

    SQL"""insert into pg_catalog.pg_replication_origin(roident, ${namedParameters.map(_.name).mkString(", ")})
      values (${roident}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(roident: PgReplicationOriginId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_replication_origin where roident = $roident""".executeUpdate() > 0
  }
  override def selectByUnique(roname: String)(implicit c: Connection): Option[PgReplicationOriginRow] = {
    ???
  }
}
