/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import anorm.Column
import anorm.MetaDataItem
import anorm.ParameterMetaData
import anorm.SqlRequestError
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.PreparedStatement
import java.sql.Types
import org.postgresql.geometric.PGcircle
import org.postgresql.jdbc.PgArray
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This represents circle datatype in PostgreSQL, consisting of a point and a radius */
case class TypoCircle(center: TypoPoint, radius: Double)
object TypoCircle {
  implicit val oFormat: OFormat[TypoCircle] = new OFormat[TypoCircle]{
    override def writes(o: TypoCircle): JsObject =
      Json.obj(
        "center" -> o.center,
        "radius" -> o.radius
      )
  
    override def reads(json: JsValue): JsResult[TypoCircle] = {
      JsResult.fromTry(
        Try(
          TypoCircle(
            center = json.\("center").as[TypoPoint],
            radius = json.\("radius").as[Double]
          )
        )
      )
    }
  }
  implicit val TypoCircleDb: ToStatement[TypoCircle] with ParameterMetaData[TypoCircle] with Column[TypoCircle] = new ToStatement[TypoCircle] with ParameterMetaData[TypoCircle] with Column[TypoCircle] {
    override def sqlType: String = "circle"
    override def jdbcType: Int = Types.OTHER
    override def set(s: PreparedStatement, index: Int, v: TypoCircle): Unit =
      s.setObject(index, new PGcircle(v.center.x, v.center.y, v.radius))
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, TypoCircle] =
      v match {
        case v: PGcircle => Right(TypoCircle(TypoPoint(v.center.x, v.center.y), v.radius))
        case other => Left(TypeDoesNotMatch(s"Expected instance of PGcircle from JDBC to produce a TypoCircle, got ${other.getClass.getName}"))
      }
  }
  
  implicit val TypoCircleDbArray: ToStatement[Array[TypoCircle]] with ParameterMetaData[Array[TypoCircle]] with Column[Array[TypoCircle]] = new ToStatement[Array[TypoCircle]] with ParameterMetaData[Array[TypoCircle]] with Column[Array[TypoCircle]] {
    override def sqlType: String = "_circle"
    override def jdbcType: Int = Types.ARRAY
    override def set(s: PreparedStatement, index: Int, v: Array[TypoCircle]): Unit =
      s.setArray(index, s.getConnection.createArrayOf("circle", v.map(v => new PGcircle(v.center.x, v.center.y, v.radius))))
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, Array[TypoCircle]] =
      v match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[_] =>
             Right(v.map(v => TypoCircle(TypoPoint(v.asInstanceOf[PGcircle].center.x, v.asInstanceOf[PGcircle].center.y), v.asInstanceOf[PGcircle].radius)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoCircle, got ${other.getClass.getName}"))
         }
        case other => Left(TypeDoesNotMatch(s"Expected PgArray from JDBC to produce an array of TypoCircle, got ${other.getClass.getName}"))
      }
  }

}
