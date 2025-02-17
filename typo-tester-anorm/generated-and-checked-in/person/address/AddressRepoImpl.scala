/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object AddressRepoImpl extends AddressRepo {
  override def delete(addressid: AddressId)(implicit c: Connection): Boolean = {
    SQL"delete from person.address where addressid = $addressid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[AddressFields, AddressRow] = {
    DeleteBuilder("person.address", AddressFields)
  }
  override def insert(unsaved: AddressRow)(implicit c: Connection): AddressRow = {
    SQL"""insert into person.address(addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
          values (${unsaved.addressid}::int4, ${unsaved.addressline1}, ${unsaved.addressline2}, ${unsaved.city}, ${unsaved.stateprovinceid}::int4, ${unsaved.postalcode}, ${unsaved.spatiallocation}::bytea, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
       """
      .executeInsert(AddressRow.rowParser(1).single)
    
  }
  override def insert(unsaved: AddressRowUnsaved)(implicit c: Connection): AddressRow = {
    val namedParameters = List(
      Some((NamedParameter("addressline1", ParameterValue.from(unsaved.addressline1)), "")),
      Some((NamedParameter("addressline2", ParameterValue.from(unsaved.addressline2)), "")),
      Some((NamedParameter("city", ParameterValue.from(unsaved.city)), "")),
      Some((NamedParameter("stateprovinceid", ParameterValue.from(unsaved.stateprovinceid)), "::int4")),
      Some((NamedParameter("postalcode", ParameterValue.from(unsaved.postalcode)), "")),
      Some((NamedParameter("spatiallocation", ParameterValue.from(unsaved.spatiallocation)), "::bytea")),
      unsaved.addressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("addressid", ParameterValue.from[AddressId](value)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.address default values
            returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
         """
        .executeInsert(AddressRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.address(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(AddressRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[AddressFields, AddressRow] = {
    SelectBuilderSql("person.address", AddressFields, AddressRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[AddressRow] = {
    SQL"""select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
          from person.address
       """.as(AddressRow.rowParser(1).*)
  }
  override def selectById(addressid: AddressId)(implicit c: Connection): Option[AddressRow] = {
    SQL"""select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
          from person.address
          where addressid = $addressid
       """.as(AddressRow.rowParser(1).singleOpt)
  }
  override def selectByIds(addressids: Array[AddressId])(implicit c: Connection): List[AddressRow] = {
    SQL"""select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
          from person.address
          where addressid = ANY($addressids)
       """.as(AddressRow.rowParser(1).*)
    
  }
  override def update(row: AddressRow)(implicit c: Connection): Boolean = {
    val addressid = row.addressid
    SQL"""update person.address
          set addressline1 = ${row.addressline1},
              addressline2 = ${row.addressline2},
              city = ${row.city},
              stateprovinceid = ${row.stateprovinceid}::int4,
              postalcode = ${row.postalcode},
              spatiallocation = ${row.spatiallocation}::bytea,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where addressid = $addressid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[AddressFields, AddressRow] = {
    UpdateBuilder("person.address", AddressFields, AddressRow.rowParser)
  }
  override def upsert(unsaved: AddressRow)(implicit c: Connection): AddressRow = {
    SQL"""insert into person.address(addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
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
          returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
       """
      .executeInsert(AddressRow.rowParser(1).single)
    
  }
}
