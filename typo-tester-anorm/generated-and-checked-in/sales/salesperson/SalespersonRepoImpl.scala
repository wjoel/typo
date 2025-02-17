/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SalespersonRepoImpl extends SalespersonRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salesperson where businessentityid = $businessentityid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalespersonFields, SalespersonRow] = {
    DeleteBuilder("sales.salesperson", SalespersonFields)
  }
  override def insert(unsaved: SalespersonRow)(implicit c: Connection): SalespersonRow = {
    SQL"""insert into sales.salesperson(businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.territoryid}::int4, ${unsaved.salesquota}::numeric, ${unsaved.bonus}::numeric, ${unsaved.commissionpct}::numeric, ${unsaved.salesytd}::numeric, ${unsaved.saleslastyear}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
       """
      .executeInsert(SalespersonRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalespersonRowUnsaved)(implicit c: Connection): SalespersonRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue.from(unsaved.territoryid)), "::int4")),
      Some((NamedParameter("salesquota", ParameterValue.from(unsaved.salesquota)), "::numeric")),
      unsaved.bonus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("bonus", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.commissionpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("commissionpct", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salesytd", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("saleslastyear", ParameterValue.from[BigDecimal](value)), "::numeric"))
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
      SQL"""insert into sales.salesperson default values
            returning businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
         """
        .executeInsert(SalespersonRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesperson(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(SalespersonRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[SalespersonFields, SalespersonRow] = {
    SelectBuilderSql("sales.salesperson", SalespersonFields, SalespersonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalespersonRow] = {
    SQL"""select businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
          from sales.salesperson
       """.as(SalespersonRow.rowParser(1).*)
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[SalespersonRow] = {
    SQL"""select businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
          from sales.salesperson
          where businessentityid = $businessentityid
       """.as(SalespersonRow.rowParser(1).singleOpt)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[SalespersonRow] = {
    SQL"""select businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
          from sales.salesperson
          where businessentityid = ANY($businessentityids)
       """.as(SalespersonRow.rowParser(1).*)
    
  }
  override def update(row: SalespersonRow)(implicit c: Connection): Boolean = {
    val businessentityid = row.businessentityid
    SQL"""update sales.salesperson
          set territoryid = ${row.territoryid}::int4,
              salesquota = ${row.salesquota}::numeric,
              bonus = ${row.bonus}::numeric,
              commissionpct = ${row.commissionpct}::numeric,
              salesytd = ${row.salesytd}::numeric,
              saleslastyear = ${row.saleslastyear}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = $businessentityid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalespersonFields, SalespersonRow] = {
    UpdateBuilder("sales.salesperson", SalespersonFields, SalespersonRow.rowParser)
  }
  override def upsert(unsaved: SalespersonRow)(implicit c: Connection): SalespersonRow = {
    SQL"""insert into sales.salesperson(businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.territoryid}::int4,
            ${unsaved.salesquota}::numeric,
            ${unsaved.bonus}::numeric,
            ${unsaved.commissionpct}::numeric,
            ${unsaved.salesytd}::numeric,
            ${unsaved.saleslastyear}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid)
          do update set
            territoryid = EXCLUDED.territoryid,
            salesquota = EXCLUDED.salesquota,
            bonus = EXCLUDED.bonus,
            commissionpct = EXCLUDED.commissionpct,
            salesytd = EXCLUDED.salesytd,
            saleslastyear = EXCLUDED.saleslastyear,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
       """
      .executeInsert(SalespersonRow.rowParser(1).single)
    
  }
}
