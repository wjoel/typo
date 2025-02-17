/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

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

object SalespersonquotahistoryRepoImpl extends SalespersonquotahistoryRepo {
  override def delete(compositeId: SalespersonquotahistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salespersonquotahistory where businessentityid = ${compositeId.businessentityid} AND quotadate = ${compositeId.quotadate}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    DeleteBuilder("sales.salespersonquotahistory", SalespersonquotahistoryFields)
  }
  override def insert(unsaved: SalespersonquotahistoryRow)(implicit c: Connection): SalespersonquotahistoryRow = {
    SQL"""insert into sales.salespersonquotahistory(businessentityid, quotadate, salesquota, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.quotadate}::timestamp, ${unsaved.salesquota}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, quotadate::text, salesquota, rowguid, modifieddate::text
       """
      .executeInsert(SalespersonquotahistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalespersonquotahistoryRowUnsaved)(implicit c: Connection): SalespersonquotahistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("quotadate", ParameterValue.from(unsaved.quotadate)), "::timestamp")),
      Some((NamedParameter("salesquota", ParameterValue.from(unsaved.salesquota)), "::numeric")),
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
      SQL"""insert into sales.salespersonquotahistory default values
            returning businessentityid, quotadate::text, salesquota, rowguid, modifieddate::text
         """
        .executeInsert(SalespersonquotahistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salespersonquotahistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, quotadate::text, salesquota, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(SalespersonquotahistoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    SelectBuilderSql("sales.salespersonquotahistory", SalespersonquotahistoryFields, SalespersonquotahistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalespersonquotahistoryRow] = {
    SQL"""select businessentityid, quotadate::text, salesquota, rowguid, modifieddate::text
          from sales.salespersonquotahistory
       """.as(SalespersonquotahistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: SalespersonquotahistoryId)(implicit c: Connection): Option[SalespersonquotahistoryRow] = {
    SQL"""select businessentityid, quotadate::text, salesquota, rowguid, modifieddate::text
          from sales.salespersonquotahistory
          where businessentityid = ${compositeId.businessentityid} AND quotadate = ${compositeId.quotadate}
       """.as(SalespersonquotahistoryRow.rowParser(1).singleOpt)
  }
  override def update(row: SalespersonquotahistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.salespersonquotahistory
          set salesquota = ${row.salesquota}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND quotadate = ${compositeId.quotadate}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    UpdateBuilder("sales.salespersonquotahistory", SalespersonquotahistoryFields, SalespersonquotahistoryRow.rowParser)
  }
  override def upsert(unsaved: SalespersonquotahistoryRow)(implicit c: Connection): SalespersonquotahistoryRow = {
    SQL"""insert into sales.salespersonquotahistory(businessentityid, quotadate, salesquota, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.quotadate}::timestamp,
            ${unsaved.salesquota}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, quotadate)
          do update set
            salesquota = EXCLUDED.salesquota,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, quotadate::text, salesquota, rowguid, modifieddate::text
       """
      .executeInsert(SalespersonquotahistoryRow.rowParser(1).single)
    
  }
}
