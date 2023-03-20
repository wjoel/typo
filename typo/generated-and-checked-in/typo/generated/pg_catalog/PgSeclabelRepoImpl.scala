/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgSeclabelRepoImpl extends PgSeclabelRepo {
  override def selectAll(implicit c: Connection): List[PgSeclabelRow] = {
    SQL"""select objoid, classoid, objsubid, provider, label from pg_catalog.pg_seclabel""".as(PgSeclabelRow.rowParser.*)
  }
  override def selectById(compositeId: PgSeclabelId)(implicit c: Connection): Option[PgSeclabelRow] = {
    SQL"""select objoid, classoid, objsubid, provider, label from pg_catalog.pg_seclabel where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}, objsubid = ${compositeId.objsubid}, provider = ${compositeId.provider}""".as(PgSeclabelRow.rowParser.singleOpt)
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
        val q = s"""select * from pg_catalog.pg_seclabel where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgSeclabelRow.rowParser.*)
    }

  }
  override def updateFieldValues(compositeId: PgSeclabelId, fieldValues: List[PgSeclabelFieldValue[_]])(implicit c: Connection): Int = {
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
        val q = s"""update pg_catalog.pg_seclabel
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}, objsubid = ${compositeId.objsubid}, provider = ${compositeId.provider}"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(compositeId: PgSeclabelId, unsaved: PgSeclabelRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("label", ParameterValue.from(unsaved.label)))
    ).flatten

    SQL"""insert into pg_catalog.pg_seclabel(objoid, classoid, objsubid, provider, ${namedParameters.map(_.name).mkString(", ")})
      values (${compositeId.objoid}, ${compositeId.classoid}, ${compositeId.objsubid}, ${compositeId.provider}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(compositeId: PgSeclabelId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_seclabel where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}, objsubid = ${compositeId.objsubid}, provider = ${compositeId.provider}""".executeUpdate() > 0
  }
}
