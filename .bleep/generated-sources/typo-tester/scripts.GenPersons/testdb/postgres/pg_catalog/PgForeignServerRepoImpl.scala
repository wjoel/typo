package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgForeignServerRepoImpl extends PgForeignServerRepo {
  override def selectAll(implicit c: Connection): List[PgForeignServerRow] = {
    SQL"""select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions from pg_catalog.pg_foreign_server""".as(PgForeignServerRow.rowParser.*)
  }
  override def selectById(oid: PgForeignServerId)(implicit c: Connection): Option[PgForeignServerRow] = {
    SQL"""select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions from pg_catalog.pg_foreign_server where oid = $oid""".as(PgForeignServerRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgForeignServerId])(implicit c: Connection): List[PgForeignServerRow] = {
    SQL"""select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions from pg_catalog.pg_foreign_server where oid in $oids""".as(PgForeignServerRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgForeignServerFieldValue[_]])(implicit c: Connection): List[PgForeignServerRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignServerFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvname(value) => NamedParameter("srvname", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvowner(value) => NamedParameter("srvowner", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvfdw(value) => NamedParameter("srvfdw", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvtype(value) => NamedParameter("srvtype", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvversion(value) => NamedParameter("srvversion", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvacl(value) => NamedParameter("srvacl", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvoptions(value) => NamedParameter("srvoptions", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_foreign_server where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgForeignServerRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgForeignServerId, fieldValues: List[PgForeignServerFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignServerFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvname(value) => NamedParameter("srvname", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvowner(value) => NamedParameter("srvowner", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvfdw(value) => NamedParameter("srvfdw", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvtype(value) => NamedParameter("srvtype", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvversion(value) => NamedParameter("srvversion", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvacl(value) => NamedParameter("srvacl", ParameterValue.from(value))
          case PgForeignServerFieldValue.srvoptions(value) => NamedParameter("srvoptions", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_foreign_server
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgForeignServerId, unsaved: PgForeignServerRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("srvname", ParameterValue.from(unsaved.srvname))),
      Some(NamedParameter("srvowner", ParameterValue.from(unsaved.srvowner))),
      Some(NamedParameter("srvfdw", ParameterValue.from(unsaved.srvfdw))),
      Some(NamedParameter("srvtype", ParameterValue.from(unsaved.srvtype))),
      Some(NamedParameter("srvversion", ParameterValue.from(unsaved.srvversion))),
      Some(NamedParameter("srvacl", ParameterValue.from(unsaved.srvacl))),
      Some(NamedParameter("srvoptions", ParameterValue.from(unsaved.srvoptions)))
    ).flatten

    SQL"""insert into pg_catalog.pg_foreign_server(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgForeignServerId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_foreign_server where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(srvname: String)(implicit c: Connection): Option[PgForeignServerRow] = {
    ???
  }
}
