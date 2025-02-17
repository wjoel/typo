/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.TypoLocalDateTime
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class ProductphotoStructure[Row](val prefix: Option[String], val extract: Row => ProductphotoRow, val merge: (Row, ProductphotoRow) => Row)
  extends Relation[ProductphotoFields, ProductphotoRow, Row]
    with ProductphotoFields[Row] { outer =>

  override val productphotoid = new IdField[ProductphotoId, Row](prefix, "productphotoid", None, Some("int4"))(x => extract(x).productphotoid, (row, value) => merge(row, extract(row).copy(productphotoid = value)))
  override val thumbnailphoto = new OptField[Array[Byte], Row](prefix, "thumbnailphoto", None, Some("bytea"))(x => extract(x).thumbnailphoto, (row, value) => merge(row, extract(row).copy(thumbnailphoto = value)))
  override val thumbnailphotofilename = new OptField[/* max 50 chars */ String, Row](prefix, "thumbnailphotofilename", None, None)(x => extract(x).thumbnailphotofilename, (row, value) => merge(row, extract(row).copy(thumbnailphotofilename = value)))
  override val largephoto = new OptField[Array[Byte], Row](prefix, "largephoto", None, Some("bytea"))(x => extract(x).largephoto, (row, value) => merge(row, extract(row).copy(largephoto = value)))
  override val largephotofilename = new OptField[/* max 50 chars */ String, Row](prefix, "largephotofilename", None, None)(x => extract(x).largephotofilename, (row, value) => merge(row, extract(row).copy(largephotofilename = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ProductphotoRow, merge: (NewRow, ProductphotoRow) => NewRow): ProductphotoStructure[NewRow] =
    new ProductphotoStructure(prefix, extract, merge)
}
