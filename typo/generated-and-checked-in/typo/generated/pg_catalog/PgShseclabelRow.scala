/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success

case class PgShseclabelRow(
  objoid: Long,
  classoid: Long,
  provider: String,
  label: String
){
  val compositeId: PgShseclabelId = PgShseclabelId(objoid, classoid, provider)
}

object PgShseclabelRow {
  implicit val rowParser: RowParser[PgShseclabelRow] = { row =>
    Success(
      PgShseclabelRow(
        objoid = row[Long]("objoid"),
        classoid = row[Long]("classoid"),
        provider = row[String]("provider"),
        label = row[String]("label")
      )
    )
  }

  
}
