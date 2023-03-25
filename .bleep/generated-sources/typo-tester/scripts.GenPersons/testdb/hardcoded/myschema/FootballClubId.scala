/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class FootballClubId(value: Long) extends AnyVal
object FootballClubId {
  implicit val ordering: Ordering[FootballClubId] = Ordering.by(_.value)
  implicit val format: Format[FootballClubId] = implicitly[Format[Long]].bimap(FootballClubId.apply, _.value)
  implicit val toStatement: ToStatement[FootballClubId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[FootballClubId] = implicitly[Column[Long]].map(FootballClubId.apply)
  def rowParser(prefix: String): RowParser[FootballClubId] = SqlParser.get[FootballClubId](prefix + "id")
}
