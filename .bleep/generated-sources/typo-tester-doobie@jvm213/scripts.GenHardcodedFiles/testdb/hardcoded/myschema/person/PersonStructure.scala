/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PersonStructure[Row](val prefix: Option[String], val extract: Row => PersonRow, val merge: (Row, PersonRow) => Row)
  extends Relation[PersonFields, PersonRow, Row]
    with PersonFields[Row] { outer =>

  override val id = new IdField[PersonId, Row](prefix, "id", None, Some("int8"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val favouriteFootballClubId = new Field[FootballClubId, Row](prefix, "favourite_football_club_id", None, None)(x => extract(x).favouriteFootballClubId, (row, value) => merge(row, extract(row).copy(favouriteFootballClubId = value)))
  override val name = new Field[/* max 100 chars */ String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val nickName = new OptField[/* max 30 chars */ String, Row](prefix, "nick_name", None, None)(x => extract(x).nickName, (row, value) => merge(row, extract(row).copy(nickName = value)))
  override val blogUrl = new OptField[/* max 100 chars */ String, Row](prefix, "blog_url", None, None)(x => extract(x).blogUrl, (row, value) => merge(row, extract(row).copy(blogUrl = value)))
  override val email = new Field[/* max 254 chars */ String, Row](prefix, "email", None, None)(x => extract(x).email, (row, value) => merge(row, extract(row).copy(email = value)))
  override val phone = new Field[/* max 8 chars */ String, Row](prefix, "phone", None, None)(x => extract(x).phone, (row, value) => merge(row, extract(row).copy(phone = value)))
  override val likesPizza = new Field[Boolean, Row](prefix, "likes_pizza", None, None)(x => extract(x).likesPizza, (row, value) => merge(row, extract(row).copy(likesPizza = value)))
  override val maritalStatusId = new Field[MaritalStatusId, Row](prefix, "marital_status_id", None, None)(x => extract(x).maritalStatusId, (row, value) => merge(row, extract(row).copy(maritalStatusId = value)))
  override val workEmail = new OptField[/* max 254 chars */ String, Row](prefix, "work_email", None, None)(x => extract(x).workEmail, (row, value) => merge(row, extract(row).copy(workEmail = value)))
  override val sector = new Field[Sector, Row](prefix, "sector", None, Some("myschema.sector"))(x => extract(x).sector, (row, value) => merge(row, extract(row).copy(sector = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, favouriteFootballClubId, name, nickName, blogUrl, email, phone, likesPizza, maritalStatusId, workEmail, sector)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PersonRow, merge: (NewRow, PersonRow) => NewRow): PersonStructure[NewRow] =
    new PersonStructure(prefix, extract, merge)
}
