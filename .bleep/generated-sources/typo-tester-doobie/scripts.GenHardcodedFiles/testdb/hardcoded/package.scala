/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb

package object hardcoded {
  implicit val UuidType: doobie.Meta[java.util.UUID] = doobie.postgres.implicits.UuidType
  implicit val InetType: doobie.Meta[java.net.InetAddress] = doobie.postgres.implicits.InetType
  implicit val unliftedBooleanArrayType: doobie.Meta[Array[java.lang.Boolean]] = doobie.postgres.implicits.unliftedBooleanArrayType
  implicit val liftedBooleanArrayType: doobie.Meta[Array[Option[java.lang.Boolean]]] = doobie.postgres.implicits.liftedBooleanArrayType
  implicit val unliftedIntegerArrayType: doobie.Meta[Array[java.lang.Integer]] = doobie.postgres.implicits.unliftedIntegerArrayType
  implicit val liftedIntegerArrayType: doobie.Meta[Array[Option[java.lang.Integer]]] = doobie.postgres.implicits.liftedIntegerArrayType
  implicit val unliftedLongArrayType: doobie.Meta[Array[java.lang.Long]] = doobie.postgres.implicits.unliftedLongArrayType
  implicit val liftedLongArrayType: doobie.Meta[Array[Option[java.lang.Long]]] = doobie.postgres.implicits.liftedLongArrayType
  implicit val unliftedFloatArrayType: doobie.Meta[Array[java.lang.Float]] = doobie.postgres.implicits.unliftedFloatArrayType
  implicit val liftedFloatArrayType: doobie.Meta[Array[Option[java.lang.Float]]] = doobie.postgres.implicits.liftedFloatArrayType
  implicit val unliftedDoubleArrayType: doobie.Meta[Array[java.lang.Double]] = doobie.postgres.implicits.unliftedDoubleArrayType
  implicit val liftedDoubleArrayType: doobie.Meta[Array[Option[java.lang.Double]]] = doobie.postgres.implicits.liftedDoubleArrayType
  implicit val unliftedStringArrayType: doobie.Meta[Array[java.lang.String]] = doobie.postgres.implicits.unliftedStringArrayType
  implicit val liftedStringArrayType: doobie.Meta[Array[Option[java.lang.String]]] = doobie.postgres.implicits.liftedStringArrayType
  implicit val unliftedUUIDArrayType: doobie.Meta[Array[java.util.UUID]] = doobie.postgres.implicits.unliftedUUIDArrayType
  implicit val liftedUUIDArrayType: doobie.Meta[Array[Option[java.util.UUID]]] = doobie.postgres.implicits.liftedUUIDArrayType
  implicit val unliftedBigDecimalArrayType: doobie.Meta[Array[java.math.BigDecimal]] = doobie.postgres.implicits.unliftedBigDecimalArrayType
  implicit val iftedBigDecimalArrayType: doobie.Meta[Array[Option[java.math.BigDecimal]]] = doobie.postgres.implicits.iftedBigDecimalArrayType
  implicit val unliftedUnboxedBooleanArrayType: doobie.Meta[Array[scala.Boolean]] = doobie.postgres.implicits.unliftedUnboxedBooleanArrayType
  implicit val liftedUnboxedBooleanArrayType: doobie.Meta[Array[Option[scala.Boolean]]] = doobie.postgres.implicits.liftedUnboxedBooleanArrayType
  implicit val unliftedUnboxedIntegerArrayType: doobie.Meta[Array[scala.Int]] = doobie.postgres.implicits.unliftedUnboxedIntegerArrayType
  implicit val liftedUnboxedIntegerArrayType: doobie.Meta[Array[Option[scala.Int]]] = doobie.postgres.implicits.liftedUnboxedIntegerArrayType
  implicit val unliftedUnboxedLongArrayType: doobie.Meta[Array[scala.Long]] = doobie.postgres.implicits.unliftedUnboxedLongArrayType
  implicit val liftedUnboxedLongArrayType: doobie.Meta[Array[Option[scala.Long]]] = doobie.postgres.implicits.liftedUnboxedLongArrayType
  implicit val unliftedUnboxedFloatArrayType: doobie.Meta[Array[scala.Float]] = doobie.postgres.implicits.unliftedUnboxedFloatArrayType
  implicit val liftedUnboxedFloatArrayType: doobie.Meta[Array[Option[scala.Float]]] = doobie.postgres.implicits.liftedUnboxedFloatArrayType
  implicit val unliftedUnboxedDoubleArrayType: doobie.Meta[Array[scala.Double]] = doobie.postgres.implicits.unliftedUnboxedDoubleArrayType
  implicit val liftedUnboxedDoubleArrayType: doobie.Meta[Array[Option[scala.Double]]] = doobie.postgres.implicits.liftedUnboxedDoubleArrayType
  implicit val bigDecimalMeta: doobie.Meta[Array[BigDecimal]] = doobie.postgres.implicits.bigDecimalMeta
  implicit val optionBigDecimalMeta: doobie.Meta[Array[Option[BigDecimal]]] = doobie.postgres.implicits.optionBigDecimalMeta
  implicit val JavaTimeOffsetDateTimeMeta: doobie.Meta[java.time.OffsetDateTime] = doobie.postgres.implicits.JavaTimeOffsetDateTimeMeta
  implicit val JavaTimeInstantMeta: doobie.Meta[java.time.Instant] = doobie.postgres.implicits.JavaTimeInstantMeta
  implicit val JavaTimeZonedDateTimeMeta: doobie.Meta[java.time.ZonedDateTime] = doobie.postgres.implicits.JavaTimeZonedDateTimeMeta
  implicit val JavaTimeLocalDateTimeMeta: doobie.Meta[java.time.LocalDateTime] = doobie.postgres.implicits.JavaTimeLocalDateTimeMeta
  implicit val JavaTimeLocalDateMeta: doobie.Meta[java.time.LocalDate] = doobie.postgres.implicits.JavaTimeLocalDateMeta
  implicit val JavaTimeLocalTimeMeta: doobie.Meta[java.time.LocalTime] = doobie.postgres.implicits.JavaTimeLocalTimeMeta
}
