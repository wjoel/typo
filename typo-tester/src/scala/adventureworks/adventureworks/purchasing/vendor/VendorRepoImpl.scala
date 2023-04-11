/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object VendorRepoImpl extends VendorRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    SQL"""delete from purchasing.vendor where businessentityid = $businessentityid""".executeUpdate() > 0
  }
  override def insert(businessentityid: BusinessentityId, unsaved: VendorRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("accountnumber", ParameterValue.from(unsaved.accountnumber))),
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      Some(NamedParameter("creditrating", ParameterValue.from(unsaved.creditrating))),
      unsaved.preferredvendorstatus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("preferredvendorstatus", ParameterValue.from[Flag](value)))
      },
      unsaved.activeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("activeflag", ParameterValue.from[Flag](value)))
      },
      Some(NamedParameter("purchasingwebserviceurl", ParameterValue.from(unsaved.purchasingwebserviceurl))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into purchasing.vendor(businessentityid, ${namedParameters.map(_.name).mkString(", ")})
          values (${businessentityid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[VendorRow] = {
    SQL"""select businessentityid, accountnumber, name, creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate from purchasing.vendor""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VendorFieldOrIdValue[_]])(implicit c: Connection): List[VendorRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VendorFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VendorFieldValue.accountnumber(value) => NamedParameter("accountnumber", ParameterValue.from(value))
          case VendorFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VendorFieldValue.creditrating(value) => NamedParameter("creditrating", ParameterValue.from(value))
          case VendorFieldValue.preferredvendorstatus(value) => NamedParameter("preferredvendorstatus", ParameterValue.from(value))
          case VendorFieldValue.activeflag(value) => NamedParameter("activeflag", ParameterValue.from(value))
          case VendorFieldValue.purchasingwebserviceurl(value) => NamedParameter("purchasingwebserviceurl", ParameterValue.from(value))
          case VendorFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from purchasing.vendor where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[VendorRow] = {
    SQL"""select businessentityid, accountnumber, name, creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate from purchasing.vendor where businessentityid = $businessentityid""".as(rowParser.singleOpt)
  }
  override def selectByIds(businessentityids: List[BusinessentityId])(implicit c: Connection): List[VendorRow] = {
    SQL"""select businessentityid, accountnumber, name, creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate from purchasing.vendor where businessentityid in $businessentityids""".as(rowParser.*)
  }
  override def update(row: VendorRow)(implicit c: Connection): Boolean = {
    val businessentityid = row.businessentityid
    SQL"""update purchasing.vendor
          set accountnumber = ${row.accountnumber},
              name = ${row.name},
              creditrating = ${row.creditrating},
              preferredvendorstatus = ${row.preferredvendorstatus},
              activeflag = ${row.activeflag},
              purchasingwebserviceurl = ${row.purchasingwebserviceurl},
              modifieddate = ${row.modifieddate}
          where businessentityid = $businessentityid""".executeUpdate() > 0
  }
  override def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[VendorFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VendorFieldValue.accountnumber(value) => NamedParameter("accountnumber", ParameterValue.from(value))
          case VendorFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VendorFieldValue.creditrating(value) => NamedParameter("creditrating", ParameterValue.from(value))
          case VendorFieldValue.preferredvendorstatus(value) => NamedParameter("preferredvendorstatus", ParameterValue.from(value))
          case VendorFieldValue.activeflag(value) => NamedParameter("activeflag", ParameterValue.from(value))
          case VendorFieldValue.purchasingwebserviceurl(value) => NamedParameter("purchasingwebserviceurl", ParameterValue.from(value))
          case VendorFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update purchasing.vendor
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where businessentityid = $businessentityid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[VendorRow] =
    RowParser[VendorRow] { row =>
      Success(
        VendorRow(
          businessentityid = row[BusinessentityId]("businessentityid"),
          accountnumber = row[AccountNumber]("accountnumber"),
          name = row[Name]("name"),
          creditrating = row[Int]("creditrating"),
          preferredvendorstatus = row[Flag]("preferredvendorstatus"),
          activeflag = row[Flag]("activeflag"),
          purchasingwebserviceurl = row[Option[String]]("purchasingwebserviceurl"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[BusinessentityId] =
    SqlParser.get[BusinessentityId]("businessentityid")
}
