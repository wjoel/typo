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

case class EmployeepayhistoryRow(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Date the change in pay is effective */
  ratechangedate: TypoLocalDateTime,
  /** Salary hourly rate. */
  rate: BigDecimal,
  /** 1 = Salary received monthly, 2 = Salary received biweekly */
  payfrequency: Int,
  modifieddate: TypoLocalDateTime
){
   val compositeId: EmployeepayhistoryId = EmployeepayhistoryId(businessentityid, ratechangedate)
 }

object EmployeepayhistoryRow {
  implicit lazy val reads: Reads[EmployeepayhistoryRow] = Reads[EmployeepayhistoryRow](json => JsResult.fromTry(
      Try(
        EmployeepayhistoryRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          ratechangedate = json.\("ratechangedate").as(TypoLocalDateTime.reads),
          rate = json.\("rate").as(Reads.bigDecReads),
          payfrequency = json.\("payfrequency").as(Reads.IntReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EmployeepayhistoryRow] = RowParser[EmployeepayhistoryRow] { row =>
    Success(
      EmployeepayhistoryRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        ratechangedate = row(idx + 1)(TypoLocalDateTime.column),
        rate = row(idx + 2)(Column.columnToScalaBigDecimal),
        payfrequency = row(idx + 3)(Column.columnToInt),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[EmployeepayhistoryRow] = OWrites[EmployeepayhistoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "ratechangedate" -> TypoLocalDateTime.writes.writes(o.ratechangedate),
      "rate" -> Writes.BigDecimalWrites.writes(o.rate),
      "payfrequency" -> Writes.IntWrites.writes(o.payfrequency),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
