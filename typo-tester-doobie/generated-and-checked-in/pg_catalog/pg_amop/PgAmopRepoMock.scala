/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amop

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

class PgAmopRepoMock(map: scala.collection.mutable.Map[PgAmopId, PgAmopRow] = scala.collection.mutable.Map.empty) extends PgAmopRepo {
  override def delete(oid: PgAmopId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgAmopFields, PgAmopRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgAmopFields, map)
  }
  override def insert(unsaved: PgAmopRow): ConnectionIO[PgAmopRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgAmopFields, PgAmopRow] = {
    SelectBuilderMock(PgAmopFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgAmopRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgAmopId): ConnectionIO[Option[PgAmopRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgAmopId]): Stream[ConnectionIO, PgAmopRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgAmopRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgAmopFields, PgAmopRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgAmopFields, map)
  }
  override def upsert(unsaved: PgAmopRow): ConnectionIO[PgAmopRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
