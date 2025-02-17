/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

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

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[PersonId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete(id: PersonId)(implicit c: Connection): Boolean = {
    map.remove(id).isDefined
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersonFields, map)
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    if (map.contains(unsaved.id))
      sys.error(s"id ${unsaved.id} already exists")
    else
      map.put(unsaved.id, unsaved)
    unsaved
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderMock(PersonFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    map.values.toList
  }
  override def selectById(id: PersonId)(implicit c: Connection): Option[PersonRow] = {
    map.get(id)
  }
  override def selectByIds(ids: Array[PersonId])(implicit c: Connection): List[PersonRow] = {
    ids.flatMap(map.get).toList
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    map.get(row.id) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.id, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersonFields, map)
  }
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    map.put(unsaved.id, unsaved)
    unsaved
  }
}
