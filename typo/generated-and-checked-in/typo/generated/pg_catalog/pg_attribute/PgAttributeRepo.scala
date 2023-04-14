/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_attribute

import java.sql.Connection

trait PgAttributeRepo {
  def delete(compositeId: PgAttributeId)(implicit c: Connection): Boolean
  def insert(compositeId: PgAttributeId, unsaved: PgAttributeRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[PgAttributeRow]
  def selectByFieldValues(fieldValues: List[PgAttributeFieldOrIdValue[_]])(implicit c: Connection): List[PgAttributeRow]
  def selectById(compositeId: PgAttributeId)(implicit c: Connection): Option[PgAttributeRow]
  def selectByUnique(attrelid: /* oid */ Long, attname: String)(implicit c: Connection): Option[PgAttributeRow]
  def update(row: PgAttributeRow)(implicit c: Connection): Boolean
  def updateFieldValues(compositeId: PgAttributeId, fieldValues: List[PgAttributeFieldValue[_]])(implicit c: Connection): Boolean
}
