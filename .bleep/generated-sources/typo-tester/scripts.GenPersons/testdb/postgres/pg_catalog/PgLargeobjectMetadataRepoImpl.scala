package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgLargeobjectMetadataRepoImpl extends PgLargeobjectMetadataRepo {
  override def selectAll(implicit c: Connection): List[PgLargeobjectMetadataRow] = {
    SQL"""select oid, lomowner, lomacl from pg_catalog.pg_largeobject_metadata""".as(PgLargeobjectMetadataRow.rowParser.*)
  }
  override def selectById(oid: PgLargeobjectMetadataId)(implicit c: Connection): Option[PgLargeobjectMetadataRow] = {
    SQL"""select oid, lomowner, lomacl from pg_catalog.pg_largeobject_metadata where oid = $oid""".as(PgLargeobjectMetadataRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgLargeobjectMetadataId])(implicit c: Connection): List[PgLargeobjectMetadataRow] = {
    SQL"""select oid, lomowner, lomacl from pg_catalog.pg_largeobject_metadata where oid in $oids""".as(PgLargeobjectMetadataRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgLargeobjectMetadataFieldValue[_]])(implicit c: Connection): List[PgLargeobjectMetadataRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgLargeobjectMetadataFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgLargeobjectMetadataFieldValue.lomowner(value) => NamedParameter("lomowner", ParameterValue.from(value))
          case PgLargeobjectMetadataFieldValue.lomacl(value) => NamedParameter("lomacl", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_largeobject_metadata where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgLargeobjectMetadataRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgLargeobjectMetadataId, fieldValues: List[PgLargeobjectMetadataFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgLargeobjectMetadataFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgLargeobjectMetadataFieldValue.lomowner(value) => NamedParameter("lomowner", ParameterValue.from(value))
          case PgLargeobjectMetadataFieldValue.lomacl(value) => NamedParameter("lomacl", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_largeobject_metadata
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgLargeobjectMetadataId, unsaved: PgLargeobjectMetadataRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("lomowner", ParameterValue.from(unsaved.lomowner))),
      Some(NamedParameter("lomacl", ParameterValue.from(unsaved.lomacl)))
    ).flatten

    SQL"""insert into pg_catalog.pg_largeobject_metadata(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgLargeobjectMetadataId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_largeobject_metadata where oid = $oid""".executeUpdate() > 0
  }
}
