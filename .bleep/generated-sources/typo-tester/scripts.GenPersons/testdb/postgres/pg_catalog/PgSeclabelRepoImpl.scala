package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgSeclabelRepoImpl extends PgSeclabelRepo {
  override def selectAll(implicit c: Connection): List[PgSeclabelRow] = {
    SQL"""select objoid, classoid, objsubid, provider, label from pg_catalog.pg_seclabel""".as(PgSeclabelRow.rowParser.*)
  }
  override def selectById(objoidAndClassoidAndObjsubidAndProvider: PgSeclabelId)(implicit c: Connection): Option[PgSeclabelRow] = {
    SQL"""select objoid, classoid, objsubid, provider, label from pg_catalog.pg_seclabel where objoid = ${objoidAndClassoidAndObjsubidAndProvider.objoid}, classoid = ${objoidAndClassoidAndObjsubidAndProvider.classoid}, objsubid = ${objoidAndClassoidAndObjsubidAndProvider.objsubid}, provider = ${objoidAndClassoidAndObjsubidAndProvider.provider}""".as(PgSeclabelRow.rowParser.singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgSeclabelFieldValue[_]])(implicit c: Connection): List[PgSeclabelRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSeclabelFieldValue.objoid(value) => NamedParameter("objoid", ParameterValue.from(value))
          case PgSeclabelFieldValue.classoid(value) => NamedParameter("classoid", ParameterValue.from(value))
          case PgSeclabelFieldValue.objsubid(value) => NamedParameter("objsubid", ParameterValue.from(value))
          case PgSeclabelFieldValue.provider(value) => NamedParameter("provider", ParameterValue.from(value))
          case PgSeclabelFieldValue.label(value) => NamedParameter("label", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_seclabel where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgSeclabelRow.rowParser.*)
    }

  }
  override def updateFieldValues(objoidAndClassoidAndObjsubidAndProvider: PgSeclabelId, fieldValues: List[PgSeclabelFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSeclabelFieldValue.objoid(value) => NamedParameter("objoid", ParameterValue.from(value))
          case PgSeclabelFieldValue.classoid(value) => NamedParameter("classoid", ParameterValue.from(value))
          case PgSeclabelFieldValue.objsubid(value) => NamedParameter("objsubid", ParameterValue.from(value))
          case PgSeclabelFieldValue.provider(value) => NamedParameter("provider", ParameterValue.from(value))
          case PgSeclabelFieldValue.label(value) => NamedParameter("label", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_seclabel
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where objoid = ${objoidAndClassoidAndObjsubidAndProvider.objoid}, classoid = ${objoidAndClassoidAndObjsubidAndProvider.classoid}, objsubid = ${objoidAndClassoidAndObjsubidAndProvider.objsubid}, provider = ${objoidAndClassoidAndObjsubidAndProvider.provider}"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(objoidAndClassoidAndObjsubidAndProvider: PgSeclabelId, unsaved: PgSeclabelRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("label", ParameterValue.from(unsaved.label)))
    ).flatten

    SQL"""insert into pg_catalog.pg_seclabel(objoid, classoid, objsubid, provider, ${namedParameters.map(_.name).mkString(", ")})
      values (${objoidAndClassoidAndObjsubidAndProvider.objoid}, ${objoidAndClassoidAndObjsubidAndProvider.classoid}, ${objoidAndClassoidAndObjsubidAndProvider.objsubid}, ${objoidAndClassoidAndObjsubidAndProvider.provider}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(objoidAndClassoidAndObjsubidAndProvider: PgSeclabelId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_seclabel where objoid = ${objoidAndClassoidAndObjsubidAndProvider.objoid}, classoid = ${objoidAndClassoidAndObjsubidAndProvider.classoid}, objsubid = ${objoidAndClassoidAndObjsubidAndProvider.objsubid}, provider = ${objoidAndClassoidAndObjsubidAndProvider.provider}""".executeUpdate() > 0
  }
}
