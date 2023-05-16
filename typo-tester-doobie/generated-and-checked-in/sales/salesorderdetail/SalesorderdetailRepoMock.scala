/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class SalesorderdetailRepoMock(toRow: Function1[SalesorderdetailRowUnsaved, SalesorderdetailRow],
                               map: scala.collection.mutable.Map[SalesorderdetailId, SalesorderdetailRow] = scala.collection.mutable.Map.empty) extends SalesorderdetailRepo {
  override def delete(compositeId: SalesorderdetailId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def insert(unsaved: SalesorderdetailRow): ConnectionIO[SalesorderdetailRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: SalesorderdetailRowUnsaved): ConnectionIO[SalesorderdetailRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, SalesorderdetailRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[SalesorderdetailFieldOrIdValue[_]]): Stream[ConnectionIO, SalesorderdetailRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, SalesorderdetailFieldValue.salesorderid(value)) => acc.filter(_.salesorderid == value)
        case (acc, SalesorderdetailFieldValue.salesorderdetailid(value)) => acc.filter(_.salesorderdetailid == value)
        case (acc, SalesorderdetailFieldValue.carriertrackingnumber(value)) => acc.filter(_.carriertrackingnumber == value)
        case (acc, SalesorderdetailFieldValue.orderqty(value)) => acc.filter(_.orderqty == value)
        case (acc, SalesorderdetailFieldValue.productid(value)) => acc.filter(_.productid == value)
        case (acc, SalesorderdetailFieldValue.specialofferid(value)) => acc.filter(_.specialofferid == value)
        case (acc, SalesorderdetailFieldValue.unitprice(value)) => acc.filter(_.unitprice == value)
        case (acc, SalesorderdetailFieldValue.unitpricediscount(value)) => acc.filter(_.unitpricediscount == value)
        case (acc, SalesorderdetailFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
        case (acc, SalesorderdetailFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(compositeId: SalesorderdetailId): ConnectionIO[Option[SalesorderdetailRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: SalesorderdetailRow): ConnectionIO[Boolean] = {
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
  override def updateFieldValues(compositeId: SalesorderdetailId, fieldValues: List[SalesorderdetailFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(compositeId) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, SalesorderdetailFieldValue.carriertrackingnumber(value)) => acc.copy(carriertrackingnumber = value)
            case (acc, SalesorderdetailFieldValue.orderqty(value)) => acc.copy(orderqty = value)
            case (acc, SalesorderdetailFieldValue.productid(value)) => acc.copy(productid = value)
            case (acc, SalesorderdetailFieldValue.specialofferid(value)) => acc.copy(specialofferid = value)
            case (acc, SalesorderdetailFieldValue.unitprice(value)) => acc.copy(unitprice = value)
            case (acc, SalesorderdetailFieldValue.unitpricediscount(value)) => acc.copy(unitpricediscount = value)
            case (acc, SalesorderdetailFieldValue.rowguid(value)) => acc.copy(rowguid = value)
            case (acc, SalesorderdetailFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
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
  override def upsert(unsaved: SalesorderdetailRow): ConnectionIO[SalesorderdetailRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}
