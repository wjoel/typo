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
import org.postgresql.jdbc.PgArray
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** Money and cash types in PostgreSQL */
case class TypoMoney(value: BigDecimal)
object TypoMoney {
  implicit val oFormat: OFormat[TypoMoney] = new OFormat[TypoMoney]{
    override def writes(o: TypoMoney): JsObject =
      Json.obj(
        "value" -> o.value
      )
  
    override def reads(json: JsValue): JsResult[TypoMoney] = {
      JsResult.fromTry(
        Try(
          TypoMoney(
            value = json.\("value").as[BigDecimal]
          )
        )
      )
    }
  }
  implicit val TypoMoneyDb: ToStatement[TypoMoney] with ParameterMetaData[TypoMoney] with Column[TypoMoney] = new ToStatement[TypoMoney] with ParameterMetaData[TypoMoney] with Column[TypoMoney] {
    override def sqlType: String = "money"
    override def jdbcType: Int = Types.OTHER
    override def set(s: PreparedStatement, index: Int, v: TypoMoney): Unit =
      s.setObject(index, v.value.bigDecimal)
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, TypoMoney] =
      v match {
        case v: java.math.BigDecimal => Right(TypoMoney(BigDecimal(v)))
        case other => Left(TypeDoesNotMatch(s"Expected instance of java.math.BigDecimal from JDBC to produce a TypoMoney, got ${other.getClass.getName}"))
      }
  }
  
  implicit val TypoMoneyDbArray: ToStatement[Array[TypoMoney]] with ParameterMetaData[Array[TypoMoney]] with Column[Array[TypoMoney]] = new ToStatement[Array[TypoMoney]] with ParameterMetaData[Array[TypoMoney]] with Column[Array[TypoMoney]] {
    override def sqlType: String = "_money"
    override def jdbcType: Int = Types.ARRAY
    override def set(s: PreparedStatement, index: Int, v: Array[TypoMoney]): Unit =
      s.setArray(index, s.getConnection.createArrayOf("money", v.map(v => v.value.bigDecimal)))
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, Array[TypoMoney]] =
      v match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[_] =>
             Right(v.map(v => TypoMoney(BigDecimal(v.asInstanceOf[java.math.BigDecimal]))))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoMoney, got ${other.getClass.getName}"))
         }
        case other => Left(TypeDoesNotMatch(s"Expected PgArray from JDBC to produce an array of TypoMoney, got ${other.getClass.getName}"))
      }
  }

}