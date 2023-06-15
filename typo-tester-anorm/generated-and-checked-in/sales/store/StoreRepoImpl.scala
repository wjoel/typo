/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
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
import org.postgresql.jdbc.PgSQLXML

object StoreRepoImpl extends StoreRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.store where businessentityid = $businessentityid".executeUpdate() > 0
  }
  override def insert(unsaved: StoreRow)(implicit c: Connection): StoreRow = {
    SQL"""insert into sales.store(businessentityid, "name", salespersonid, demographics, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.salespersonid}::int4, ${unsaved.demographics}::xml, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  override def insert(unsaved: StoreRowUnsaved)(implicit c: Connection): StoreRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      Some((NamedParameter("salespersonid", ParameterValue.from(unsaved.salespersonid)), "::int4")),
      Some((NamedParameter("demographics", ParameterValue.from(unsaved.demographics)), "::xml")),
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
      SQL"""insert into sales.store default values
            returning businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.store(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[StoreRow] = {
    SQL"""select businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
          from sales.store
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[StoreFieldOrIdValue[_]])(implicit c: Connection): List[StoreRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case StoreFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case StoreFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case StoreFieldValue.salespersonid(value) => NamedParameter("salespersonid", ParameterValue.from(value))
          case StoreFieldValue.demographics(value) => NamedParameter("demographics", ParameterValue.from(value))
          case StoreFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case StoreFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
                    from sales.store
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[StoreRow] = {
    SQL"""select businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
          from sales.store
          where businessentityid = $businessentityid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[StoreRow] = {
    implicit val toStatement: ToStatement[Array[BusinessentityId]] =
      (s: PreparedStatement, index: Int, v: Array[BusinessentityId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
          from sales.store
          where businessentityid = ANY($businessentityids)
       """.as(rowParser.*)
  
  }
  override def update(row: StoreRow)(implicit c: Connection): Boolean = {
    val businessentityid = row.businessentityid
    SQL"""update sales.store
          set "name" = ${row.name}::"public"."Name",
              salespersonid = ${row.salespersonid}::int4,
              demographics = ${row.demographics}::xml,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = $businessentityid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[StoreFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case StoreFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case StoreFieldValue.salespersonid(value) => NamedParameter("salespersonid", ParameterValue.from(value))
          case StoreFieldValue.demographics(value) => NamedParameter("demographics", ParameterValue.from(value))
          case StoreFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case StoreFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.store
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where businessentityid = {businessentityid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("businessentityid", ParameterValue.from(businessentityid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: StoreRow)(implicit c: Connection): StoreRow = {
    SQL"""insert into sales.store(businessentityid, "name", salespersonid, demographics, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.salespersonid}::int4,
            ${unsaved.demographics}::xml,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid)
          do update set
            "name" = EXCLUDED."name",
            salespersonid = EXCLUDED.salespersonid,
            demographics = EXCLUDED.demographics,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, "name", salespersonid, demographics, rowguid, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  val rowParser: RowParser[StoreRow] =
    RowParser[StoreRow] { row =>
      Success(
        StoreRow(
          businessentityid = row[BusinessentityId]("businessentityid"),
          name = row[Name]("name"),
          salespersonid = row[Option[BusinessentityId]]("salespersonid"),
          demographics = row[Option[PgSQLXML]]("demographics"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}