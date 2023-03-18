package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatisticExtDataRepoImpl extends PgStatisticExtDataRepo {
  override def selectAll(implicit c: Connection): List[PgStatisticExtDataRow] = {
    SQL"""select stxoid, stxdndistinct, stxddependencies, stxdmcv, stxdexpr from pg_catalog.pg_statistic_ext_data""".as(PgStatisticExtDataRow.rowParser.*)
  }
  override def selectById(stxoid: PgStatisticExtDataId)(implicit c: Connection): Option[PgStatisticExtDataRow] = {
    SQL"""select stxoid, stxdndistinct, stxddependencies, stxdmcv, stxdexpr from pg_catalog.pg_statistic_ext_data where stxoid = $stxoid""".as(PgStatisticExtDataRow.rowParser.singleOpt)
  }
  override def selectByIds(stxoids: List[PgStatisticExtDataId])(implicit c: Connection): List[PgStatisticExtDataRow] = {
    SQL"""select stxoid, stxdndistinct, stxddependencies, stxdmcv, stxdexpr from pg_catalog.pg_statistic_ext_data where stxoid in $stxoids""".as(PgStatisticExtDataRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatisticExtDataFieldValue[_]])(implicit c: Connection): List[PgStatisticExtDataRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatisticExtDataFieldValue.stxoid(value) => NamedParameter("stxoid", ParameterValue.from(value))
          case PgStatisticExtDataFieldValue.stxdndistinct(value) => NamedParameter("stxdndistinct", ParameterValue.from(value))
          case PgStatisticExtDataFieldValue.stxddependencies(value) => NamedParameter("stxddependencies", ParameterValue.from(value))
          case PgStatisticExtDataFieldValue.stxdmcv(value) => NamedParameter("stxdmcv", ParameterValue.from(value))
          case PgStatisticExtDataFieldValue.stxdexpr(value) => NamedParameter("stxdexpr", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_statistic_ext_data where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatisticExtDataRow.rowParser.*)
    }

  }
  override def updateFieldValues(stxoid: PgStatisticExtDataId, fieldValues: List[PgStatisticExtDataFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatisticExtDataFieldValue.stxoid(value) => NamedParameter("stxoid", ParameterValue.from(value))
          case PgStatisticExtDataFieldValue.stxdndistinct(value) => NamedParameter("stxdndistinct", ParameterValue.from(value))
          case PgStatisticExtDataFieldValue.stxddependencies(value) => NamedParameter("stxddependencies", ParameterValue.from(value))
          case PgStatisticExtDataFieldValue.stxdmcv(value) => NamedParameter("stxdmcv", ParameterValue.from(value))
          case PgStatisticExtDataFieldValue.stxdexpr(value) => NamedParameter("stxdexpr", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_statistic_ext_data
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where stxoid = $stxoid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(stxoid: PgStatisticExtDataId, unsaved: PgStatisticExtDataRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("stxdndistinct", ParameterValue.from(unsaved.stxdndistinct))),
      Some(NamedParameter("stxddependencies", ParameterValue.from(unsaved.stxddependencies))),
      Some(NamedParameter("stxdmcv", ParameterValue.from(unsaved.stxdmcv))),
      Some(NamedParameter("stxdexpr", ParameterValue.from(unsaved.stxdexpr)))
    ).flatten

    SQL"""insert into pg_catalog.pg_statistic_ext_data(stxoid, ${namedParameters.map(_.name).mkString(", ")})
      values (${stxoid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(stxoid: PgStatisticExtDataId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_statistic_ext_data where stxoid = $stxoid""".executeUpdate() > 0
  }
}
