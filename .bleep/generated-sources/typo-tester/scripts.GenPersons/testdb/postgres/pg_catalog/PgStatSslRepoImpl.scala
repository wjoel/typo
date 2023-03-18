package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatSslRepoImpl extends PgStatSslRepo {
  override def selectAll(implicit c: Connection): List[PgStatSslRow] = {
    SQL"""select pid, ssl, version, cipher, bits, client_dn, client_serial, issuer_dn from pg_catalog.pg_stat_ssl""".as(PgStatSslRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatSslFieldValue[_]])(implicit c: Connection): List[PgStatSslRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatSslFieldValue.pid(value) => NamedParameter("pid", ParameterValue.from(value))
          case PgStatSslFieldValue.ssl(value) => NamedParameter("ssl", ParameterValue.from(value))
          case PgStatSslFieldValue.version(value) => NamedParameter("version", ParameterValue.from(value))
          case PgStatSslFieldValue.cipher(value) => NamedParameter("cipher", ParameterValue.from(value))
          case PgStatSslFieldValue.bits(value) => NamedParameter("bits", ParameterValue.from(value))
          case PgStatSslFieldValue.clientDn(value) => NamedParameter("client_dn", ParameterValue.from(value))
          case PgStatSslFieldValue.clientSerial(value) => NamedParameter("client_serial", ParameterValue.from(value))
          case PgStatSslFieldValue.issuerDn(value) => NamedParameter("issuer_dn", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_ssl where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatSslRow.rowParser.*)
    }

  }
}