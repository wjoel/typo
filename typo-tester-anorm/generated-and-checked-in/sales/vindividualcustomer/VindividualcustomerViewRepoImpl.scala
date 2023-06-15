/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vindividualcustomer

import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection

object VindividualcustomerViewRepoImpl extends VindividualcustomerViewRepo {
  override def selectAll(implicit c: Connection): List[VindividualcustomerViewRow] = {
    SQL"""select businessentityid, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion, addresstype, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname, demographics
          from sales.vindividualcustomer
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VindividualcustomerViewFieldOrIdValue[_]])(implicit c: Connection): List[VindividualcustomerViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VindividualcustomerViewFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.firstname(value) => NamedParameter("firstname", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.middlename(value) => NamedParameter("middlename", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.lastname(value) => NamedParameter("lastname", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.suffix(value) => NamedParameter("suffix", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.phonenumber(value) => NamedParameter("phonenumber", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.phonenumbertype(value) => NamedParameter("phonenumbertype", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.emailaddress(value) => NamedParameter("emailaddress", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.emailpromotion(value) => NamedParameter("emailpromotion", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.addresstype(value) => NamedParameter("addresstype", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.addressline1(value) => NamedParameter("addressline1", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.addressline2(value) => NamedParameter("addressline2", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.city(value) => NamedParameter("city", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.stateprovincename(value) => NamedParameter("stateprovincename", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.postalcode(value) => NamedParameter("postalcode", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.countryregionname(value) => NamedParameter("countryregionname", ParameterValue.from(value))
          case VindividualcustomerViewFieldValue.demographics(value) => NamedParameter("demographics", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion, addresstype, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname, demographics
                    from sales.vindividualcustomer
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[VindividualcustomerViewRow] =
    RowParser[VindividualcustomerViewRow] { row =>
      Success(
        VindividualcustomerViewRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          title = row[Option[String]]("title"),
          firstname = row[Option[Name]]("firstname"),
          middlename = row[Option[Name]]("middlename"),
          lastname = row[Option[Name]]("lastname"),
          suffix = row[Option[String]]("suffix"),
          phonenumber = row[Option[Phone]]("phonenumber"),
          phonenumbertype = row[Option[Name]]("phonenumbertype"),
          emailaddress = row[Option[String]]("emailaddress"),
          emailpromotion = row[Option[Int]]("emailpromotion"),
          addresstype = row[Option[Name]]("addresstype"),
          addressline1 = row[Option[String]]("addressline1"),
          addressline2 = row[Option[String]]("addressline2"),
          city = row[Option[String]]("city"),
          stateprovincename = row[Option[Name]]("stateprovincename"),
          postalcode = row[Option[String]]("postalcode"),
          countryregionname = row[Option[Name]]("countryregionname"),
          demographics = row[Option[TypoXml]]("demographics")
        )
      )
    }
}
