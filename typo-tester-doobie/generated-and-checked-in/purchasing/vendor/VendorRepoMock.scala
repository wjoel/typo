/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class VendorRepoMock(toRow: Function1[VendorRowUnsaved, VendorRow],
                     map: scala.collection.mutable.Map[BusinessentityId, VendorRow] = scala.collection.mutable.Map.empty) extends VendorRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    delay(map.remove(businessentityid).isDefined)
  }
  override def insert(unsaved: VendorRow): ConnectionIO[VendorRow] = {
    delay {
      if (map.contains(unsaved.businessentityid))
        sys.error(s"id ${unsaved.businessentityid} already exists")
      else
        map.put(unsaved.businessentityid, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: VendorRowUnsaved): ConnectionIO[VendorRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, VendorRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[VendorFieldOrIdValue[_]]): Stream[ConnectionIO, VendorRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, VendorFieldValue.businessentityid(value)) => acc.filter(_.businessentityid == value)
        case (acc, VendorFieldValue.accountnumber(value)) => acc.filter(_.accountnumber == value)
        case (acc, VendorFieldValue.name(value)) => acc.filter(_.name == value)
        case (acc, VendorFieldValue.creditrating(value)) => acc.filter(_.creditrating == value)
        case (acc, VendorFieldValue.preferredvendorstatus(value)) => acc.filter(_.preferredvendorstatus == value)
        case (acc, VendorFieldValue.activeflag(value)) => acc.filter(_.activeflag == value)
        case (acc, VendorFieldValue.purchasingwebserviceurl(value)) => acc.filter(_.purchasingwebserviceurl == value)
        case (acc, VendorFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[VendorRow]] = {
    delay(map.get(businessentityid))
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, VendorRow] = {
    Stream.emits(businessentityids.flatMap(map.get).toList)
  }
  override def update(row: VendorRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.businessentityid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.businessentityid, row)
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[VendorFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(businessentityid) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, VendorFieldValue.accountnumber(value)) => acc.copy(accountnumber = value)
            case (acc, VendorFieldValue.name(value)) => acc.copy(name = value)
            case (acc, VendorFieldValue.creditrating(value)) => acc.copy(creditrating = value)
            case (acc, VendorFieldValue.preferredvendorstatus(value)) => acc.copy(preferredvendorstatus = value)
            case (acc, VendorFieldValue.activeflag(value)) => acc.copy(activeflag = value)
            case (acc, VendorFieldValue.purchasingwebserviceurl(value)) => acc.copy(purchasingwebserviceurl = value)
            case (acc, VendorFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
          }
          if (updatedRow != oldRow) {
            map.put(businessentityid, updatedRow)
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: VendorRow): ConnectionIO[VendorRow] = {
    delay {
      map.put(unsaved.businessentityid, unsaved)
      unsaved
    }
  }
}
