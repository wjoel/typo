/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection

object VstorewithcontactsViewRepoImpl extends VstorewithcontactsViewRepo {
  override def selectAll(implicit c: Connection): List[VstorewithcontactsViewRow] = {
    SQL"""select businessentityid, "name", contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion
          from sales.vstorewithcontacts
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VstorewithcontactsViewFieldOrIdValue[_]])(implicit c: Connection): List[VstorewithcontactsViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VstorewithcontactsViewFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.contacttype(value) => NamedParameter("contacttype", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.firstname(value) => NamedParameter("firstname", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.middlename(value) => NamedParameter("middlename", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.lastname(value) => NamedParameter("lastname", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.suffix(value) => NamedParameter("suffix", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.phonenumber(value) => NamedParameter("phonenumber", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.phonenumbertype(value) => NamedParameter("phonenumbertype", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.emailaddress(value) => NamedParameter("emailaddress", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.emailpromotion(value) => NamedParameter("emailpromotion", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, "name", contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion
                    from sales.vstorewithcontacts
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[VstorewithcontactsViewRow] =
    RowParser[VstorewithcontactsViewRow] { row =>
      Success(
        VstorewithcontactsViewRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          name = row[Option[Name]]("name"),
          contacttype = row[Option[Name]]("contacttype"),
          title = row[Option[String]]("title"),
          firstname = row[Option[Name]]("firstname"),
          middlename = row[Option[Name]]("middlename"),
          lastname = row[Option[Name]]("lastname"),
          suffix = row[Option[String]]("suffix"),
          phonenumber = row[Option[Phone]]("phonenumber"),
          phonenumbertype = row[Option[Name]]("phonenumbertype"),
          emailaddress = row[Option[String]]("emailaddress"),
          emailpromotion = row[Option[Int]]("emailpromotion")
        )
      )
    }
}