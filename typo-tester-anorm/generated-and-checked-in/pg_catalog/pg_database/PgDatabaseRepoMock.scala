/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class PgDatabaseRepoMock(map: scala.collection.mutable.Map[PgDatabaseId, PgDatabaseRow] = scala.collection.mutable.Map.empty) extends PgDatabaseRepo {
  override def delete(oid: PgDatabaseId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgDatabaseFields, PgDatabaseRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgDatabaseFields, map)
  }
  override def insert(unsaved: PgDatabaseRow)(implicit c: Connection): PgDatabaseRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgDatabaseFields, PgDatabaseRow] = {
    SelectBuilderMock(PgDatabaseFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgDatabaseRow] = {
    map.values.toList
  }
  override def selectById(oid: PgDatabaseId)(implicit c: Connection): Option[PgDatabaseRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgDatabaseId])(implicit c: Connection): List[PgDatabaseRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgDatabaseRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgDatabaseFields, PgDatabaseRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgDatabaseFields, map)
  }
  override def upsert(unsaved: PgDatabaseRow)(implicit c: Connection): PgDatabaseRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
