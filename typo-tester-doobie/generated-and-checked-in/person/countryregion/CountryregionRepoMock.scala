/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class CountryregionRepoMock(toRow: Function1[CountryregionRowUnsaved, CountryregionRow],
                            map: scala.collection.mutable.Map[CountryregionId, CountryregionRow] = scala.collection.mutable.Map.empty) extends CountryregionRepo {
  override def delete(countryregioncode: CountryregionId): ConnectionIO[Boolean] = {
    delay(map.remove(countryregioncode).isDefined)
  }
  override def insert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow] = {
    delay {
      if (map.contains(unsaved.countryregioncode))
        sys.error(s"id ${unsaved.countryregioncode} already exists")
      else
        map.put(unsaved.countryregioncode, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: CountryregionRowUnsaved): ConnectionIO[CountryregionRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, CountryregionRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[CountryregionFieldOrIdValue[_]]): Stream[ConnectionIO, CountryregionRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, CountryregionFieldValue.countryregioncode(value)) => acc.filter(_.countryregioncode == value)
        case (acc, CountryregionFieldValue.name(value)) => acc.filter(_.name == value)
        case (acc, CountryregionFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(countryregioncode: CountryregionId): ConnectionIO[Option[CountryregionRow]] = {
    delay(map.get(countryregioncode))
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId]): Stream[ConnectionIO, CountryregionRow] = {
    Stream.emits(countryregioncodes.flatMap(map.get).toList)
  }
  override def update(row: CountryregionRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.countryregioncode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.countryregioncode, row)
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(countryregioncode: CountryregionId, fieldValues: List[CountryregionFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(countryregioncode) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, CountryregionFieldValue.name(value)) => acc.copy(name = value)
            case (acc, CountryregionFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
          }
          if (updatedRow != oldRow) {
            map.put(countryregioncode, updatedRow)
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow] = {
    delay {
      map.put(unsaved.countryregioncode, unsaved)
      unsaved
    }
  }
}