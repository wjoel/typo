/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class ProductinventoryRepoMock(toRow: Function1[ProductinventoryRowUnsaved, ProductinventoryRow],
                               map: scala.collection.mutable.Map[ProductinventoryId, ProductinventoryRow] = scala.collection.mutable.Map.empty) extends ProductinventoryRepo {
  override def delete(compositeId: ProductinventoryId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductinventoryFields, map)
  }
  override def insert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: ProductinventoryRowUnsaved): ConnectionIO[ProductinventoryRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow] = {
    SelectBuilderMock(ProductinventoryFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductinventoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: ProductinventoryId): ConnectionIO[Option[ProductinventoryRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: ProductinventoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductinventoryFields, map)
  }
  override def upsert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}
