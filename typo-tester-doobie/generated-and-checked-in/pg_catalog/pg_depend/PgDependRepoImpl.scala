/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_depend

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

object PgDependRepoImpl extends PgDependRepo {
  override def delete: DeleteBuilder[PgDependFields, PgDependRow] = {
    DeleteBuilder("pg_catalog.pg_depend", PgDependFields)
  }
  override def insert(unsaved: PgDependRow): ConnectionIO[PgDependRow] = {
    sql"""insert into pg_catalog.pg_depend(classid, objid, objsubid, refclassid, refobjid, refobjsubid, deptype)
          values (${fromWrite(unsaved.classid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.objid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.objsubid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.refclassid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.refobjid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.refobjsubid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.deptype)(Write.fromPut(Meta.StringMeta.put))}::char)
          returning classid, objid, objsubid, refclassid, refobjid, refobjsubid, deptype
       """.query(PgDependRow.read).unique
  }
  override def select: SelectBuilder[PgDependFields, PgDependRow] = {
    SelectBuilderSql("pg_catalog.pg_depend", PgDependFields, PgDependRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgDependRow] = {
    sql"select classid, objid, objsubid, refclassid, refobjid, refobjsubid, deptype from pg_catalog.pg_depend".query(PgDependRow.read).stream
  }
  override def update: UpdateBuilder[PgDependFields, PgDependRow] = {
    UpdateBuilder("pg_catalog.pg_depend", PgDependFields, PgDependRow.read)
  }
}
