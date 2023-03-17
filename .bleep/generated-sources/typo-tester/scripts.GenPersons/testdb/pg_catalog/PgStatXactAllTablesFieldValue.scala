package testdb.pg_catalog



sealed abstract class PgStatXactAllTablesFieldValue[T](val name: String, val value: T)

object PgStatXactAllTablesFieldValue {
  case class relid(override val value: Long) extends PgStatXactAllTablesFieldValue("relid", value)
  case class schemaname(override val value: String) extends PgStatXactAllTablesFieldValue("schemaname", value)
  case class relname(override val value: String) extends PgStatXactAllTablesFieldValue("relname", value)
  case class seqScan(override val value: /* unknown nullability */ Option[Long]) extends PgStatXactAllTablesFieldValue("seq_scan", value)
  case class seqTupRead(override val value: /* unknown nullability */ Option[Long]) extends PgStatXactAllTablesFieldValue("seq_tup_read", value)
  case class idxScan(override val value: /* unknown nullability */ Option[Long]) extends PgStatXactAllTablesFieldValue("idx_scan", value)
  case class idxTupFetch(override val value: /* unknown nullability */ Option[Long]) extends PgStatXactAllTablesFieldValue("idx_tup_fetch", value)
  case class nTupIns(override val value: /* unknown nullability */ Option[Long]) extends PgStatXactAllTablesFieldValue("n_tup_ins", value)
  case class nTupUpd(override val value: /* unknown nullability */ Option[Long]) extends PgStatXactAllTablesFieldValue("n_tup_upd", value)
  case class nTupDel(override val value: /* unknown nullability */ Option[Long]) extends PgStatXactAllTablesFieldValue("n_tup_del", value)
  case class nTupHotUpd(override val value: /* unknown nullability */ Option[Long]) extends PgStatXactAllTablesFieldValue("n_tup_hot_upd", value)
}