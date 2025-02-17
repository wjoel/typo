/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

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

class ProductproductphotoRepoMock(toRow: Function1[ProductproductphotoRowUnsaved, ProductproductphotoRow],
                                  map: scala.collection.mutable.Map[ProductproductphotoId, ProductproductphotoRow] = scala.collection.mutable.Map.empty) extends ProductproductphotoRepo {
  override def delete(compositeId: ProductproductphotoId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductproductphotoFields, map)
  }
  override def insert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: ProductproductphotoRowUnsaved): ConnectionIO[ProductproductphotoRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    SelectBuilderMock(ProductproductphotoFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductproductphotoRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: ProductproductphotoId): ConnectionIO[Option[ProductproductphotoRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: ProductproductphotoRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductproductphotoFields, map)
  }
  override def upsert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}
