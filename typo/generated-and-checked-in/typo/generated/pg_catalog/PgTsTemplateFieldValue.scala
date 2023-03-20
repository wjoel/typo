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



sealed abstract class PgTsTemplateFieldValue[T](val name: String, val value: T)

object PgTsTemplateFieldValue {
  case class oid(override val value: PgTsTemplateId) extends PgTsTemplateFieldValue("oid", value)
  case class tmplname(override val value: String) extends PgTsTemplateFieldValue("tmplname", value)
  case class tmplnamespace(override val value: Long) extends PgTsTemplateFieldValue("tmplnamespace", value)
  case class tmplinit(override val value: String) extends PgTsTemplateFieldValue("tmplinit", value)
  case class tmpllexize(override val value: String) extends PgTsTemplateFieldValue("tmpllexize", value)
}