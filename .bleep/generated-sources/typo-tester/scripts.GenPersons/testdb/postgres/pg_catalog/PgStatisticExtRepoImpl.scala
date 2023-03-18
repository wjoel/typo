package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatisticExtRepoImpl extends PgStatisticExtRepo {
  override def selectAll(implicit c: Connection): List[PgStatisticExtRow] = {
    SQL"""select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext""".as(PgStatisticExtRow.rowParser.*)
  }
  override def selectById(oid: PgStatisticExtId)(implicit c: Connection): Option[PgStatisticExtRow] = {
    SQL"""select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext where oid = $oid""".as(PgStatisticExtRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgStatisticExtId])(implicit c: Connection): List[PgStatisticExtRow] = {
    SQL"""select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext where oid in $oids""".as(PgStatisticExtRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatisticExtFieldValue[_]])(implicit c: Connection): List[PgStatisticExtRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatisticExtFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxrelid(value) => NamedParameter("stxrelid", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxname(value) => NamedParameter("stxname", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxnamespace(value) => NamedParameter("stxnamespace", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxowner(value) => NamedParameter("stxowner", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxstattarget(value) => NamedParameter("stxstattarget", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxkeys(value) => NamedParameter("stxkeys", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxkind(value) => NamedParameter("stxkind", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxexprs(value) => NamedParameter("stxexprs", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_statistic_ext where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatisticExtRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgStatisticExtId, fieldValues: List[PgStatisticExtFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatisticExtFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxrelid(value) => NamedParameter("stxrelid", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxname(value) => NamedParameter("stxname", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxnamespace(value) => NamedParameter("stxnamespace", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxowner(value) => NamedParameter("stxowner", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxstattarget(value) => NamedParameter("stxstattarget", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxkeys(value) => NamedParameter("stxkeys", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxkind(value) => NamedParameter("stxkind", ParameterValue.from(value))
          case PgStatisticExtFieldValue.stxexprs(value) => NamedParameter("stxexprs", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_statistic_ext
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgStatisticExtId, unsaved: PgStatisticExtRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("stxrelid", ParameterValue.from(unsaved.stxrelid))),
      Some(NamedParameter("stxname", ParameterValue.from(unsaved.stxname))),
      Some(NamedParameter("stxnamespace", ParameterValue.from(unsaved.stxnamespace))),
      Some(NamedParameter("stxowner", ParameterValue.from(unsaved.stxowner))),
      Some(NamedParameter("stxstattarget", ParameterValue.from(unsaved.stxstattarget))),
      Some(NamedParameter("stxkeys", ParameterValue.from(unsaved.stxkeys))),
      Some(NamedParameter("stxkind", ParameterValue.from(unsaved.stxkind))),
      Some(NamedParameter("stxexprs", ParameterValue.from(unsaved.stxexprs)))
    ).flatten

    SQL"""insert into pg_catalog.pg_statistic_ext(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgStatisticExtId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_statistic_ext where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(stxname: String, stxnamespace: Long)(implicit c: Connection): Option[PgStatisticExtRow] = {
    ???
  }
}
