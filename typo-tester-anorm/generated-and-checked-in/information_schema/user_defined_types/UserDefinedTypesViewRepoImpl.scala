/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_defined_types

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object UserDefinedTypesViewRepoImpl extends UserDefinedTypesViewRepo {
  override def select: SelectBuilder[UserDefinedTypesViewFields, UserDefinedTypesViewRow] = {
    SelectBuilderSql("information_schema.user_defined_types", UserDefinedTypesViewFields, UserDefinedTypesViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[UserDefinedTypesViewRow] = {
    SQL"""select "user_defined_type_catalog", "user_defined_type_schema", "user_defined_type_name", user_defined_type_category, is_instantiable, is_final, ordering_form, ordering_category, ordering_routine_catalog, ordering_routine_schema, ordering_routine_name, reference_type, data_type, character_maximum_length, character_octet_length, "character_set_catalog", "character_set_schema", "character_set_name", "collation_catalog", "collation_schema", "collation_name", numeric_precision, numeric_precision_radix, numeric_scale, datetime_precision, interval_type, interval_precision, source_dtd_identifier, ref_dtd_identifier
          from information_schema.user_defined_types
       """.as(UserDefinedTypesViewRow.rowParser(1).*)
  }
}
