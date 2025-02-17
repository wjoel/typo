/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription_rel

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

class PgSubscriptionRelRepoMock(map: scala.collection.mutable.Map[PgSubscriptionRelId, PgSubscriptionRelRow] = scala.collection.mutable.Map.empty) extends PgSubscriptionRelRepo {
  override def delete(compositeId: PgSubscriptionRelId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def delete: DeleteBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgSubscriptionRelFields, map)
  }
  override def insert(unsaved: PgSubscriptionRelRow)(implicit c: Connection): PgSubscriptionRelRow = {
    if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    SelectBuilderMock(PgSubscriptionRelFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgSubscriptionRelRow] = {
    map.values.toList
  }
  override def selectById(compositeId: PgSubscriptionRelId)(implicit c: Connection): Option[PgSubscriptionRelRow] = {
    map.get(compositeId)
  }
  override def update(row: PgSubscriptionRelRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgSubscriptionRelFields, map)
  }
  override def upsert(unsaved: PgSubscriptionRelRow)(implicit c: Connection): PgSubscriptionRelRow = {
    map.put(unsaved.compositeId, unsaved)
    unsaved
  }
}
