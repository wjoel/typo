/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object EmployeepayhistoryRepoImpl extends EmployeepayhistoryRepo {
  override def delete(compositeId: EmployeepayhistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from humanresources.employeepayhistory where businessentityid = ${compositeId.businessentityid} AND ratechangedate = ${compositeId.ratechangedate}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    DeleteBuilder("humanresources.employeepayhistory", EmployeepayhistoryFields)
  }
  override def insert(unsaved: EmployeepayhistoryRow)(implicit c: Connection): EmployeepayhistoryRow = {
    SQL"""insert into humanresources.employeepayhistory(businessentityid, ratechangedate, rate, payfrequency, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.ratechangedate}::timestamp, ${unsaved.rate}::numeric, ${unsaved.payfrequency}::int2, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, ratechangedate::text, rate, payfrequency, modifieddate::text
       """
      .executeInsert(EmployeepayhistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: EmployeepayhistoryRowUnsaved)(implicit c: Connection): EmployeepayhistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("ratechangedate", ParameterValue.from(unsaved.ratechangedate)), "::timestamp")),
      Some((NamedParameter("rate", ParameterValue.from(unsaved.rate)), "::numeric")),
      Some((NamedParameter("payfrequency", ParameterValue.from(unsaved.payfrequency)), "::int2")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.employeepayhistory default values
            returning businessentityid, ratechangedate::text, rate, payfrequency, modifieddate::text
         """
        .executeInsert(EmployeepayhistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into humanresources.employeepayhistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, ratechangedate::text, rate, payfrequency, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(EmployeepayhistoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    SelectBuilderSql("humanresources.employeepayhistory", EmployeepayhistoryFields, EmployeepayhistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[EmployeepayhistoryRow] = {
    SQL"""select businessentityid, ratechangedate::text, rate, payfrequency, modifieddate::text
          from humanresources.employeepayhistory
       """.as(EmployeepayhistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: EmployeepayhistoryId)(implicit c: Connection): Option[EmployeepayhistoryRow] = {
    SQL"""select businessentityid, ratechangedate::text, rate, payfrequency, modifieddate::text
          from humanresources.employeepayhistory
          where businessentityid = ${compositeId.businessentityid} AND ratechangedate = ${compositeId.ratechangedate}
       """.as(EmployeepayhistoryRow.rowParser(1).singleOpt)
  }
  override def update(row: EmployeepayhistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update humanresources.employeepayhistory
          set rate = ${row.rate}::numeric,
              payfrequency = ${row.payfrequency}::int2,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND ratechangedate = ${compositeId.ratechangedate}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    UpdateBuilder("humanresources.employeepayhistory", EmployeepayhistoryFields, EmployeepayhistoryRow.rowParser)
  }
  override def upsert(unsaved: EmployeepayhistoryRow)(implicit c: Connection): EmployeepayhistoryRow = {
    SQL"""insert into humanresources.employeepayhistory(businessentityid, ratechangedate, rate, payfrequency, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.ratechangedate}::timestamp,
            ${unsaved.rate}::numeric,
            ${unsaved.payfrequency}::int2,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, ratechangedate)
          do update set
            rate = EXCLUDED.rate,
            payfrequency = EXCLUDED.payfrequency,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, ratechangedate::text, rate, payfrequency, modifieddate::text
       """
      .executeInsert(EmployeepayhistoryRow.rowParser(1).single)
    
  }
}
