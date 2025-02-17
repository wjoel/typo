/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_statements

import adventureworks.TypoOffsetDateTime
import adventureworks.TypoRegtype
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgPreparedStatementsViewStructure[Row](val prefix: Option[String], val extract: Row => PgPreparedStatementsViewRow, val merge: (Row, PgPreparedStatementsViewRow) => Row)
  extends Relation[PgPreparedStatementsViewFields, PgPreparedStatementsViewRow, Row]
    with PgPreparedStatementsViewFields[Row] { outer =>

  override val name = new OptField[String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val statement = new OptField[String, Row](prefix, "statement", None, None)(x => extract(x).statement, (row, value) => merge(row, extract(row).copy(statement = value)))
  override val prepareTime = new OptField[TypoOffsetDateTime, Row](prefix, "prepare_time", Some("text"), Some("timestamptz"))(x => extract(x).prepareTime, (row, value) => merge(row, extract(row).copy(prepareTime = value)))
  override val parameterTypes = new OptField[Array[TypoRegtype], Row](prefix, "parameter_types", None, Some("_regtype"))(x => extract(x).parameterTypes, (row, value) => merge(row, extract(row).copy(parameterTypes = value)))
  override val fromSql = new OptField[Boolean, Row](prefix, "from_sql", None, None)(x => extract(x).fromSql, (row, value) => merge(row, extract(row).copy(fromSql = value)))
  override val genericPlans = new OptField[Long, Row](prefix, "generic_plans", None, Some("int8"))(x => extract(x).genericPlans, (row, value) => merge(row, extract(row).copy(genericPlans = value)))
  override val customPlans = new OptField[Long, Row](prefix, "custom_plans", None, Some("int8"))(x => extract(x).customPlans, (row, value) => merge(row, extract(row).copy(customPlans = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](name, statement, prepareTime, parameterTypes, fromSql, genericPlans, customPlans)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgPreparedStatementsViewRow, merge: (NewRow, PgPreparedStatementsViewRow) => NewRow): PgPreparedStatementsViewStructure[NewRow] =
    new PgPreparedStatementsViewStructure(prefix, extract, merge)
}
