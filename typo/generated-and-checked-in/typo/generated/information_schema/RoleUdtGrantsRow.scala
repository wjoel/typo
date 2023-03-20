/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success

case class RoleUdtGrantsRow(
  /** Points to [[UdtPrivilegesRow.grantor]] */
  grantor: Option[String],
  /** Points to [[UdtPrivilegesRow.grantee]] */
  grantee: Option[String],
  /** Points to [[UdtPrivilegesRow.udtCatalog]] */
  udtCatalog: Option[String],
  /** Points to [[UdtPrivilegesRow.udtSchema]] */
  udtSchema: Option[String],
  /** Points to [[UdtPrivilegesRow.udtName]] */
  udtName: Option[String],
  /** Points to [[UdtPrivilegesRow.privilegeType]] */
  privilegeType: Option[String],
  /** Points to [[UdtPrivilegesRow.isGrantable]] */
  isGrantable: Option[String]
)

object RoleUdtGrantsRow {
  implicit val rowParser: RowParser[RoleUdtGrantsRow] = { row =>
    Success(
      RoleUdtGrantsRow(
        grantor = row[Option[String]]("grantor"),
        grantee = row[Option[String]]("grantee"),
        udtCatalog = row[Option[String]]("udt_catalog"),
        udtSchema = row[Option[String]]("udt_schema"),
        udtName = row[Option[String]]("udt_name"),
        privilegeType = row[Option[String]]("privilege_type"),
        isGrantable = row[Option[String]]("is_grantable")
      )
    )
  }

  
}