package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgRewriteRepoImpl extends PgRewriteRepo {
  override def selectAll(implicit c: Connection): List[PgRewriteRow] = {
    SQL"""select oid, rulename, ev_class, ev_type, ev_enabled, is_instead, ev_qual, ev_action from pg_catalog.pg_rewrite""".as(PgRewriteRow.rowParser.*)
  }
  override def selectById(oid: PgRewriteId)(implicit c: Connection): Option[PgRewriteRow] = {
    SQL"""select oid, rulename, ev_class, ev_type, ev_enabled, is_instead, ev_qual, ev_action from pg_catalog.pg_rewrite where oid = $oid""".as(PgRewriteRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgRewriteId])(implicit c: Connection): List[PgRewriteRow] = {
    SQL"""select oid, rulename, ev_class, ev_type, ev_enabled, is_instead, ev_qual, ev_action from pg_catalog.pg_rewrite where oid in $oids""".as(PgRewriteRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgRewriteFieldValue[_]])(implicit c: Connection): List[PgRewriteRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgRewriteFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgRewriteFieldValue.rulename(value) => NamedParameter("rulename", ParameterValue.from(value))
          case PgRewriteFieldValue.evClass(value) => NamedParameter("ev_class", ParameterValue.from(value))
          case PgRewriteFieldValue.evType(value) => NamedParameter("ev_type", ParameterValue.from(value))
          case PgRewriteFieldValue.evEnabled(value) => NamedParameter("ev_enabled", ParameterValue.from(value))
          case PgRewriteFieldValue.isInstead(value) => NamedParameter("is_instead", ParameterValue.from(value))
          case PgRewriteFieldValue.evQual(value) => NamedParameter("ev_qual", ParameterValue.from(value))
          case PgRewriteFieldValue.evAction(value) => NamedParameter("ev_action", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_rewrite where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgRewriteRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgRewriteId, fieldValues: List[PgRewriteFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgRewriteFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgRewriteFieldValue.rulename(value) => NamedParameter("rulename", ParameterValue.from(value))
          case PgRewriteFieldValue.evClass(value) => NamedParameter("ev_class", ParameterValue.from(value))
          case PgRewriteFieldValue.evType(value) => NamedParameter("ev_type", ParameterValue.from(value))
          case PgRewriteFieldValue.evEnabled(value) => NamedParameter("ev_enabled", ParameterValue.from(value))
          case PgRewriteFieldValue.isInstead(value) => NamedParameter("is_instead", ParameterValue.from(value))
          case PgRewriteFieldValue.evQual(value) => NamedParameter("ev_qual", ParameterValue.from(value))
          case PgRewriteFieldValue.evAction(value) => NamedParameter("ev_action", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_rewrite
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgRewriteId, unsaved: PgRewriteRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("rulename", ParameterValue.from(unsaved.rulename))),
      Some(NamedParameter("ev_class", ParameterValue.from(unsaved.evClass))),
      Some(NamedParameter("ev_type", ParameterValue.from(unsaved.evType))),
      Some(NamedParameter("ev_enabled", ParameterValue.from(unsaved.evEnabled))),
      Some(NamedParameter("is_instead", ParameterValue.from(unsaved.isInstead))),
      Some(NamedParameter("ev_qual", ParameterValue.from(unsaved.evQual))),
      Some(NamedParameter("ev_action", ParameterValue.from(unsaved.evAction)))
    ).flatten

    SQL"""insert into pg_catalog.pg_rewrite(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgRewriteId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_rewrite where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(evClass: Long, rulename: String)(implicit c: Connection): Option[PgRewriteRow] = {
    ???
  }
}
