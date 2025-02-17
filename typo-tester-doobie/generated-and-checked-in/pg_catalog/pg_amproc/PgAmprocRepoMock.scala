/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amproc

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

class PgAmprocRepoMock(map: scala.collection.mutable.Map[PgAmprocId, PgAmprocRow] = scala.collection.mutable.Map.empty) extends PgAmprocRepo {
  override def delete(oid: PgAmprocId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgAmprocFields, PgAmprocRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgAmprocFields, map)
  }
  override def insert(unsaved: PgAmprocRow): ConnectionIO[PgAmprocRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgAmprocFields, PgAmprocRow] = {
    SelectBuilderMock(PgAmprocFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgAmprocRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgAmprocId): ConnectionIO[Option[PgAmprocRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgAmprocId]): Stream[ConnectionIO, PgAmprocRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgAmprocRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgAmprocFields, PgAmprocRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgAmprocFields, map)
  }
  override def upsert(unsaved: PgAmprocRow): ConnectionIO[PgAmprocRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
