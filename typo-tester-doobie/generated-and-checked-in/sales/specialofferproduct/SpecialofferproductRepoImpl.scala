/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

object SpecialofferproductRepoImpl extends SpecialofferproductRepo {
  override def delete(compositeId: SpecialofferproductId): ConnectionIO[Boolean] = {
    sql"delete from sales.specialofferproduct where specialofferid = ${compositeId.specialofferid} AND productid = ${compositeId.productid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: SpecialofferproductRow): ConnectionIO[SpecialofferproductRow] = {
    sql"""insert into sales.specialofferproduct(specialofferid, productid, rowguid, modifieddate)
          values (${unsaved.specialofferid}::int4, ${unsaved.productid}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning specialofferid, productid, rowguid, modifieddate
       """.query.unique
  }
  override def insert(unsaved: SpecialofferproductRowUnsaved): ConnectionIO[SpecialofferproductRow] = {
    val fs = List(
      Some((Fragment.const(s"specialofferid"), fr"${unsaved.specialofferid}::int4")),
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.specialofferproduct default values
            returning specialofferid, productid, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.specialofferproduct(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning specialofferid, productid, rowguid, modifieddate
         """
    }
    q.query.unique
  
  }
  override def selectAll: Stream[ConnectionIO, SpecialofferproductRow] = {
    sql"select specialofferid, productid, rowguid, modifieddate from sales.specialofferproduct".query[SpecialofferproductRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SpecialofferproductFieldOrIdValue[_]]): Stream[ConnectionIO, SpecialofferproductRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SpecialofferproductFieldValue.specialofferid(value) => fr"specialofferid = $value"
        case SpecialofferproductFieldValue.productid(value) => fr"productid = $value"
        case SpecialofferproductFieldValue.rowguid(value) => fr"rowguid = $value"
        case SpecialofferproductFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.specialofferproduct $where".query[SpecialofferproductRow].stream
  
  }
  override def selectById(compositeId: SpecialofferproductId): ConnectionIO[Option[SpecialofferproductRow]] = {
    sql"select specialofferid, productid, rowguid, modifieddate from sales.specialofferproduct where specialofferid = ${compositeId.specialofferid} AND productid = ${compositeId.productid}".query[SpecialofferproductRow].option
  }
  override def update(row: SpecialofferproductRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.specialofferproduct
          set rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where specialofferid = ${compositeId.specialofferid} AND productid = ${compositeId.productid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(compositeId: SpecialofferproductId, fieldValues: List[SpecialofferproductFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case SpecialofferproductFieldValue.rowguid(value) => fr"rowguid = $value"
            case SpecialofferproductFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.specialofferproduct
              $updates
              where specialofferid = ${compositeId.specialofferid} AND productid = ${compositeId.productid}
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: SpecialofferproductRow): ConnectionIO[SpecialofferproductRow] = {
    sql"""insert into sales.specialofferproduct(specialofferid, productid, rowguid, modifieddate)
          values (
            ${unsaved.specialofferid}::int4,
            ${unsaved.productid}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (specialofferid, productid)
          do update set
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning specialofferid, productid, rowguid, modifieddate
       """.query.unique
  }
  implicit val read: Read[SpecialofferproductRow] =
    new Read[SpecialofferproductRow](
      gets = List(
        (Get[SpecialofferId], Nullability.NoNulls),
        (Get[ProductId], Nullability.NoNulls),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => SpecialofferproductRow(
        specialofferid = Get[SpecialofferId].unsafeGetNonNullable(rs, i + 0),
        productid = Get[ProductId].unsafeGetNonNullable(rs, i + 1),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 2),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 3)
      )
    )
  

}