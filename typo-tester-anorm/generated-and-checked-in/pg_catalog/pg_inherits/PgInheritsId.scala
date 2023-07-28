/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `pg_catalog.pg_inherits` */
case class PgInheritsId(inhrelid: /* oid */ Long, inhseqno: Int)
object PgInheritsId {
  implicit val ordering: Ordering[PgInheritsId] = Ordering.by(x => (x.inhrelid, x.inhseqno))
  implicit val reads: Reads[PgInheritsId] = Reads[PgInheritsId](json => JsResult.fromTry(
      Try(
        PgInheritsId(
          inhrelid = json.\("inhrelid").as(Reads.LongReads),
          inhseqno = json.\("inhseqno").as(Reads.IntReads)
        )
      )
    ),
  )
  implicit val writes: OWrites[PgInheritsId] = OWrites[PgInheritsId](o =>
    new JsObject(ListMap[String, JsValue](
      "inhrelid" -> Writes.LongWrites.writes(o.inhrelid),
      "inhseqno" -> Writes.IntWrites.writes(o.inhseqno)
    ))
  )
}
