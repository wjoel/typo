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



case class PgProcRowUnsaved(
  proname: String,
  pronamespace: Long,
  proowner: Long,
  prolang: Long,
  procost: Float,
  prorows: Float,
  provariadic: Long,
  prosupport: String,
  prokind: String,
  prosecdef: Boolean,
  proleakproof: Boolean,
  proisstrict: Boolean,
  proretset: Boolean,
  provolatile: String,
  proparallel: String,
  pronargs: Short,
  pronargdefaults: Short,
  prorettype: Long,
  proargtypes: String,
  proallargtypes: Option[Array[Long]],
  proargmodes: Option[Array[String]],
  proargnames: Option[Array[String]],
  proargdefaults: Option[String],
  protrftypes: Option[Array[Long]],
  prosrc: String,
  probin: Option[String],
  prosqlbody: Option[String],
  proconfig: Option[Array[String]],
  proacl: Option[Array[String]]
)
object PgProcRowUnsaved {
  
}
