/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

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

object WorkorderroutingRepoImpl extends WorkorderroutingRepo {
  override def delete(compositeId: WorkorderroutingId)(implicit c: Connection): Boolean = {
    SQL"delete from production.workorderrouting where workorderid = ${compositeId.workorderid} AND productid = ${compositeId.productid} AND operationsequence = ${compositeId.operationsequence}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    DeleteBuilder("production.workorderrouting", WorkorderroutingFields)
  }
  override def insert(unsaved: WorkorderroutingRow)(implicit c: Connection): WorkorderroutingRow = {
    SQL"""insert into production.workorderrouting(workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate)
          values (${unsaved.workorderid}::int4, ${unsaved.productid}::int4, ${unsaved.operationsequence}::int2, ${unsaved.locationid}::int2, ${unsaved.scheduledstartdate}::timestamp, ${unsaved.scheduledenddate}::timestamp, ${unsaved.actualstartdate}::timestamp, ${unsaved.actualenddate}::timestamp, ${unsaved.actualresourcehrs}::numeric, ${unsaved.plannedcost}::numeric, ${unsaved.actualcost}::numeric, ${unsaved.modifieddate}::timestamp)
          returning workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
       """
      .executeInsert(WorkorderroutingRow.rowParser(1).single)
    
  }
  override def insert(unsaved: WorkorderroutingRowUnsaved)(implicit c: Connection): WorkorderroutingRow = {
    val namedParameters = List(
      Some((NamedParameter("workorderid", ParameterValue.from(unsaved.workorderid)), "::int4")),
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("operationsequence", ParameterValue.from(unsaved.operationsequence)), "::int2")),
      Some((NamedParameter("locationid", ParameterValue.from(unsaved.locationid)), "::int2")),
      Some((NamedParameter("scheduledstartdate", ParameterValue.from(unsaved.scheduledstartdate)), "::timestamp")),
      Some((NamedParameter("scheduledenddate", ParameterValue.from(unsaved.scheduledenddate)), "::timestamp")),
      Some((NamedParameter("actualstartdate", ParameterValue.from(unsaved.actualstartdate)), "::timestamp")),
      Some((NamedParameter("actualenddate", ParameterValue.from(unsaved.actualenddate)), "::timestamp")),
      Some((NamedParameter("actualresourcehrs", ParameterValue.from(unsaved.actualresourcehrs)), "::numeric")),
      Some((NamedParameter("plannedcost", ParameterValue.from(unsaved.plannedcost)), "::numeric")),
      Some((NamedParameter("actualcost", ParameterValue.from(unsaved.actualcost)), "::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.workorderrouting default values
            returning workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
         """
        .executeInsert(WorkorderroutingRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.workorderrouting(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(WorkorderroutingRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    SelectBuilderSql("production.workorderrouting", WorkorderroutingFields, WorkorderroutingRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[WorkorderroutingRow] = {
    SQL"""select workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
          from production.workorderrouting
       """.as(WorkorderroutingRow.rowParser(1).*)
  }
  override def selectById(compositeId: WorkorderroutingId)(implicit c: Connection): Option[WorkorderroutingRow] = {
    SQL"""select workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
          from production.workorderrouting
          where workorderid = ${compositeId.workorderid} AND productid = ${compositeId.productid} AND operationsequence = ${compositeId.operationsequence}
       """.as(WorkorderroutingRow.rowParser(1).singleOpt)
  }
  override def update(row: WorkorderroutingRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.workorderrouting
          set locationid = ${row.locationid}::int2,
              scheduledstartdate = ${row.scheduledstartdate}::timestamp,
              scheduledenddate = ${row.scheduledenddate}::timestamp,
              actualstartdate = ${row.actualstartdate}::timestamp,
              actualenddate = ${row.actualenddate}::timestamp,
              actualresourcehrs = ${row.actualresourcehrs}::numeric,
              plannedcost = ${row.plannedcost}::numeric,
              actualcost = ${row.actualcost}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where workorderid = ${compositeId.workorderid} AND productid = ${compositeId.productid} AND operationsequence = ${compositeId.operationsequence}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    UpdateBuilder("production.workorderrouting", WorkorderroutingFields, WorkorderroutingRow.rowParser)
  }
  override def upsert(unsaved: WorkorderroutingRow)(implicit c: Connection): WorkorderroutingRow = {
    SQL"""insert into production.workorderrouting(workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate)
          values (
            ${unsaved.workorderid}::int4,
            ${unsaved.productid}::int4,
            ${unsaved.operationsequence}::int2,
            ${unsaved.locationid}::int2,
            ${unsaved.scheduledstartdate}::timestamp,
            ${unsaved.scheduledenddate}::timestamp,
            ${unsaved.actualstartdate}::timestamp,
            ${unsaved.actualenddate}::timestamp,
            ${unsaved.actualresourcehrs}::numeric,
            ${unsaved.plannedcost}::numeric,
            ${unsaved.actualcost}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (workorderid, productid, operationsequence)
          do update set
            locationid = EXCLUDED.locationid,
            scheduledstartdate = EXCLUDED.scheduledstartdate,
            scheduledenddate = EXCLUDED.scheduledenddate,
            actualstartdate = EXCLUDED.actualstartdate,
            actualenddate = EXCLUDED.actualenddate,
            actualresourcehrs = EXCLUDED.actualresourcehrs,
            plannedcost = EXCLUDED.plannedcost,
            actualcost = EXCLUDED.actualcost,
            modifieddate = EXCLUDED.modifieddate
          returning workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
       """
      .executeInsert(WorkorderroutingRow.rowParser(1).single)
    
  }
}
