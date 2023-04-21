/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class CreditcardRow(
  /** Primary key for CreditCard records. */
  creditcardid: CreditcardId,
  /** Credit card name. */
  cardtype: String,
  /** Credit card number. */
  cardnumber: String,
  /** Credit card expiration month. */
  expmonth: Int,
  /** Credit card expiration year. */
  expyear: Int,
  modifieddate: LocalDateTime
)

object CreditcardRow {
  implicit val oFormat: OFormat[CreditcardRow] = new OFormat[CreditcardRow]{
    override def writes(o: CreditcardRow): JsObject =
      Json.obj(
        "creditcardid" -> o.creditcardid,
        "cardtype" -> o.cardtype,
        "cardnumber" -> o.cardnumber,
        "expmonth" -> o.expmonth,
        "expyear" -> o.expyear,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CreditcardRow] = {
      JsResult.fromTry(
        Try(
          CreditcardRow(
            creditcardid = json.\("creditcardid").as[CreditcardId],
            cardtype = json.\("cardtype").as[String],
            cardnumber = json.\("cardnumber").as[String],
            expmonth = json.\("expmonth").as[Int],
            expyear = json.\("expyear").as[Int],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
