/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgAuthidRepoImpl extends PgAuthidRepo {
  override def selectAll(implicit c: Connection): List[PgAuthidRow] = {
    SQL"""select oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil from pg_catalog.pg_authid""".as(PgAuthidRow.rowParser("").*)
  }
  override def selectById(oid: PgAuthidId)(implicit c: Connection): Option[PgAuthidRow] = {
    SQL"""select oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil from pg_catalog.pg_authid where oid = $oid""".as(PgAuthidRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgAuthidId])(implicit c: Connection): List[PgAuthidRow] = {
    SQL"""select oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil from pg_catalog.pg_authid where oid in $oids""".as(PgAuthidRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgAuthidFieldValue[_]])(implicit c: Connection): List[PgAuthidRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAuthidFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgAuthidFieldValue.rolname(value) => NamedParameter("rolname", ParameterValue.from(value))
          case PgAuthidFieldValue.rolsuper(value) => NamedParameter("rolsuper", ParameterValue.from(value))
          case PgAuthidFieldValue.rolinherit(value) => NamedParameter("rolinherit", ParameterValue.from(value))
          case PgAuthidFieldValue.rolcreaterole(value) => NamedParameter("rolcreaterole", ParameterValue.from(value))
          case PgAuthidFieldValue.rolcreatedb(value) => NamedParameter("rolcreatedb", ParameterValue.from(value))
          case PgAuthidFieldValue.rolcanlogin(value) => NamedParameter("rolcanlogin", ParameterValue.from(value))
          case PgAuthidFieldValue.rolreplication(value) => NamedParameter("rolreplication", ParameterValue.from(value))
          case PgAuthidFieldValue.rolbypassrls(value) => NamedParameter("rolbypassrls", ParameterValue.from(value))
          case PgAuthidFieldValue.rolconnlimit(value) => NamedParameter("rolconnlimit", ParameterValue.from(value))
          case PgAuthidFieldValue.rolpassword(value) => NamedParameter("rolpassword", ParameterValue.from(value))
          case PgAuthidFieldValue.rolvaliduntil(value) => NamedParameter("rolvaliduntil", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_authid where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgAuthidRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgAuthidId, fieldValues: List[PgAuthidFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAuthidFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgAuthidFieldValue.rolname(value) => NamedParameter("rolname", ParameterValue.from(value))
          case PgAuthidFieldValue.rolsuper(value) => NamedParameter("rolsuper", ParameterValue.from(value))
          case PgAuthidFieldValue.rolinherit(value) => NamedParameter("rolinherit", ParameterValue.from(value))
          case PgAuthidFieldValue.rolcreaterole(value) => NamedParameter("rolcreaterole", ParameterValue.from(value))
          case PgAuthidFieldValue.rolcreatedb(value) => NamedParameter("rolcreatedb", ParameterValue.from(value))
          case PgAuthidFieldValue.rolcanlogin(value) => NamedParameter("rolcanlogin", ParameterValue.from(value))
          case PgAuthidFieldValue.rolreplication(value) => NamedParameter("rolreplication", ParameterValue.from(value))
          case PgAuthidFieldValue.rolbypassrls(value) => NamedParameter("rolbypassrls", ParameterValue.from(value))
          case PgAuthidFieldValue.rolconnlimit(value) => NamedParameter("rolconnlimit", ParameterValue.from(value))
          case PgAuthidFieldValue.rolpassword(value) => NamedParameter("rolpassword", ParameterValue.from(value))
          case PgAuthidFieldValue.rolvaliduntil(value) => NamedParameter("rolvaliduntil", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_authid
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgAuthidId, unsaved: PgAuthidRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("rolname", ParameterValue.from(unsaved.rolname))),
      Some(NamedParameter("rolsuper", ParameterValue.from(unsaved.rolsuper))),
      Some(NamedParameter("rolinherit", ParameterValue.from(unsaved.rolinherit))),
      Some(NamedParameter("rolcreaterole", ParameterValue.from(unsaved.rolcreaterole))),
      Some(NamedParameter("rolcreatedb", ParameterValue.from(unsaved.rolcreatedb))),
      Some(NamedParameter("rolcanlogin", ParameterValue.from(unsaved.rolcanlogin))),
      Some(NamedParameter("rolreplication", ParameterValue.from(unsaved.rolreplication))),
      Some(NamedParameter("rolbypassrls", ParameterValue.from(unsaved.rolbypassrls))),
      Some(NamedParameter("rolconnlimit", ParameterValue.from(unsaved.rolconnlimit))),
      Some(NamedParameter("rolpassword", ParameterValue.from(unsaved.rolpassword))),
      Some(NamedParameter("rolvaliduntil", ParameterValue.from(unsaved.rolvaliduntil)))
    ).flatten

    SQL"""insert into pg_catalog.pg_authid(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgAuthidId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_authid where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(rolname: String)(implicit c: Connection): Option[PgAuthidRow] = {
    ???
  }
}
