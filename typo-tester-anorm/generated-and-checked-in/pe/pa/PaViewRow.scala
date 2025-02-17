/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PaViewRow(
  id: Option[Int],
  /** Points to [[person.password.PasswordRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.password.PasswordRow.passwordhash]] */
  passwordhash: Option[/* max 128 chars */ String],
  /** Points to [[person.password.PasswordRow.passwordsalt]] */
  passwordsalt: Option[/* max 10 chars */ String],
  /** Points to [[person.password.PasswordRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.password.PasswordRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PaViewRow {
  implicit lazy val reads: Reads[PaViewRow] = Reads[PaViewRow](json => JsResult.fromTry(
      Try(
        PaViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          passwordhash = json.\("passwordhash").toOption.map(_.as(Reads.StringReads)),
          passwordsalt = json.\("passwordsalt").toOption.map(_.as(Reads.StringReads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PaViewRow] = RowParser[PaViewRow] { row =>
    Success(
      PaViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        businessentityid = row(idx + 1)(Column.columnToOption(BusinessentityId.column)),
        passwordhash = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        passwordsalt = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        rowguid = row(idx + 4)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PaViewRow] = OWrites[PaViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "passwordhash" -> Writes.OptionWrites(Writes.StringWrites).writes(o.passwordhash),
      "passwordsalt" -> Writes.OptionWrites(Writes.StringWrites).writes(o.passwordsalt),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
