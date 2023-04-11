/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object ProductdescriptionRepoImpl extends ProductdescriptionRepo {
  override def delete(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productdescription where productdescriptionid = $productdescriptionid""".executeUpdate() > 0
  }
  override def insert(unsaved: ProductdescriptionRowUnsaved)(implicit c: Connection): ProductdescriptionId = {
    val namedParameters = List(
      Some(NamedParameter("description", ParameterValue.from(unsaved.description))),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.productdescription(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning productdescriptionid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[ProductdescriptionRow] = {
    SQL"""select productdescriptionid, description, rowguid, modifieddate from production.productdescription""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductdescriptionFieldOrIdValue[_]])(implicit c: Connection): List[ProductdescriptionRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductdescriptionFieldValue.productdescriptionid(value) => NamedParameter("productdescriptionid", ParameterValue.from(value))
          case ProductdescriptionFieldValue.description(value) => NamedParameter("description", ParameterValue.from(value))
          case ProductdescriptionFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductdescriptionFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.productdescription where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(productdescriptionid: ProductdescriptionId)(implicit c: Connection): Option[ProductdescriptionRow] = {
    SQL"""select productdescriptionid, description, rowguid, modifieddate from production.productdescription where productdescriptionid = $productdescriptionid""".as(rowParser.singleOpt)
  }
  override def selectByIds(productdescriptionids: List[ProductdescriptionId])(implicit c: Connection): List[ProductdescriptionRow] = {
    SQL"""select productdescriptionid, description, rowguid, modifieddate from production.productdescription where productdescriptionid in $productdescriptionids""".as(rowParser.*)
  }
  override def update(row: ProductdescriptionRow)(implicit c: Connection): Boolean = {
    val productdescriptionid = row.productdescriptionid
    SQL"""update production.productdescription
          set description = ${row.description},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where productdescriptionid = $productdescriptionid""".executeUpdate() > 0
  }
  override def updateFieldValues(productdescriptionid: ProductdescriptionId, fieldValues: List[ProductdescriptionFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductdescriptionFieldValue.description(value) => NamedParameter("description", ParameterValue.from(value))
          case ProductdescriptionFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductdescriptionFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.productdescription
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where productdescriptionid = $productdescriptionid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductdescriptionRow] =
    RowParser[ProductdescriptionRow] { row =>
      Success(
        ProductdescriptionRow(
          productdescriptionid = row[ProductdescriptionId]("productdescriptionid"),
          description = row[String]("description"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[ProductdescriptionId] =
    SqlParser.get[ProductdescriptionId]("productdescriptionid")
}
