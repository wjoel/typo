package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgTsParserRepoImpl extends PgTsParserRepo {
  override def selectAll(implicit c: Connection): List[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype from pg_catalog.pg_ts_parser""".as(PgTsParserRow.rowParser.*)
  }
  override def selectById(oid: PgTsParserId)(implicit c: Connection): Option[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype from pg_catalog.pg_ts_parser where oid = $oid""".as(PgTsParserRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgTsParserId])(implicit c: Connection): List[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype from pg_catalog.pg_ts_parser where oid in $oids""".as(PgTsParserRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgTsParserFieldValue[_]])(implicit c: Connection): List[PgTsParserRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTsParserFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTsParserFieldValue.prsname(value) => NamedParameter("prsname", ParameterValue.from(value))
          case PgTsParserFieldValue.prsnamespace(value) => NamedParameter("prsnamespace", ParameterValue.from(value))
          case PgTsParserFieldValue.prsstart(value) => NamedParameter("prsstart", ParameterValue.from(value))
          case PgTsParserFieldValue.prstoken(value) => NamedParameter("prstoken", ParameterValue.from(value))
          case PgTsParserFieldValue.prsend(value) => NamedParameter("prsend", ParameterValue.from(value))
          case PgTsParserFieldValue.prsheadline(value) => NamedParameter("prsheadline", ParameterValue.from(value))
          case PgTsParserFieldValue.prslextype(value) => NamedParameter("prslextype", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_ts_parser where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgTsParserRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgTsParserId, fieldValues: List[PgTsParserFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTsParserFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTsParserFieldValue.prsname(value) => NamedParameter("prsname", ParameterValue.from(value))
          case PgTsParserFieldValue.prsnamespace(value) => NamedParameter("prsnamespace", ParameterValue.from(value))
          case PgTsParserFieldValue.prsstart(value) => NamedParameter("prsstart", ParameterValue.from(value))
          case PgTsParserFieldValue.prstoken(value) => NamedParameter("prstoken", ParameterValue.from(value))
          case PgTsParserFieldValue.prsend(value) => NamedParameter("prsend", ParameterValue.from(value))
          case PgTsParserFieldValue.prsheadline(value) => NamedParameter("prsheadline", ParameterValue.from(value))
          case PgTsParserFieldValue.prslextype(value) => NamedParameter("prslextype", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_ts_parser
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgTsParserId, unsaved: PgTsParserRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("prsname", ParameterValue.from(unsaved.prsname))),
      Some(NamedParameter("prsnamespace", ParameterValue.from(unsaved.prsnamespace))),
      Some(NamedParameter("prsstart", ParameterValue.from(unsaved.prsstart))),
      Some(NamedParameter("prstoken", ParameterValue.from(unsaved.prstoken))),
      Some(NamedParameter("prsend", ParameterValue.from(unsaved.prsend))),
      Some(NamedParameter("prsheadline", ParameterValue.from(unsaved.prsheadline))),
      Some(NamedParameter("prslextype", ParameterValue.from(unsaved.prslextype)))
    ).flatten

    SQL"""insert into pg_catalog.pg_ts_parser(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgTsParserId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_ts_parser where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(prsname: String, prsnamespace: Long)(implicit c: Connection): Option[PgTsParserRow] = {
    ???
  }
}
