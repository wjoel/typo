package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgTablespaceRepoImpl extends PgTablespaceRepo {
  override def selectAll(implicit c: Connection): List[PgTablespaceRow] = {
    SQL"""select oid, spcname, spcowner, spcacl, spcoptions from pg_catalog.pg_tablespace""".as(PgTablespaceRow.rowParser.*)
  }
  override def selectById(oid: PgTablespaceId)(implicit c: Connection): Option[PgTablespaceRow] = {
    SQL"""select oid, spcname, spcowner, spcacl, spcoptions from pg_catalog.pg_tablespace where oid = $oid""".as(PgTablespaceRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgTablespaceId])(implicit c: Connection): List[PgTablespaceRow] = {
    SQL"""select oid, spcname, spcowner, spcacl, spcoptions from pg_catalog.pg_tablespace where oid in $oids""".as(PgTablespaceRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgTablespaceFieldValue[_]])(implicit c: Connection): List[PgTablespaceRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTablespaceFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTablespaceFieldValue.spcname(value) => NamedParameter("spcname", ParameterValue.from(value))
          case PgTablespaceFieldValue.spcowner(value) => NamedParameter("spcowner", ParameterValue.from(value))
          case PgTablespaceFieldValue.spcacl(value) => NamedParameter("spcacl", ParameterValue.from(value))
          case PgTablespaceFieldValue.spcoptions(value) => NamedParameter("spcoptions", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_tablespace where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgTablespaceRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgTablespaceId, fieldValues: List[PgTablespaceFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTablespaceFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTablespaceFieldValue.spcname(value) => NamedParameter("spcname", ParameterValue.from(value))
          case PgTablespaceFieldValue.spcowner(value) => NamedParameter("spcowner", ParameterValue.from(value))
          case PgTablespaceFieldValue.spcacl(value) => NamedParameter("spcacl", ParameterValue.from(value))
          case PgTablespaceFieldValue.spcoptions(value) => NamedParameter("spcoptions", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_tablespace
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgTablespaceId, unsaved: PgTablespaceRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("spcname", ParameterValue.from(unsaved.spcname))),
      Some(NamedParameter("spcowner", ParameterValue.from(unsaved.spcowner))),
      Some(NamedParameter("spcacl", ParameterValue.from(unsaved.spcacl))),
      Some(NamedParameter("spcoptions", ParameterValue.from(unsaved.spcoptions)))
    ).flatten

    SQL"""insert into pg_catalog.pg_tablespace(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgTablespaceId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_tablespace where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(spcname: String)(implicit c: Connection): Option[PgTablespaceRow] = {
    ???
  }
}
