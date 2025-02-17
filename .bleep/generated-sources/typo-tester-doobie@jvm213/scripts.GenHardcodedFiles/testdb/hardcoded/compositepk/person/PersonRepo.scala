/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PersonRepo {
  def delete(compositeId: PersonId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PersonFields, PersonRow]
  def insert(unsaved: PersonRow): ConnectionIO[PersonRow]
  def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow]
  def select: SelectBuilder[PersonFields, PersonRow]
  def selectAll: Stream[ConnectionIO, PersonRow]
  def selectById(compositeId: PersonId): ConnectionIO[Option[PersonRow]]
  def update(row: PersonRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PersonFields, PersonRow]
  def upsert(unsaved: PersonRow): ConnectionIO[PersonRow]
}
