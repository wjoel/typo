package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgIndexRepoImpl extends PgIndexRepo {
  override def selectAll(implicit c: Connection): List[PgIndexRow] = {
    SQL"""select indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred from pg_catalog.pg_index""".as(PgIndexRow.rowParser.*)
  }
  override def selectById(indexrelid: PgIndexId)(implicit c: Connection): Option[PgIndexRow] = {
    SQL"""select indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred from pg_catalog.pg_index where indexrelid = $indexrelid""".as(PgIndexRow.rowParser.singleOpt)
  }
  override def selectByIds(indexrelids: List[PgIndexId])(implicit c: Connection): List[PgIndexRow] = {
    SQL"""select indexrelid, indrelid, indnatts, indnkeyatts, indisunique, indisprimary, indisexclusion, indimmediate, indisclustered, indisvalid, indcheckxmin, indisready, indislive, indisreplident, indkey, indcollation, indclass, indoption, indexprs, indpred from pg_catalog.pg_index where indexrelid in $indexrelids""".as(PgIndexRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgIndexFieldValue[_]])(implicit c: Connection): List[PgIndexRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgIndexFieldValue.indexrelid(value) => NamedParameter("indexrelid", ParameterValue.from(value))
          case PgIndexFieldValue.indrelid(value) => NamedParameter("indrelid", ParameterValue.from(value))
          case PgIndexFieldValue.indnatts(value) => NamedParameter("indnatts", ParameterValue.from(value))
          case PgIndexFieldValue.indnkeyatts(value) => NamedParameter("indnkeyatts", ParameterValue.from(value))
          case PgIndexFieldValue.indisunique(value) => NamedParameter("indisunique", ParameterValue.from(value))
          case PgIndexFieldValue.indisprimary(value) => NamedParameter("indisprimary", ParameterValue.from(value))
          case PgIndexFieldValue.indisexclusion(value) => NamedParameter("indisexclusion", ParameterValue.from(value))
          case PgIndexFieldValue.indimmediate(value) => NamedParameter("indimmediate", ParameterValue.from(value))
          case PgIndexFieldValue.indisclustered(value) => NamedParameter("indisclustered", ParameterValue.from(value))
          case PgIndexFieldValue.indisvalid(value) => NamedParameter("indisvalid", ParameterValue.from(value))
          case PgIndexFieldValue.indcheckxmin(value) => NamedParameter("indcheckxmin", ParameterValue.from(value))
          case PgIndexFieldValue.indisready(value) => NamedParameter("indisready", ParameterValue.from(value))
          case PgIndexFieldValue.indislive(value) => NamedParameter("indislive", ParameterValue.from(value))
          case PgIndexFieldValue.indisreplident(value) => NamedParameter("indisreplident", ParameterValue.from(value))
          case PgIndexFieldValue.indkey(value) => NamedParameter("indkey", ParameterValue.from(value))
          case PgIndexFieldValue.indcollation(value) => NamedParameter("indcollation", ParameterValue.from(value))
          case PgIndexFieldValue.indclass(value) => NamedParameter("indclass", ParameterValue.from(value))
          case PgIndexFieldValue.indoption(value) => NamedParameter("indoption", ParameterValue.from(value))
          case PgIndexFieldValue.indexprs(value) => NamedParameter("indexprs", ParameterValue.from(value))
          case PgIndexFieldValue.indpred(value) => NamedParameter("indpred", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_index where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgIndexRow.rowParser.*)
    }

  }
  override def updateFieldValues(indexrelid: PgIndexId, fieldValues: List[PgIndexFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgIndexFieldValue.indexrelid(value) => NamedParameter("indexrelid", ParameterValue.from(value))
          case PgIndexFieldValue.indrelid(value) => NamedParameter("indrelid", ParameterValue.from(value))
          case PgIndexFieldValue.indnatts(value) => NamedParameter("indnatts", ParameterValue.from(value))
          case PgIndexFieldValue.indnkeyatts(value) => NamedParameter("indnkeyatts", ParameterValue.from(value))
          case PgIndexFieldValue.indisunique(value) => NamedParameter("indisunique", ParameterValue.from(value))
          case PgIndexFieldValue.indisprimary(value) => NamedParameter("indisprimary", ParameterValue.from(value))
          case PgIndexFieldValue.indisexclusion(value) => NamedParameter("indisexclusion", ParameterValue.from(value))
          case PgIndexFieldValue.indimmediate(value) => NamedParameter("indimmediate", ParameterValue.from(value))
          case PgIndexFieldValue.indisclustered(value) => NamedParameter("indisclustered", ParameterValue.from(value))
          case PgIndexFieldValue.indisvalid(value) => NamedParameter("indisvalid", ParameterValue.from(value))
          case PgIndexFieldValue.indcheckxmin(value) => NamedParameter("indcheckxmin", ParameterValue.from(value))
          case PgIndexFieldValue.indisready(value) => NamedParameter("indisready", ParameterValue.from(value))
          case PgIndexFieldValue.indislive(value) => NamedParameter("indislive", ParameterValue.from(value))
          case PgIndexFieldValue.indisreplident(value) => NamedParameter("indisreplident", ParameterValue.from(value))
          case PgIndexFieldValue.indkey(value) => NamedParameter("indkey", ParameterValue.from(value))
          case PgIndexFieldValue.indcollation(value) => NamedParameter("indcollation", ParameterValue.from(value))
          case PgIndexFieldValue.indclass(value) => NamedParameter("indclass", ParameterValue.from(value))
          case PgIndexFieldValue.indoption(value) => NamedParameter("indoption", ParameterValue.from(value))
          case PgIndexFieldValue.indexprs(value) => NamedParameter("indexprs", ParameterValue.from(value))
          case PgIndexFieldValue.indpred(value) => NamedParameter("indpred", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_index
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where indexrelid = $indexrelid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(indexrelid: PgIndexId, unsaved: PgIndexRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("indrelid", ParameterValue.from(unsaved.indrelid))),
      Some(NamedParameter("indnatts", ParameterValue.from(unsaved.indnatts))),
      Some(NamedParameter("indnkeyatts", ParameterValue.from(unsaved.indnkeyatts))),
      Some(NamedParameter("indisunique", ParameterValue.from(unsaved.indisunique))),
      Some(NamedParameter("indisprimary", ParameterValue.from(unsaved.indisprimary))),
      Some(NamedParameter("indisexclusion", ParameterValue.from(unsaved.indisexclusion))),
      Some(NamedParameter("indimmediate", ParameterValue.from(unsaved.indimmediate))),
      Some(NamedParameter("indisclustered", ParameterValue.from(unsaved.indisclustered))),
      Some(NamedParameter("indisvalid", ParameterValue.from(unsaved.indisvalid))),
      Some(NamedParameter("indcheckxmin", ParameterValue.from(unsaved.indcheckxmin))),
      Some(NamedParameter("indisready", ParameterValue.from(unsaved.indisready))),
      Some(NamedParameter("indislive", ParameterValue.from(unsaved.indislive))),
      Some(NamedParameter("indisreplident", ParameterValue.from(unsaved.indisreplident))),
      Some(NamedParameter("indkey", ParameterValue.from(unsaved.indkey))),
      Some(NamedParameter("indcollation", ParameterValue.from(unsaved.indcollation))),
      Some(NamedParameter("indclass", ParameterValue.from(unsaved.indclass))),
      Some(NamedParameter("indoption", ParameterValue.from(unsaved.indoption))),
      Some(NamedParameter("indexprs", ParameterValue.from(unsaved.indexprs))),
      Some(NamedParameter("indpred", ParameterValue.from(unsaved.indpred)))
    ).flatten

    SQL"""insert into pg_catalog.pg_index(indexrelid, ${namedParameters.map(_.name).mkString(", ")})
      values (${indexrelid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(indexrelid: PgIndexId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_index where indexrelid = $indexrelid""".executeUpdate() > 0
  }
}
