package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgTriggerRepoImpl extends PgTriggerRepo {
  override def selectAll(implicit c: Connection): List[PgTriggerRow] = {
    SQL"""select oid, tgrelid, tgparentid, tgname, tgfoid, tgtype, tgenabled, tgisinternal, tgconstrrelid, tgconstrindid, tgconstraint, tgdeferrable, tginitdeferred, tgnargs, tgattr, tgargs, tgqual, tgoldtable, tgnewtable from pg_catalog.pg_trigger""".as(PgTriggerRow.rowParser.*)
  }
  override def selectById(oid: PgTriggerId)(implicit c: Connection): Option[PgTriggerRow] = {
    SQL"""select oid, tgrelid, tgparentid, tgname, tgfoid, tgtype, tgenabled, tgisinternal, tgconstrrelid, tgconstrindid, tgconstraint, tgdeferrable, tginitdeferred, tgnargs, tgattr, tgargs, tgqual, tgoldtable, tgnewtable from pg_catalog.pg_trigger where oid = $oid""".as(PgTriggerRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgTriggerId])(implicit c: Connection): List[PgTriggerRow] = {
    SQL"""select oid, tgrelid, tgparentid, tgname, tgfoid, tgtype, tgenabled, tgisinternal, tgconstrrelid, tgconstrindid, tgconstraint, tgdeferrable, tginitdeferred, tgnargs, tgattr, tgargs, tgqual, tgoldtable, tgnewtable from pg_catalog.pg_trigger where oid in $oids""".as(PgTriggerRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgTriggerFieldValue[_]])(implicit c: Connection): List[PgTriggerRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTriggerFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgrelid(value) => NamedParameter("tgrelid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgparentid(value) => NamedParameter("tgparentid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgname(value) => NamedParameter("tgname", ParameterValue.from(value))
          case PgTriggerFieldValue.tgfoid(value) => NamedParameter("tgfoid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgtype(value) => NamedParameter("tgtype", ParameterValue.from(value))
          case PgTriggerFieldValue.tgenabled(value) => NamedParameter("tgenabled", ParameterValue.from(value))
          case PgTriggerFieldValue.tgisinternal(value) => NamedParameter("tgisinternal", ParameterValue.from(value))
          case PgTriggerFieldValue.tgconstrrelid(value) => NamedParameter("tgconstrrelid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgconstrindid(value) => NamedParameter("tgconstrindid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgconstraint(value) => NamedParameter("tgconstraint", ParameterValue.from(value))
          case PgTriggerFieldValue.tgdeferrable(value) => NamedParameter("tgdeferrable", ParameterValue.from(value))
          case PgTriggerFieldValue.tginitdeferred(value) => NamedParameter("tginitdeferred", ParameterValue.from(value))
          case PgTriggerFieldValue.tgnargs(value) => NamedParameter("tgnargs", ParameterValue.from(value))
          case PgTriggerFieldValue.tgattr(value) => NamedParameter("tgattr", ParameterValue.from(value))
          case PgTriggerFieldValue.tgargs(value) => NamedParameter("tgargs", ParameterValue.from(value))
          case PgTriggerFieldValue.tgqual(value) => NamedParameter("tgqual", ParameterValue.from(value))
          case PgTriggerFieldValue.tgoldtable(value) => NamedParameter("tgoldtable", ParameterValue.from(value))
          case PgTriggerFieldValue.tgnewtable(value) => NamedParameter("tgnewtable", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_trigger where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgTriggerRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgTriggerId, fieldValues: List[PgTriggerFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTriggerFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgrelid(value) => NamedParameter("tgrelid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgparentid(value) => NamedParameter("tgparentid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgname(value) => NamedParameter("tgname", ParameterValue.from(value))
          case PgTriggerFieldValue.tgfoid(value) => NamedParameter("tgfoid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgtype(value) => NamedParameter("tgtype", ParameterValue.from(value))
          case PgTriggerFieldValue.tgenabled(value) => NamedParameter("tgenabled", ParameterValue.from(value))
          case PgTriggerFieldValue.tgisinternal(value) => NamedParameter("tgisinternal", ParameterValue.from(value))
          case PgTriggerFieldValue.tgconstrrelid(value) => NamedParameter("tgconstrrelid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgconstrindid(value) => NamedParameter("tgconstrindid", ParameterValue.from(value))
          case PgTriggerFieldValue.tgconstraint(value) => NamedParameter("tgconstraint", ParameterValue.from(value))
          case PgTriggerFieldValue.tgdeferrable(value) => NamedParameter("tgdeferrable", ParameterValue.from(value))
          case PgTriggerFieldValue.tginitdeferred(value) => NamedParameter("tginitdeferred", ParameterValue.from(value))
          case PgTriggerFieldValue.tgnargs(value) => NamedParameter("tgnargs", ParameterValue.from(value))
          case PgTriggerFieldValue.tgattr(value) => NamedParameter("tgattr", ParameterValue.from(value))
          case PgTriggerFieldValue.tgargs(value) => NamedParameter("tgargs", ParameterValue.from(value))
          case PgTriggerFieldValue.tgqual(value) => NamedParameter("tgqual", ParameterValue.from(value))
          case PgTriggerFieldValue.tgoldtable(value) => NamedParameter("tgoldtable", ParameterValue.from(value))
          case PgTriggerFieldValue.tgnewtable(value) => NamedParameter("tgnewtable", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_trigger
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgTriggerId, unsaved: PgTriggerRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("tgrelid", ParameterValue.from(unsaved.tgrelid))),
      Some(NamedParameter("tgparentid", ParameterValue.from(unsaved.tgparentid))),
      Some(NamedParameter("tgname", ParameterValue.from(unsaved.tgname))),
      Some(NamedParameter("tgfoid", ParameterValue.from(unsaved.tgfoid))),
      Some(NamedParameter("tgtype", ParameterValue.from(unsaved.tgtype))),
      Some(NamedParameter("tgenabled", ParameterValue.from(unsaved.tgenabled))),
      Some(NamedParameter("tgisinternal", ParameterValue.from(unsaved.tgisinternal))),
      Some(NamedParameter("tgconstrrelid", ParameterValue.from(unsaved.tgconstrrelid))),
      Some(NamedParameter("tgconstrindid", ParameterValue.from(unsaved.tgconstrindid))),
      Some(NamedParameter("tgconstraint", ParameterValue.from(unsaved.tgconstraint))),
      Some(NamedParameter("tgdeferrable", ParameterValue.from(unsaved.tgdeferrable))),
      Some(NamedParameter("tginitdeferred", ParameterValue.from(unsaved.tginitdeferred))),
      Some(NamedParameter("tgnargs", ParameterValue.from(unsaved.tgnargs))),
      Some(NamedParameter("tgattr", ParameterValue.from(unsaved.tgattr))),
      Some(NamedParameter("tgargs", ParameterValue.from(unsaved.tgargs))),
      Some(NamedParameter("tgqual", ParameterValue.from(unsaved.tgqual))),
      Some(NamedParameter("tgoldtable", ParameterValue.from(unsaved.tgoldtable))),
      Some(NamedParameter("tgnewtable", ParameterValue.from(unsaved.tgnewtable)))
    ).flatten

    SQL"""insert into pg_catalog.pg_trigger(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgTriggerId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_trigger where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(tgrelid: Long, tgname: String)(implicit c: Connection): Option[PgTriggerRow] = {
    ???
  }
}
