package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgAmRepoImpl extends PgAmRepo {
  override def selectAll(implicit c: Connection): List[PgAmRow] = {
    SQL"""select oid, amname, amhandler, amtype from pg_catalog.pg_am""".as(PgAmRow.rowParser.*)
  }
  override def selectById(oid: PgAmId)(implicit c: Connection): Option[PgAmRow] = {
    SQL"""select oid, amname, amhandler, amtype from pg_catalog.pg_am where oid = $oid""".as(PgAmRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgAmId])(implicit c: Connection): List[PgAmRow] = {
    SQL"""select oid, amname, amhandler, amtype from pg_catalog.pg_am where oid in $oids""".as(PgAmRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgAmFieldValue[_]])(implicit c: Connection): List[PgAmRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAmFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgAmFieldValue.amname(value) => NamedParameter("amname", ParameterValue.from(value))
          case PgAmFieldValue.amhandler(value) => NamedParameter("amhandler", ParameterValue.from(value))
          case PgAmFieldValue.amtype(value) => NamedParameter("amtype", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_am where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgAmRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgAmId, fieldValues: List[PgAmFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAmFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgAmFieldValue.amname(value) => NamedParameter("amname", ParameterValue.from(value))
          case PgAmFieldValue.amhandler(value) => NamedParameter("amhandler", ParameterValue.from(value))
          case PgAmFieldValue.amtype(value) => NamedParameter("amtype", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_am
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgAmId, unsaved: PgAmRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("amname", ParameterValue.from(unsaved.amname))),
      Some(NamedParameter("amhandler", ParameterValue.from(unsaved.amhandler))),
      Some(NamedParameter("amtype", ParameterValue.from(unsaved.amtype)))
    ).flatten

    SQL"""insert into pg_catalog.pg_am(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgAmId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_am where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(amname: String)(implicit c: Connection): Option[PgAmRow] = {
    ???
  }
}
