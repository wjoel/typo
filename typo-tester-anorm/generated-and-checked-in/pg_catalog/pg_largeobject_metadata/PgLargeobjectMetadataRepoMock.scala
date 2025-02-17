/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject_metadata

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

class PgLargeobjectMetadataRepoMock(map: scala.collection.mutable.Map[PgLargeobjectMetadataId, PgLargeobjectMetadataRow] = scala.collection.mutable.Map.empty) extends PgLargeobjectMetadataRepo {
  override def delete(oid: PgLargeobjectMetadataId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgLargeobjectMetadataFields, map)
  }
  override def insert(unsaved: PgLargeobjectMetadataRow)(implicit c: Connection): PgLargeobjectMetadataRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow] = {
    SelectBuilderMock(PgLargeobjectMetadataFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgLargeobjectMetadataRow] = {
    map.values.toList
  }
  override def selectById(oid: PgLargeobjectMetadataId)(implicit c: Connection): Option[PgLargeobjectMetadataRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgLargeobjectMetadataId])(implicit c: Connection): List[PgLargeobjectMetadataRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgLargeobjectMetadataRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgLargeobjectMetadataFields, map)
  }
  override def upsert(unsaved: PgLargeobjectMetadataRow)(implicit c: Connection): PgLargeobjectMetadataRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
