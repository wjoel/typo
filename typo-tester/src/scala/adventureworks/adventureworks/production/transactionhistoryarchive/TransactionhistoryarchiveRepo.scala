/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import java.sql.Connection

trait TransactionhistoryarchiveRepo {
  def delete(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Boolean
  def insert(transactionid: TransactionhistoryarchiveId, unsaved: TransactionhistoryarchiveRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[TransactionhistoryarchiveRow]
  def selectByFieldValues(fieldValues: List[TransactionhistoryarchiveFieldOrIdValue[_]])(implicit c: Connection): List[TransactionhistoryarchiveRow]
  def selectById(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Option[TransactionhistoryarchiveRow]
  def selectByIds(transactionids: List[TransactionhistoryarchiveId])(implicit c: Connection): List[TransactionhistoryarchiveRow]
  def update(row: TransactionhistoryarchiveRow)(implicit c: Connection): Boolean
  def updateFieldValues(transactionid: TransactionhistoryarchiveId, fieldValues: List[TransactionhistoryarchiveFieldValue[_]])(implicit c: Connection): Boolean
}
