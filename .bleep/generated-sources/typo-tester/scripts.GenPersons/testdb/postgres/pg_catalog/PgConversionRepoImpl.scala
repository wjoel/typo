package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgConversionRepoImpl extends PgConversionRepo {
  override def selectAll(implicit c: Connection): List[PgConversionRow] = {
    SQL"""select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault from pg_catalog.pg_conversion""".as(PgConversionRow.rowParser.*)
  }
  override def selectById(oid: PgConversionId)(implicit c: Connection): Option[PgConversionRow] = {
    SQL"""select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault from pg_catalog.pg_conversion where oid = $oid""".as(PgConversionRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgConversionId])(implicit c: Connection): List[PgConversionRow] = {
    SQL"""select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault from pg_catalog.pg_conversion where oid in $oids""".as(PgConversionRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgConversionFieldValue[_]])(implicit c: Connection): List[PgConversionRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgConversionFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgConversionFieldValue.conname(value) => NamedParameter("conname", ParameterValue.from(value))
          case PgConversionFieldValue.connamespace(value) => NamedParameter("connamespace", ParameterValue.from(value))
          case PgConversionFieldValue.conowner(value) => NamedParameter("conowner", ParameterValue.from(value))
          case PgConversionFieldValue.conforencoding(value) => NamedParameter("conforencoding", ParameterValue.from(value))
          case PgConversionFieldValue.contoencoding(value) => NamedParameter("contoencoding", ParameterValue.from(value))
          case PgConversionFieldValue.conproc(value) => NamedParameter("conproc", ParameterValue.from(value))
          case PgConversionFieldValue.condefault(value) => NamedParameter("condefault", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_conversion where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgConversionRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgConversionId, fieldValues: List[PgConversionFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgConversionFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgConversionFieldValue.conname(value) => NamedParameter("conname", ParameterValue.from(value))
          case PgConversionFieldValue.connamespace(value) => NamedParameter("connamespace", ParameterValue.from(value))
          case PgConversionFieldValue.conowner(value) => NamedParameter("conowner", ParameterValue.from(value))
          case PgConversionFieldValue.conforencoding(value) => NamedParameter("conforencoding", ParameterValue.from(value))
          case PgConversionFieldValue.contoencoding(value) => NamedParameter("contoencoding", ParameterValue.from(value))
          case PgConversionFieldValue.conproc(value) => NamedParameter("conproc", ParameterValue.from(value))
          case PgConversionFieldValue.condefault(value) => NamedParameter("condefault", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_conversion
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgConversionId, unsaved: PgConversionRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("conname", ParameterValue.from(unsaved.conname))),
      Some(NamedParameter("connamespace", ParameterValue.from(unsaved.connamespace))),
      Some(NamedParameter("conowner", ParameterValue.from(unsaved.conowner))),
      Some(NamedParameter("conforencoding", ParameterValue.from(unsaved.conforencoding))),
      Some(NamedParameter("contoencoding", ParameterValue.from(unsaved.contoencoding))),
      Some(NamedParameter("conproc", ParameterValue.from(unsaved.conproc))),
      Some(NamedParameter("condefault", ParameterValue.from(unsaved.condefault)))
    ).flatten

    SQL"""insert into pg_catalog.pg_conversion(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgConversionId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_conversion where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(connamespace: Long, conforencoding: Int, contoencoding: Int, oid: Long)(implicit c: Connection): Option[PgConversionRow] = {
    ???
  }
  override def selectByUnique(conname: String, connamespace: Long)(implicit c: Connection): Option[PgConversionRow] = {
    ???
  }
}
