/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success

case class PgConstraintRow(
  oid: PgConstraintId,
  conname: String,
  connamespace: Long,
  contype: String,
  condeferrable: Boolean,
  condeferred: Boolean,
  convalidated: Boolean,
  conrelid: Long,
  contypid: Long,
  conindid: Long,
  conparentid: Long,
  confrelid: Long,
  confupdtype: String,
  confdeltype: String,
  confmatchtype: String,
  conislocal: Boolean,
  coninhcount: Int,
  connoinherit: Boolean,
  conkey: Option[Array[Short]],
  confkey: Option[Array[Short]],
  conpfeqop: Option[Array[Long]],
  conppeqop: Option[Array[Long]],
  conffeqop: Option[Array[Long]],
  conexclop: Option[Array[Long]],
  conbin: Option[String]
)

object PgConstraintRow {
  implicit val rowParser: RowParser[PgConstraintRow] = { row =>
    Success(
      PgConstraintRow(
        oid = row[PgConstraintId]("oid"),
        conname = row[String]("conname"),
        connamespace = row[Long]("connamespace"),
        contype = row[String]("contype"),
        condeferrable = row[Boolean]("condeferrable"),
        condeferred = row[Boolean]("condeferred"),
        convalidated = row[Boolean]("convalidated"),
        conrelid = row[Long]("conrelid"),
        contypid = row[Long]("contypid"),
        conindid = row[Long]("conindid"),
        conparentid = row[Long]("conparentid"),
        confrelid = row[Long]("confrelid"),
        confupdtype = row[String]("confupdtype"),
        confdeltype = row[String]("confdeltype"),
        confmatchtype = row[String]("confmatchtype"),
        conislocal = row[Boolean]("conislocal"),
        coninhcount = row[Int]("coninhcount"),
        connoinherit = row[Boolean]("connoinherit"),
        conkey = row[Option[Array[Short]]]("conkey"),
        confkey = row[Option[Array[Short]]]("confkey"),
        conpfeqop = row[Option[Array[Long]]]("conpfeqop"),
        conppeqop = row[Option[Array[Long]]]("conppeqop"),
        conffeqop = row[Option[Array[Long]]]("conffeqop"),
        conexclop = row[Option[Array[Long]]]("conexclop"),
        conbin = row[Option[String]]("conbin")
      )
    )
  }

  
}