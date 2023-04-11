/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.Defaulted
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object ProductmodelillustrationRepoImpl extends ProductmodelillustrationRepo {
  override def delete(compositeId: ProductmodelillustrationId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productmodelillustration where productmodelid = ${compositeId.productmodelid}, illustrationid = ${compositeId.illustrationid}""".executeUpdate() > 0
  }
  override def insert(compositeId: ProductmodelillustrationId, unsaved: ProductmodelillustrationRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.productmodelillustration(productmodelid, illustrationid, ${namedParameters.map(_.name).mkString(", ")})
          values (${compositeId.productmodelid}, ${compositeId.illustrationid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[ProductmodelillustrationRow] = {
    SQL"""select productmodelid, illustrationid, modifieddate from production.productmodelillustration""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductmodelillustrationFieldOrIdValue[_]])(implicit c: Connection): List[ProductmodelillustrationRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductmodelillustrationFieldValue.productmodelid(value) => NamedParameter("productmodelid", ParameterValue.from(value))
          case ProductmodelillustrationFieldValue.illustrationid(value) => NamedParameter("illustrationid", ParameterValue.from(value))
          case ProductmodelillustrationFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.productmodelillustration where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: ProductmodelillustrationId)(implicit c: Connection): Option[ProductmodelillustrationRow] = {
    SQL"""select productmodelid, illustrationid, modifieddate from production.productmodelillustration where productmodelid = ${compositeId.productmodelid}, illustrationid = ${compositeId.illustrationid}""".as(rowParser.singleOpt)
  }
  override def update(row: ProductmodelillustrationRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productmodelillustration
          set modifieddate = ${row.modifieddate}
          where productmodelid = ${compositeId.productmodelid}, illustrationid = ${compositeId.illustrationid}""".executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: ProductmodelillustrationId, fieldValues: List[ProductmodelillustrationFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductmodelillustrationFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.productmodelillustration
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where productmodelid = ${compositeId.productmodelid}, illustrationid = ${compositeId.illustrationid}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductmodelillustrationRow] =
    RowParser[ProductmodelillustrationRow] { row =>
      Success(
        ProductmodelillustrationRow(
          productmodelid = row[ProductmodelId]("productmodelid"),
          illustrationid = row[IllustrationId]("illustrationid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[ProductmodelillustrationId] =
    RowParser[ProductmodelillustrationId] { row =>
      Success(
        ProductmodelillustrationId(
          productmodelid = row[ProductmodelId]("productmodelid"),
          illustrationid = row[IllustrationId]("illustrationid")
        )
      )
    }
}
