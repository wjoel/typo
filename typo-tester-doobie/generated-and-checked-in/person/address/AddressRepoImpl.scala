/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.Defaulted
import adventureworks.person.stateprovince.StateprovinceId
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

object AddressRepoImpl extends AddressRepo {
  override def delete(addressid: AddressId): ConnectionIO[Boolean] = {
    sql"delete from person.address where addressid = $addressid".update.run.map(_ > 0)
  }
  override def insert(unsaved: AddressRow): ConnectionIO[AddressRow] = {
    sql"""insert into person.address(addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
          values (${unsaved.addressid}::int4, ${unsaved.addressline1}, ${unsaved.addressline2}, ${unsaved.city}, ${unsaved.stateprovinceid}::int4, ${unsaved.postalcode}, ${unsaved.spatiallocation}::bytea, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
       """.query.unique
  }
  override def insert(unsaved: AddressRowUnsaved): ConnectionIO[AddressRow] = {
    val fs = List(
      Some((Fragment.const(s"addressline1"), fr"${unsaved.addressline1}")),
      Some((Fragment.const(s"addressline2"), fr"${unsaved.addressline2}")),
      Some((Fragment.const(s"city"), fr"${unsaved.city}")),
      Some((Fragment.const(s"stateprovinceid"), fr"${unsaved.stateprovinceid}::int4")),
      Some((Fragment.const(s"postalcode"), fr"${unsaved.postalcode}")),
      Some((Fragment.const(s"spatiallocation"), fr"${unsaved.spatiallocation}::bytea")),
      unsaved.addressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"addressid"), fr"${value: AddressId}::int4"))
      },
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
      sql"""insert into person.address default values
            returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.address(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
         """
    }
    q.query.unique
  
  }
  override def selectAll: Stream[ConnectionIO, AddressRow] = {
    sql"select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate from person.address".query[AddressRow].stream
  }
  override def selectByFieldValues(fieldValues: List[AddressFieldOrIdValue[_]]): Stream[ConnectionIO, AddressRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case AddressFieldValue.addressid(value) => fr"addressid = $value"
        case AddressFieldValue.addressline1(value) => fr"addressline1 = $value"
        case AddressFieldValue.addressline2(value) => fr"addressline2 = $value"
        case AddressFieldValue.city(value) => fr"city = $value"
        case AddressFieldValue.stateprovinceid(value) => fr"stateprovinceid = $value"
        case AddressFieldValue.postalcode(value) => fr"postalcode = $value"
        case AddressFieldValue.spatiallocation(value) => fr"spatiallocation = $value"
        case AddressFieldValue.rowguid(value) => fr"rowguid = $value"
        case AddressFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from person.address $where".query[AddressRow].stream
  
  }
  override def selectById(addressid: AddressId): ConnectionIO[Option[AddressRow]] = {
    sql"select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate from person.address where addressid = $addressid".query[AddressRow].option
  }
  override def selectByIds(addressids: Array[AddressId]): Stream[ConnectionIO, AddressRow] = {
    sql"select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate from person.address where addressid = ANY($addressids)".query[AddressRow].stream
  }
  override def update(row: AddressRow): ConnectionIO[Boolean] = {
    val addressid = row.addressid
    sql"""update person.address
          set addressline1 = ${row.addressline1},
              addressline2 = ${row.addressline2},
              city = ${row.city},
              stateprovinceid = ${row.stateprovinceid}::int4,
              postalcode = ${row.postalcode},
              spatiallocation = ${row.spatiallocation}::bytea,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where addressid = $addressid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(addressid: AddressId, fieldValues: List[AddressFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case AddressFieldValue.addressline1(value) => fr"addressline1 = $value"
            case AddressFieldValue.addressline2(value) => fr"addressline2 = $value"
            case AddressFieldValue.city(value) => fr"city = $value"
            case AddressFieldValue.stateprovinceid(value) => fr"stateprovinceid = $value"
            case AddressFieldValue.postalcode(value) => fr"postalcode = $value"
            case AddressFieldValue.spatiallocation(value) => fr"spatiallocation = $value"
            case AddressFieldValue.rowguid(value) => fr"rowguid = $value"
            case AddressFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update person.address
              $updates
              where addressid = $addressid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: AddressRow): ConnectionIO[AddressRow] = {
    sql"""insert into person.address(addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
          values (
            ${unsaved.addressid}::int4,
            ${unsaved.addressline1},
            ${unsaved.addressline2},
            ${unsaved.city},
            ${unsaved.stateprovinceid}::int4,
            ${unsaved.postalcode},
            ${unsaved.spatiallocation}::bytea,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (addressid)
          do update set
            addressline1 = EXCLUDED.addressline1,
            addressline2 = EXCLUDED.addressline2,
            city = EXCLUDED.city,
            stateprovinceid = EXCLUDED.stateprovinceid,
            postalcode = EXCLUDED.postalcode,
            spatiallocation = EXCLUDED.spatiallocation,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
       """.query.unique
  }
  implicit val read: Read[AddressRow] =
    new Read[AddressRow](
      gets = List(
        (Get[AddressId], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[String], Nullability.Nullable),
        (Get[String], Nullability.NoNulls),
        (Get[StateprovinceId], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[Array[Byte]], Nullability.Nullable),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => AddressRow(
        addressid = Get[AddressId].unsafeGetNonNullable(rs, i + 0),
        addressline1 = Get[String].unsafeGetNonNullable(rs, i + 1),
        addressline2 = Get[String].unsafeGetNullable(rs, i + 2),
        city = Get[String].unsafeGetNonNullable(rs, i + 3),
        stateprovinceid = Get[StateprovinceId].unsafeGetNonNullable(rs, i + 4),
        postalcode = Get[String].unsafeGetNonNullable(rs, i + 5),
        spatiallocation = Get[Array[Byte]].unsafeGetNullable(rs, i + 6),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 7),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 8)
      )
    )
  

}
