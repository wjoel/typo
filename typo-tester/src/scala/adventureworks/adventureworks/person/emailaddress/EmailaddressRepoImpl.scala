/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object EmailaddressRepoImpl extends EmailaddressRepo {
  override def delete(compositeId: EmailaddressId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.emailaddress where businessentityid = ${compositeId.businessentityid}, emailaddressid = ${compositeId.emailaddressid}""".executeUpdate() > 0
  }
  override def insert(compositeId: EmailaddressId, unsaved: EmailaddressRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("emailaddress", ParameterValue.from(unsaved.emailaddress))),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into person.emailaddress(businessentityid, emailaddressid, ${namedParameters.map(_.name).mkString(", ")})
          values (${compositeId.businessentityid}, ${compositeId.emailaddressid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[EmailaddressRow] = {
    SQL"""select businessentityid, emailaddressid, emailaddress, rowguid, modifieddate from person.emailaddress""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[EmailaddressFieldOrIdValue[_]])(implicit c: Connection): List[EmailaddressRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case EmailaddressFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case EmailaddressFieldValue.emailaddressid(value) => NamedParameter("emailaddressid", ParameterValue.from(value))
          case EmailaddressFieldValue.emailaddress(value) => NamedParameter("emailaddress", ParameterValue.from(value))
          case EmailaddressFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case EmailaddressFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from person.emailaddress where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: EmailaddressId)(implicit c: Connection): Option[EmailaddressRow] = {
    SQL"""select businessentityid, emailaddressid, emailaddress, rowguid, modifieddate from person.emailaddress where businessentityid = ${compositeId.businessentityid}, emailaddressid = ${compositeId.emailaddressid}""".as(rowParser.singleOpt)
  }
  override def update(row: EmailaddressRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update person.emailaddress
          set emailaddress = ${row.emailaddress},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where businessentityid = ${compositeId.businessentityid}, emailaddressid = ${compositeId.emailaddressid}""".executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: EmailaddressId, fieldValues: List[EmailaddressFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case EmailaddressFieldValue.emailaddress(value) => NamedParameter("emailaddress", ParameterValue.from(value))
          case EmailaddressFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case EmailaddressFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update person.emailaddress
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where businessentityid = ${compositeId.businessentityid}, emailaddressid = ${compositeId.emailaddressid}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[EmailaddressRow] =
    RowParser[EmailaddressRow] { row =>
      Success(
        EmailaddressRow(
          businessentityid = row[BusinessentityId]("businessentityid"),
          emailaddressid = row[Int]("emailaddressid"),
          emailaddress = row[Option[String]]("emailaddress"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[EmailaddressId] =
    RowParser[EmailaddressId] { row =>
      Success(
        EmailaddressId(
          businessentityid = row[BusinessentityId]("businessentityid"),
          emailaddressid = row[Int]("emailaddressid")
        )
      )
    }
}
