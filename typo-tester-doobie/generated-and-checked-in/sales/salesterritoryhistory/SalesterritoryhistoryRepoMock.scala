/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class SalesterritoryhistoryRepoMock(toRow: Function1[SalesterritoryhistoryRowUnsaved, SalesterritoryhistoryRow],
                                    map: scala.collection.mutable.Map[SalesterritoryhistoryId, SalesterritoryhistoryRow] = scala.collection.mutable.Map.empty) extends SalesterritoryhistoryRepo {
  override def delete(compositeId: SalesterritoryhistoryId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def insert(unsaved: SalesterritoryhistoryRow): ConnectionIO[SalesterritoryhistoryRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: SalesterritoryhistoryRowUnsaved): ConnectionIO[SalesterritoryhistoryRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, SalesterritoryhistoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[SalesterritoryhistoryFieldOrIdValue[_]]): Stream[ConnectionIO, SalesterritoryhistoryRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, SalesterritoryhistoryFieldValue.businessentityid(value)) => acc.filter(_.businessentityid == value)
        case (acc, SalesterritoryhistoryFieldValue.territoryid(value)) => acc.filter(_.territoryid == value)
        case (acc, SalesterritoryhistoryFieldValue.startdate(value)) => acc.filter(_.startdate == value)
        case (acc, SalesterritoryhistoryFieldValue.enddate(value)) => acc.filter(_.enddate == value)
        case (acc, SalesterritoryhistoryFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
        case (acc, SalesterritoryhistoryFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(compositeId: SalesterritoryhistoryId): ConnectionIO[Option[SalesterritoryhistoryRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: SalesterritoryhistoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row)
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(compositeId: SalesterritoryhistoryId, fieldValues: List[SalesterritoryhistoryFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(compositeId) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, SalesterritoryhistoryFieldValue.enddate(value)) => acc.copy(enddate = value)
            case (acc, SalesterritoryhistoryFieldValue.rowguid(value)) => acc.copy(rowguid = value)
            case (acc, SalesterritoryhistoryFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
          }
          if (updatedRow != oldRow) {
            map.put(compositeId, updatedRow)
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: SalesterritoryhistoryRow): ConnectionIO[SalesterritoryhistoryRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}
