/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_collation

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

class PgCollationRepoMock(map: scala.collection.mutable.Map[PgCollationId, PgCollationRow] = scala.collection.mutable.Map.empty) extends PgCollationRepo {
  override def delete(oid: PgCollationId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgCollationFields, PgCollationRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgCollationFields, map)
  }
  override def insert(unsaved: PgCollationRow)(implicit c: Connection): PgCollationRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgCollationFields, PgCollationRow] = {
    SelectBuilderMock(PgCollationFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgCollationRow] = {
    map.values.toList
  }
  override def selectById(oid: PgCollationId)(implicit c: Connection): Option[PgCollationRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgCollationId])(implicit c: Connection): List[PgCollationRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgCollationRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgCollationFields, PgCollationRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgCollationFields, map)
  }
  override def upsert(unsaved: PgCollationRow)(implicit c: Connection): PgCollationRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
