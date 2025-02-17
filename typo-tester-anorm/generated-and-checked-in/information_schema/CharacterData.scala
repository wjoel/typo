/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `information_schema.character_data`
  * No constraint
  */
case class CharacterData(value: String) extends AnyVal
object CharacterData {
  implicit lazy val arrayColumn: Column[Array[CharacterData]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[CharacterData]] = implicitly[ToStatement[Array[String]]].contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CharacterData, String] = Bijection[CharacterData, String](_.value)(CharacterData.apply)
  implicit lazy val column: Column[CharacterData] = implicitly[Column[String]].map(CharacterData.apply)
  implicit lazy val ordering: Ordering[CharacterData] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[CharacterData] = new ParameterMetaData[CharacterData] {
    override def sqlType: String = implicitly[ParameterMetaData[String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[String]].jdbcType
  }
  implicit lazy val reads: Reads[CharacterData] = Reads.StringReads.map(CharacterData.apply)
  implicit lazy val toStatement: ToStatement[CharacterData] = implicitly[ToStatement[String]].contramap(_.value)
  implicit lazy val writes: Writes[CharacterData] = Writes.StringWrites.contramap(_.value)
}
