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
import org.postgresql.geometric.PGcircle
import org.postgresql.jdbc.PgArray
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This represents circle datatype in PostgreSQL, consisting of a point and a radius */
case class TypoCircle(center: TypoPoint, radius: Double)

object TypoCircle {
  implicit lazy val arrayColumn: Column[Array[TypoCircle]] = Column.nonNull[Array[TypoCircle]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoCircle(TypoPoint(v.asInstanceOf[PGcircle].center.x, v.asInstanceOf[PGcircle].center.y), v.asInstanceOf[PGcircle].radius)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoCircle, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayParameterMetaData: ParameterMetaData[Array[TypoCircle]] = new ParameterMetaData[Array[TypoCircle]] {
    override def sqlType: String = "_circle"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit lazy val arrayToStatement: ToStatement[Array[TypoCircle]] = ToStatement[Array[TypoCircle]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("circle", v.map(v => new PGcircle(v.center.x, v.center.y, v.radius)))))
  implicit lazy val column: Column[TypoCircle] = Column.nonNull[TypoCircle]((v1: Any, _) =>
    v1 match {
      case v: PGcircle => Right(TypoCircle(TypoPoint(v.center.x, v.center.y), v.radius))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.geometric.PGcircle, got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[TypoPoint]): Ordering[TypoCircle] = Ordering.by(x => (x.center, x.radius))
  implicit lazy val parameterMetadata: ParameterMetaData[TypoCircle] = new ParameterMetaData[TypoCircle] {
    override def sqlType: String = "circle"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoCircle] = Reads[TypoCircle](json => JsResult.fromTry(
      Try(
        TypoCircle(
          center = json.\("center").as(TypoPoint.reads),
          radius = json.\("radius").as(Reads.DoubleReads)
        )
      )
    ),
  )
  implicit lazy val toStatement: ToStatement[TypoCircle] = ToStatement[TypoCircle]((s, index, v) => s.setObject(index, new PGcircle(v.center.x, v.center.y, v.radius)))
  implicit lazy val writes: OWrites[TypoCircle] = OWrites[TypoCircle](o =>
    new JsObject(ListMap[String, JsValue](
      "center" -> TypoPoint.writes.writes(o.center),
      "radius" -> Writes.DoubleWrites.writes(o.radius)
    ))
  )
}
