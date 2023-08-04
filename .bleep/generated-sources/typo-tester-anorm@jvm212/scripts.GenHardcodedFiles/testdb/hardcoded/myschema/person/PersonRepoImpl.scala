/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import testdb.hardcoded.Defaulted
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PersonRepoImpl extends PersonRepo {
  override def delete(id: PersonId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.person where "id" = $id""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("myschema.person", PersonFields)
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into myschema.person("id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector)
          values (${unsaved.id}::int8, ${unsaved.favouriteFootballClubId}, ${unsaved.name}, ${unsaved.nickName}, ${unsaved.blogUrl}, ${unsaved.email}, ${unsaved.phone}, ${unsaved.likesPizza}, ${unsaved.maritalStatusId}, ${unsaved.workEmail}, ${unsaved.sector}::myschema.sector)
          returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
       """
      .executeInsert(PersonRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    val namedParameters = List(
      Some((NamedParameter("favourite_football_club_id", ParameterValue.from(unsaved.favouriteFootballClubId)), "")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), "")),
      Some((NamedParameter("nick_name", ParameterValue.from(unsaved.nickName)), "")),
      Some((NamedParameter("blog_url", ParameterValue.from(unsaved.blogUrl)), "")),
      Some((NamedParameter("email", ParameterValue.from(unsaved.email)), "")),
      Some((NamedParameter("phone", ParameterValue.from(unsaved.phone)), "")),
      Some((NamedParameter("likes_pizza", ParameterValue.from(unsaved.likesPizza)), "")),
      Some((NamedParameter("work_email", ParameterValue.from(unsaved.workEmail)), "")),
      unsaved.id match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("id", ParameterValue.from[PersonId](value)), "::int8"))
      },
      unsaved.maritalStatusId match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("marital_status_id", ParameterValue.from[MaritalStatusId](value)), ""))
      },
      unsaved.sector match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("sector", ParameterValue.from[Sector](value)), "::myschema.sector"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into myschema.person default values
            returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
         """
        .executeInsert(PersonRow.rowParser(1).single)
    } else {
      val q = s"""insert into myschema.person(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(PersonRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("myschema.person", PersonFields, PersonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    SQL"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
          from myschema.person
       """.as(PersonRow.rowParser(1).*)
  }
  override def selectById(id: PersonId)(implicit c: Connection): Option[PersonRow] = {
    SQL"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
          from myschema.person
          where "id" = $id
       """.as(PersonRow.rowParser(1).singleOpt)
  }
  override def selectByIds(ids: Array[PersonId])(implicit c: Connection): List[PersonRow] = {
    SQL"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
          from myschema.person
          where "id" = ANY($ids)
       """.as(PersonRow.rowParser(1).*)
    
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    val id = row.id
    SQL"""update myschema.person
          set favourite_football_club_id = ${row.favouriteFootballClubId},
              "name" = ${row.name},
              nick_name = ${row.nickName},
              blog_url = ${row.blogUrl},
              email = ${row.email},
              phone = ${row.phone},
              likes_pizza = ${row.likesPizza},
              marital_status_id = ${row.maritalStatusId},
              work_email = ${row.workEmail},
              sector = ${row.sector}::myschema.sector
          where "id" = $id
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("myschema.person", PersonFields, PersonRow.rowParser)
  }
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into myschema.person("id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector)
          values (
            ${unsaved.id}::int8,
            ${unsaved.favouriteFootballClubId},
            ${unsaved.name},
            ${unsaved.nickName},
            ${unsaved.blogUrl},
            ${unsaved.email},
            ${unsaved.phone},
            ${unsaved.likesPizza},
            ${unsaved.maritalStatusId},
            ${unsaved.workEmail},
            ${unsaved.sector}::myschema.sector
          )
          on conflict ("id")
          do update set
            favourite_football_club_id = EXCLUDED.favourite_football_club_id,
            "name" = EXCLUDED."name",
            nick_name = EXCLUDED.nick_name,
            blog_url = EXCLUDED.blog_url,
            email = EXCLUDED.email,
            phone = EXCLUDED.phone,
            likes_pizza = EXCLUDED.likes_pizza,
            marital_status_id = EXCLUDED.marital_status_id,
            work_email = EXCLUDED.work_email,
            sector = EXCLUDED.sector
          returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
       """
      .executeInsert(PersonRow.rowParser(1).single)
    
  }
}