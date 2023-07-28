/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_authid

import adventureworks.TypoOffsetDateTime
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgAuthidRow(
  oid: PgAuthidId,
  rolname: String,
  rolsuper: Boolean,
  rolinherit: Boolean,
  rolcreaterole: Boolean,
  rolcreatedb: Boolean,
  rolcanlogin: Boolean,
  rolreplication: Boolean,
  rolbypassrls: Boolean,
  rolconnlimit: Int,
  rolpassword: Option[String],
  rolvaliduntil: Option[TypoOffsetDateTime]
)

object PgAuthidRow {
  implicit val reads: Reads[PgAuthidRow] = Reads[PgAuthidRow](json => JsResult.fromTry(
      Try(
        PgAuthidRow(
          oid = json.\("oid").as(PgAuthidId.reads),
          rolname = json.\("rolname").as(Reads.StringReads),
          rolsuper = json.\("rolsuper").as(Reads.BooleanReads),
          rolinherit = json.\("rolinherit").as(Reads.BooleanReads),
          rolcreaterole = json.\("rolcreaterole").as(Reads.BooleanReads),
          rolcreatedb = json.\("rolcreatedb").as(Reads.BooleanReads),
          rolcanlogin = json.\("rolcanlogin").as(Reads.BooleanReads),
          rolreplication = json.\("rolreplication").as(Reads.BooleanReads),
          rolbypassrls = json.\("rolbypassrls").as(Reads.BooleanReads),
          rolconnlimit = json.\("rolconnlimit").as(Reads.IntReads),
          rolpassword = json.\("rolpassword").toOption.map(_.as(Reads.StringReads)),
          rolvaliduntil = json.\("rolvaliduntil").toOption.map(_.as(TypoOffsetDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgAuthidRow] = RowParser[PgAuthidRow] { row =>
    Success(
      PgAuthidRow(
        oid = row(idx + 0)(PgAuthidId.column),
        rolname = row(idx + 1)(Column.columnToString),
        rolsuper = row(idx + 2)(Column.columnToBoolean),
        rolinherit = row(idx + 3)(Column.columnToBoolean),
        rolcreaterole = row(idx + 4)(Column.columnToBoolean),
        rolcreatedb = row(idx + 5)(Column.columnToBoolean),
        rolcanlogin = row(idx + 6)(Column.columnToBoolean),
        rolreplication = row(idx + 7)(Column.columnToBoolean),
        rolbypassrls = row(idx + 8)(Column.columnToBoolean),
        rolconnlimit = row(idx + 9)(Column.columnToInt),
        rolpassword = row(idx + 10)(Column.columnToOption(Column.columnToString)),
        rolvaliduntil = row(idx + 11)(Column.columnToOption(TypoOffsetDateTime.column))
      )
    )
  }
  implicit val writes: OWrites[PgAuthidRow] = OWrites[PgAuthidRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgAuthidId.writes.writes(o.oid),
      "rolname" -> Writes.StringWrites.writes(o.rolname),
      "rolsuper" -> Writes.BooleanWrites.writes(o.rolsuper),
      "rolinherit" -> Writes.BooleanWrites.writes(o.rolinherit),
      "rolcreaterole" -> Writes.BooleanWrites.writes(o.rolcreaterole),
      "rolcreatedb" -> Writes.BooleanWrites.writes(o.rolcreatedb),
      "rolcanlogin" -> Writes.BooleanWrites.writes(o.rolcanlogin),
      "rolreplication" -> Writes.BooleanWrites.writes(o.rolreplication),
      "rolbypassrls" -> Writes.BooleanWrites.writes(o.rolbypassrls),
      "rolconnlimit" -> Writes.IntWrites.writes(o.rolconnlimit),
      "rolpassword" -> Writes.OptionWrites(Writes.StringWrites).writes(o.rolpassword),
      "rolvaliduntil" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.rolvaliduntil)
    ))
  )
}
