/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_available_extension_versions

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

case class PgAvailableExtensionVersionsViewRow(
  name: Option[String],
  version: Option[String],
  installed: Option[Boolean],
  superuser: Option[Boolean],
  trusted: Option[Boolean],
  relocatable: Option[Boolean],
  schema: Option[String],
  requires: Option[Array[String]],
  comment: Option[String]
)

object PgAvailableExtensionVersionsViewRow {
  implicit val reads: Reads[PgAvailableExtensionVersionsViewRow] = Reads[PgAvailableExtensionVersionsViewRow](json => JsResult.fromTry(
      Try(
        PgAvailableExtensionVersionsViewRow(
          name = json.\("name").toOption.map(_.as(Reads.StringReads)),
          version = json.\("version").toOption.map(_.as(Reads.StringReads)),
          installed = json.\("installed").toOption.map(_.as(Reads.BooleanReads)),
          superuser = json.\("superuser").toOption.map(_.as(Reads.BooleanReads)),
          trusted = json.\("trusted").toOption.map(_.as(Reads.BooleanReads)),
          relocatable = json.\("relocatable").toOption.map(_.as(Reads.BooleanReads)),
          schema = json.\("schema").toOption.map(_.as(Reads.StringReads)),
          requires = json.\("requires").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          comment = json.\("comment").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgAvailableExtensionVersionsViewRow] = RowParser[PgAvailableExtensionVersionsViewRow] { row =>
    Success(
      PgAvailableExtensionVersionsViewRow(
        name = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        version = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        installed = row(idx + 2)(Column.columnToOption(Column.columnToBoolean)),
        superuser = row(idx + 3)(Column.columnToOption(Column.columnToBoolean)),
        trusted = row(idx + 4)(Column.columnToOption(Column.columnToBoolean)),
        relocatable = row(idx + 5)(Column.columnToOption(Column.columnToBoolean)),
        schema = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        requires = row(idx + 7)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        comment = row(idx + 8)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit val writes: OWrites[PgAvailableExtensionVersionsViewRow] = OWrites[PgAvailableExtensionVersionsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.name),
      "version" -> Writes.OptionWrites(Writes.StringWrites).writes(o.version),
      "installed" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.installed),
      "superuser" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.superuser),
      "trusted" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.trusted),
      "relocatable" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.relocatable),
      "schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schema),
      "requires" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.requires),
      "comment" -> Writes.OptionWrites(Writes.StringWrites).writes(o.comment)
    ))
  )
}
