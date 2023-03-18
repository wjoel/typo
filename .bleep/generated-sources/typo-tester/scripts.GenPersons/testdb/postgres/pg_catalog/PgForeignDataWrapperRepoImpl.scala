package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgForeignDataWrapperRepoImpl extends PgForeignDataWrapperRepo {
  override def selectAll(implicit c: Connection): List[PgForeignDataWrapperRow] = {
    SQL"""select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper""".as(PgForeignDataWrapperRow.rowParser.*)
  }
  override def selectById(oid: PgForeignDataWrapperId)(implicit c: Connection): Option[PgForeignDataWrapperRow] = {
    SQL"""select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper where oid = $oid""".as(PgForeignDataWrapperRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgForeignDataWrapperId])(implicit c: Connection): List[PgForeignDataWrapperRow] = {
    SQL"""select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper where oid in $oids""".as(PgForeignDataWrapperRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgForeignDataWrapperFieldValue[_]])(implicit c: Connection): List[PgForeignDataWrapperRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignDataWrapperFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwname(value) => NamedParameter("fdwname", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwowner(value) => NamedParameter("fdwowner", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwhandler(value) => NamedParameter("fdwhandler", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwvalidator(value) => NamedParameter("fdwvalidator", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwacl(value) => NamedParameter("fdwacl", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwoptions(value) => NamedParameter("fdwoptions", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_foreign_data_wrapper where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgForeignDataWrapperRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgForeignDataWrapperId, fieldValues: List[PgForeignDataWrapperFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignDataWrapperFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwname(value) => NamedParameter("fdwname", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwowner(value) => NamedParameter("fdwowner", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwhandler(value) => NamedParameter("fdwhandler", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwvalidator(value) => NamedParameter("fdwvalidator", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwacl(value) => NamedParameter("fdwacl", ParameterValue.from(value))
          case PgForeignDataWrapperFieldValue.fdwoptions(value) => NamedParameter("fdwoptions", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_foreign_data_wrapper
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgForeignDataWrapperId, unsaved: PgForeignDataWrapperRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("fdwname", ParameterValue.from(unsaved.fdwname))),
      Some(NamedParameter("fdwowner", ParameterValue.from(unsaved.fdwowner))),
      Some(NamedParameter("fdwhandler", ParameterValue.from(unsaved.fdwhandler))),
      Some(NamedParameter("fdwvalidator", ParameterValue.from(unsaved.fdwvalidator))),
      Some(NamedParameter("fdwacl", ParameterValue.from(unsaved.fdwacl))),
      Some(NamedParameter("fdwoptions", ParameterValue.from(unsaved.fdwoptions)))
    ).flatten

    SQL"""insert into pg_catalog.pg_foreign_data_wrapper(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgForeignDataWrapperId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_foreign_data_wrapper where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(fdwname: String)(implicit c: Connection): Option[PgForeignDataWrapperRow] = {
    ???
  }
}
