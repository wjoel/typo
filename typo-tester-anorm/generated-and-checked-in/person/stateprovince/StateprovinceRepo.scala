/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import java.sql.Connection

trait StateprovinceRepo {
  def delete(stateprovinceid: StateprovinceId)(implicit c: Connection): Boolean
  def insert(unsaved: StateprovinceRow)(implicit c: Connection): StateprovinceRow
  def insert(unsaved: StateprovinceRowUnsaved)(implicit c: Connection): StateprovinceRow
  def selectAll(implicit c: Connection): List[StateprovinceRow]
  def selectByFieldValues(fieldValues: List[StateprovinceFieldOrIdValue[_]])(implicit c: Connection): List[StateprovinceRow]
  def selectById(stateprovinceid: StateprovinceId)(implicit c: Connection): Option[StateprovinceRow]
  def selectByIds(stateprovinceids: Array[StateprovinceId])(implicit c: Connection): List[StateprovinceRow]
  def update(row: StateprovinceRow)(implicit c: Connection): Boolean
  def updateFieldValues(stateprovinceid: StateprovinceId, fieldValues: List[StateprovinceFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: StateprovinceRow)(implicit c: Connection): StateprovinceRow
}