/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `humanresources.employeepayhistory` */
case class EmployeepayhistoryId(businessentityid: BusinessentityId, ratechangedate: TypoLocalDateTime)
object EmployeepayhistoryId {
  implicit def ordering(implicit O0: Ordering[TypoLocalDateTime]): Ordering[EmployeepayhistoryId] = Ordering.by(x => (x.businessentityid, x.ratechangedate))
  implicit val reads: Reads[EmployeepayhistoryId] = Reads[EmployeepayhistoryId](json => JsResult.fromTry(
      Try(
        EmployeepayhistoryId(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          ratechangedate = json.\("ratechangedate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  implicit val writes: OWrites[EmployeepayhistoryId] = OWrites[EmployeepayhistoryId](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "ratechangedate" -> TypoLocalDateTime.writes.writes(o.ratechangedate)
    ))
  )
}
