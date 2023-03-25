/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgStatSubscriptionRepoImpl extends PgStatSubscriptionRepo {
  override def selectAll(implicit c: Connection): List[PgStatSubscriptionRow] = {
    SQL"""select subid, subname, pid, relid, received_lsn, last_msg_send_time, last_msg_receipt_time, latest_end_lsn, latest_end_time from pg_catalog.pg_stat_subscription""".as(PgStatSubscriptionRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatSubscriptionFieldValue[_]])(implicit c: Connection): List[PgStatSubscriptionRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatSubscriptionFieldValue.subid(value) => NamedParameter("subid", ParameterValue.from(value))
          case PgStatSubscriptionFieldValue.subname(value) => NamedParameter("subname", ParameterValue.from(value))
          case PgStatSubscriptionFieldValue.pid(value) => NamedParameter("pid", ParameterValue.from(value))
          case PgStatSubscriptionFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatSubscriptionFieldValue.receivedLsn(value) => NamedParameter("received_lsn", ParameterValue.from(value))
          case PgStatSubscriptionFieldValue.lastMsgSendTime(value) => NamedParameter("last_msg_send_time", ParameterValue.from(value))
          case PgStatSubscriptionFieldValue.lastMsgReceiptTime(value) => NamedParameter("last_msg_receipt_time", ParameterValue.from(value))
          case PgStatSubscriptionFieldValue.latestEndLsn(value) => NamedParameter("latest_end_lsn", ParameterValue.from(value))
          case PgStatSubscriptionFieldValue.latestEndTime(value) => NamedParameter("latest_end_time", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_stat_subscription where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatSubscriptionRow.rowParser("").*)
    }

  }
}
