/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyearsdata

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VsalespersonsalesbyfiscalyearsdataRow(
  /** Points to [[salesorderheader.SalesorderheaderRow.salespersonid]] */
  salespersonid: Option[BusinessentityId],
  fullname: Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: Option[String],
  salesterritory: Option[Name],
  salestotal: Option[BigDecimal],
  fiscalyear: Option[BigDecimal]
)

object VsalespersonsalesbyfiscalyearsdataRow {
  implicit val oFormat: OFormat[VsalespersonsalesbyfiscalyearsdataRow] = new OFormat[VsalespersonsalesbyfiscalyearsdataRow]{
    override def writes(o: VsalespersonsalesbyfiscalyearsdataRow): JsObject =
      Json.obj(
        "salespersonid" -> o.salespersonid,
        "fullname" -> o.fullname,
        "jobtitle" -> o.jobtitle,
        "salesterritory" -> o.salesterritory,
        "salestotal" -> o.salestotal,
        "fiscalyear" -> o.fiscalyear
      )
  
    override def reads(json: JsValue): JsResult[VsalespersonsalesbyfiscalyearsdataRow] = {
      JsResult.fromTry(
        Try(
          VsalespersonsalesbyfiscalyearsdataRow(
            salespersonid = json.\("salespersonid").toOption.map(_.as[BusinessentityId]),
            fullname = json.\("fullname").toOption.map(_.as[String]),
            jobtitle = json.\("jobtitle").toOption.map(_.as[String]),
            salesterritory = json.\("salesterritory").toOption.map(_.as[Name]),
            salestotal = json.\("salestotal").toOption.map(_.as[BigDecimal]),
            fiscalyear = json.\("fiscalyear").toOption.map(_.as[BigDecimal])
          )
        )
      )
    }
  }
}
