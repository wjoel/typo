package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgShdescriptionRepoImpl extends PgShdescriptionRepo {
  override def selectAll(implicit c: Connection): List[PgShdescriptionRow] = {
    SQL"""select objoid, classoid, description from pg_catalog.pg_shdescription""".as(PgShdescriptionRow.rowParser.*)
  }
  override def selectById(compositeId: PgShdescriptionId)(implicit c: Connection): Option[PgShdescriptionRow] = {
    SQL"""select objoid, classoid, description from pg_catalog.pg_shdescription where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}""".as(PgShdescriptionRow.rowParser.singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgShdescriptionFieldValue[_]])(implicit c: Connection): List[PgShdescriptionRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgShdescriptionFieldValue.objoid(value) => NamedParameter("objoid", ParameterValue.from(value))
          case PgShdescriptionFieldValue.classoid(value) => NamedParameter("classoid", ParameterValue.from(value))
          case PgShdescriptionFieldValue.description(value) => NamedParameter("description", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_shdescription where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgShdescriptionRow.rowParser.*)
    }

  }
  override def updateFieldValues(compositeId: PgShdescriptionId, fieldValues: List[PgShdescriptionFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgShdescriptionFieldValue.objoid(value) => NamedParameter("objoid", ParameterValue.from(value))
          case PgShdescriptionFieldValue.classoid(value) => NamedParameter("classoid", ParameterValue.from(value))
          case PgShdescriptionFieldValue.description(value) => NamedParameter("description", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_shdescription
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(compositeId: PgShdescriptionId, unsaved: PgShdescriptionRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("description", ParameterValue.from(unsaved.description)))
    ).flatten

    SQL"""insert into pg_catalog.pg_shdescription(objoid, classoid, ${namedParameters.map(_.name).mkString(", ")})
      values (${compositeId.objoid}, ${compositeId.classoid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(compositeId: PgShdescriptionId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_shdescription where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}""".executeUpdate() > 0
  }
}
