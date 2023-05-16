/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.time.LocalDateTime
import java.util.UUID

case class CustomerRow(
  /** Primary key. */
  customerid: CustomerId,
  /** Foreign key to Person.BusinessEntityID
      Points to [[person.person.PersonRow.businessentityid]] */
  personid: Option[BusinessentityId],
  /** Foreign key to Store.BusinessEntityID
      Points to [[store.StoreRow.businessentityid]] */
  storeid: Option[BusinessentityId],
  /** ID of the territory in which the customer is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  rowguid: UUID,
  modifieddate: LocalDateTime
)


