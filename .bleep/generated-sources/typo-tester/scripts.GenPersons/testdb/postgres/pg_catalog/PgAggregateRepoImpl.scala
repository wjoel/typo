package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgAggregateRepoImpl extends PgAggregateRepo {
  override def selectAll(implicit c: Connection): List[PgAggregateRow] = {
    SQL"""select aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval from pg_catalog.pg_aggregate""".as(PgAggregateRow.rowParser.*)
  }
  override def selectById(aggfnoid: PgAggregateId)(implicit c: Connection): Option[PgAggregateRow] = {
    SQL"""select aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval from pg_catalog.pg_aggregate where aggfnoid = $aggfnoid""".as(PgAggregateRow.rowParser.singleOpt)
  }
  override def selectByIds(aggfnoids: List[PgAggregateId])(implicit c: Connection): List[PgAggregateRow] = {
    SQL"""select aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval from pg_catalog.pg_aggregate where aggfnoid in $aggfnoids""".as(PgAggregateRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgAggregateFieldValue[_]])(implicit c: Connection): List[PgAggregateRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAggregateFieldValue.aggfnoid(value) => NamedParameter("aggfnoid", ParameterValue.from(value))
          case PgAggregateFieldValue.aggkind(value) => NamedParameter("aggkind", ParameterValue.from(value))
          case PgAggregateFieldValue.aggnumdirectargs(value) => NamedParameter("aggnumdirectargs", ParameterValue.from(value))
          case PgAggregateFieldValue.aggtransfn(value) => NamedParameter("aggtransfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggfinalfn(value) => NamedParameter("aggfinalfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggcombinefn(value) => NamedParameter("aggcombinefn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggserialfn(value) => NamedParameter("aggserialfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggdeserialfn(value) => NamedParameter("aggdeserialfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmtransfn(value) => NamedParameter("aggmtransfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggminvtransfn(value) => NamedParameter("aggminvtransfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmfinalfn(value) => NamedParameter("aggmfinalfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggfinalextra(value) => NamedParameter("aggfinalextra", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmfinalextra(value) => NamedParameter("aggmfinalextra", ParameterValue.from(value))
          case PgAggregateFieldValue.aggfinalmodify(value) => NamedParameter("aggfinalmodify", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmfinalmodify(value) => NamedParameter("aggmfinalmodify", ParameterValue.from(value))
          case PgAggregateFieldValue.aggsortop(value) => NamedParameter("aggsortop", ParameterValue.from(value))
          case PgAggregateFieldValue.aggtranstype(value) => NamedParameter("aggtranstype", ParameterValue.from(value))
          case PgAggregateFieldValue.aggtransspace(value) => NamedParameter("aggtransspace", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmtranstype(value) => NamedParameter("aggmtranstype", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmtransspace(value) => NamedParameter("aggmtransspace", ParameterValue.from(value))
          case PgAggregateFieldValue.agginitval(value) => NamedParameter("agginitval", ParameterValue.from(value))
          case PgAggregateFieldValue.aggminitval(value) => NamedParameter("aggminitval", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_aggregate where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgAggregateRow.rowParser.*)
    }

  }
  override def updateFieldValues(aggfnoid: PgAggregateId, fieldValues: List[PgAggregateFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAggregateFieldValue.aggfnoid(value) => NamedParameter("aggfnoid", ParameterValue.from(value))
          case PgAggregateFieldValue.aggkind(value) => NamedParameter("aggkind", ParameterValue.from(value))
          case PgAggregateFieldValue.aggnumdirectargs(value) => NamedParameter("aggnumdirectargs", ParameterValue.from(value))
          case PgAggregateFieldValue.aggtransfn(value) => NamedParameter("aggtransfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggfinalfn(value) => NamedParameter("aggfinalfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggcombinefn(value) => NamedParameter("aggcombinefn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggserialfn(value) => NamedParameter("aggserialfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggdeserialfn(value) => NamedParameter("aggdeserialfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmtransfn(value) => NamedParameter("aggmtransfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggminvtransfn(value) => NamedParameter("aggminvtransfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmfinalfn(value) => NamedParameter("aggmfinalfn", ParameterValue.from(value))
          case PgAggregateFieldValue.aggfinalextra(value) => NamedParameter("aggfinalextra", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmfinalextra(value) => NamedParameter("aggmfinalextra", ParameterValue.from(value))
          case PgAggregateFieldValue.aggfinalmodify(value) => NamedParameter("aggfinalmodify", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmfinalmodify(value) => NamedParameter("aggmfinalmodify", ParameterValue.from(value))
          case PgAggregateFieldValue.aggsortop(value) => NamedParameter("aggsortop", ParameterValue.from(value))
          case PgAggregateFieldValue.aggtranstype(value) => NamedParameter("aggtranstype", ParameterValue.from(value))
          case PgAggregateFieldValue.aggtransspace(value) => NamedParameter("aggtransspace", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmtranstype(value) => NamedParameter("aggmtranstype", ParameterValue.from(value))
          case PgAggregateFieldValue.aggmtransspace(value) => NamedParameter("aggmtransspace", ParameterValue.from(value))
          case PgAggregateFieldValue.agginitval(value) => NamedParameter("agginitval", ParameterValue.from(value))
          case PgAggregateFieldValue.aggminitval(value) => NamedParameter("aggminitval", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_aggregate
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where aggfnoid = $aggfnoid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(aggfnoid: PgAggregateId, unsaved: PgAggregateRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("aggkind", ParameterValue.from(unsaved.aggkind))),
      Some(NamedParameter("aggnumdirectargs", ParameterValue.from(unsaved.aggnumdirectargs))),
      Some(NamedParameter("aggtransfn", ParameterValue.from(unsaved.aggtransfn))),
      Some(NamedParameter("aggfinalfn", ParameterValue.from(unsaved.aggfinalfn))),
      Some(NamedParameter("aggcombinefn", ParameterValue.from(unsaved.aggcombinefn))),
      Some(NamedParameter("aggserialfn", ParameterValue.from(unsaved.aggserialfn))),
      Some(NamedParameter("aggdeserialfn", ParameterValue.from(unsaved.aggdeserialfn))),
      Some(NamedParameter("aggmtransfn", ParameterValue.from(unsaved.aggmtransfn))),
      Some(NamedParameter("aggminvtransfn", ParameterValue.from(unsaved.aggminvtransfn))),
      Some(NamedParameter("aggmfinalfn", ParameterValue.from(unsaved.aggmfinalfn))),
      Some(NamedParameter("aggfinalextra", ParameterValue.from(unsaved.aggfinalextra))),
      Some(NamedParameter("aggmfinalextra", ParameterValue.from(unsaved.aggmfinalextra))),
      Some(NamedParameter("aggfinalmodify", ParameterValue.from(unsaved.aggfinalmodify))),
      Some(NamedParameter("aggmfinalmodify", ParameterValue.from(unsaved.aggmfinalmodify))),
      Some(NamedParameter("aggsortop", ParameterValue.from(unsaved.aggsortop))),
      Some(NamedParameter("aggtranstype", ParameterValue.from(unsaved.aggtranstype))),
      Some(NamedParameter("aggtransspace", ParameterValue.from(unsaved.aggtransspace))),
      Some(NamedParameter("aggmtranstype", ParameterValue.from(unsaved.aggmtranstype))),
      Some(NamedParameter("aggmtransspace", ParameterValue.from(unsaved.aggmtransspace))),
      Some(NamedParameter("agginitval", ParameterValue.from(unsaved.agginitval))),
      Some(NamedParameter("aggminitval", ParameterValue.from(unsaved.aggminitval)))
    ).flatten

    SQL"""insert into pg_catalog.pg_aggregate(aggfnoid, ${namedParameters.map(_.name).mkString(", ")})
      values (${aggfnoid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(aggfnoid: PgAggregateId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_aggregate where aggfnoid = $aggfnoid""".executeUpdate() > 0
  }
}
