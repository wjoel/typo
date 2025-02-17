/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

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

class CustomerRepoMock(toRow: Function1[CustomerRowUnsaved, CustomerRow],
                       map: scala.collection.mutable.Map[CustomerId, CustomerRow] = scala.collection.mutable.Map.empty) extends CustomerRepo {
  override def delete(customerid: CustomerId): ConnectionIO[Boolean] = {
    delay(map.remove(customerid).isDefined)
  }
  override def delete: DeleteBuilder[CustomerFields, CustomerRow] = {
    DeleteBuilderMock(DeleteParams.empty, CustomerFields, map)
  }
  override def insert(unsaved: CustomerRow): ConnectionIO[CustomerRow] = {
    delay {
      if (map.contains(unsaved.customerid))
        sys.error(s"id ${unsaved.customerid} already exists")
      else
        map.put(unsaved.customerid, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: CustomerRowUnsaved): ConnectionIO[CustomerRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[CustomerFields, CustomerRow] = {
    SelectBuilderMock(CustomerFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CustomerRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(customerid: CustomerId): ConnectionIO[Option[CustomerRow]] = {
    delay(map.get(customerid))
  }
  override def selectByIds(customerids: Array[CustomerId]): Stream[ConnectionIO, CustomerRow] = {
    Stream.emits(customerids.flatMap(map.get).toList)
  }
  override def update(row: CustomerRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.customerid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.customerid, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[CustomerFields, CustomerRow] = {
    UpdateBuilderMock(UpdateParams.empty, CustomerFields, map)
  }
  override def upsert(unsaved: CustomerRow): ConnectionIO[CustomerRow] = {
    delay {
      map.put(unsaved.customerid, unsaved)
      unsaved
    }
  }
}
