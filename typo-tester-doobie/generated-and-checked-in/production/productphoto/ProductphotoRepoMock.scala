/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class ProductphotoRepoMock(toRow: Function1[ProductphotoRowUnsaved, ProductphotoRow],
                           map: scala.collection.mutable.Map[ProductphotoId, ProductphotoRow] = scala.collection.mutable.Map.empty) extends ProductphotoRepo {
  override def delete(productphotoid: ProductphotoId): ConnectionIO[Boolean] = {
    delay(map.remove(productphotoid).isDefined)
  }
  override def insert(unsaved: ProductphotoRow): ConnectionIO[ProductphotoRow] = {
    delay {
      if (map.contains(unsaved.productphotoid))
        sys.error(s"id ${unsaved.productphotoid} already exists")
      else
        map.put(unsaved.productphotoid, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: ProductphotoRowUnsaved): ConnectionIO[ProductphotoRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, ProductphotoRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[ProductphotoFieldOrIdValue[_]]): Stream[ConnectionIO, ProductphotoRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, ProductphotoFieldValue.productphotoid(value)) => acc.filter(_.productphotoid == value)
        case (acc, ProductphotoFieldValue.thumbnailphoto(value)) => acc.filter(_.thumbnailphoto == value)
        case (acc, ProductphotoFieldValue.thumbnailphotofilename(value)) => acc.filter(_.thumbnailphotofilename == value)
        case (acc, ProductphotoFieldValue.largephoto(value)) => acc.filter(_.largephoto == value)
        case (acc, ProductphotoFieldValue.largephotofilename(value)) => acc.filter(_.largephotofilename == value)
        case (acc, ProductphotoFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(productphotoid: ProductphotoId): ConnectionIO[Option[ProductphotoRow]] = {
    delay(map.get(productphotoid))
  }
  override def selectByIds(productphotoids: Array[ProductphotoId]): Stream[ConnectionIO, ProductphotoRow] = {
    Stream.emits(productphotoids.flatMap(map.get).toList)
  }
  override def update(row: ProductphotoRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.productphotoid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productphotoid, row)
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(productphotoid: ProductphotoId, fieldValues: List[ProductphotoFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(productphotoid) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, ProductphotoFieldValue.thumbnailphoto(value)) => acc.copy(thumbnailphoto = value)
            case (acc, ProductphotoFieldValue.thumbnailphotofilename(value)) => acc.copy(thumbnailphotofilename = value)
            case (acc, ProductphotoFieldValue.largephoto(value)) => acc.copy(largephoto = value)
            case (acc, ProductphotoFieldValue.largephotofilename(value)) => acc.copy(largephotofilename = value)
            case (acc, ProductphotoFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
          }
          if (updatedRow != oldRow) {
            map.put(productphotoid, updatedRow)
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: ProductphotoRow): ConnectionIO[ProductphotoRow] = {
    delay {
      map.put(unsaved.productphotoid, unsaved)
      unsaved
    }
  }
}
