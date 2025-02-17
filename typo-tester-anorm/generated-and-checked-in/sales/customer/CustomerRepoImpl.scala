/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

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

object CustomerRepoImpl extends CustomerRepo {
  override def delete(customerid: CustomerId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.customer where customerid = $customerid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[CustomerFields, CustomerRow] = {
    DeleteBuilder("sales.customer", CustomerFields)
  }
  override def insert(unsaved: CustomerRow)(implicit c: Connection): CustomerRow = {
    SQL"""insert into sales.customer(customerid, personid, storeid, territoryid, rowguid, modifieddate)
          values (${unsaved.customerid}::int4, ${unsaved.personid}::int4, ${unsaved.storeid}::int4, ${unsaved.territoryid}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning customerid, personid, storeid, territoryid, rowguid, modifieddate::text
       """
      .executeInsert(CustomerRow.rowParser(1).single)
    
  }
  override def insert(unsaved: CustomerRowUnsaved)(implicit c: Connection): CustomerRow = {
    val namedParameters = List(
      Some((NamedParameter("personid", ParameterValue.from(unsaved.personid)), "::int4")),
      Some((NamedParameter("storeid", ParameterValue.from(unsaved.storeid)), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue.from(unsaved.territoryid)), "::int4")),
      unsaved.customerid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("customerid", ParameterValue.from[CustomerId](value)), "::int4"))
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
      SQL"""insert into sales.customer default values
            returning customerid, personid, storeid, territoryid, rowguid, modifieddate::text
         """
        .executeInsert(CustomerRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.customer(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning customerid, personid, storeid, territoryid, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(CustomerRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[CustomerFields, CustomerRow] = {
    SelectBuilderSql("sales.customer", CustomerFields, CustomerRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CustomerRow] = {
    SQL"""select customerid, personid, storeid, territoryid, rowguid, modifieddate::text
          from sales.customer
       """.as(CustomerRow.rowParser(1).*)
  }
  override def selectById(customerid: CustomerId)(implicit c: Connection): Option[CustomerRow] = {
    SQL"""select customerid, personid, storeid, territoryid, rowguid, modifieddate::text
          from sales.customer
          where customerid = $customerid
       """.as(CustomerRow.rowParser(1).singleOpt)
  }
  override def selectByIds(customerids: Array[CustomerId])(implicit c: Connection): List[CustomerRow] = {
    SQL"""select customerid, personid, storeid, territoryid, rowguid, modifieddate::text
          from sales.customer
          where customerid = ANY($customerids)
       """.as(CustomerRow.rowParser(1).*)
    
  }
  override def update(row: CustomerRow)(implicit c: Connection): Boolean = {
    val customerid = row.customerid
    SQL"""update sales.customer
          set personid = ${row.personid}::int4,
              storeid = ${row.storeid}::int4,
              territoryid = ${row.territoryid}::int4,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where customerid = $customerid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[CustomerFields, CustomerRow] = {
    UpdateBuilder("sales.customer", CustomerFields, CustomerRow.rowParser)
  }
  override def upsert(unsaved: CustomerRow)(implicit c: Connection): CustomerRow = {
    SQL"""insert into sales.customer(customerid, personid, storeid, territoryid, rowguid, modifieddate)
          values (
            ${unsaved.customerid}::int4,
            ${unsaved.personid}::int4,
            ${unsaved.storeid}::int4,
            ${unsaved.territoryid}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (customerid)
          do update set
            personid = EXCLUDED.personid,
            storeid = EXCLUDED.storeid,
            territoryid = EXCLUDED.territoryid,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning customerid, personid, storeid, territoryid, rowguid, modifieddate::text
       """
      .executeInsert(CustomerRow.rowParser(1).single)
    
  }
}
