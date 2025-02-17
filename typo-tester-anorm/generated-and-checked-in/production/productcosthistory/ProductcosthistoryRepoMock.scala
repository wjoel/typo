/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

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

class ProductcosthistoryRepoMock(toRow: Function1[ProductcosthistoryRowUnsaved, ProductcosthistoryRow],
                                 map: scala.collection.mutable.Map[ProductcosthistoryId, ProductcosthistoryRow] = scala.collection.mutable.Map.empty) extends ProductcosthistoryRepo {
  override def delete(compositeId: ProductcosthistoryId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductcosthistoryFields, map)
  }
  override def insert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow = {
    if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    unsaved
  }
  override def insert(unsaved: ProductcosthistoryRowUnsaved)(implicit c: Connection): ProductcosthistoryRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    SelectBuilderMock(ProductcosthistoryFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductcosthistoryRow] = {
    map.values.toList
  }
  override def selectById(compositeId: ProductcosthistoryId)(implicit c: Connection): Option[ProductcosthistoryRow] = {
    map.get(compositeId)
  }
  override def update(row: ProductcosthistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductcosthistoryFields, map)
  }
  override def upsert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow = {
    map.put(unsaved.compositeId, unsaved)
    unsaved
  }
}
