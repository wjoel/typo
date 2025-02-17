/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_constraint

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

class PgConstraintRepoMock(map: scala.collection.mutable.Map[PgConstraintId, PgConstraintRow] = scala.collection.mutable.Map.empty) extends PgConstraintRepo {
  override def delete(oid: PgConstraintId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgConstraintFields, PgConstraintRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgConstraintFields, map)
  }
  override def insert(unsaved: PgConstraintRow): ConnectionIO[PgConstraintRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgConstraintFields, PgConstraintRow] = {
    SelectBuilderMock(PgConstraintFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgConstraintRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgConstraintId): ConnectionIO[Option[PgConstraintRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgConstraintId]): Stream[ConnectionIO, PgConstraintRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgConstraintRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgConstraintFields, PgConstraintRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgConstraintFields, map)
  }
  override def upsert(unsaved: PgConstraintRow): ConnectionIO[PgConstraintRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
