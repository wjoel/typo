/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_views

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgViewsViewStructure[Row](val prefix: Option[String], val extract: Row => PgViewsViewRow, val merge: (Row, PgViewsViewRow) => Row)
  extends Relation[PgViewsViewFields, PgViewsViewRow, Row]
    with PgViewsViewFields[Row] { outer =>

  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, Some("name"))(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val viewname = new OptField[String, Row](prefix, "viewname", None, Some("name"))(x => extract(x).viewname, (row, value) => merge(row, extract(row).copy(viewname = value)))
  override val viewowner = new OptField[String, Row](prefix, "viewowner", None, Some("name"))(x => extract(x).viewowner, (row, value) => merge(row, extract(row).copy(viewowner = value)))
  override val definition = new OptField[String, Row](prefix, "definition", None, None)(x => extract(x).definition, (row, value) => merge(row, extract(row).copy(definition = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](schemaname, viewname, viewowner, definition)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgViewsViewRow, merge: (NewRow, PgViewsViewRow) => NewRow): PgViewsViewStructure[NewRow] =
    new PgViewsViewStructure(prefix, extract, merge)
}
