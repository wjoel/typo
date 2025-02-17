/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
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

object IllustrationRepoImpl extends IllustrationRepo {
  override def delete(illustrationid: IllustrationId): ConnectionIO[Boolean] = {
    sql"delete from production.illustration where illustrationid = ${fromWrite(illustrationid)(Write.fromPut(IllustrationId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[IllustrationFields, IllustrationRow] = {
    DeleteBuilder("production.illustration", IllustrationFields)
  }
  override def insert(unsaved: IllustrationRow): ConnectionIO[IllustrationRow] = {
    sql"""insert into production.illustration(illustrationid, diagram, modifieddate)
          values (${fromWrite(unsaved.illustrationid)(Write.fromPut(IllustrationId.put))}::int4, ${fromWrite(unsaved.diagram)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning illustrationid, diagram, modifieddate::text
       """.query(IllustrationRow.read).unique
  }
  override def insert(unsaved: IllustrationRowUnsaved): ConnectionIO[IllustrationRow] = {
    val fs = List(
      Some((Fragment.const(s"diagram"), fr"${fromWrite(unsaved.diagram)(Write.fromPutOption(TypoXml.put))}::xml")),
      unsaved.illustrationid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"illustrationid"), fr"${fromWrite(value: IllustrationId)(Write.fromPut(IllustrationId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.illustration default values
            returning illustrationid, diagram, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.illustration(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning illustrationid, diagram, modifieddate::text
         """
    }
    q.query(IllustrationRow.read).unique
    
  }
  override def select: SelectBuilder[IllustrationFields, IllustrationRow] = {
    SelectBuilderSql("production.illustration", IllustrationFields, IllustrationRow.read)
  }
  override def selectAll: Stream[ConnectionIO, IllustrationRow] = {
    sql"select illustrationid, diagram, modifieddate::text from production.illustration".query(IllustrationRow.read).stream
  }
  override def selectById(illustrationid: IllustrationId): ConnectionIO[Option[IllustrationRow]] = {
    sql"select illustrationid, diagram, modifieddate::text from production.illustration where illustrationid = ${fromWrite(illustrationid)(Write.fromPut(IllustrationId.put))}".query(IllustrationRow.read).option
  }
  override def selectByIds(illustrationids: Array[IllustrationId]): Stream[ConnectionIO, IllustrationRow] = {
    sql"select illustrationid, diagram, modifieddate::text from production.illustration where illustrationid = ANY(${fromWrite(illustrationids)(Write.fromPut(IllustrationId.arrayPut))})".query(IllustrationRow.read).stream
  }
  override def update(row: IllustrationRow): ConnectionIO[Boolean] = {
    val illustrationid = row.illustrationid
    sql"""update production.illustration
          set diagram = ${fromWrite(row.diagram)(Write.fromPutOption(TypoXml.put))}::xml,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where illustrationid = ${fromWrite(illustrationid)(Write.fromPut(IllustrationId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[IllustrationFields, IllustrationRow] = {
    UpdateBuilder("production.illustration", IllustrationFields, IllustrationRow.read)
  }
  override def upsert(unsaved: IllustrationRow): ConnectionIO[IllustrationRow] = {
    sql"""insert into production.illustration(illustrationid, diagram, modifieddate)
          values (
            ${fromWrite(unsaved.illustrationid)(Write.fromPut(IllustrationId.put))}::int4,
            ${fromWrite(unsaved.diagram)(Write.fromPutOption(TypoXml.put))}::xml,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (illustrationid)
          do update set
            diagram = EXCLUDED.diagram,
            modifieddate = EXCLUDED.modifieddate
          returning illustrationid, diagram, modifieddate::text
       """.query(IllustrationRow.read).unique
  }
}
