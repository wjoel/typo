/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_transform

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

class PgTransformRepoMock(map: scala.collection.mutable.Map[PgTransformId, PgTransformRow] = scala.collection.mutable.Map.empty) extends PgTransformRepo {
  override def delete(oid: PgTransformId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgTransformFields, PgTransformRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgTransformFields, map)
  }
  override def insert(unsaved: PgTransformRow): ConnectionIO[PgTransformRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgTransformFields, PgTransformRow] = {
    SelectBuilderMock(PgTransformFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgTransformRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgTransformId): ConnectionIO[Option[PgTransformRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgTransformId]): Stream[ConnectionIO, PgTransformRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgTransformRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgTransformFields, PgTransformRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgTransformFields, map)
  }
  override def upsert(unsaved: PgTransformRow): ConnectionIO[PgTransformRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
