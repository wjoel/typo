/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection

object VstorewithaddressesRepoImpl extends VstorewithaddressesRepo {
  override def selectAll(implicit c: Connection): List[VstorewithaddressesRow] = {
    SQL"""select businessentityid, name, addresstype, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname from sales.vstorewithaddresses""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VstorewithaddressesFieldOrIdValue[_]])(implicit c: Connection): List[VstorewithaddressesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VstorewithaddressesFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VstorewithaddressesFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VstorewithaddressesFieldValue.addresstype(value) => NamedParameter("addresstype", ParameterValue.from(value))
          case VstorewithaddressesFieldValue.addressline1(value) => NamedParameter("addressline1", ParameterValue.from(value))
          case VstorewithaddressesFieldValue.addressline2(value) => NamedParameter("addressline2", ParameterValue.from(value))
          case VstorewithaddressesFieldValue.city(value) => NamedParameter("city", ParameterValue.from(value))
          case VstorewithaddressesFieldValue.stateprovincename(value) => NamedParameter("stateprovincename", ParameterValue.from(value))
          case VstorewithaddressesFieldValue.postalcode(value) => NamedParameter("postalcode", ParameterValue.from(value))
          case VstorewithaddressesFieldValue.countryregionname(value) => NamedParameter("countryregionname", ParameterValue.from(value))
        }
        val q = s"""select * from sales.vstorewithaddresses where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[VstorewithaddressesRow] =
    RowParser[VstorewithaddressesRow] { row =>
      Success(
        VstorewithaddressesRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          name = row[Option[Name]]("name"),
          addresstype = row[Option[Name]]("addresstype"),
          addressline1 = row[Option[String]]("addressline1"),
          addressline2 = row[Option[String]]("addressline2"),
          city = row[Option[String]]("city"),
          stateprovincename = row[Option[Name]]("stateprovincename"),
          postalcode = row[Option[String]]("postalcode"),
          countryregionname = row[Option[Name]]("countryregionname")
        )
      )
    }
}