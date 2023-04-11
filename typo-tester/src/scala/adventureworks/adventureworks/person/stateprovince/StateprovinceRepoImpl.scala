/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.Defaulted
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object StateprovinceRepoImpl extends StateprovinceRepo {
  override def delete(stateprovinceid: StateprovinceId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.stateprovince where stateprovinceid = $stateprovinceid""".executeUpdate() > 0
  }
  override def insert(unsaved: StateprovinceRowUnsaved)(implicit c: Connection): StateprovinceId = {
    val namedParameters = List(
      Some(NamedParameter("stateprovincecode", ParameterValue.from(unsaved.stateprovincecode))),
      Some(NamedParameter("countryregioncode", ParameterValue.from(unsaved.countryregioncode))),
      unsaved.isonlystateprovinceflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("isonlystateprovinceflag", ParameterValue.from[Flag](value)))
      },
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      Some(NamedParameter("territoryid", ParameterValue.from(unsaved.territoryid))),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into person.stateprovince(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning stateprovinceid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[StateprovinceRow] = {
    SQL"""select stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, name, territoryid, rowguid, modifieddate from person.stateprovince""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[StateprovinceFieldOrIdValue[_]])(implicit c: Connection): List[StateprovinceRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case StateprovinceFieldValue.stateprovinceid(value) => NamedParameter("stateprovinceid", ParameterValue.from(value))
          case StateprovinceFieldValue.stateprovincecode(value) => NamedParameter("stateprovincecode", ParameterValue.from(value))
          case StateprovinceFieldValue.countryregioncode(value) => NamedParameter("countryregioncode", ParameterValue.from(value))
          case StateprovinceFieldValue.isonlystateprovinceflag(value) => NamedParameter("isonlystateprovinceflag", ParameterValue.from(value))
          case StateprovinceFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case StateprovinceFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case StateprovinceFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case StateprovinceFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from person.stateprovince where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(stateprovinceid: StateprovinceId)(implicit c: Connection): Option[StateprovinceRow] = {
    SQL"""select stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, name, territoryid, rowguid, modifieddate from person.stateprovince where stateprovinceid = $stateprovinceid""".as(rowParser.singleOpt)
  }
  override def selectByIds(stateprovinceids: List[StateprovinceId])(implicit c: Connection): List[StateprovinceRow] = {
    SQL"""select stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, name, territoryid, rowguid, modifieddate from person.stateprovince where stateprovinceid in $stateprovinceids""".as(rowParser.*)
  }
  override def update(row: StateprovinceRow)(implicit c: Connection): Boolean = {
    val stateprovinceid = row.stateprovinceid
    SQL"""update person.stateprovince
          set stateprovincecode = ${row.stateprovincecode},
              countryregioncode = ${row.countryregioncode},
              isonlystateprovinceflag = ${row.isonlystateprovinceflag},
              name = ${row.name},
              territoryid = ${row.territoryid},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where stateprovinceid = $stateprovinceid""".executeUpdate() > 0
  }
  override def updateFieldValues(stateprovinceid: StateprovinceId, fieldValues: List[StateprovinceFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case StateprovinceFieldValue.stateprovincecode(value) => NamedParameter("stateprovincecode", ParameterValue.from(value))
          case StateprovinceFieldValue.countryregioncode(value) => NamedParameter("countryregioncode", ParameterValue.from(value))
          case StateprovinceFieldValue.isonlystateprovinceflag(value) => NamedParameter("isonlystateprovinceflag", ParameterValue.from(value))
          case StateprovinceFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case StateprovinceFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case StateprovinceFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case StateprovinceFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update person.stateprovince
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where stateprovinceid = $stateprovinceid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[StateprovinceRow] =
    RowParser[StateprovinceRow] { row =>
      Success(
        StateprovinceRow(
          stateprovinceid = row[StateprovinceId]("stateprovinceid"),
          stateprovincecode = row[/* bpchar */ String]("stateprovincecode"),
          countryregioncode = row[CountryregionId]("countryregioncode"),
          isonlystateprovinceflag = row[Flag]("isonlystateprovinceflag"),
          name = row[Name]("name"),
          territoryid = row[SalesterritoryId]("territoryid"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[StateprovinceId] =
    SqlParser.get[StateprovinceId]("stateprovinceid")
}
