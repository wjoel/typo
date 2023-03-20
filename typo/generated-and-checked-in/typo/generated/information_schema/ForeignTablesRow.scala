/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success

case class ForeignTablesRow(
  /** Points to [[PgForeignTablesRow.foreignTableCatalog]] */
  foreignTableCatalog: Option[String],
  /** Points to [[PgForeignTablesRow.foreignTableSchema]] */
  foreignTableSchema: Option[String],
  /** Points to [[PgForeignTablesRow.foreignTableName]] */
  foreignTableName: Option[String],
  /** Points to [[PgForeignTablesRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[String],
  /** Points to [[PgForeignTablesRow.foreignServerName]] */
  foreignServerName: Option[String]
)

object ForeignTablesRow {
  implicit val rowParser: RowParser[ForeignTablesRow] = { row =>
    Success(
      ForeignTablesRow(
        foreignTableCatalog = row[Option[String]]("foreign_table_catalog"),
        foreignTableSchema = row[Option[String]]("foreign_table_schema"),
        foreignTableName = row[Option[String]]("foreign_table_name"),
        foreignServerCatalog = row[Option[String]]("foreign_server_catalog"),
        foreignServerName = row[Option[String]]("foreign_server_name")
      )
    )
  }

  
}
