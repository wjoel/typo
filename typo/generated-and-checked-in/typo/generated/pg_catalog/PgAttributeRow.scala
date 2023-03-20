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

case class PgAttributeRow(
  attrelid: Long,
  attname: String,
  atttypid: Long,
  attstattarget: Int,
  attlen: Short,
  attnum: Short,
  attndims: Int,
  attcacheoff: Int,
  atttypmod: Int,
  attbyval: Boolean,
  attalign: String,
  attstorage: String,
  attcompression: String,
  attnotnull: Boolean,
  atthasdef: Boolean,
  atthasmissing: Boolean,
  attidentity: String,
  attgenerated: String,
  attisdropped: Boolean,
  attislocal: Boolean,
  attinhcount: Int,
  attcollation: Long,
  attacl: Option[Array[String]],
  attoptions: Option[Array[String]],
  attfdwoptions: Option[Array[String]],
  attmissingval: Option[String]
){
  val compositeId: PgAttributeId = PgAttributeId(attrelid, attnum)
}

object PgAttributeRow {
  implicit val rowParser: RowParser[PgAttributeRow] = { row =>
    Success(
      PgAttributeRow(
        attrelid = row[Long]("attrelid"),
        attname = row[String]("attname"),
        atttypid = row[Long]("atttypid"),
        attstattarget = row[Int]("attstattarget"),
        attlen = row[Short]("attlen"),
        attnum = row[Short]("attnum"),
        attndims = row[Int]("attndims"),
        attcacheoff = row[Int]("attcacheoff"),
        atttypmod = row[Int]("atttypmod"),
        attbyval = row[Boolean]("attbyval"),
        attalign = row[String]("attalign"),
        attstorage = row[String]("attstorage"),
        attcompression = row[String]("attcompression"),
        attnotnull = row[Boolean]("attnotnull"),
        atthasdef = row[Boolean]("atthasdef"),
        atthasmissing = row[Boolean]("atthasmissing"),
        attidentity = row[String]("attidentity"),
        attgenerated = row[String]("attgenerated"),
        attisdropped = row[Boolean]("attisdropped"),
        attislocal = row[Boolean]("attislocal"),
        attinhcount = row[Int]("attinhcount"),
        attcollation = row[Long]("attcollation"),
        attacl = row[Option[Array[String]]]("attacl"),
        attoptions = row[Option[Array[String]]]("attoptions"),
        attfdwoptions = row[Option[Array[String]]]("attfdwoptions"),
        attmissingval = row[Option[String]]("attmissingval")
      )
    )
  }

  
}
