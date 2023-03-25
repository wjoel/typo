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

object PgExtensionRepoImpl extends PgExtensionRepo {
  override def selectAll(implicit c: Connection): List[PgExtensionRow] = {
    SQL"""select oid, extname, extowner, extnamespace, extrelocatable, extversion, extconfig, extcondition from pg_catalog.pg_extension""".as(PgExtensionRow.rowParser("").*)
  }
  override def selectById(oid: PgExtensionId)(implicit c: Connection): Option[PgExtensionRow] = {
    SQL"""select oid, extname, extowner, extnamespace, extrelocatable, extversion, extconfig, extcondition from pg_catalog.pg_extension where oid = $oid""".as(PgExtensionRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgExtensionId])(implicit c: Connection): List[PgExtensionRow] = {
    SQL"""select oid, extname, extowner, extnamespace, extrelocatable, extversion, extconfig, extcondition from pg_catalog.pg_extension where oid in $oids""".as(PgExtensionRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgExtensionFieldValue[_]])(implicit c: Connection): List[PgExtensionRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgExtensionFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgExtensionFieldValue.extname(value) => NamedParameter("extname", ParameterValue.from(value))
          case PgExtensionFieldValue.extowner(value) => NamedParameter("extowner", ParameterValue.from(value))
          case PgExtensionFieldValue.extnamespace(value) => NamedParameter("extnamespace", ParameterValue.from(value))
          case PgExtensionFieldValue.extrelocatable(value) => NamedParameter("extrelocatable", ParameterValue.from(value))
          case PgExtensionFieldValue.extversion(value) => NamedParameter("extversion", ParameterValue.from(value))
          case PgExtensionFieldValue.extconfig(value) => NamedParameter("extconfig", ParameterValue.from(value))
          case PgExtensionFieldValue.extcondition(value) => NamedParameter("extcondition", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_extension where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgExtensionRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgExtensionId, fieldValues: List[PgExtensionFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgExtensionFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgExtensionFieldValue.extname(value) => NamedParameter("extname", ParameterValue.from(value))
          case PgExtensionFieldValue.extowner(value) => NamedParameter("extowner", ParameterValue.from(value))
          case PgExtensionFieldValue.extnamespace(value) => NamedParameter("extnamespace", ParameterValue.from(value))
          case PgExtensionFieldValue.extrelocatable(value) => NamedParameter("extrelocatable", ParameterValue.from(value))
          case PgExtensionFieldValue.extversion(value) => NamedParameter("extversion", ParameterValue.from(value))
          case PgExtensionFieldValue.extconfig(value) => NamedParameter("extconfig", ParameterValue.from(value))
          case PgExtensionFieldValue.extcondition(value) => NamedParameter("extcondition", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_extension
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgExtensionId, unsaved: PgExtensionRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("extname", ParameterValue.from(unsaved.extname))),
      Some(NamedParameter("extowner", ParameterValue.from(unsaved.extowner))),
      Some(NamedParameter("extnamespace", ParameterValue.from(unsaved.extnamespace))),
      Some(NamedParameter("extrelocatable", ParameterValue.from(unsaved.extrelocatable))),
      Some(NamedParameter("extversion", ParameterValue.from(unsaved.extversion))),
      Some(NamedParameter("extconfig", ParameterValue.from(unsaved.extconfig))),
      Some(NamedParameter("extcondition", ParameterValue.from(unsaved.extcondition)))
    ).flatten

    SQL"""insert into pg_catalog.pg_extension(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgExtensionId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_extension where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(extname: String)(implicit c: Connection): Option[PgExtensionRow] = {
    ???
  }
}
