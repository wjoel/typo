/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet

object MaritalStatusRepoImpl extends MaritalStatusRepo {
  override def delete(id: MaritalStatusId): ConnectionIO[Boolean] = {
    sql"""delete from myschema.marital_status where "id" = $id""".update.run.map(_ > 0)
  }
  override def insert(unsaved: MaritalStatusRow): ConnectionIO[MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (${unsaved.id}::int8)
          returning "id"
       """.query.unique
  }
  override def selectAll: Stream[ConnectionIO, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status""".query[MaritalStatusRow].stream
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[_]]): Stream[ConnectionIO, MaritalStatusRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case MaritalStatusFieldValue.id(value) => fr""""id" = $value"""
      } :_*
    )
    sql"select * from myschema.marital_status $where".query[MaritalStatusRow].stream
  
  }
  override def selectById(id: MaritalStatusId): ConnectionIO[Option[MaritalStatusRow]] = {
    sql"""select "id" from myschema.marital_status where "id" = $id""".query[MaritalStatusRow].option
  }
  override def selectByIds(ids: Array[MaritalStatusId]): Stream[ConnectionIO, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status where "id" = ANY($ids)""".query[MaritalStatusRow].stream
  }
  override def upsert(unsaved: MaritalStatusRow): ConnectionIO[MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (
            ${unsaved.id}::int8
          )
          on conflict ("id")
          do update set
            
          returning "id"
       """.query.unique
  }
  implicit val read: Read[MaritalStatusRow] =
    new Read[MaritalStatusRow](
      gets = List(
        (Get[MaritalStatusId], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => MaritalStatusRow(
        id = Get[MaritalStatusId].unsafeGetNonNullable(rs, i + 0)
      )
    )
  

}
