/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog



case class PgDatabaseRowUnsaved(
  datname: String,
  datdba: Long,
  encoding: Int,
  datcollate: String,
  datctype: String,
  datistemplate: Boolean,
  datallowconn: Boolean,
  datconnlimit: Int,
  datlastsysoid: Long,
  datfrozenxid: String,
  datminmxid: String,
  dattablespace: Long,
  datacl: Option[Array[String]]
)
object PgDatabaseRowUnsaved {
  
}