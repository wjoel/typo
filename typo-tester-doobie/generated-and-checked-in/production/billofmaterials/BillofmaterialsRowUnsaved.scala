/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import java.time.LocalDateTime

/** This class corresponds to a row in table `production.billofmaterials` which has not been persisted yet */
case class BillofmaterialsRowUnsaved(
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  componentid: ProductId,
  /** Date the component stopped being used in the assembly item. */
  enddate: Option[LocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID). */
  bomlevel: Int,
  /** Default: nextval('production.billofmaterials_billofmaterialsid_seq'::regclass)
      Primary key for BillOfMaterials records. */
  billofmaterialsid: Defaulted[BillofmaterialsId] = Defaulted.UseDefault,
  /** Default: now()
      Date the component started being used in the assembly item. */
  startdate: Defaulted[LocalDateTime] = Defaulted.UseDefault,
  /** Default: 1.00
      Quantity of the component needed to create the assembly. */
  perassemblyqty: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(billofmaterialsidDefault: => BillofmaterialsId, startdateDefault: => LocalDateTime, perassemblyqtyDefault: => BigDecimal, modifieddateDefault: => LocalDateTime): BillofmaterialsRow =
    BillofmaterialsRow(
      productassemblyid = productassemblyid,
      componentid = componentid,
      enddate = enddate,
      unitmeasurecode = unitmeasurecode,
      bomlevel = bomlevel,
      billofmaterialsid = billofmaterialsid match {
                            case Defaulted.UseDefault => billofmaterialsidDefault
                            case Defaulted.Provided(value) => value
                          },
      startdate = startdate match {
                    case Defaulted.UseDefault => startdateDefault
                    case Defaulted.Provided(value) => value
                  },
      perassemblyqty = perassemblyqty match {
                         case Defaulted.UseDefault => perassemblyqtyDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}

