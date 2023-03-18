package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgForeignTableRepoImpl extends PgForeignTableRepo {
  override def selectAll(implicit c: Connection): List[PgForeignTableRow] = {
    SQL"""select ftrelid, ftserver, ftoptions from pg_catalog.pg_foreign_table""".as(PgForeignTableRow.rowParser.*)
  }
  override def selectById(ftrelid: PgForeignTableId)(implicit c: Connection): Option[PgForeignTableRow] = {
    SQL"""select ftrelid, ftserver, ftoptions from pg_catalog.pg_foreign_table where ftrelid = $ftrelid""".as(PgForeignTableRow.rowParser.singleOpt)
  }
  override def selectByIds(ftrelids: List[PgForeignTableId])(implicit c: Connection): List[PgForeignTableRow] = {
    SQL"""select ftrelid, ftserver, ftoptions from pg_catalog.pg_foreign_table where ftrelid in $ftrelids""".as(PgForeignTableRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgForeignTableFieldValue[_]])(implicit c: Connection): List[PgForeignTableRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignTableFieldValue.ftrelid(value) => NamedParameter("ftrelid", ParameterValue.from(value))
          case PgForeignTableFieldValue.ftserver(value) => NamedParameter("ftserver", ParameterValue.from(value))
          case PgForeignTableFieldValue.ftoptions(value) => NamedParameter("ftoptions", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_foreign_table where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgForeignTableRow.rowParser.*)
    }

  }
  override def updateFieldValues(ftrelid: PgForeignTableId, fieldValues: List[PgForeignTableFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignTableFieldValue.ftrelid(value) => NamedParameter("ftrelid", ParameterValue.from(value))
          case PgForeignTableFieldValue.ftserver(value) => NamedParameter("ftserver", ParameterValue.from(value))
          case PgForeignTableFieldValue.ftoptions(value) => NamedParameter("ftoptions", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_foreign_table
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where ftrelid = $ftrelid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(ftrelid: PgForeignTableId, unsaved: PgForeignTableRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("ftserver", ParameterValue.from(unsaved.ftserver))),
      Some(NamedParameter("ftoptions", ParameterValue.from(unsaved.ftoptions)))
    ).flatten

    SQL"""insert into pg_catalog.pg_foreign_table(ftrelid, ${namedParameters.map(_.name).mkString(", ")})
      values (${ftrelid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(ftrelid: PgForeignTableId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_foreign_table where ftrelid = $ftrelid""".executeUpdate() > 0
  }
}
