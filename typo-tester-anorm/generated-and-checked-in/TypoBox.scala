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
import org.postgresql.geometric.PGbox
import org.postgresql.jdbc.PgArray
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This represents the box datatype in PostgreSQL */
case class TypoBox(x1: Double, y1: Double, x2: Double, y2: Double)
object TypoBox {
  implicit val oFormat: OFormat[TypoBox] = new OFormat[TypoBox]{
    override def writes(o: TypoBox): JsObject =
      Json.obj(
        "x1" -> o.x1,
        "y1" -> o.y1,
        "x2" -> o.x2,
        "y2" -> o.y2
      )
  
    override def reads(json: JsValue): JsResult[TypoBox] = {
      JsResult.fromTry(
        Try(
          TypoBox(
            x1 = json.\("x1").as[Double],
            y1 = json.\("y1").as[Double],
            x2 = json.\("x2").as[Double],
            y2 = json.\("y2").as[Double]
          )
        )
      )
    }
  }
  implicit val TypoBoxDb: ToStatement[TypoBox] with ParameterMetaData[TypoBox] with Column[TypoBox] = new ToStatement[TypoBox] with ParameterMetaData[TypoBox] with Column[TypoBox] {
    override def sqlType: String = "box"
    override def jdbcType: Int = Types.OTHER
    override def set(s: PreparedStatement, index: Int, v: TypoBox): Unit =
      s.setObject(index, new PGbox(v.x1, v.y1, v.x2, v.y2))
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, TypoBox] =
      v match {
        case v: PGbox => Right(TypoBox(v.point(0).x, v.point(0).y, v.point(1).x, v.point(1).y))
        case other => Left(TypeDoesNotMatch(s"Expected instance of PGbox from JDBC to produce a TypoBox, got ${other.getClass.getName}"))
      }
  }
  
  implicit val TypoBoxDbArray: ToStatement[Array[TypoBox]] with ParameterMetaData[Array[TypoBox]] with Column[Array[TypoBox]] = new ToStatement[Array[TypoBox]] with ParameterMetaData[Array[TypoBox]] with Column[Array[TypoBox]] {
    override def sqlType: String = "_box"
    override def jdbcType: Int = Types.ARRAY
    override def set(s: PreparedStatement, index: Int, v: Array[TypoBox]): Unit =
      s.setArray(index, s.getConnection.createArrayOf("box", v.map(v => new PGbox(v.x1, v.y1, v.x2, v.y2))))
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, Array[TypoBox]] =
      v match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[_] =>
             Right(v.map(v => TypoBox(v.asInstanceOf[PGbox].point(0).x, v.asInstanceOf[PGbox].point(0).y, v.asInstanceOf[PGbox].point(1).x, v.asInstanceOf[PGbox].point(1).y)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoBox, got ${other.getClass.getName}"))
         }
        case other => Left(TypeDoesNotMatch(s"Expected PgArray from JDBC to produce an array of TypoBox, got ${other.getClass.getName}"))
      }
  }

}
