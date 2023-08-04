/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_ssl

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgStatSslViewRepoImpl extends PgStatSslViewRepo {
  override def select: SelectBuilder[PgStatSslViewFields, PgStatSslViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_ssl", PgStatSslViewFields, PgStatSslViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgStatSslViewRow] = {
    SQL"""select pid, ssl, "version", cipher, bits, client_dn, client_serial, issuer_dn
          from pg_catalog.pg_stat_ssl
       """.as(PgStatSslViewRow.rowParser(1).*)
  }
}