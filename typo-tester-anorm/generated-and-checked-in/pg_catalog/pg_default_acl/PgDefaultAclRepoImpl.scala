/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_default_acl

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgDefaultAclRepoImpl extends PgDefaultAclRepo {
  override def delete(oid: PgDefaultAclId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_default_acl where oid = $oid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgDefaultAclFields, PgDefaultAclRow] = {
    DeleteBuilder("pg_catalog.pg_default_acl", PgDefaultAclFields)
  }
  override def insert(unsaved: PgDefaultAclRow)(implicit c: Connection): PgDefaultAclRow = {
    SQL"""insert into pg_catalog.pg_default_acl(oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl)
          values (${unsaved.oid}::oid, ${unsaved.defaclrole}::oid, ${unsaved.defaclnamespace}::oid, ${unsaved.defaclobjtype}::char, ${unsaved.defaclacl}::_aclitem)
          returning oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl
       """
      .executeInsert(PgDefaultAclRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgDefaultAclFields, PgDefaultAclRow] = {
    SelectBuilderSql("pg_catalog.pg_default_acl", PgDefaultAclFields, PgDefaultAclRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgDefaultAclRow] = {
    SQL"""select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl
          from pg_catalog.pg_default_acl
       """.as(PgDefaultAclRow.rowParser(1).*)
  }
  override def selectById(oid: PgDefaultAclId)(implicit c: Connection): Option[PgDefaultAclRow] = {
    SQL"""select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl
          from pg_catalog.pg_default_acl
          where oid = $oid
       """.as(PgDefaultAclRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgDefaultAclId])(implicit c: Connection): List[PgDefaultAclRow] = {
    SQL"""select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl
          from pg_catalog.pg_default_acl
          where oid = ANY($oids)
       """.as(PgDefaultAclRow.rowParser(1).*)
    
  }
  override def update(row: PgDefaultAclRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_default_acl
          set defaclrole = ${row.defaclrole}::oid,
              defaclnamespace = ${row.defaclnamespace}::oid,
              defaclobjtype = ${row.defaclobjtype}::char,
              defaclacl = ${row.defaclacl}::_aclitem
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgDefaultAclFields, PgDefaultAclRow] = {
    UpdateBuilder("pg_catalog.pg_default_acl", PgDefaultAclFields, PgDefaultAclRow.rowParser)
  }
  override def upsert(unsaved: PgDefaultAclRow)(implicit c: Connection): PgDefaultAclRow = {
    SQL"""insert into pg_catalog.pg_default_acl(oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.defaclrole}::oid,
            ${unsaved.defaclnamespace}::oid,
            ${unsaved.defaclobjtype}::char,
            ${unsaved.defaclacl}::_aclitem
          )
          on conflict (oid)
          do update set
            defaclrole = EXCLUDED.defaclrole,
            defaclnamespace = EXCLUDED.defaclnamespace,
            defaclobjtype = EXCLUDED.defaclobjtype,
            defaclacl = EXCLUDED.defaclacl
          returning oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl
       """
      .executeInsert(PgDefaultAclRow.rowParser(1).single)
    
  }
}
