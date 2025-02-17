/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

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

class BillofmaterialsRepoMock(toRow: Function1[BillofmaterialsRowUnsaved, BillofmaterialsRow],
                              map: scala.collection.mutable.Map[BillofmaterialsId, BillofmaterialsRow] = scala.collection.mutable.Map.empty) extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Boolean = {
    map.remove(billofmaterialsid).isDefined
  }
  override def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    DeleteBuilderMock(DeleteParams.empty, BillofmaterialsFields, map)
  }
  override def insert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    if (map.contains(unsaved.billofmaterialsid))
      sys.error(s"id ${unsaved.billofmaterialsid} already exists")
    else
      map.put(unsaved.billofmaterialsid, unsaved)
    unsaved
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved)(implicit c: Connection): BillofmaterialsRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    SelectBuilderMock(BillofmaterialsFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[BillofmaterialsRow] = {
    map.values.toList
  }
  override def selectById(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Option[BillofmaterialsRow] = {
    map.get(billofmaterialsid)
  }
  override def selectByIds(billofmaterialsids: Array[BillofmaterialsId])(implicit c: Connection): List[BillofmaterialsRow] = {
    billofmaterialsids.flatMap(map.get).toList
  }
  override def update(row: BillofmaterialsRow)(implicit c: Connection): Boolean = {
    map.get(row.billofmaterialsid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.billofmaterialsid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    UpdateBuilderMock(UpdateParams.empty, BillofmaterialsFields, map)
  }
  override def upsert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    map.put(unsaved.billofmaterialsid, unsaved)
    unsaved
  }
}
