package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgSequenceRepoImpl extends PgSequenceRepo {
  override def selectAll(implicit c: Connection): List[PgSequenceRow] = {
    SQL"""select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle from pg_catalog.pg_sequence""".as(PgSequenceRow.rowParser.*)
  }
  override def selectById(seqrelid: PgSequenceId)(implicit c: Connection): Option[PgSequenceRow] = {
    SQL"""select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle from pg_catalog.pg_sequence where seqrelid = $seqrelid""".as(PgSequenceRow.rowParser.singleOpt)
  }
  override def selectByIds(seqrelids: List[PgSequenceId])(implicit c: Connection): List[PgSequenceRow] = {
    SQL"""select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle from pg_catalog.pg_sequence where seqrelid in $seqrelids""".as(PgSequenceRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgSequenceFieldValue[_]])(implicit c: Connection): List[PgSequenceRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSequenceFieldValue.seqrelid(value) => NamedParameter("seqrelid", ParameterValue.from(value))
          case PgSequenceFieldValue.seqtypid(value) => NamedParameter("seqtypid", ParameterValue.from(value))
          case PgSequenceFieldValue.seqstart(value) => NamedParameter("seqstart", ParameterValue.from(value))
          case PgSequenceFieldValue.seqincrement(value) => NamedParameter("seqincrement", ParameterValue.from(value))
          case PgSequenceFieldValue.seqmax(value) => NamedParameter("seqmax", ParameterValue.from(value))
          case PgSequenceFieldValue.seqmin(value) => NamedParameter("seqmin", ParameterValue.from(value))
          case PgSequenceFieldValue.seqcache(value) => NamedParameter("seqcache", ParameterValue.from(value))
          case PgSequenceFieldValue.seqcycle(value) => NamedParameter("seqcycle", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_sequence where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgSequenceRow.rowParser.*)
    }

  }
  override def updateFieldValues(seqrelid: PgSequenceId, fieldValues: List[PgSequenceFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSequenceFieldValue.seqrelid(value) => NamedParameter("seqrelid", ParameterValue.from(value))
          case PgSequenceFieldValue.seqtypid(value) => NamedParameter("seqtypid", ParameterValue.from(value))
          case PgSequenceFieldValue.seqstart(value) => NamedParameter("seqstart", ParameterValue.from(value))
          case PgSequenceFieldValue.seqincrement(value) => NamedParameter("seqincrement", ParameterValue.from(value))
          case PgSequenceFieldValue.seqmax(value) => NamedParameter("seqmax", ParameterValue.from(value))
          case PgSequenceFieldValue.seqmin(value) => NamedParameter("seqmin", ParameterValue.from(value))
          case PgSequenceFieldValue.seqcache(value) => NamedParameter("seqcache", ParameterValue.from(value))
          case PgSequenceFieldValue.seqcycle(value) => NamedParameter("seqcycle", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_sequence
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where seqrelid = $seqrelid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(seqrelid: PgSequenceId, unsaved: PgSequenceRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("seqtypid", ParameterValue.from(unsaved.seqtypid))),
      Some(NamedParameter("seqstart", ParameterValue.from(unsaved.seqstart))),
      Some(NamedParameter("seqincrement", ParameterValue.from(unsaved.seqincrement))),
      Some(NamedParameter("seqmax", ParameterValue.from(unsaved.seqmax))),
      Some(NamedParameter("seqmin", ParameterValue.from(unsaved.seqmin))),
      Some(NamedParameter("seqcache", ParameterValue.from(unsaved.seqcache))),
      Some(NamedParameter("seqcycle", ParameterValue.from(unsaved.seqcycle)))
    ).flatten

    SQL"""insert into pg_catalog.pg_sequence(seqrelid, ${namedParameters.map(_.name).mkString(", ")})
      values (${seqrelid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(seqrelid: PgSequenceId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_sequence where seqrelid = $seqrelid""".executeUpdate() > 0
  }
}
