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
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object IllustrationRepoImpl extends IllustrationRepo {
  override def delete(illustrationid: IllustrationId)(implicit c: Connection): Boolean = {
    SQL"delete from production.illustration where illustrationid = $illustrationid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[IllustrationFields, IllustrationRow] = {
    DeleteBuilder("production.illustration", IllustrationFields)
  }
  override def insert(unsaved: IllustrationRow)(implicit c: Connection): IllustrationRow = {
    SQL"""insert into production.illustration(illustrationid, diagram, modifieddate)
          values (${unsaved.illustrationid}::int4, ${unsaved.diagram}::xml, ${unsaved.modifieddate}::timestamp)
          returning illustrationid, diagram, modifieddate::text
       """
      .executeInsert(IllustrationRow.rowParser(1).single)
    
  }
  override def insert(unsaved: IllustrationRowUnsaved)(implicit c: Connection): IllustrationRow = {
    val namedParameters = List(
      Some((NamedParameter("diagram", ParameterValue.from(unsaved.diagram)), "::xml")),
      unsaved.illustrationid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("illustrationid", ParameterValue.from[IllustrationId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.illustration default values
            returning illustrationid, diagram, modifieddate::text
         """
        .executeInsert(IllustrationRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.illustration(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning illustrationid, diagram, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(IllustrationRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[IllustrationFields, IllustrationRow] = {
    SelectBuilderSql("production.illustration", IllustrationFields, IllustrationRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[IllustrationRow] = {
    SQL"""select illustrationid, diagram, modifieddate::text
          from production.illustration
       """.as(IllustrationRow.rowParser(1).*)
  }
  override def selectById(illustrationid: IllustrationId)(implicit c: Connection): Option[IllustrationRow] = {
    SQL"""select illustrationid, diagram, modifieddate::text
          from production.illustration
          where illustrationid = $illustrationid
       """.as(IllustrationRow.rowParser(1).singleOpt)
  }
  override def selectByIds(illustrationids: Array[IllustrationId])(implicit c: Connection): List[IllustrationRow] = {
    SQL"""select illustrationid, diagram, modifieddate::text
          from production.illustration
          where illustrationid = ANY($illustrationids)
       """.as(IllustrationRow.rowParser(1).*)
    
  }
  override def update(row: IllustrationRow)(implicit c: Connection): Boolean = {
    val illustrationid = row.illustrationid
    SQL"""update production.illustration
          set diagram = ${row.diagram}::xml,
              modifieddate = ${row.modifieddate}::timestamp
          where illustrationid = $illustrationid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[IllustrationFields, IllustrationRow] = {
    UpdateBuilder("production.illustration", IllustrationFields, IllustrationRow.rowParser)
  }
  override def upsert(unsaved: IllustrationRow)(implicit c: Connection): IllustrationRow = {
    SQL"""insert into production.illustration(illustrationid, diagram, modifieddate)
          values (
            ${unsaved.illustrationid}::int4,
            ${unsaved.diagram}::xml,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (illustrationid)
          do update set
            diagram = EXCLUDED.diagram,
            modifieddate = EXCLUDED.modifieddate
          returning illustrationid, diagram, modifieddate::text
       """
      .executeInsert(IllustrationRow.rowParser(1).single)
    
  }
}
