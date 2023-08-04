/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

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

class PgProcRepoMock(map: scala.collection.mutable.Map[PgProcId, PgProcRow] = scala.collection.mutable.Map.empty) extends PgProcRepo {
  override def delete(oid: PgProcId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgProcFields, PgProcRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgProcFields, map)
  }
  override def insert(unsaved: PgProcRow): ConnectionIO[PgProcRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgProcFields, PgProcRow] = {
    SelectBuilderMock(PgProcFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgProcRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgProcId): ConnectionIO[Option[PgProcRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgProcId]): Stream[ConnectionIO, PgProcRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgProcRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgProcFields, PgProcRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgProcFields, map)
  }
  override def upsert(unsaved: PgProcRow): ConnectionIO[PgProcRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}