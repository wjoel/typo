/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog



case class PgClassRowUnsaved(
  relname: String,
  relnamespace: Long,
  reltype: Long,
  reloftype: Long,
  relowner: Long,
  relam: Long,
  relfilenode: Long,
  reltablespace: Long,
  relpages: Int,
  reltuples: Float,
  relallvisible: Int,
  reltoastrelid: Long,
  relhasindex: Boolean,
  relisshared: Boolean,
  relpersistence: String,
  relkind: String,
  relnatts: Short,
  relchecks: Short,
  relhasrules: Boolean,
  relhastriggers: Boolean,
  relhassubclass: Boolean,
  relrowsecurity: Boolean,
  relforcerowsecurity: Boolean,
  relispopulated: Boolean,
  relreplident: String,
  relispartition: Boolean,
  relrewrite: Long,
  relfrozenxid: String,
  relminmxid: String,
  relacl: Option[Array[String]],
  reloptions: Option[Array[String]],
  relpartbound: Option[String]
)
object PgClassRowUnsaved {
  
}
