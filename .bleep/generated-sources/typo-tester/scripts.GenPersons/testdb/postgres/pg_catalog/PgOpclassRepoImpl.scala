package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgOpclassRepoImpl extends PgOpclassRepo {
  override def selectAll(implicit c: Connection): List[PgOpclassRow] = {
    SQL"""select oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype from pg_catalog.pg_opclass""".as(PgOpclassRow.rowParser.*)
  }
  override def selectById(oid: PgOpclassId)(implicit c: Connection): Option[PgOpclassRow] = {
    SQL"""select oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype from pg_catalog.pg_opclass where oid = $oid""".as(PgOpclassRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgOpclassId])(implicit c: Connection): List[PgOpclassRow] = {
    SQL"""select oid, opcmethod, opcname, opcnamespace, opcowner, opcfamily, opcintype, opcdefault, opckeytype from pg_catalog.pg_opclass where oid in $oids""".as(PgOpclassRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgOpclassFieldValue[_]])(implicit c: Connection): List[PgOpclassRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgOpclassFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgOpclassFieldValue.opcmethod(value) => NamedParameter("opcmethod", ParameterValue.from(value))
          case PgOpclassFieldValue.opcname(value) => NamedParameter("opcname", ParameterValue.from(value))
          case PgOpclassFieldValue.opcnamespace(value) => NamedParameter("opcnamespace", ParameterValue.from(value))
          case PgOpclassFieldValue.opcowner(value) => NamedParameter("opcowner", ParameterValue.from(value))
          case PgOpclassFieldValue.opcfamily(value) => NamedParameter("opcfamily", ParameterValue.from(value))
          case PgOpclassFieldValue.opcintype(value) => NamedParameter("opcintype", ParameterValue.from(value))
          case PgOpclassFieldValue.opcdefault(value) => NamedParameter("opcdefault", ParameterValue.from(value))
          case PgOpclassFieldValue.opckeytype(value) => NamedParameter("opckeytype", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_opclass where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgOpclassRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgOpclassId, fieldValues: List[PgOpclassFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgOpclassFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgOpclassFieldValue.opcmethod(value) => NamedParameter("opcmethod", ParameterValue.from(value))
          case PgOpclassFieldValue.opcname(value) => NamedParameter("opcname", ParameterValue.from(value))
          case PgOpclassFieldValue.opcnamespace(value) => NamedParameter("opcnamespace", ParameterValue.from(value))
          case PgOpclassFieldValue.opcowner(value) => NamedParameter("opcowner", ParameterValue.from(value))
          case PgOpclassFieldValue.opcfamily(value) => NamedParameter("opcfamily", ParameterValue.from(value))
          case PgOpclassFieldValue.opcintype(value) => NamedParameter("opcintype", ParameterValue.from(value))
          case PgOpclassFieldValue.opcdefault(value) => NamedParameter("opcdefault", ParameterValue.from(value))
          case PgOpclassFieldValue.opckeytype(value) => NamedParameter("opckeytype", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_opclass
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgOpclassId, unsaved: PgOpclassRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("opcmethod", ParameterValue.from(unsaved.opcmethod))),
      Some(NamedParameter("opcname", ParameterValue.from(unsaved.opcname))),
      Some(NamedParameter("opcnamespace", ParameterValue.from(unsaved.opcnamespace))),
      Some(NamedParameter("opcowner", ParameterValue.from(unsaved.opcowner))),
      Some(NamedParameter("opcfamily", ParameterValue.from(unsaved.opcfamily))),
      Some(NamedParameter("opcintype", ParameterValue.from(unsaved.opcintype))),
      Some(NamedParameter("opcdefault", ParameterValue.from(unsaved.opcdefault))),
      Some(NamedParameter("opckeytype", ParameterValue.from(unsaved.opckeytype)))
    ).flatten

    SQL"""insert into pg_catalog.pg_opclass(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgOpclassId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_opclass where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(opcmethod: Long, opcname: String, opcnamespace: Long)(implicit c: Connection): Option[PgOpclassRow] = {
    ???
  }
}
