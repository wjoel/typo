/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.public.Name
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.productmodel` which has not been persisted yet */
case class ProductmodelRowUnsaved(
  /** Product model description. */
  name: Name,
  /** Detailed product catalog information in xml format. */
  catalogdescription: Option[TypoXml],
  /** Manufacturing instructions in xml format. */
  instructions: Option[TypoXml],
  /** Default: nextval('production.productmodel_productmodelid_seq'::regclass)
      Primary key for ProductModel records. */
  productmodelid: Defaulted[ProductmodelId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productmodelidDefault: => ProductmodelId, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): ProductmodelRow =
    ProductmodelRow(
      name = name,
      catalogdescription = catalogdescription,
      instructions = instructions,
      productmodelid = productmodelid match {
                         case Defaulted.UseDefault => productmodelidDefault
                         case Defaulted.Provided(value) => value
                       },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelRowUnsaved {
  implicit lazy val reads: Reads[ProductmodelRowUnsaved] = Reads[ProductmodelRowUnsaved](json => JsResult.fromTry(
      Try(
        ProductmodelRowUnsaved(
          name = json.\("name").as(Name.reads),
          catalogdescription = json.\("catalogdescription").toOption.map(_.as(TypoXml.reads)),
          instructions = json.\("instructions").toOption.map(_.as(TypoXml.reads)),
          productmodelid = json.\("productmodelid").as(Defaulted.reads(ProductmodelId.reads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductmodelRowUnsaved] = OWrites[ProductmodelRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Name.writes.writes(o.name),
      "catalogdescription" -> Writes.OptionWrites(TypoXml.writes).writes(o.catalogdescription),
      "instructions" -> Writes.OptionWrites(TypoXml.writes).writes(o.instructions),
      "productmodelid" -> Defaulted.writes(ProductmodelId.writes).writes(o.productmodelid),
      "rowguid" -> Defaulted.writes(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
