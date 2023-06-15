/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import cats.data.NonEmptyList
import doobie.Get
import doobie.Put
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import org.postgresql.util.PGInterval

/** Interval type in PostgreSQL */
case class TypoInterval(years: Int, months: Int, days: Int, hours: Int, minutes: Int, seconds: Double)
object TypoInterval {
  implicit val decoder: Decoder[TypoInterval] =
    (c: HCursor) =>
      for {
        years <- c.downField("years").as[Int]
        months <- c.downField("months").as[Int]
        days <- c.downField("days").as[Int]
        hours <- c.downField("hours").as[Int]
        minutes <- c.downField("minutes").as[Int]
        seconds <- c.downField("seconds").as[Double]
      } yield TypoInterval(years, months, days, hours, minutes, seconds)
  implicit val encoder: Encoder[TypoInterval] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "years" := row.years,
        "months" := row.months,
        "days" := row.days,
        "hours" := row.hours,
        "minutes" := row.minutes,
        "seconds" := row.seconds
      )}
  implicit val TypoIntervalGet: Get[TypoInterval] =
    Get.Advanced.other[PGInterval](cats.data.NonEmptyList.one("interval"))
      .map(v => TypoInterval(v.getYears, v.getMonths, v.getDays, v.getHours, v.getMinutes, v.getSeconds))
  
  implicit val TypoIntervalPut: Put[TypoInterval] =
    Put.Advanced.other[PGInterval](NonEmptyList.one("interval"))
      .contramap(v => new PGInterval(v.years, v.months, v.days, v.hours, v.minutes, v.seconds))
  
  implicit val TypoIntervalGetArray: Get[Array[TypoInterval]] =
    Get.Advanced.array[AnyRef](NonEmptyList.one("_interval"))
      .map(_.map(v => TypoInterval(v.asInstanceOf[PGInterval].getYears, v.asInstanceOf[PGInterval].getMonths, v.asInstanceOf[PGInterval].getDays, v.asInstanceOf[PGInterval].getHours, v.asInstanceOf[PGInterval].getMinutes, v.asInstanceOf[PGInterval].getSeconds)))
  
  implicit val TypoIntervalPutArray: Put[Array[TypoInterval]] =
    Put.Advanced.array[AnyRef](NonEmptyList.one("_interval"), "interval")
      .contramap(_.map(v => new PGInterval(v.years, v.months, v.days, v.hours, v.minutes, v.seconds)))

}
