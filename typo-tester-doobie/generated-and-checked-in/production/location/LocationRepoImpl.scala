/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object LocationRepoImpl extends LocationRepo {
  override def delete(locationid: LocationId): ConnectionIO[Boolean] = {
    sql"""delete from production."location" where locationid = ${fromWrite(locationid)(Write.fromPut(LocationId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[LocationFields, LocationRow] = {
    DeleteBuilder("production.location", LocationFields)
  }
  override def insert(unsaved: LocationRow): ConnectionIO[LocationRow] = {
    sql"""insert into production."location"(locationid, "name", costrate, availability, modifieddate)
          values (${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.costrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.availability)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning locationid, "name", costrate, availability, modifieddate::text
       """.query(LocationRow.read).unique
  }
  override def insert(unsaved: LocationRowUnsaved): ConnectionIO[LocationRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name"""")),
      unsaved.locationid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"locationid"), fr"${fromWrite(value: LocationId)(Write.fromPut(LocationId.put))}::int4"))
      },
      unsaved.costrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"costrate"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.availability match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"availability"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production."location" default values
            returning locationid, "name", costrate, availability, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production."location"(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning locationid, "name", costrate, availability, modifieddate::text
         """
    }
    q.query(LocationRow.read).unique
    
  }
  override def select: SelectBuilder[LocationFields, LocationRow] = {
    SelectBuilderSql("production.location", LocationFields, LocationRow.read)
  }
  override def selectAll: Stream[ConnectionIO, LocationRow] = {
    sql"""select locationid, "name", costrate, availability, modifieddate::text from production."location"""".query(LocationRow.read).stream
  }
  override def selectById(locationid: LocationId): ConnectionIO[Option[LocationRow]] = {
    sql"""select locationid, "name", costrate, availability, modifieddate::text from production."location" where locationid = ${fromWrite(locationid)(Write.fromPut(LocationId.put))}""".query(LocationRow.read).option
  }
  override def selectByIds(locationids: Array[LocationId]): Stream[ConnectionIO, LocationRow] = {
    sql"""select locationid, "name", costrate, availability, modifieddate::text from production."location" where locationid = ANY(${fromWrite(locationids)(Write.fromPut(LocationId.arrayPut))})""".query(LocationRow.read).stream
  }
  override def update(row: LocationRow): ConnectionIO[Boolean] = {
    val locationid = row.locationid
    sql"""update production."location"
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::"public"."Name",
              costrate = ${fromWrite(row.costrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              availability = ${fromWrite(row.availability)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where locationid = ${fromWrite(locationid)(Write.fromPut(LocationId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[LocationFields, LocationRow] = {
    UpdateBuilder("production.location", LocationFields, LocationRow.read)
  }
  override def upsert(unsaved: LocationRow): ConnectionIO[LocationRow] = {
    sql"""insert into production."location"(locationid, "name", costrate, availability, modifieddate)
          values (
            ${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.costrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.availability)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (locationid)
          do update set
            "name" = EXCLUDED."name",
            costrate = EXCLUDED.costrate,
            availability = EXCLUDED.availability,
            modifieddate = EXCLUDED.modifieddate
          returning locationid, "name", costrate, availability, modifieddate::text
       """.query(LocationRow.read).unique
  }
}
