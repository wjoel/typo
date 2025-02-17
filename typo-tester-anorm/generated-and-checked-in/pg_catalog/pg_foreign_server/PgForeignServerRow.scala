/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_server

import adventureworks.TypoAclItem
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

case class PgForeignServerRow(
  oid: PgForeignServerId,
  srvname: String,
  srvowner: /* oid */ Long,
  srvfdw: /* oid */ Long,
  srvtype: Option[String],
  srvversion: Option[String],
  srvacl: Option[Array[TypoAclItem]],
  srvoptions: Option[Array[String]]
)

object PgForeignServerRow {
  implicit lazy val reads: Reads[PgForeignServerRow] = Reads[PgForeignServerRow](json => JsResult.fromTry(
      Try(
        PgForeignServerRow(
          oid = json.\("oid").as(PgForeignServerId.reads),
          srvname = json.\("srvname").as(Reads.StringReads),
          srvowner = json.\("srvowner").as(Reads.LongReads),
          srvfdw = json.\("srvfdw").as(Reads.LongReads),
          srvtype = json.\("srvtype").toOption.map(_.as(Reads.StringReads)),
          srvversion = json.\("srvversion").toOption.map(_.as(Reads.StringReads)),
          srvacl = json.\("srvacl").toOption.map(_.as(Reads.ArrayReads[TypoAclItem](TypoAclItem.reads, implicitly))),
          srvoptions = json.\("srvoptions").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly)))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgForeignServerRow] = RowParser[PgForeignServerRow] { row =>
    Success(
      PgForeignServerRow(
        oid = row(idx + 0)(PgForeignServerId.column),
        srvname = row(idx + 1)(Column.columnToString),
        srvowner = row(idx + 2)(Column.columnToLong),
        srvfdw = row(idx + 3)(Column.columnToLong),
        srvtype = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        srvversion = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        srvacl = row(idx + 6)(Column.columnToOption(TypoAclItem.arrayColumn)),
        srvoptions = row(idx + 7)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly)))
      )
    )
  }
  implicit lazy val writes: OWrites[PgForeignServerRow] = OWrites[PgForeignServerRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgForeignServerId.writes.writes(o.oid),
      "srvname" -> Writes.StringWrites.writes(o.srvname),
      "srvowner" -> Writes.LongWrites.writes(o.srvowner),
      "srvfdw" -> Writes.LongWrites.writes(o.srvfdw),
      "srvtype" -> Writes.OptionWrites(Writes.StringWrites).writes(o.srvtype),
      "srvversion" -> Writes.OptionWrites(Writes.StringWrites).writes(o.srvversion),
      "srvacl" -> Writes.OptionWrites(Writes.arrayWrites[TypoAclItem](implicitly, TypoAclItem.writes)).writes(o.srvacl),
      "srvoptions" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.srvoptions)
    ))
  )
}
