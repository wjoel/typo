/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_default_acl

import adventureworks.TypoAclItem
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream

object PgDefaultAclRepoImpl extends PgDefaultAclRepo {
  override def delete(oid: PgDefaultAclId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_default_acl where oid = ${fromWrite(oid)(Write.fromPut(PgDefaultAclId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgDefaultAclRow): ConnectionIO[PgDefaultAclRow] = {
    sql"""insert into pg_catalog.pg_default_acl(oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgDefaultAclId.put))}::oid, ${fromWrite(unsaved.defaclrole)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.defaclnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.defaclobjtype)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.defaclacl)(Write.fromPut(TypoAclItem.arrayPut))}::_aclitem)
          returning oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl
       """.query(PgDefaultAclRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgDefaultAclRow] = {
    sql"select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl from pg_catalog.pg_default_acl".query(PgDefaultAclRow.read).stream
  }
  override def selectById(oid: PgDefaultAclId): ConnectionIO[Option[PgDefaultAclRow]] = {
    sql"select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl from pg_catalog.pg_default_acl where oid = ${fromWrite(oid)(Write.fromPut(PgDefaultAclId.put))}".query(PgDefaultAclRow.read).option
  }
  override def selectByIds(oids: Array[PgDefaultAclId]): Stream[ConnectionIO, PgDefaultAclRow] = {
    sql"select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl from pg_catalog.pg_default_acl where oid = ANY(${fromWrite(oids)(Write.fromPut(PgDefaultAclId.arrayPut))})".query(PgDefaultAclRow.read).stream
  }
  override def update(row: PgDefaultAclRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_default_acl
          set defaclrole = ${fromWrite(row.defaclrole)(Write.fromPut(Meta.LongMeta.put))}::oid,
              defaclnamespace = ${fromWrite(row.defaclnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
              defaclobjtype = ${fromWrite(row.defaclobjtype)(Write.fromPut(Meta.StringMeta.put))}::char,
              defaclacl = ${fromWrite(row.defaclacl)(Write.fromPut(TypoAclItem.arrayPut))}::_aclitem
          where oid = ${fromWrite(oid)(Write.fromPut(PgDefaultAclId.put))}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgDefaultAclRow): ConnectionIO[PgDefaultAclRow] = {
    sql"""insert into pg_catalog.pg_default_acl(oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgDefaultAclId.put))}::oid,
            ${fromWrite(unsaved.defaclrole)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.defaclnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.defaclobjtype)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.defaclacl)(Write.fromPut(TypoAclItem.arrayPut))}::_aclitem
          )
          on conflict (oid)
          do update set
            defaclrole = EXCLUDED.defaclrole,
            defaclnamespace = EXCLUDED.defaclnamespace,
            defaclobjtype = EXCLUDED.defaclobjtype,
            defaclacl = EXCLUDED.defaclacl
          returning oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl
       """.query(PgDefaultAclRow.read).unique
  }
}
