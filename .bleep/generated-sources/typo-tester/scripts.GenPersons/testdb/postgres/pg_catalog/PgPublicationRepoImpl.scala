package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgPublicationRepoImpl extends PgPublicationRepo {
  override def selectAll(implicit c: Connection): List[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot from pg_catalog.pg_publication""".as(PgPublicationRow.rowParser.*)
  }
  override def selectById(oid: PgPublicationId)(implicit c: Connection): Option[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot from pg_catalog.pg_publication where oid = $oid""".as(PgPublicationRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgPublicationId])(implicit c: Connection): List[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot from pg_catalog.pg_publication where oid in $oids""".as(PgPublicationRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgPublicationFieldValue[_]])(implicit c: Connection): List[PgPublicationRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPublicationFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgPublicationFieldValue.pubname(value) => NamedParameter("pubname", ParameterValue.from(value))
          case PgPublicationFieldValue.pubowner(value) => NamedParameter("pubowner", ParameterValue.from(value))
          case PgPublicationFieldValue.puballtables(value) => NamedParameter("puballtables", ParameterValue.from(value))
          case PgPublicationFieldValue.pubinsert(value) => NamedParameter("pubinsert", ParameterValue.from(value))
          case PgPublicationFieldValue.pubupdate(value) => NamedParameter("pubupdate", ParameterValue.from(value))
          case PgPublicationFieldValue.pubdelete(value) => NamedParameter("pubdelete", ParameterValue.from(value))
          case PgPublicationFieldValue.pubtruncate(value) => NamedParameter("pubtruncate", ParameterValue.from(value))
          case PgPublicationFieldValue.pubviaroot(value) => NamedParameter("pubviaroot", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_publication where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgPublicationRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgPublicationId, fieldValues: List[PgPublicationFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPublicationFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgPublicationFieldValue.pubname(value) => NamedParameter("pubname", ParameterValue.from(value))
          case PgPublicationFieldValue.pubowner(value) => NamedParameter("pubowner", ParameterValue.from(value))
          case PgPublicationFieldValue.puballtables(value) => NamedParameter("puballtables", ParameterValue.from(value))
          case PgPublicationFieldValue.pubinsert(value) => NamedParameter("pubinsert", ParameterValue.from(value))
          case PgPublicationFieldValue.pubupdate(value) => NamedParameter("pubupdate", ParameterValue.from(value))
          case PgPublicationFieldValue.pubdelete(value) => NamedParameter("pubdelete", ParameterValue.from(value))
          case PgPublicationFieldValue.pubtruncate(value) => NamedParameter("pubtruncate", ParameterValue.from(value))
          case PgPublicationFieldValue.pubviaroot(value) => NamedParameter("pubviaroot", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_publication
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgPublicationId, unsaved: PgPublicationRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("pubname", ParameterValue.from(unsaved.pubname))),
      Some(NamedParameter("pubowner", ParameterValue.from(unsaved.pubowner))),
      Some(NamedParameter("puballtables", ParameterValue.from(unsaved.puballtables))),
      Some(NamedParameter("pubinsert", ParameterValue.from(unsaved.pubinsert))),
      Some(NamedParameter("pubupdate", ParameterValue.from(unsaved.pubupdate))),
      Some(NamedParameter("pubdelete", ParameterValue.from(unsaved.pubdelete))),
      Some(NamedParameter("pubtruncate", ParameterValue.from(unsaved.pubtruncate))),
      Some(NamedParameter("pubviaroot", ParameterValue.from(unsaved.pubviaroot)))
    ).flatten

    SQL"""insert into pg_catalog.pg_publication(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgPublicationId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_publication where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(pubname: String)(implicit c: Connection): Option[PgPublicationRow] = {
    ???
  }
}
