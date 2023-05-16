/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait CountryregionRepo {
  def delete(countryregioncode: CountryregionId): ConnectionIO[Boolean]
  def insert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow]
  def insert(unsaved: CountryregionRowUnsaved): ConnectionIO[CountryregionRow]
  def selectAll: Stream[ConnectionIO, CountryregionRow]
  def selectByFieldValues(fieldValues: List[CountryregionFieldOrIdValue[_]]): Stream[ConnectionIO, CountryregionRow]
  def selectById(countryregioncode: CountryregionId): ConnectionIO[Option[CountryregionRow]]
  def selectByIds(countryregioncodes: Array[CountryregionId]): Stream[ConnectionIO, CountryregionRow]
  def update(row: CountryregionRow): ConnectionIO[Boolean]
  def updateFieldValues(countryregioncode: CountryregionId, fieldValues: List[CountryregionFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow]
}
