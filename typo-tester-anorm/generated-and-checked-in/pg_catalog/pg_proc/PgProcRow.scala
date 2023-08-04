/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import adventureworks.TypoAclItem
import adventureworks.TypoOidVector
import adventureworks.TypoPgNodeTree
import adventureworks.TypoRegproc
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

case class PgProcRow(
  oid: PgProcId,
  proname: String,
  pronamespace: /* oid */ Long,
  proowner: /* oid */ Long,
  prolang: /* oid */ Long,
  procost: Float,
  prorows: Float,
  provariadic: /* oid */ Long,
  prosupport: TypoRegproc,
  prokind: String,
  prosecdef: Boolean,
  proleakproof: Boolean,
  proisstrict: Boolean,
  proretset: Boolean,
  provolatile: String,
  proparallel: String,
  pronargs: Int,
  pronargdefaults: Int,
  prorettype: /* oid */ Long,
  proargtypes: TypoOidVector,
  proallargtypes: Option[Array[/* oid */ Long]],
  proargmodes: Option[Array[String]],
  proargnames: Option[Array[String]],
  proargdefaults: Option[TypoPgNodeTree],
  protrftypes: Option[Array[/* oid */ Long]],
  prosrc: String,
  probin: Option[String],
  prosqlbody: Option[TypoPgNodeTree],
  proconfig: Option[Array[String]],
  proacl: Option[Array[TypoAclItem]]
)

