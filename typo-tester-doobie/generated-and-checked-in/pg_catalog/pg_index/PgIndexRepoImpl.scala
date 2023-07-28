/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_index

import adventureworks.TypoInt2Vector
import adventureworks.TypoOidVector
import adventureworks.TypoPgNodeTree
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream

object PgIndexRepoImpl extends PgIndexRepo {
  override def delete(indexrelid: PgIndexId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_index where indexrelid = ${fromWrite(indexrelid)(Write.fromPut(PgIndexId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgIndexRow): ConnectionIO[PgIndexRow] = {
    sql"""insert into pg_catalog.pg_index(indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred)
          values (${fromWrite(unsaved.indexrelid)(Write.fromPut(PgIndexId.put))}::oid, ${fromWrite(unsaved.indrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.indnatts)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.indnkeyatts)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.indisunique)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indisprimary)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indisexclusion)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indimmediate)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indisclustered)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indisvalid)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indcheckxmin)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indisready)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indislive)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indisreplident)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.indkey)(Write.fromPut(TypoInt2Vector.put))}::int2vector, ${fromWrite(unsaved.indcollation)(Write.fromPut(TypoOidVector.put))}::oidvector, ${fromWrite(unsaved.indclass)(Write.fromPut(TypoOidVector.put))}::oidvector, ${fromWrite(unsaved.indoption)(Write.fromPut(TypoInt2Vector.put))}::int2vector, ${fromWrite(unsaved.indexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree, ${fromWrite(unsaved.indpred)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree)
          returning indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred
       """.query(PgIndexRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgIndexRow] = {
    sql"select indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred from pg_catalog.pg_index".query(PgIndexRow.read).stream
  }
  override def selectById(indexrelid: PgIndexId): ConnectionIO[Option[PgIndexRow]] = {
    sql"select indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred from pg_catalog.pg_index where indexrelid = ${fromWrite(indexrelid)(Write.fromPut(PgIndexId.put))}".query(PgIndexRow.read).option
  }
  override def selectByIds(indexrelids: Array[PgIndexId]): Stream[ConnectionIO, PgIndexRow] = {
    sql"select indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred from pg_catalog.pg_index where indexrelid = ANY(${fromWrite(indexrelids)(Write.fromPut(PgIndexId.arrayPut))})".query(PgIndexRow.read).stream
  }
  override def update(row: PgIndexRow): ConnectionIO[Boolean] = {
    val indexrelid = row.indexrelid
    sql"""update pg_catalog.pg_index
          set indrelid = ${fromWrite(row.indrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              indnatts = ${fromWrite(row.indnatts)(Write.fromPut(Meta.IntMeta.put))}::int2,
              indnkeyatts = ${fromWrite(row.indnkeyatts)(Write.fromPut(Meta.IntMeta.put))}::int2,
              indisunique = ${fromWrite(row.indisunique)(Write.fromPut(Meta.BooleanMeta.put))},
              indisprimary = ${fromWrite(row.indisprimary)(Write.fromPut(Meta.BooleanMeta.put))},
              indisexclusion = ${fromWrite(row.indisexclusion)(Write.fromPut(Meta.BooleanMeta.put))},
              indimmediate = ${fromWrite(row.indimmediate)(Write.fromPut(Meta.BooleanMeta.put))},
              indisclustered = ${fromWrite(row.indisclustered)(Write.fromPut(Meta.BooleanMeta.put))},
              indisvalid = ${fromWrite(row.indisvalid)(Write.fromPut(Meta.BooleanMeta.put))},
              indcheckxmin = ${fromWrite(row.indcheckxmin)(Write.fromPut(Meta.BooleanMeta.put))},
              indisready = ${fromWrite(row.indisready)(Write.fromPut(Meta.BooleanMeta.put))},
              indislive = ${fromWrite(row.indislive)(Write.fromPut(Meta.BooleanMeta.put))},
              indisreplident = ${fromWrite(row.indisreplident)(Write.fromPut(Meta.BooleanMeta.put))},
              indkey = ${fromWrite(row.indkey)(Write.fromPut(TypoInt2Vector.put))}::int2vector,
              indcollation = ${fromWrite(row.indcollation)(Write.fromPut(TypoOidVector.put))}::oidvector,
              indclass = ${fromWrite(row.indclass)(Write.fromPut(TypoOidVector.put))}::oidvector,
              indoption = ${fromWrite(row.indoption)(Write.fromPut(TypoInt2Vector.put))}::int2vector,
              indexprs = ${fromWrite(row.indexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree,
              indpred = ${fromWrite(row.indpred)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          where indexrelid = ${fromWrite(indexrelid)(Write.fromPut(PgIndexId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgIndexRow): ConnectionIO[PgIndexRow] = {
    sql"""insert into pg_catalog.pg_index(indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred)
          values (
            ${fromWrite(unsaved.indexrelid)(Write.fromPut(PgIndexId.put))}::oid,
            ${fromWrite(unsaved.indrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.indnatts)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.indnkeyatts)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.indisunique)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indisprimary)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indisexclusion)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indimmediate)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indisclustered)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indisvalid)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indcheckxmin)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indisready)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indislive)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indisreplident)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.indkey)(Write.fromPut(TypoInt2Vector.put))}::int2vector,
            ${fromWrite(unsaved.indcollation)(Write.fromPut(TypoOidVector.put))}::oidvector,
            ${fromWrite(unsaved.indclass)(Write.fromPut(TypoOidVector.put))}::oidvector,
            ${fromWrite(unsaved.indoption)(Write.fromPut(TypoInt2Vector.put))}::int2vector,
            ${fromWrite(unsaved.indexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree,
            ${fromWrite(unsaved.indpred)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          )
          on conflict (indexrelid)
          do update set
            indrelid = EXCLUDED.indrelid,
            indnatts = EXCLUDED.indnatts,
            indnkeyatts = EXCLUDED.indnkeyatts,
            indisunique = EXCLUDED.indisunique,
            indisprimary = EXCLUDED.indisprimary,
            indisexclusion = EXCLUDED.indisexclusion,
            indimmediate = EXCLUDED.indimmediate,
            indisclustered = EXCLUDED.indisclustered,
            indisvalid = EXCLUDED.indisvalid,
            indcheckxmin = EXCLUDED.indcheckxmin,
            indisready = EXCLUDED.indisready,
            indislive = EXCLUDED.indislive,
            indisreplident = EXCLUDED.indisreplident,
            indkey = EXCLUDED.indkey,
            indcollation = EXCLUDED.indcollation,
            indclass = EXCLUDED.indclass,
            indoption = EXCLUDED.indoption,
            indexprs = EXCLUDED.indexprs,
            indpred = EXCLUDED.indpred
          returning indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred
       """.query(PgIndexRow.read).unique
  }
}
