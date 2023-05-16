/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sr

import adventureworks.public.Name
import adventureworks.sales.salesreason.SalesreasonId
import java.time.LocalDateTime

case class SrViewRow(
  id: Option[Int],
  /** Points to [[sales.salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: Option[SalesreasonId],
  /** Points to [[sales.salesreason.SalesreasonRow.name]] */
  name: Option[Name],
  /** Points to [[sales.salesreason.SalesreasonRow.reasontype]] */
  reasontype: Option[Name],
  /** Points to [[sales.salesreason.SalesreasonRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)


