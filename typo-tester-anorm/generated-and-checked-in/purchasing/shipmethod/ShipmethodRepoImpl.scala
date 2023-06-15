/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object ShipmethodRepoImpl extends ShipmethodRepo {
  override def delete(shipmethodid: ShipmethodId)(implicit c: Connection): Boolean = {
    SQL"delete from purchasing.shipmethod where shipmethodid = $shipmethodid".executeUpdate() > 0
  }
  override def insert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow = {
    SQL"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (${unsaved.shipmethodid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.shipbase}::numeric, ${unsaved.shiprate}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  override def insert(unsaved: ShipmethodRowUnsaved)(implicit c: Connection): ShipmethodRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.shipmethodid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shipmethodid", ParameterValue.from[ShipmethodId](value)), "::int4"))
      },
      unsaved.shipbase match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shipbase", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.shiprate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shiprate", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.shipmethod default values
            returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into purchasing.shipmethod(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ShipmethodRow] = {
    SQL"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
          from purchasing.shipmethod
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ShipmethodFieldOrIdValue[_]])(implicit c: Connection): List[ShipmethodRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ShipmethodFieldValue.shipmethodid(value) => NamedParameter("shipmethodid", ParameterValue.from(value))
          case ShipmethodFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ShipmethodFieldValue.shipbase(value) => NamedParameter("shipbase", ParameterValue.from(value))
          case ShipmethodFieldValue.shiprate(value) => NamedParameter("shiprate", ParameterValue.from(value))
          case ShipmethodFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ShipmethodFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
                    from purchasing.shipmethod
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(shipmethodid: ShipmethodId)(implicit c: Connection): Option[ShipmethodRow] = {
    SQL"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
          from purchasing.shipmethod
          where shipmethodid = $shipmethodid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(shipmethodids: Array[ShipmethodId])(implicit c: Connection): List[ShipmethodRow] = {
    implicit val toStatement: ToStatement[Array[ShipmethodId]] =
      (s: PreparedStatement, index: Int, v: Array[ShipmethodId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
          from purchasing.shipmethod
          where shipmethodid = ANY($shipmethodids)
       """.as(rowParser.*)
  
  }
  override def update(row: ShipmethodRow)(implicit c: Connection): Boolean = {
    val shipmethodid = row.shipmethodid
    SQL"""update purchasing.shipmethod
          set "name" = ${row.name}::"public"."Name",
              shipbase = ${row.shipbase}::numeric,
              shiprate = ${row.shiprate}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where shipmethodid = $shipmethodid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(shipmethodid: ShipmethodId, fieldValues: List[ShipmethodFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ShipmethodFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ShipmethodFieldValue.shipbase(value) => NamedParameter("shipbase", ParameterValue.from(value))
          case ShipmethodFieldValue.shiprate(value) => NamedParameter("shiprate", ParameterValue.from(value))
          case ShipmethodFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ShipmethodFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update purchasing.shipmethod
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where shipmethodid = {shipmethodid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("shipmethodid", ParameterValue.from(shipmethodid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow = {
    SQL"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (
            ${unsaved.shipmethodid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.shipbase}::numeric,
            ${unsaved.shiprate}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (shipmethodid)
          do update set
            "name" = EXCLUDED."name",
            shipbase = EXCLUDED.shipbase,
            shiprate = EXCLUDED.shiprate,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  val rowParser: RowParser[ShipmethodRow] =
    RowParser[ShipmethodRow] { row =>
      Success(
        ShipmethodRow(
          shipmethodid = row[ShipmethodId]("shipmethodid"),
          name = row[Name]("name"),
          shipbase = row[BigDecimal]("shipbase"),
          shiprate = row[BigDecimal]("shiprate"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}