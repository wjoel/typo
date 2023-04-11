/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import java.sql.Connection

trait PersonphoneRepo {
  def delete(compositeId: PersonphoneId)(implicit c: Connection): Boolean
  def insert(compositeId: PersonphoneId, unsaved: PersonphoneRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[PersonphoneRow]
  def selectByFieldValues(fieldValues: List[PersonphoneFieldOrIdValue[_]])(implicit c: Connection): List[PersonphoneRow]
  def selectById(compositeId: PersonphoneId)(implicit c: Connection): Option[PersonphoneRow]
  def update(row: PersonphoneRow)(implicit c: Connection): Boolean
  def updateFieldValues(compositeId: PersonphoneId, fieldValues: List[PersonphoneFieldValue[_]])(implicit c: Connection): Boolean
}
