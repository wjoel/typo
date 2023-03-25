/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgBackendMemoryContextsRow(
  name: Option[String],
  ident: Option[String],
  parent: Option[String],
  level: Option[Int],
  totalBytes: Option[Long],
  totalNblocks: Option[Long],
  freeBytes: Option[Long],
  freeChunks: Option[Long],
  usedBytes: Option[Long]
)

object PgBackendMemoryContextsRow {
  def rowParser(prefix: String): RowParser[PgBackendMemoryContextsRow] = { row =>
    Success(
      PgBackendMemoryContextsRow(
        name = row[Option[String]](prefix + "name"),
        ident = row[Option[String]](prefix + "ident"),
        parent = row[Option[String]](prefix + "parent"),
        level = row[Option[Int]](prefix + "level"),
        totalBytes = row[Option[Long]](prefix + "total_bytes"),
        totalNblocks = row[Option[Long]](prefix + "total_nblocks"),
        freeBytes = row[Option[Long]](prefix + "free_bytes"),
        freeChunks = row[Option[Long]](prefix + "free_chunks"),
        usedBytes = row[Option[Long]](prefix + "used_bytes")
      )
    )
  }

  implicit val oFormat: OFormat[PgBackendMemoryContextsRow] = new OFormat[PgBackendMemoryContextsRow]{
    override def writes(o: PgBackendMemoryContextsRow): JsObject =
      Json.obj(
        "name" -> o.name,
      "ident" -> o.ident,
      "parent" -> o.parent,
      "level" -> o.level,
      "total_bytes" -> o.totalBytes,
      "total_nblocks" -> o.totalNblocks,
      "free_bytes" -> o.freeBytes,
      "free_chunks" -> o.freeChunks,
      "used_bytes" -> o.usedBytes
      )

    override def reads(json: JsValue): JsResult[PgBackendMemoryContextsRow] = {
      JsResult.fromTry(
        Try(
          PgBackendMemoryContextsRow(
            name = json.\("name").toOption.map(_.as[String]),
            ident = json.\("ident").toOption.map(_.as[String]),
            parent = json.\("parent").toOption.map(_.as[String]),
            level = json.\("level").toOption.map(_.as[Int]),
            totalBytes = json.\("total_bytes").toOption.map(_.as[Long]),
            totalNblocks = json.\("total_nblocks").toOption.map(_.as[Long]),
            freeBytes = json.\("free_bytes").toOption.map(_.as[Long]),
            freeChunks = json.\("free_chunks").toOption.map(_.as[Long]),
            usedBytes = json.\("used_bytes").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
