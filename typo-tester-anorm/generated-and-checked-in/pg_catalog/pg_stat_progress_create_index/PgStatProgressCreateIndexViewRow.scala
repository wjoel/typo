/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_create_index

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

case class PgStatProgressCreateIndexViewRow(
  pid: Option[Int],
  datid: Option[/* oid */ Long],
  datname: Option[String],
  relid: Option[/* oid */ Long],
  indexRelid: Option[/* oid */ Long],
  command: Option[String],
  phase: Option[String],
  lockersTotal: Option[Long],
  lockersDone: Option[Long],
  currentLockerPid: Option[Long],
  blocksTotal: Option[Long],
  blocksDone: Option[Long],
  tuplesTotal: Option[Long],
  tuplesDone: Option[Long],
  partitionsTotal: Option[Long],
  partitionsDone: Option[Long]
)

object PgStatProgressCreateIndexViewRow {
  implicit lazy val reads: Reads[PgStatProgressCreateIndexViewRow] = Reads[PgStatProgressCreateIndexViewRow](json => JsResult.fromTry(
      Try(
        PgStatProgressCreateIndexViewRow(
          pid = json.\("pid").toOption.map(_.as(Reads.IntReads)),
          datid = json.\("datid").toOption.map(_.as(Reads.LongReads)),
          datname = json.\("datname").toOption.map(_.as(Reads.StringReads)),
          relid = json.\("relid").toOption.map(_.as(Reads.LongReads)),
          indexRelid = json.\("index_relid").toOption.map(_.as(Reads.LongReads)),
          command = json.\("command").toOption.map(_.as(Reads.StringReads)),
          phase = json.\("phase").toOption.map(_.as(Reads.StringReads)),
          lockersTotal = json.\("lockers_total").toOption.map(_.as(Reads.LongReads)),
          lockersDone = json.\("lockers_done").toOption.map(_.as(Reads.LongReads)),
          currentLockerPid = json.\("current_locker_pid").toOption.map(_.as(Reads.LongReads)),
          blocksTotal = json.\("blocks_total").toOption.map(_.as(Reads.LongReads)),
          blocksDone = json.\("blocks_done").toOption.map(_.as(Reads.LongReads)),
          tuplesTotal = json.\("tuples_total").toOption.map(_.as(Reads.LongReads)),
          tuplesDone = json.\("tuples_done").toOption.map(_.as(Reads.LongReads)),
          partitionsTotal = json.\("partitions_total").toOption.map(_.as(Reads.LongReads)),
          partitionsDone = json.\("partitions_done").toOption.map(_.as(Reads.LongReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatProgressCreateIndexViewRow] = RowParser[PgStatProgressCreateIndexViewRow] { row =>
    Success(
      PgStatProgressCreateIndexViewRow(
        pid = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        datid = row(idx + 1)(Column.columnToOption(Column.columnToLong)),
        datname = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        relid = row(idx + 3)(Column.columnToOption(Column.columnToLong)),
        indexRelid = row(idx + 4)(Column.columnToOption(Column.columnToLong)),
        command = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        phase = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        lockersTotal = row(idx + 7)(Column.columnToOption(Column.columnToLong)),
        lockersDone = row(idx + 8)(Column.columnToOption(Column.columnToLong)),
        currentLockerPid = row(idx + 9)(Column.columnToOption(Column.columnToLong)),
        blocksTotal = row(idx + 10)(Column.columnToOption(Column.columnToLong)),
        blocksDone = row(idx + 11)(Column.columnToOption(Column.columnToLong)),
        tuplesTotal = row(idx + 12)(Column.columnToOption(Column.columnToLong)),
        tuplesDone = row(idx + 13)(Column.columnToOption(Column.columnToLong)),
        partitionsTotal = row(idx + 14)(Column.columnToOption(Column.columnToLong)),
        partitionsDone = row(idx + 15)(Column.columnToOption(Column.columnToLong))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatProgressCreateIndexViewRow] = OWrites[PgStatProgressCreateIndexViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "pid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.pid),
      "datid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.datid),
      "datname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.datname),
      "relid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.relid),
      "index_relid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.indexRelid),
      "command" -> Writes.OptionWrites(Writes.StringWrites).writes(o.command),
      "phase" -> Writes.OptionWrites(Writes.StringWrites).writes(o.phase),
      "lockers_total" -> Writes.OptionWrites(Writes.LongWrites).writes(o.lockersTotal),
      "lockers_done" -> Writes.OptionWrites(Writes.LongWrites).writes(o.lockersDone),
      "current_locker_pid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.currentLockerPid),
      "blocks_total" -> Writes.OptionWrites(Writes.LongWrites).writes(o.blocksTotal),
      "blocks_done" -> Writes.OptionWrites(Writes.LongWrites).writes(o.blocksDone),
      "tuples_total" -> Writes.OptionWrites(Writes.LongWrites).writes(o.tuplesTotal),
      "tuples_done" -> Writes.OptionWrites(Writes.LongWrites).writes(o.tuplesDone),
      "partitions_total" -> Writes.OptionWrites(Writes.LongWrites).writes(o.partitionsTotal),
      "partitions_done" -> Writes.OptionWrites(Writes.LongWrites).writes(o.partitionsDone)
    ))
  )
}