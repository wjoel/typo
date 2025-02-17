/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** This is `java.time.LocalDateTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoLocalDateTime(value: LocalDateTime)

object TypoLocalDateTime {
  val parser: DateTimeFormatter =
    new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true).toFormatter
  def apply(value: LocalDateTime): TypoLocalDateTime = new TypoLocalDateTime(value.truncatedTo(ChronoUnit.MICROS))
  def now = TypoLocalDateTime(LocalDateTime.now)
  implicit lazy val arrayColumn: Column[Array[TypoLocalDateTime]] = Column.nonNull[Array[TypoLocalDateTime]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoLocalDateTime(LocalDateTime.parse(v.asInstanceOf[String], parser))))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoLocalDateTime, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayParameterMetaData: ParameterMetaData[Array[TypoLocalDateTime]] = new ParameterMetaData[Array[TypoLocalDateTime]] {
    override def sqlType: String = "_timestamp"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit lazy val arrayToStatement: ToStatement[Array[TypoLocalDateTime]] = ToStatement[Array[TypoLocalDateTime]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("timestamp", v.map(v => v.value.toString))))
  implicit lazy val bijection: Bijection[TypoLocalDateTime, LocalDateTime] = Bijection[TypoLocalDateTime, LocalDateTime](_.value)(TypoLocalDateTime.apply)
  implicit lazy val column: Column[TypoLocalDateTime] = Column.nonNull[TypoLocalDateTime]((v1: Any, _) =>
    v1 match {
      case v: String => Right(TypoLocalDateTime(LocalDateTime.parse(v, parser)))
      case other => Left(TypeDoesNotMatch(s"Expected instance of java.lang.String, got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[LocalDateTime]): Ordering[TypoLocalDateTime] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoLocalDateTime] = new ParameterMetaData[TypoLocalDateTime] {
    override def sqlType: String = "timestamp"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoLocalDateTime] = Reads.DefaultLocalDateTimeReads.map(TypoLocalDateTime.apply)
  implicit lazy val toStatement: ToStatement[TypoLocalDateTime] = ToStatement[TypoLocalDateTime]((s, index, v) => s.setObject(index, v.value.toString))
  implicit lazy val writes: Writes[TypoLocalDateTime] = Writes.DefaultLocalDateTimeWrites.contramap(_.value)
}