object PgProcRow {
  implicit lazy val reads: Reads[PgProcRow] = Reads[PgProcRow](json => JsResult.fromTry(
      Try(
        PgProcRow(
          oid = json.\("oid").as(PgProcId.reads),
          proname = json.\("proname").as(Reads.StringReads),
          pronamespace = json.\("pronamespace").as(Reads.LongReads),
          proowner = json.\("proowner").as(Reads.LongReads),
          prolang = json.\("prolang").as(Reads.LongReads),
          procost = json.\("procost").as(Reads.FloatReads),
          prorows = json.\("prorows").as(Reads.FloatReads),
          provariadic = json.\("provariadic").as(Reads.LongReads),
          prosupport = json.\("prosupport").as(TypoRegproc.reads),
          prokind = json.\("prokind").as(Reads.StringReads),
          prosecdef = json.\("prosecdef").as(Reads.BooleanReads),
          proleakproof = json.\("proleakproof").as(Reads.BooleanReads),
          proisstrict = json.\("proisstrict").as(Reads.BooleanReads),
          proretset = json.\("proretset").as(Reads.BooleanReads),
          provolatile = json.\("provolatile").as(Reads.StringReads),
          proparallel = json.\("proparallel").as(Reads.StringReads),
          pronargs = json.\("pronargs").as(Reads.IntReads),
          pronargdefaults = json.\("pronargdefaults").as(Reads.IntReads),
          prorettype = json.\("prorettype").as(Reads.LongReads),
          proargtypes = json.\("proargtypes").as(TypoOidVector.reads),
          proallargtypes = json.\("proallargtypes").toOption.map(_.as(Reads.ArrayReads[Long](Reads.LongReads, implicitly))),
          proargmodes = json.\("proargmodes").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          proargnames = json.\("proargnames").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          proargdefaults = json.\("proargdefaults").toOption.map(_.as(TypoPgNodeTree.reads)),
          protrftypes = json.\("protrftypes").toOption.map(_.as(Reads.ArrayReads[Long](Reads.LongReads, implicitly))),
          prosrc = json.\("prosrc").as(Reads.StringReads),
          probin = json.\("probin").toOption.map(_.as(Reads.StringReads)),
          prosqlbody = json.\("prosqlbody").toOption.map(_.as(TypoPgNodeTree.reads)),
          proconfig = json.\("proconfig").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          proacl = json.\("proacl").toOption.map(_.as(Reads.ArrayReads[TypoAclItem](TypoAclItem.reads, implicitly)))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgProcRow] = RowParser[PgProcRow] { row =>
    Success(
      PgProcRow(
        oid = row(idx + 0)(PgProcId.column),
        proname = row(idx + 1)(Column.columnToString),
        pronamespace = row(idx + 2)(Column.columnToLong),
        proowner = row(idx + 3)(Column.columnToLong),
        prolang = row(idx + 4)(Column.columnToLong),
        procost = row(idx + 5)(Column.columnToFloat),
        prorows = row(idx + 6)(Column.columnToFloat),
        provariadic = row(idx + 7)(Column.columnToLong),
        prosupport = row(idx + 8)(TypoRegproc.column),
        prokind = row(idx + 9)(Column.columnToString),
        prosecdef = row(idx + 10)(Column.columnToBoolean),
        proleakproof = row(idx + 11)(Column.columnToBoolean),
        proisstrict = row(idx + 12)(Column.columnToBoolean),
        proretset = row(idx + 13)(Column.columnToBoolean),
        provolatile = row(idx + 14)(Column.columnToString),
        proparallel = row(idx + 15)(Column.columnToString),
        pronargs = row(idx + 16)(Column.columnToInt),
        pronargdefaults = row(idx + 17)(Column.columnToInt),
        prorettype = row(idx + 18)(Column.columnToLong),
        proargtypes = row(idx + 19)(TypoOidVector.column),
        proallargtypes = row(idx + 20)(Column.columnToOption(Column.columnToArray[Long](Column.columnToLong, implicitly))),
        proargmodes = row(idx + 21)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        proargnames = row(idx + 22)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        proargdefaults = row(idx + 23)(Column.columnToOption(TypoPgNodeTree.column)),
        protrftypes = row(idx + 24)(Column.columnToOption(Column.columnToArray[Long](Column.columnToLong, implicitly))),
        prosrc = row(idx + 25)(Column.columnToString),
        probin = row(idx + 26)(Column.columnToOption(Column.columnToString)),
        prosqlbody = row(idx + 27)(Column.columnToOption(TypoPgNodeTree.column)),
        proconfig = row(idx + 28)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        proacl = row(idx + 29)(Column.columnToOption(TypoAclItem.arrayColumn))
      )
    )
  }
  implicit lazy val writes: OWrites[PgProcRow] = OWrites[PgProcRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgProcId.writes.writes(o.oid),
      "proname" -> Writes.StringWrites.writes(o.proname),
      "pronamespace" -> Writes.LongWrites.writes(o.pronamespace),
      "proowner" -> Writes.LongWrites.writes(o.proowner),
      "prolang" -> Writes.LongWrites.writes(o.prolang),
      "procost" -> Writes.FloatWrites.writes(o.procost),
      "prorows" -> Writes.FloatWrites.writes(o.prorows),
      "provariadic" -> Writes.LongWrites.writes(o.provariadic),
      "prosupport" -> TypoRegproc.writes.writes(o.prosupport),
      "prokind" -> Writes.StringWrites.writes(o.prokind),
      "prosecdef" -> Writes.BooleanWrites.writes(o.prosecdef),
      "proleakproof" -> Writes.BooleanWrites.writes(o.proleakproof),
      "proisstrict" -> Writes.BooleanWrites.writes(o.proisstrict),
      "proretset" -> Writes.BooleanWrites.writes(o.proretset),
      "provolatile" -> Writes.StringWrites.writes(o.provolatile),
      "proparallel" -> Writes.StringWrites.writes(o.proparallel),
      "pronargs" -> Writes.IntWrites.writes(o.pronargs),
      "pronargdefaults" -> Writes.IntWrites.writes(o.pronargdefaults),
      "prorettype" -> Writes.LongWrites.writes(o.prorettype),
      "proargtypes" -> TypoOidVector.writes.writes(o.proargtypes),
      "proallargtypes" -> Writes.OptionWrites(Writes.arrayWrites[Long](implicitly, Writes.LongWrites)).writes(o.proallargtypes),
      "proargmodes" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.proargmodes),
      "proargnames" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.proargnames),
      "proargdefaults" -> Writes.OptionWrites(TypoPgNodeTree.writes).writes(o.proargdefaults),
      "protrftypes" -> Writes.OptionWrites(Writes.arrayWrites[Long](implicitly, Writes.LongWrites)).writes(o.protrftypes),
      "prosrc" -> Writes.StringWrites.writes(o.prosrc),
      "probin" -> Writes.OptionWrites(Writes.StringWrites).writes(o.probin),
      "prosqlbody" -> Writes.OptionWrites(TypoPgNodeTree.writes).writes(o.prosqlbody),
      "proconfig" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.proconfig),
      "proacl" -> Writes.OptionWrites(Writes.arrayWrites[TypoAclItem](implicitly, TypoAclItem.writes)).writes(o.proacl)
    ))
  )
}
