package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgEventTriggerRepoImpl extends PgEventTriggerRepo {
  override def selectAll(implicit c: Connection): List[PgEventTriggerRow] = {
    SQL"""select oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags from pg_catalog.pg_event_trigger""".as(PgEventTriggerRow.rowParser.*)
  }
  override def selectById(oid: PgEventTriggerId)(implicit c: Connection): Option[PgEventTriggerRow] = {
    SQL"""select oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags from pg_catalog.pg_event_trigger where oid = $oid""".as(PgEventTriggerRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgEventTriggerId])(implicit c: Connection): List[PgEventTriggerRow] = {
    SQL"""select oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags from pg_catalog.pg_event_trigger where oid in $oids""".as(PgEventTriggerRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgEventTriggerFieldValue[_]])(implicit c: Connection): List[PgEventTriggerRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgEventTriggerFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtname(value) => NamedParameter("evtname", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtevent(value) => NamedParameter("evtevent", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtowner(value) => NamedParameter("evtowner", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtfoid(value) => NamedParameter("evtfoid", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtenabled(value) => NamedParameter("evtenabled", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evttags(value) => NamedParameter("evttags", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_event_trigger where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgEventTriggerRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgEventTriggerId, fieldValues: List[PgEventTriggerFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgEventTriggerFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtname(value) => NamedParameter("evtname", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtevent(value) => NamedParameter("evtevent", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtowner(value) => NamedParameter("evtowner", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtfoid(value) => NamedParameter("evtfoid", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evtenabled(value) => NamedParameter("evtenabled", ParameterValue.from(value))
          case PgEventTriggerFieldValue.evttags(value) => NamedParameter("evttags", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_event_trigger
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgEventTriggerId, unsaved: PgEventTriggerRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("evtname", ParameterValue.from(unsaved.evtname))),
      Some(NamedParameter("evtevent", ParameterValue.from(unsaved.evtevent))),
      Some(NamedParameter("evtowner", ParameterValue.from(unsaved.evtowner))),
      Some(NamedParameter("evtfoid", ParameterValue.from(unsaved.evtfoid))),
      Some(NamedParameter("evtenabled", ParameterValue.from(unsaved.evtenabled))),
      Some(NamedParameter("evttags", ParameterValue.from(unsaved.evttags)))
    ).flatten

    SQL"""insert into pg_catalog.pg_event_trigger(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgEventTriggerId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_event_trigger where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(evtname: String)(implicit c: Connection): Option[PgEventTriggerRow] = {
    ???
  }
}
