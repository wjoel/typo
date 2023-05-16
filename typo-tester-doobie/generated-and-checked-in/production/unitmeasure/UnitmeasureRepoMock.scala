/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class UnitmeasureRepoMock(toRow: Function1[UnitmeasureRowUnsaved, UnitmeasureRow],
                          map: scala.collection.mutable.Map[UnitmeasureId, UnitmeasureRow] = scala.collection.mutable.Map.empty) extends UnitmeasureRepo {
  override def delete(unitmeasurecode: UnitmeasureId): ConnectionIO[Boolean] = {
    delay(map.remove(unitmeasurecode).isDefined)
  }
  override def insert(unsaved: UnitmeasureRow): ConnectionIO[UnitmeasureRow] = {
    delay {
      if (map.contains(unsaved.unitmeasurecode))
        sys.error(s"id ${unsaved.unitmeasurecode} already exists")
      else
        map.put(unsaved.unitmeasurecode, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: UnitmeasureRowUnsaved): ConnectionIO[UnitmeasureRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, UnitmeasureRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[UnitmeasureFieldOrIdValue[_]]): Stream[ConnectionIO, UnitmeasureRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, UnitmeasureFieldValue.unitmeasurecode(value)) => acc.filter(_.unitmeasurecode == value)
        case (acc, UnitmeasureFieldValue.name(value)) => acc.filter(_.name == value)
        case (acc, UnitmeasureFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(unitmeasurecode: UnitmeasureId): ConnectionIO[Option[UnitmeasureRow]] = {
    delay(map.get(unitmeasurecode))
  }
  override def selectByIds(unitmeasurecodes: Array[UnitmeasureId]): Stream[ConnectionIO, UnitmeasureRow] = {
    Stream.emits(unitmeasurecodes.flatMap(map.get).toList)
  }
  override def update(row: UnitmeasureRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.unitmeasurecode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.unitmeasurecode, row)
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(unitmeasurecode: UnitmeasureId, fieldValues: List[UnitmeasureFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(unitmeasurecode) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, UnitmeasureFieldValue.name(value)) => acc.copy(name = value)
            case (acc, UnitmeasureFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
          }
          if (updatedRow != oldRow) {
            map.put(unitmeasurecode, updatedRow)
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: UnitmeasureRow): ConnectionIO[UnitmeasureRow] = {
    delay {
      map.put(unsaved.unitmeasurecode, unsaved)
      unsaved
    }
  }
}
