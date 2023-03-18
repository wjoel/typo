package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgConstraintRepoImpl extends PgConstraintRepo {
  override def selectAll(implicit c: Connection): List[PgConstraintRow] = {
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint""".as(PgConstraintRow.rowParser.*)
  }
  override def selectById(oid: PgConstraintId)(implicit c: Connection): Option[PgConstraintRow] = {
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint where oid = $oid""".as(PgConstraintRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgConstraintId])(implicit c: Connection): List[PgConstraintRow] = {
    SQL"""select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint where oid in $oids""".as(PgConstraintRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgConstraintFieldValue[_]])(implicit c: Connection): List[PgConstraintRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgConstraintFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgConstraintFieldValue.conname(value) => NamedParameter("conname", ParameterValue.from(value))
          case PgConstraintFieldValue.connamespace(value) => NamedParameter("connamespace", ParameterValue.from(value))
          case PgConstraintFieldValue.contype(value) => NamedParameter("contype", ParameterValue.from(value))
          case PgConstraintFieldValue.condeferrable(value) => NamedParameter("condeferrable", ParameterValue.from(value))
          case PgConstraintFieldValue.condeferred(value) => NamedParameter("condeferred", ParameterValue.from(value))
          case PgConstraintFieldValue.convalidated(value) => NamedParameter("convalidated", ParameterValue.from(value))
          case PgConstraintFieldValue.conrelid(value) => NamedParameter("conrelid", ParameterValue.from(value))
          case PgConstraintFieldValue.contypid(value) => NamedParameter("contypid", ParameterValue.from(value))
          case PgConstraintFieldValue.conindid(value) => NamedParameter("conindid", ParameterValue.from(value))
          case PgConstraintFieldValue.conparentid(value) => NamedParameter("conparentid", ParameterValue.from(value))
          case PgConstraintFieldValue.confrelid(value) => NamedParameter("confrelid", ParameterValue.from(value))
          case PgConstraintFieldValue.confupdtype(value) => NamedParameter("confupdtype", ParameterValue.from(value))
          case PgConstraintFieldValue.confdeltype(value) => NamedParameter("confdeltype", ParameterValue.from(value))
          case PgConstraintFieldValue.confmatchtype(value) => NamedParameter("confmatchtype", ParameterValue.from(value))
          case PgConstraintFieldValue.conislocal(value) => NamedParameter("conislocal", ParameterValue.from(value))
          case PgConstraintFieldValue.coninhcount(value) => NamedParameter("coninhcount", ParameterValue.from(value))
          case PgConstraintFieldValue.connoinherit(value) => NamedParameter("connoinherit", ParameterValue.from(value))
          case PgConstraintFieldValue.conkey(value) => NamedParameter("conkey", ParameterValue.from(value))
          case PgConstraintFieldValue.confkey(value) => NamedParameter("confkey", ParameterValue.from(value))
          case PgConstraintFieldValue.conpfeqop(value) => NamedParameter("conpfeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conppeqop(value) => NamedParameter("conppeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conffeqop(value) => NamedParameter("conffeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conexclop(value) => NamedParameter("conexclop", ParameterValue.from(value))
          case PgConstraintFieldValue.conbin(value) => NamedParameter("conbin", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_constraint where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgConstraintRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgConstraintId, fieldValues: List[PgConstraintFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgConstraintFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgConstraintFieldValue.conname(value) => NamedParameter("conname", ParameterValue.from(value))
          case PgConstraintFieldValue.connamespace(value) => NamedParameter("connamespace", ParameterValue.from(value))
          case PgConstraintFieldValue.contype(value) => NamedParameter("contype", ParameterValue.from(value))
          case PgConstraintFieldValue.condeferrable(value) => NamedParameter("condeferrable", ParameterValue.from(value))
          case PgConstraintFieldValue.condeferred(value) => NamedParameter("condeferred", ParameterValue.from(value))
          case PgConstraintFieldValue.convalidated(value) => NamedParameter("convalidated", ParameterValue.from(value))
          case PgConstraintFieldValue.conrelid(value) => NamedParameter("conrelid", ParameterValue.from(value))
          case PgConstraintFieldValue.contypid(value) => NamedParameter("contypid", ParameterValue.from(value))
          case PgConstraintFieldValue.conindid(value) => NamedParameter("conindid", ParameterValue.from(value))
          case PgConstraintFieldValue.conparentid(value) => NamedParameter("conparentid", ParameterValue.from(value))
          case PgConstraintFieldValue.confrelid(value) => NamedParameter("confrelid", ParameterValue.from(value))
          case PgConstraintFieldValue.confupdtype(value) => NamedParameter("confupdtype", ParameterValue.from(value))
          case PgConstraintFieldValue.confdeltype(value) => NamedParameter("confdeltype", ParameterValue.from(value))
          case PgConstraintFieldValue.confmatchtype(value) => NamedParameter("confmatchtype", ParameterValue.from(value))
          case PgConstraintFieldValue.conislocal(value) => NamedParameter("conislocal", ParameterValue.from(value))
          case PgConstraintFieldValue.coninhcount(value) => NamedParameter("coninhcount", ParameterValue.from(value))
          case PgConstraintFieldValue.connoinherit(value) => NamedParameter("connoinherit", ParameterValue.from(value))
          case PgConstraintFieldValue.conkey(value) => NamedParameter("conkey", ParameterValue.from(value))
          case PgConstraintFieldValue.confkey(value) => NamedParameter("confkey", ParameterValue.from(value))
          case PgConstraintFieldValue.conpfeqop(value) => NamedParameter("conpfeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conppeqop(value) => NamedParameter("conppeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conffeqop(value) => NamedParameter("conffeqop", ParameterValue.from(value))
          case PgConstraintFieldValue.conexclop(value) => NamedParameter("conexclop", ParameterValue.from(value))
          case PgConstraintFieldValue.conbin(value) => NamedParameter("conbin", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_constraint
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgConstraintId, unsaved: PgConstraintRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("conname", ParameterValue.from(unsaved.conname))),
      Some(NamedParameter("connamespace", ParameterValue.from(unsaved.connamespace))),
      Some(NamedParameter("contype", ParameterValue.from(unsaved.contype))),
      Some(NamedParameter("condeferrable", ParameterValue.from(unsaved.condeferrable))),
      Some(NamedParameter("condeferred", ParameterValue.from(unsaved.condeferred))),
      Some(NamedParameter("convalidated", ParameterValue.from(unsaved.convalidated))),
      Some(NamedParameter("conrelid", ParameterValue.from(unsaved.conrelid))),
      Some(NamedParameter("contypid", ParameterValue.from(unsaved.contypid))),
      Some(NamedParameter("conindid", ParameterValue.from(unsaved.conindid))),
      Some(NamedParameter("conparentid", ParameterValue.from(unsaved.conparentid))),
      Some(NamedParameter("confrelid", ParameterValue.from(unsaved.confrelid))),
      Some(NamedParameter("confupdtype", ParameterValue.from(unsaved.confupdtype))),
      Some(NamedParameter("confdeltype", ParameterValue.from(unsaved.confdeltype))),
      Some(NamedParameter("confmatchtype", ParameterValue.from(unsaved.confmatchtype))),
      Some(NamedParameter("conislocal", ParameterValue.from(unsaved.conislocal))),
      Some(NamedParameter("coninhcount", ParameterValue.from(unsaved.coninhcount))),
      Some(NamedParameter("connoinherit", ParameterValue.from(unsaved.connoinherit))),
      Some(NamedParameter("conkey", ParameterValue.from(unsaved.conkey))),
      Some(NamedParameter("confkey", ParameterValue.from(unsaved.confkey))),
      Some(NamedParameter("conpfeqop", ParameterValue.from(unsaved.conpfeqop))),
      Some(NamedParameter("conppeqop", ParameterValue.from(unsaved.conppeqop))),
      Some(NamedParameter("conffeqop", ParameterValue.from(unsaved.conffeqop))),
      Some(NamedParameter("conexclop", ParameterValue.from(unsaved.conexclop))),
      Some(NamedParameter("conbin", ParameterValue.from(unsaved.conbin)))
    ).flatten

    SQL"""insert into pg_catalog.pg_constraint(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgConstraintId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_constraint where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(conrelid: Long, contypid: Long, conname: String)(implicit c: Connection): Option[PgConstraintRow] = {
    ???
  }
}
