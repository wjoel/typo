package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgPublicationRelRepoImpl extends PgPublicationRelRepo {
  override def selectAll(implicit c: Connection): List[PgPublicationRelRow] = {
    SQL"""select oid, prpubid, prrelid from pg_catalog.pg_publication_rel""".as(PgPublicationRelRow.rowParser.*)
  }
  override def selectById(oid: PgPublicationRelId)(implicit c: Connection): Option[PgPublicationRelRow] = {
    SQL"""select oid, prpubid, prrelid from pg_catalog.pg_publication_rel where oid = $oid""".as(PgPublicationRelRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgPublicationRelId])(implicit c: Connection): List[PgPublicationRelRow] = {
    SQL"""select oid, prpubid, prrelid from pg_catalog.pg_publication_rel where oid in $oids""".as(PgPublicationRelRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgPublicationRelFieldValue[_]])(implicit c: Connection): List[PgPublicationRelRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPublicationRelFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgPublicationRelFieldValue.prpubid(value) => NamedParameter("prpubid", ParameterValue.from(value))
          case PgPublicationRelFieldValue.prrelid(value) => NamedParameter("prrelid", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_publication_rel where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgPublicationRelRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgPublicationRelId, fieldValues: List[PgPublicationRelFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPublicationRelFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgPublicationRelFieldValue.prpubid(value) => NamedParameter("prpubid", ParameterValue.from(value))
          case PgPublicationRelFieldValue.prrelid(value) => NamedParameter("prrelid", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_publication_rel
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgPublicationRelId, unsaved: PgPublicationRelRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("prpubid", ParameterValue.from(unsaved.prpubid))),
      Some(NamedParameter("prrelid", ParameterValue.from(unsaved.prrelid)))
    ).flatten

    SQL"""insert into pg_catalog.pg_publication_rel(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgPublicationRelId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_publication_rel where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(prrelid: Long, prpubid: Long)(implicit c: Connection): Option[PgPublicationRelRow] = {
    ???
  }
}
