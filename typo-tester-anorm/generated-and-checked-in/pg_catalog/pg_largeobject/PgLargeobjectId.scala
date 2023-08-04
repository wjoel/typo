/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `pg_catalog.pg_largeobject` */
case class PgLargeobjectId(loid: /* oid */ Long, pageno: Int)
object PgLargeobjectId {
  implicit lazy val ordering: Ordering[PgLargeobjectId] = Ordering.by(x => (x.loid, x.pageno))
  implicit lazy val reads: Reads[PgLargeobjectId] = Reads[PgLargeobjectId](json => JsResult.fromTry(
      Try(
        PgLargeobjectId(
          loid = json.\("loid").as(Reads.LongReads),
          pageno = json.\("pageno").as(Reads.IntReads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[PgLargeobjectId] = OWrites[PgLargeobjectId](o =>
    new JsObject(ListMap[String, JsValue](
      "loid" -> Writes.LongWrites.writes(o.loid),
      "pageno" -> Writes.IntWrites.writes(o.pageno)
    ))
  )
}
