/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tablespace

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

class PgTablespaceRepoMock(map: scala.collection.mutable.Map[PgTablespaceId, PgTablespaceRow] = scala.collection.mutable.Map.empty) extends PgTablespaceRepo {
  override def delete(oid: PgTablespaceId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgTablespaceFields, PgTablespaceRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgTablespaceFields, map)
  }
  override def insert(unsaved: PgTablespaceRow)(implicit c: Connection): PgTablespaceRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgTablespaceFields, PgTablespaceRow] = {
    SelectBuilderMock(PgTablespaceFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgTablespaceRow] = {
    map.values.toList
  }
  override def selectById(oid: PgTablespaceId)(implicit c: Connection): Option[PgTablespaceRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgTablespaceId])(implicit c: Connection): List[PgTablespaceRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgTablespaceRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgTablespaceFields, PgTablespaceRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgTablespaceFields, map)
  }
  override def upsert(unsaved: PgTablespaceRow)(implicit c: Connection): PgTablespaceRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
