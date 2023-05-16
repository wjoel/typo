/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class BusinessentitycontactRepoMock(toRow: Function1[BusinessentitycontactRowUnsaved, BusinessentitycontactRow],
                                    map: scala.collection.mutable.Map[BusinessentitycontactId, BusinessentitycontactRow] = scala.collection.mutable.Map.empty) extends BusinessentitycontactRepo {
  override def delete(compositeId: BusinessentitycontactId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def insert(unsaved: BusinessentitycontactRow): ConnectionIO[BusinessentitycontactRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: BusinessentitycontactRowUnsaved): ConnectionIO[BusinessentitycontactRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, BusinessentitycontactRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[BusinessentitycontactFieldOrIdValue[_]]): Stream[ConnectionIO, BusinessentitycontactRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, BusinessentitycontactFieldValue.businessentityid(value)) => acc.filter(_.businessentityid == value)
        case (acc, BusinessentitycontactFieldValue.personid(value)) => acc.filter(_.personid == value)
        case (acc, BusinessentitycontactFieldValue.contacttypeid(value)) => acc.filter(_.contacttypeid == value)
        case (acc, BusinessentitycontactFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
        case (acc, BusinessentitycontactFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(compositeId: BusinessentitycontactId): ConnectionIO[Option[BusinessentitycontactRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: BusinessentitycontactRow): ConnectionIO[Boolean] = {
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
  override def updateFieldValues(compositeId: BusinessentitycontactId, fieldValues: List[BusinessentitycontactFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(compositeId) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, BusinessentitycontactFieldValue.rowguid(value)) => acc.copy(rowguid = value)
            case (acc, BusinessentitycontactFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
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
  override def upsert(unsaved: BusinessentitycontactRow): ConnectionIO[BusinessentitycontactRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}
