package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgTransformRepoImpl extends PgTransformRepo {
  override def selectAll(implicit c: Connection): List[PgTransformRow] = {
    SQL"""select oid, trftype, trflang, trffromsql, trftosql from pg_catalog.pg_transform""".as(PgTransformRow.rowParser.*)
  }
  override def selectById(oid: PgTransformId)(implicit c: Connection): Option[PgTransformRow] = {
    SQL"""select oid, trftype, trflang, trffromsql, trftosql from pg_catalog.pg_transform where oid = $oid""".as(PgTransformRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgTransformId])(implicit c: Connection): List[PgTransformRow] = {
    SQL"""select oid, trftype, trflang, trffromsql, trftosql from pg_catalog.pg_transform where oid in $oids""".as(PgTransformRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgTransformFieldValue[_]])(implicit c: Connection): List[PgTransformRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTransformFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTransformFieldValue.trftype(value) => NamedParameter("trftype", ParameterValue.from(value))
          case PgTransformFieldValue.trflang(value) => NamedParameter("trflang", ParameterValue.from(value))
          case PgTransformFieldValue.trffromsql(value) => NamedParameter("trffromsql", ParameterValue.from(value))
          case PgTransformFieldValue.trftosql(value) => NamedParameter("trftosql", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_transform where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgTransformRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgTransformId, fieldValues: List[PgTransformFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTransformFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTransformFieldValue.trftype(value) => NamedParameter("trftype", ParameterValue.from(value))
          case PgTransformFieldValue.trflang(value) => NamedParameter("trflang", ParameterValue.from(value))
          case PgTransformFieldValue.trffromsql(value) => NamedParameter("trffromsql", ParameterValue.from(value))
          case PgTransformFieldValue.trftosql(value) => NamedParameter("trftosql", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_transform
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgTransformId, unsaved: PgTransformRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("trftype", ParameterValue.from(unsaved.trftype))),
      Some(NamedParameter("trflang", ParameterValue.from(unsaved.trflang))),
      Some(NamedParameter("trffromsql", ParameterValue.from(unsaved.trffromsql))),
      Some(NamedParameter("trftosql", ParameterValue.from(unsaved.trftosql)))
    ).flatten

    SQL"""insert into pg_catalog.pg_transform(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgTransformId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_transform where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(trftype: Long, trflang: Long)(implicit c: Connection): Option[PgTransformRow] = {
    ???
  }
}
