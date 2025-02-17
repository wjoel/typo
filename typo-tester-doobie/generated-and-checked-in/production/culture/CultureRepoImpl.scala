/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object CultureRepoImpl extends CultureRepo {
  override def delete(cultureid: CultureId): ConnectionIO[Boolean] = {
    sql"delete from production.culture where cultureid = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[CultureFields, CultureRow] = {
    DeleteBuilder("production.culture", CultureFields)
  }
  override def insert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    sql"""insert into production.culture(cultureid, "name", modifieddate)
          values (${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning cultureid, "name", modifieddate::text
       """.query(CultureRow.read).unique
  }
  override def insert(unsaved: CultureRowUnsaved): ConnectionIO[CultureRow] = {
    val fs = List(
      Some((Fragment.const(s"cultureid"), fr"${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar")),
      Some((Fragment.const(s""""name""""), fr"""${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name"""")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.culture default values
            returning cultureid, "name", modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.culture(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning cultureid, "name", modifieddate::text
         """
    }
    q.query(CultureRow.read).unique
    
  }
  override def select: SelectBuilder[CultureFields, CultureRow] = {
    SelectBuilderSql("production.culture", CultureFields, CultureRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CultureRow] = {
    sql"""select cultureid, "name", modifieddate::text from production.culture""".query(CultureRow.read).stream
  }
  override def selectById(cultureid: CultureId): ConnectionIO[Option[CultureRow]] = {
    sql"""select cultureid, "name", modifieddate::text from production.culture where cultureid = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}""".query(CultureRow.read).option
  }
  override def selectByIds(cultureids: Array[CultureId]): Stream[ConnectionIO, CultureRow] = {
    sql"""select cultureid, "name", modifieddate::text from production.culture where cultureid = ANY(${fromWrite(cultureids)(Write.fromPut(CultureId.arrayPut))})""".query(CultureRow.read).stream
  }
  override def update(row: CultureRow): ConnectionIO[Boolean] = {
    val cultureid = row.cultureid
    sql"""update production.culture
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::"public"."Name",
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where cultureid = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[CultureFields, CultureRow] = {
    UpdateBuilder("production.culture", CultureFields, CultureRow.read)
  }
  override def upsert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    sql"""insert into production.culture(cultureid, "name", modifieddate)
          values (
            ${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (cultureid)
          do update set
            "name" = EXCLUDED."name",
            modifieddate = EXCLUDED.modifieddate
          returning cultureid, "name", modifieddate::text
       """.query(CultureRow.read).unique
  }
}
