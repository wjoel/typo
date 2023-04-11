/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object WorkorderRepoImpl extends WorkorderRepo {
  override def delete(workorderid: WorkorderId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.workorder where workorderid = $workorderid""".executeUpdate() > 0
  }
  override def insert(unsaved: WorkorderRowUnsaved)(implicit c: Connection): WorkorderId = {
    val namedParameters = List(
      Some(NamedParameter("productid", ParameterValue.from(unsaved.productid))),
      Some(NamedParameter("orderqty", ParameterValue.from(unsaved.orderqty))),
      Some(NamedParameter("scrappedqty", ParameterValue.from(unsaved.scrappedqty))),
      Some(NamedParameter("startdate", ParameterValue.from(unsaved.startdate))),
      Some(NamedParameter("enddate", ParameterValue.from(unsaved.enddate))),
      Some(NamedParameter("duedate", ParameterValue.from(unsaved.duedate))),
      Some(NamedParameter("scrapreasonid", ParameterValue.from(unsaved.scrapreasonid))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.workorder(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning workorderid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[WorkorderRow] = {
    SQL"""select workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate from production.workorder""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[WorkorderFieldOrIdValue[_]])(implicit c: Connection): List[WorkorderRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case WorkorderFieldValue.workorderid(value) => NamedParameter("workorderid", ParameterValue.from(value))
          case WorkorderFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case WorkorderFieldValue.orderqty(value) => NamedParameter("orderqty", ParameterValue.from(value))
          case WorkorderFieldValue.scrappedqty(value) => NamedParameter("scrappedqty", ParameterValue.from(value))
          case WorkorderFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case WorkorderFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case WorkorderFieldValue.duedate(value) => NamedParameter("duedate", ParameterValue.from(value))
          case WorkorderFieldValue.scrapreasonid(value) => NamedParameter("scrapreasonid", ParameterValue.from(value))
          case WorkorderFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.workorder where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(workorderid: WorkorderId)(implicit c: Connection): Option[WorkorderRow] = {
    SQL"""select workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate from production.workorder where workorderid = $workorderid""".as(rowParser.singleOpt)
  }
  override def selectByIds(workorderids: List[WorkorderId])(implicit c: Connection): List[WorkorderRow] = {
    SQL"""select workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate from production.workorder where workorderid in $workorderids""".as(rowParser.*)
  }
  override def update(row: WorkorderRow)(implicit c: Connection): Boolean = {
    val workorderid = row.workorderid
    SQL"""update production.workorder
          set productid = ${row.productid},
              orderqty = ${row.orderqty},
              scrappedqty = ${row.scrappedqty},
              startdate = ${row.startdate},
              enddate = ${row.enddate},
              duedate = ${row.duedate},
              scrapreasonid = ${row.scrapreasonid},
              modifieddate = ${row.modifieddate}
          where workorderid = $workorderid""".executeUpdate() > 0
  }
  override def updateFieldValues(workorderid: WorkorderId, fieldValues: List[WorkorderFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case WorkorderFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case WorkorderFieldValue.orderqty(value) => NamedParameter("orderqty", ParameterValue.from(value))
          case WorkorderFieldValue.scrappedqty(value) => NamedParameter("scrappedqty", ParameterValue.from(value))
          case WorkorderFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case WorkorderFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case WorkorderFieldValue.duedate(value) => NamedParameter("duedate", ParameterValue.from(value))
          case WorkorderFieldValue.scrapreasonid(value) => NamedParameter("scrapreasonid", ParameterValue.from(value))
          case WorkorderFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.workorder
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where workorderid = $workorderid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[WorkorderRow] =
    RowParser[WorkorderRow] { row =>
      Success(
        WorkorderRow(
          workorderid = row[WorkorderId]("workorderid"),
          productid = row[ProductId]("productid"),
          orderqty = row[Int]("orderqty"),
          scrappedqty = row[Int]("scrappedqty"),
          startdate = row[LocalDateTime]("startdate"),
          enddate = row[Option[LocalDateTime]]("enddate"),
          duedate = row[LocalDateTime]("duedate"),
          scrapreasonid = row[Option[ScrapreasonId]]("scrapreasonid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[WorkorderId] =
    SqlParser.get[WorkorderId]("workorderid")
}
