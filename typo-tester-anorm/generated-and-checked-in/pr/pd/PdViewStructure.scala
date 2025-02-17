/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pd

import adventureworks.TypoLocalDateTime
import adventureworks.production.productdescription.ProductdescriptionId
import java.util.UUID
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PdViewStructure[Row](val prefix: Option[String], val extract: Row => PdViewRow, val merge: (Row, PdViewRow) => Row)
  extends Relation[PdViewFields, PdViewRow, Row]
    with PdViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val productdescriptionid = new OptField[ProductdescriptionId, Row](prefix, "productdescriptionid", None, Some("int4"))(x => extract(x).productdescriptionid, (row, value) => merge(row, extract(row).copy(productdescriptionid = value)))
  override val description = new OptField[/* max 400 chars */ String, Row](prefix, "description", None, None)(x => extract(x).description, (row, value) => merge(row, extract(row).copy(description = value)))
  override val rowguid = new OptField[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, productdescriptionid, description, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PdViewRow, merge: (NewRow, PdViewRow) => NewRow): PdViewStructure[NewRow] =
    new PdViewStructure(prefix, extract, merge)
}
