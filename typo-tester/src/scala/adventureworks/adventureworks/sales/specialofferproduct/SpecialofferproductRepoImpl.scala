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
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object SpecialofferproductRepoImpl extends SpecialofferproductRepo {
  override def delete(compositeId: SpecialofferproductId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.specialofferproduct where specialofferid = ${compositeId.specialofferid}, productid = ${compositeId.productid}""".executeUpdate() > 0
  }
  override def insert(compositeId: SpecialofferproductId, unsaved: SpecialofferproductRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into sales.specialofferproduct(specialofferid, productid, ${namedParameters.map(_.name).mkString(", ")})
          values (${compositeId.specialofferid}, ${compositeId.productid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[SpecialofferproductRow] = {
    SQL"""select specialofferid, productid, rowguid, modifieddate from sales.specialofferproduct""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SpecialofferproductFieldOrIdValue[_]])(implicit c: Connection): List[SpecialofferproductRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SpecialofferproductFieldValue.specialofferid(value) => NamedParameter("specialofferid", ParameterValue.from(value))
          case SpecialofferproductFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case SpecialofferproductFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SpecialofferproductFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from sales.specialofferproduct where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: SpecialofferproductId)(implicit c: Connection): Option[SpecialofferproductRow] = {
    SQL"""select specialofferid, productid, rowguid, modifieddate from sales.specialofferproduct where specialofferid = ${compositeId.specialofferid}, productid = ${compositeId.productid}""".as(rowParser.singleOpt)
  }
  override def update(row: SpecialofferproductRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.specialofferproduct
          set rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where specialofferid = ${compositeId.specialofferid}, productid = ${compositeId.productid}""".executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: SpecialofferproductId, fieldValues: List[SpecialofferproductFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SpecialofferproductFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SpecialofferproductFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update sales.specialofferproduct
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where specialofferid = ${compositeId.specialofferid}, productid = ${compositeId.productid}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[SpecialofferproductRow] =
    RowParser[SpecialofferproductRow] { row =>
      Success(
        SpecialofferproductRow(
          specialofferid = row[SpecialofferId]("specialofferid"),
          productid = row[ProductId]("productid"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[SpecialofferproductId] =
    RowParser[SpecialofferproductId] { row =>
      Success(
        SpecialofferproductId(
          specialofferid = row[SpecialofferId]("specialofferid"),
          productid = row[ProductId]("productid")
        )
      )
    }
}
