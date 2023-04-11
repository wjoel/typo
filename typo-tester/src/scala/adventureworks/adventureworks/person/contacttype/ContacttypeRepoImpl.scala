/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object ContacttypeRepoImpl extends ContacttypeRepo {
  override def delete(contacttypeid: ContacttypeId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.contacttype where contacttypeid = $contacttypeid""".executeUpdate() > 0
  }
  override def insert(unsaved: ContacttypeRowUnsaved)(implicit c: Connection): ContacttypeId = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into person.contacttype(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning contacttypeid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[ContacttypeRow] = {
    SQL"""select contacttypeid, name, modifieddate from person.contacttype""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ContacttypeFieldOrIdValue[_]])(implicit c: Connection): List[ContacttypeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ContacttypeFieldValue.contacttypeid(value) => NamedParameter("contacttypeid", ParameterValue.from(value))
          case ContacttypeFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ContacttypeFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from person.contacttype where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(contacttypeid: ContacttypeId)(implicit c: Connection): Option[ContacttypeRow] = {
    SQL"""select contacttypeid, name, modifieddate from person.contacttype where contacttypeid = $contacttypeid""".as(rowParser.singleOpt)
  }
  override def selectByIds(contacttypeids: List[ContacttypeId])(implicit c: Connection): List[ContacttypeRow] = {
    SQL"""select contacttypeid, name, modifieddate from person.contacttype where contacttypeid in $contacttypeids""".as(rowParser.*)
  }
  override def update(row: ContacttypeRow)(implicit c: Connection): Boolean = {
    val contacttypeid = row.contacttypeid
    SQL"""update person.contacttype
          set name = ${row.name},
              modifieddate = ${row.modifieddate}
          where contacttypeid = $contacttypeid""".executeUpdate() > 0
  }
  override def updateFieldValues(contacttypeid: ContacttypeId, fieldValues: List[ContacttypeFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ContacttypeFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ContacttypeFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update person.contacttype
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where contacttypeid = $contacttypeid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ContacttypeRow] =
    RowParser[ContacttypeRow] { row =>
      Success(
        ContacttypeRow(
          contacttypeid = row[ContacttypeId]("contacttypeid"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[ContacttypeId] =
    SqlParser.get[ContacttypeId]("contacttypeid")
}
