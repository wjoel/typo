package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgLanguageRepoImpl extends PgLanguageRepo {
  override def selectAll(implicit c: Connection): List[PgLanguageRow] = {
    SQL"""select oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl from pg_catalog.pg_language""".as(PgLanguageRow.rowParser.*)
  }
  override def selectById(oid: PgLanguageId)(implicit c: Connection): Option[PgLanguageRow] = {
    SQL"""select oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl from pg_catalog.pg_language where oid = $oid""".as(PgLanguageRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgLanguageId])(implicit c: Connection): List[PgLanguageRow] = {
    SQL"""select oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl from pg_catalog.pg_language where oid in $oids""".as(PgLanguageRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgLanguageFieldValue[_]])(implicit c: Connection): List[PgLanguageRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgLanguageFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgLanguageFieldValue.lanname(value) => NamedParameter("lanname", ParameterValue.from(value))
          case PgLanguageFieldValue.lanowner(value) => NamedParameter("lanowner", ParameterValue.from(value))
          case PgLanguageFieldValue.lanispl(value) => NamedParameter("lanispl", ParameterValue.from(value))
          case PgLanguageFieldValue.lanpltrusted(value) => NamedParameter("lanpltrusted", ParameterValue.from(value))
          case PgLanguageFieldValue.lanplcallfoid(value) => NamedParameter("lanplcallfoid", ParameterValue.from(value))
          case PgLanguageFieldValue.laninline(value) => NamedParameter("laninline", ParameterValue.from(value))
          case PgLanguageFieldValue.lanvalidator(value) => NamedParameter("lanvalidator", ParameterValue.from(value))
          case PgLanguageFieldValue.lanacl(value) => NamedParameter("lanacl", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_language where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgLanguageRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgLanguageId, fieldValues: List[PgLanguageFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgLanguageFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgLanguageFieldValue.lanname(value) => NamedParameter("lanname", ParameterValue.from(value))
          case PgLanguageFieldValue.lanowner(value) => NamedParameter("lanowner", ParameterValue.from(value))
          case PgLanguageFieldValue.lanispl(value) => NamedParameter("lanispl", ParameterValue.from(value))
          case PgLanguageFieldValue.lanpltrusted(value) => NamedParameter("lanpltrusted", ParameterValue.from(value))
          case PgLanguageFieldValue.lanplcallfoid(value) => NamedParameter("lanplcallfoid", ParameterValue.from(value))
          case PgLanguageFieldValue.laninline(value) => NamedParameter("laninline", ParameterValue.from(value))
          case PgLanguageFieldValue.lanvalidator(value) => NamedParameter("lanvalidator", ParameterValue.from(value))
          case PgLanguageFieldValue.lanacl(value) => NamedParameter("lanacl", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_language
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgLanguageId, unsaved: PgLanguageRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("lanname", ParameterValue.from(unsaved.lanname))),
      Some(NamedParameter("lanowner", ParameterValue.from(unsaved.lanowner))),
      Some(NamedParameter("lanispl", ParameterValue.from(unsaved.lanispl))),
      Some(NamedParameter("lanpltrusted", ParameterValue.from(unsaved.lanpltrusted))),
      Some(NamedParameter("lanplcallfoid", ParameterValue.from(unsaved.lanplcallfoid))),
      Some(NamedParameter("laninline", ParameterValue.from(unsaved.laninline))),
      Some(NamedParameter("lanvalidator", ParameterValue.from(unsaved.lanvalidator))),
      Some(NamedParameter("lanacl", ParameterValue.from(unsaved.lanacl)))
    ).flatten

    SQL"""insert into pg_catalog.pg_language(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgLanguageId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_language where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(lanname: String)(implicit c: Connection): Option[PgLanguageRow] = {
    ???
  }
}
