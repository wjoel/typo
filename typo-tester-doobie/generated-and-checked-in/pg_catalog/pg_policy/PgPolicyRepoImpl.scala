/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_policy

import adventureworks.TypoPgNodeTree
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgPolicyRepoImpl extends PgPolicyRepo {
  override def delete(oid: PgPolicyId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_policy where oid = ${fromWrite(oid)(Write.fromPut(PgPolicyId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgPolicyFields, PgPolicyRow] = {
    DeleteBuilder("pg_catalog.pg_policy", PgPolicyFields)
  }
  override def insert(unsaved: PgPolicyRow): ConnectionIO[PgPolicyRow] = {
    sql"""insert into pg_catalog.pg_policy(oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgPolicyId.put))}::oid, ${fromWrite(unsaved.polname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.polrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.polcmd)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.polpermissive)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.polroles)(Write.fromPut(adventureworks.LongArrayMeta.put))}::_oid, ${fromWrite(unsaved.polqual)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree, ${fromWrite(unsaved.polwithcheck)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree)
          returning oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
       """.query(PgPolicyRow.read).unique
  }
  override def select: SelectBuilder[PgPolicyFields, PgPolicyRow] = {
    SelectBuilderSql("pg_catalog.pg_policy", PgPolicyFields, PgPolicyRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgPolicyRow] = {
    sql"select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy".query(PgPolicyRow.read).stream
  }
  override def selectById(oid: PgPolicyId): ConnectionIO[Option[PgPolicyRow]] = {
    sql"select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy where oid = ${fromWrite(oid)(Write.fromPut(PgPolicyId.put))}".query(PgPolicyRow.read).option
  }
  override def selectByIds(oids: Array[PgPolicyId]): Stream[ConnectionIO, PgPolicyRow] = {
    sql"select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy where oid = ANY(${fromWrite(oids)(Write.fromPut(PgPolicyId.arrayPut))})".query(PgPolicyRow.read).stream
  }
  override def update(row: PgPolicyRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_policy
          set polname = ${fromWrite(row.polname)(Write.fromPut(Meta.StringMeta.put))}::name,
              polrelid = ${fromWrite(row.polrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              polcmd = ${fromWrite(row.polcmd)(Write.fromPut(Meta.StringMeta.put))}::char,
              polpermissive = ${fromWrite(row.polpermissive)(Write.fromPut(Meta.BooleanMeta.put))},
              polroles = ${fromWrite(row.polroles)(Write.fromPut(adventureworks.LongArrayMeta.put))}::_oid,
              polqual = ${fromWrite(row.polqual)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree,
              polwithcheck = ${fromWrite(row.polwithcheck)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          where oid = ${fromWrite(oid)(Write.fromPut(PgPolicyId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgPolicyFields, PgPolicyRow] = {
    UpdateBuilder("pg_catalog.pg_policy", PgPolicyFields, PgPolicyRow.read)
  }
  override def upsert(unsaved: PgPolicyRow): ConnectionIO[PgPolicyRow] = {
    sql"""insert into pg_catalog.pg_policy(oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgPolicyId.put))}::oid,
            ${fromWrite(unsaved.polname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.polrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.polcmd)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.polpermissive)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.polroles)(Write.fromPut(adventureworks.LongArrayMeta.put))}::_oid,
            ${fromWrite(unsaved.polqual)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree,
            ${fromWrite(unsaved.polwithcheck)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          )
          on conflict (oid)
          do update set
            polname = EXCLUDED.polname,
            polrelid = EXCLUDED.polrelid,
            polcmd = EXCLUDED.polcmd,
            polpermissive = EXCLUDED.polpermissive,
            polroles = EXCLUDED.polroles,
            polqual = EXCLUDED.polqual,
            polwithcheck = EXCLUDED.polwithcheck
          returning oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
       """.query(PgPolicyRow.read).unique
  }
}
