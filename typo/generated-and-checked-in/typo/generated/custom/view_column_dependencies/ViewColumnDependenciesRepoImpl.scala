/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package custom
package view_column_dependencies

import anorm.SqlStringInterpolation
import java.sql.Connection

object ViewColumnDependenciesRepoImpl extends ViewColumnDependenciesRepo {
  override def apply()(implicit c: Connection): List[ViewColumnDependenciesRow] = {
    val sql = SQL"""SELECT view_class.relnamespace::regnamespace  AS view_schema
                   , view_class.relname                     AS view_name
                   , table_class.relnamespace::regnamespace AS table_schema
                   , table_class.relname                    AS table_name
                   , table_a.attname                        AS column_name
              FROM pg_class table_class
                       JOIN pg_attribute table_a ON table_a.attrelid = table_class.oid
                       JOIN pg_depend dep ON dep.refobjid = table_a.attrelid AND dep.refobjsubid = table_a.attnum
                       JOIN pg_rewrite rewrite ON rewrite.oid = dep.objid
                       JOIN pg_class view_class ON view_class.oid = rewrite.ev_class
                  AND dep.classid = 'pg_rewrite'::regclass -- it's a view
                  AND rewrite.ev_type = '1' -- only SELECT
                  AND rewrite.is_instead -- INSTEAD rule
              ;
              """
    sql.as(ViewColumnDependenciesRow.rowParser("").*)
  
  }
}
