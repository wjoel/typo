package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgAuthMembersRepoImpl extends PgAuthMembersRepo {
  override def selectAll(implicit c: Connection): List[PgAuthMembersRow] = {
    SQL"""select roleid, member, grantor, admin_option from pg_catalog.pg_auth_members""".as(PgAuthMembersRow.rowParser.*)
  }
  override def selectById(roleidAndMember: PgAuthMembersId)(implicit c: Connection): Option[PgAuthMembersRow] = {
    SQL"""select roleid, member, grantor, admin_option from pg_catalog.pg_auth_members where roleid = ${roleidAndMember.roleid}, member = ${roleidAndMember.member}""".as(PgAuthMembersRow.rowParser.singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgAuthMembersFieldValue[_]])(implicit c: Connection): List[PgAuthMembersRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAuthMembersFieldValue.roleid(value) => NamedParameter("roleid", ParameterValue.from(value))
          case PgAuthMembersFieldValue.member(value) => NamedParameter("member", ParameterValue.from(value))
          case PgAuthMembersFieldValue.grantor(value) => NamedParameter("grantor", ParameterValue.from(value))
          case PgAuthMembersFieldValue.adminOption(value) => NamedParameter("admin_option", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_auth_members where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgAuthMembersRow.rowParser.*)
    }

  }
  override def updateFieldValues(roleidAndMember: PgAuthMembersId, fieldValues: List[PgAuthMembersFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAuthMembersFieldValue.roleid(value) => NamedParameter("roleid", ParameterValue.from(value))
          case PgAuthMembersFieldValue.member(value) => NamedParameter("member", ParameterValue.from(value))
          case PgAuthMembersFieldValue.grantor(value) => NamedParameter("grantor", ParameterValue.from(value))
          case PgAuthMembersFieldValue.adminOption(value) => NamedParameter("admin_option", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_auth_members
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where roleid = ${roleidAndMember.roleid}, member = ${roleidAndMember.member}"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(roleidAndMember: PgAuthMembersId, unsaved: PgAuthMembersRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("grantor", ParameterValue.from(unsaved.grantor))),
      Some(NamedParameter("admin_option", ParameterValue.from(unsaved.adminOption)))
    ).flatten

    SQL"""insert into pg_catalog.pg_auth_members(roleid, member, ${namedParameters.map(_.name).mkString(", ")})
      values (${roleidAndMember.roleid}, ${roleidAndMember.member}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(roleidAndMember: PgAuthMembersId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_auth_members where roleid = ${roleidAndMember.roleid}, member = ${roleidAndMember.member}""".executeUpdate() > 0
  }
  override def selectByUnique(member: Long, roleid: Long)(implicit c: Connection): Option[PgAuthMembersRow] = {
    ???
  }
}
