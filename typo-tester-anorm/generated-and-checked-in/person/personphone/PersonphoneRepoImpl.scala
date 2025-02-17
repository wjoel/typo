/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

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

object PersonphoneRepoImpl extends PersonphoneRepo {
  override def delete(compositeId: PersonphoneId)(implicit c: Connection): Boolean = {
    SQL"delete from person.personphone where businessentityid = ${compositeId.businessentityid} AND phonenumber = ${compositeId.phonenumber} AND phonenumbertypeid = ${compositeId.phonenumbertypeid}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PersonphoneFields, PersonphoneRow] = {
    DeleteBuilder("person.personphone", PersonphoneFields)
  }
  override def insert(unsaved: PersonphoneRow)(implicit c: Connection): PersonphoneRow = {
    SQL"""insert into person.personphone(businessentityid, phonenumber, phonenumbertypeid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.phonenumber}::"public".Phone, ${unsaved.phonenumbertypeid}::int4, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, phonenumber, phonenumbertypeid, modifieddate::text
       """
      .executeInsert(PersonphoneRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PersonphoneRowUnsaved)(implicit c: Connection): PersonphoneRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("phonenumber", ParameterValue.from(unsaved.phonenumber)), """::"public".Phone""")),
      Some((NamedParameter("phonenumbertypeid", ParameterValue.from(unsaved.phonenumbertypeid)), "::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.personphone default values
            returning businessentityid, phonenumber, phonenumbertypeid, modifieddate::text
         """
        .executeInsert(PersonphoneRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.personphone(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, phonenumber, phonenumbertypeid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(PersonphoneRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[PersonphoneFields, PersonphoneRow] = {
    SelectBuilderSql("person.personphone", PersonphoneFields, PersonphoneRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PersonphoneRow] = {
    SQL"""select businessentityid, phonenumber, phonenumbertypeid, modifieddate::text
          from person.personphone
       """.as(PersonphoneRow.rowParser(1).*)
  }
  override def selectById(compositeId: PersonphoneId)(implicit c: Connection): Option[PersonphoneRow] = {
    SQL"""select businessentityid, phonenumber, phonenumbertypeid, modifieddate::text
          from person.personphone
          where businessentityid = ${compositeId.businessentityid} AND phonenumber = ${compositeId.phonenumber} AND phonenumbertypeid = ${compositeId.phonenumbertypeid}
       """.as(PersonphoneRow.rowParser(1).singleOpt)
  }
  override def update(row: PersonphoneRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update person.personphone
          set modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND phonenumber = ${compositeId.phonenumber} AND phonenumbertypeid = ${compositeId.phonenumbertypeid}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PersonphoneFields, PersonphoneRow] = {
    UpdateBuilder("person.personphone", PersonphoneFields, PersonphoneRow.rowParser)
  }
  override def upsert(unsaved: PersonphoneRow)(implicit c: Connection): PersonphoneRow = {
    SQL"""insert into person.personphone(businessentityid, phonenumber, phonenumbertypeid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.phonenumber}::"public".Phone,
            ${unsaved.phonenumbertypeid}::int4,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, phonenumber, phonenumbertypeid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, phonenumber, phonenumbertypeid, modifieddate::text
       """
      .executeInsert(PersonphoneRow.rowParser(1).single)
    
  }
}
