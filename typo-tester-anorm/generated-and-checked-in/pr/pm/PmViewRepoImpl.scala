/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import adventureworks.TypoXml
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object PmViewRepoImpl extends PmViewRepo {
  override def selectAll(implicit c: Connection): List[PmViewRow] = {
    SQL"""select "id", productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
          from pr.pm
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PmViewFieldOrIdValue[_]])(implicit c: Connection): List[PmViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PmViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PmViewFieldValue.productmodelid(value) => NamedParameter("productmodelid", ParameterValue.from(value))
          case PmViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PmViewFieldValue.catalogdescription(value) => NamedParameter("catalogdescription", ParameterValue.from(value))
          case PmViewFieldValue.instructions(value) => NamedParameter("instructions", ParameterValue.from(value))
          case PmViewFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case PmViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
                    from pr.pm
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[PmViewRow] =
    RowParser[PmViewRow] { row =>
      Success(
        PmViewRow(
          id = row[Option[Int]]("id"),
          productmodelid = row[Option[ProductmodelId]]("productmodelid"),
          name = row[Option[Name]]("name"),
          catalogdescription = row[Option[TypoXml]]("catalogdescription"),
          instructions = row[Option[TypoXml]]("instructions"),
          rowguid = row[Option[UUID]]("rowguid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
