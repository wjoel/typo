package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgRangeRepoImpl extends PgRangeRepo {
  override def selectAll(implicit c: Connection): List[PgRangeRow] = {
    SQL"""select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range""".as(PgRangeRow.rowParser.*)
  }
  override def selectById(rngtypid: PgRangeId)(implicit c: Connection): Option[PgRangeRow] = {
    SQL"""select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range where rngtypid = $rngtypid""".as(PgRangeRow.rowParser.singleOpt)
  }
  override def selectByIds(rngtypids: List[PgRangeId])(implicit c: Connection): List[PgRangeRow] = {
    SQL"""select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range where rngtypid in $rngtypids""".as(PgRangeRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgRangeFieldValue[_]])(implicit c: Connection): List[PgRangeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgRangeFieldValue.rngtypid(value) => NamedParameter("rngtypid", ParameterValue.from(value))
          case PgRangeFieldValue.rngsubtype(value) => NamedParameter("rngsubtype", ParameterValue.from(value))
          case PgRangeFieldValue.rngmultitypid(value) => NamedParameter("rngmultitypid", ParameterValue.from(value))
          case PgRangeFieldValue.rngcollation(value) => NamedParameter("rngcollation", ParameterValue.from(value))
          case PgRangeFieldValue.rngsubopc(value) => NamedParameter("rngsubopc", ParameterValue.from(value))
          case PgRangeFieldValue.rngcanonical(value) => NamedParameter("rngcanonical", ParameterValue.from(value))
          case PgRangeFieldValue.rngsubdiff(value) => NamedParameter("rngsubdiff", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_range where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgRangeRow.rowParser.*)
    }

  }
  override def updateFieldValues(rngtypid: PgRangeId, fieldValues: List[PgRangeFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgRangeFieldValue.rngtypid(value) => NamedParameter("rngtypid", ParameterValue.from(value))
          case PgRangeFieldValue.rngsubtype(value) => NamedParameter("rngsubtype", ParameterValue.from(value))
          case PgRangeFieldValue.rngmultitypid(value) => NamedParameter("rngmultitypid", ParameterValue.from(value))
          case PgRangeFieldValue.rngcollation(value) => NamedParameter("rngcollation", ParameterValue.from(value))
          case PgRangeFieldValue.rngsubopc(value) => NamedParameter("rngsubopc", ParameterValue.from(value))
          case PgRangeFieldValue.rngcanonical(value) => NamedParameter("rngcanonical", ParameterValue.from(value))
          case PgRangeFieldValue.rngsubdiff(value) => NamedParameter("rngsubdiff", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_range
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where rngtypid = $rngtypid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(rngtypid: PgRangeId, unsaved: PgRangeRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("rngsubtype", ParameterValue.from(unsaved.rngsubtype))),
      Some(NamedParameter("rngmultitypid", ParameterValue.from(unsaved.rngmultitypid))),
      Some(NamedParameter("rngcollation", ParameterValue.from(unsaved.rngcollation))),
      Some(NamedParameter("rngsubopc", ParameterValue.from(unsaved.rngsubopc))),
      Some(NamedParameter("rngcanonical", ParameterValue.from(unsaved.rngcanonical))),
      Some(NamedParameter("rngsubdiff", ParameterValue.from(unsaved.rngsubdiff)))
    ).flatten

    SQL"""insert into pg_catalog.pg_range(rngtypid, ${namedParameters.map(_.name).mkString(", ")})
      values (${rngtypid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(rngtypid: PgRangeId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_range where rngtypid = $rngtypid""".executeUpdate() > 0
  }
  override def selectByUnique(rngmultitypid: Long)(implicit c: Connection): Option[PgRangeRow] = {
    ???
  }
}
