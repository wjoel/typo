package typo
package internal

import typo.internal.codegen.*

class CustomTypes(pkg: sc.QIdent) {

  lazy val TypoBox = CustomType(
    comment = "This represents the box datatype in PostgreSQL",
    sqlType = "box",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoBox")),
    params = NonEmptyList(
      sc.Param(sc.Ident("x1"), sc.Type.Double, None),
      sc.Param(sc.Ident("y1"), sc.Type.Double, None),
      sc.Param(sc.Ident("x2"), sc.Type.Double, None),
      sc.Param(sc.Ident("y2"), sc.Type.Double, None)
    ),
    isNull = p => code"$p.isNull",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PGbox,
      toTypo = (expr, target) => code"$target($expr.point(0).x, $expr.point(0).y, $expr.point(1).x, $expr.point(1).y)"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.PGbox,
      fromTypo = (expr, target) => code"new $target($expr.x1, $expr.y1, $expr.x2, $expr.y2)"
    )
  )

  lazy val TypoLocalDate = CustomType(
    comment = "This is `java.time.LocalDate`, but transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken",
    sqlType = "date",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoLocalDate")),
    params = NonEmptyList(
      sc.Param(sc.Ident("value"), sc.Type.LocalDate, None)
    ),
    isNull = p => code"$p != null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.String,
      toTypo = (expr, target) => code"$target(${sc.Type.LocalDate}.parse($expr))"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.String,
      fromTypo = (expr, _) => code"$expr.value.toString"
    ),
    objBody = Some { target =>
      code"def now = $target(${sc.Type.LocalDate}.now)"
    }
  )
  lazy val TypoLocalTime = CustomType(
    comment = "This is `java.time.LocalTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken",
    sqlType = "time",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoLocalTime")),
    params = NonEmptyList(
      sc.Param(sc.Ident("value"), sc.Type.LocalTime, None)
    ),
    isNull = p => code"$p != null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.String,
      toTypo = (expr, target) => code"$target(${sc.Type.LocalTime}.parse($expr))"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.String,
      fromTypo = (expr, _) => code"$expr.value.toString"
    ),
    objBody = Some { target =>
      code"""|def apply(value: ${sc.Type.LocalTime}): $target = new $target(value.truncatedTo(${sc.Type.ChronoUnit}.MICROS))
             |def now = $target(${sc.Type.LocalTime}.now)""".stripMargin
    }
  )

  lazy val TypoLocalDateTime = CustomType(
    comment = "This is `java.time.LocalDateTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken",
    sqlType = "timestamp",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoLocalDateTime")),
    params = NonEmptyList(
      sc.Param(sc.Ident("value"), sc.Type.LocalDateTime, None)
    ),
    isNull = p => code"$p != null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.String,
      toTypo = (expr, target) => code"$target(${sc.Type.LocalDateTime}.parse($expr, parser))"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.String,
      fromTypo = (expr, _) => code"$expr.value.toString"
    ),
    objBody = Some { target =>
      code"""|val parser: ${sc.Type.DateTimeFormatter} =
             |  new ${sc.Type.DateTimeFormatterBuilder}().appendPattern("yyyy-MM-dd HH:mm:ss").appendFraction(${sc.Type.ChronoField}.MICRO_OF_SECOND, 0, 6, true).toFormatter
             |def apply(value: ${sc.Type.LocalDateTime}): $target = new $target(value.truncatedTo(${sc.Type.ChronoUnit}.MICROS))
             |def now = $target(${sc.Type.LocalDateTime}.now)
             |""".stripMargin
    }
  )
  lazy val TypoOffsetDateTime = CustomType(
    comment = "This is `java.time.OffsetDateTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken",
    sqlType = "timestamptz",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoOffsetDateTime")),
    params = NonEmptyList(
      sc.Param(sc.Ident("value"), sc.Type.OffsetDateTime, None)
    ),
    isNull = p => code"$p != null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.String,
      toTypo = (expr, target) => code"$target(${sc.Type.OffsetDateTime}.parse($expr, parser))"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.String,
      fromTypo = (expr, _) => code"$expr.value.toString"
    ),
    objBody = Some { target =>
      code"""|val parser: ${sc.Type.DateTimeFormatter} =
             |  new ${sc.Type.DateTimeFormatterBuilder}().appendPattern("yyyy-MM-dd HH:mm:ss").appendFraction(${sc.Type.ChronoField}.MICRO_OF_SECOND, 0, 6, true).appendPattern("X").toFormatter
             |def apply(value: ${sc.Type.OffsetDateTime}): $target = new $target(value.truncatedTo(${sc.Type.ChronoUnit}.MICROS))  
             |def now = $target(${sc.Type.OffsetDateTime}.now)
             |""".stripMargin
    }
  )

  lazy val TypoOffsetTime = CustomType(
    comment = "This is `java.time.OffsetTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken",
    sqlType = "timetz",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoOffsetTime")),
    params = NonEmptyList(
      sc.Param(sc.Ident("value"), sc.Type.OffsetTime, None)
    ),
    isNull = p => code"$p != null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.String,
      toTypo = (expr, target) => code"$target(${sc.Type.OffsetTime}.parse($expr, parser))"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.String,
      fromTypo = (expr, _) => code"$expr.value.toString"
    ),
    objBody = Some { target =>
      code"""|val parser: ${sc.Type.DateTimeFormatter} =
             |  new ${sc.Type.DateTimeFormatterBuilder}().appendPattern("HH:mm:ss").appendFraction(${sc.Type.ChronoField}.MICRO_OF_SECOND, 0, 6, true).appendPattern("X").toFormatter
             |def apply(value: ${sc.Type.OffsetTime}): $target = new $target(value.truncatedTo(${sc.Type.ChronoUnit}.MICROS))
             |def now = $target(${sc.Type.OffsetTime}.now)
             |""".stripMargin
    }
  )

  lazy val TypoCircle = CustomType(
    comment = "This represents circle datatype in PostgreSQL, consisting of a point and a radius",
    sqlType = "circle",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoCircle")),
    params = NonEmptyList(
      sc.Param(sc.Ident("center"), TypoPoint.typoType, None),
      sc.Param(sc.Ident("radius"), sc.Type.Double, None)
    ),
    isNull = p => code"$p.center == null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PGcircle,
      toTypo = (expr, target) => code"$target(TypoPoint($expr.center.x, $expr.center.y), $expr.radius)"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.PGcircle,
      fromTypo = (expr, target) => code"new $target($expr.center.x, $expr.center.y, $expr.radius)"
    )
  )

  lazy val TypoLine = CustomType(
    comment = "This implements a line represented by the linear equation Ax + By + C = 0",
    sqlType = "line",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoLine")),
    params = NonEmptyList(
      sc.Param(sc.Ident("a"), sc.Type.Double, None),
      sc.Param(sc.Ident("b"), sc.Type.Double, None),
      sc.Param(sc.Ident("c"), sc.Type.Double, None)
    ),
    isNull = p => code"$p.isNull",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PGline,
      toTypo = (expr, target) => code"$target($expr.a, $expr.b, $expr.c)"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.PGline,
      fromTypo = (expr, target) => code"new $target($expr.a, $expr.b, $expr.c)"
    )
  )

  lazy val TypoLineSegment = CustomType(
    comment = "This implements a line represented by the linear equation Ax + By + C = 0",
    sqlType = "lseg",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoLineSegment")),
    params = NonEmptyList(
      sc.Param(sc.Ident("p1"), TypoPoint.typoType, None),
      sc.Param(sc.Ident("p2"), TypoPoint.typoType, None)
    ),
    isNull = p => code"$p.point == null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PGlseg,
      toTypo = (expr, target) => code"$target(${TypoPoint.toTypo0(code"$expr.point(0)")}, ${TypoPoint.toTypo0(code"$expr.point(1)")})"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.PGlseg,
      fromTypo = (expr, target) => code"new $target(${TypoPoint.fromTypo0(code"$expr.p1")}, ${TypoPoint.fromTypo0(code"$expr.p2")})"
    )
  )

  lazy val TypoPath = CustomType(
    comment = "This implements a path (a multiple segmented line, which may be closed)",
    sqlType = "path",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoPath")),
    params = NonEmptyList(
      sc.Param(sc.Ident("open"), sc.Type.Boolean, None),
      sc.Param(sc.Ident("points"), sc.Type.List.of(TypoPoint.typoType), None)
    ),
    isNull = p => code"$p.points == null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PGpath,
      toTypo = (expr, target) => code"$target($expr.isOpen, $expr.points.map(p => ${TypoPoint.typoType}(p.x, p.y)).toList)"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.PGpath,
      fromTypo = (expr, target) => code"new $target($expr.points.map(p => new ${sc.Type.PGpoint}(p.x, p.y)).toArray, $expr.open)"
    )
  )

  lazy val TypoPoint = CustomType(
    comment = "Point datatype in PostgreSQL",
    sqlType = "point",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoPoint")),
    params = NonEmptyList(
      sc.Param(sc.Ident("x"), sc.Type.Double, None),
      sc.Param(sc.Ident("y"), sc.Type.Double, None)
    ),
    isNull = p => code"$p.isNull",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PGpoint,
      toTypo = (expr, target) => code"$target($expr.x, $expr.y)"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.PGpoint,
      fromTypo = (expr, target) => code"new $target($expr.x, $expr.y)"
    )
  )

  lazy val TypoPolygon = CustomType(
    comment = "Polygon datatype in PostgreSQL",
    sqlType = "polygon",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoPolygon")),
    params = NonEmptyList(
      sc.Param(sc.Ident("points"), sc.Type.List.of(TypoPoint.typoType), None)
    ),
    isNull = p => code"$p.points == null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PGpolygon,
      toTypo = (expr, target) => code"$target($expr.points.map(p => ${TypoPoint.typoType}(p.x, p.y)).toList)"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.PGpolygon,
      fromTypo = (expr, target) => code"new $target($expr.points.map(p => new ${sc.Type.PGpoint}(p.x, p.y)).toArray)"
    )
  )

  lazy val TypoInterval = CustomType(
    comment = "Interval type in PostgreSQL",
    sqlType = "interval",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoInterval")),
    params = NonEmptyList(
      sc.Param(sc.Ident("years"), sc.Type.Int, None),
      sc.Param(sc.Ident("months"), sc.Type.Int, None),
      sc.Param(sc.Ident("days"), sc.Type.Int, None),
      sc.Param(sc.Ident("hours"), sc.Type.Int, None),
      sc.Param(sc.Ident("minutes"), sc.Type.Int, None),
      sc.Param(sc.Ident("seconds"), sc.Type.Double, None)
    ),
    isNull = p => code"$p.isNull",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PGInterval,
      toTypo = (expr, target) => code"$target($expr.getYears, $expr.getMonths, $expr.getDays, $expr.getHours, $expr.getMinutes, $expr.getSeconds)"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.PGInterval,
      fromTypo = (expr, target) => code"new $target($expr.years, $expr.months, $expr.days, $expr.hours, $expr.minutes, $expr.seconds)"
    )
  )

  lazy val TypoHStore = CustomType(
    comment = "The text representation of an hstore, used for input and output, includes zero or more key => value pairs separated by commas",
    sqlType = "hstore",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoHStore")),
    params = NonEmptyList(
      sc.Param(sc.Ident("value"), sc.Type.Map.of(sc.Type.String, sc.Type.String), None)
    ),
    isNull = p => code"$p == null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.JavaMap.of(sc.Type.Wildcard, sc.Type.Wildcard),
      toTypo = (expr, target) => {
        code"""|{
               |  val b = ${sc.Type.Map}.newBuilder[${sc.Type.String}, ${sc.Type.String}]
               |  $expr.forEach { case (k, v) => b += k.asInstanceOf[${sc.Type.String}] -> v.asInstanceOf[${sc.Type.String}]}
               |  $target(b.result())
               |}""".stripMargin
      }
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.JavaMap.of(sc.Type.String, sc.Type.String),
      fromTypo = (expr, _) => {
        code"""|{
               |  val b = new ${sc.Type.JavaHashMap}[${sc.Type.String}, ${sc.Type.String}]
               |  $expr.value.foreach { case (k, v) => b.put(k, v)}
               |  b
               |}""".stripMargin
      }
    )
  )

  lazy val TypoMoney = CustomType(
    comment = "Money and cash types in PostgreSQL",
    sqlType = "money",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoMoney")),
    params = NonEmptyList(
      sc.Param(sc.Ident("value"), sc.Type.BigDecimal, None)
    ),
    isNull = p => code"$p.isNull",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.JavaBigDecimal,
      toTypo = (expr, target) => code"$target(${sc.Type.BigDecimal}($expr))"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.JavaBigDecimal,
      fromTypo = (expr, _) => code"$expr.value.bigDecimal"
    )
  )

  lazy val TypoXml = CustomType(
    comment = "XML",
    sqlType = "xml",
    typoType = sc.Type.Qualified(pkg / sc.Ident("TypoXml")),
    params = NonEmptyList(
      sc.Param(sc.Ident("value"), sc.Type.String, None)
    ),
    isNull = p => code"$p.getString == null",
    toTypo = CustomType.ToTypo(
      jdbcType = sc.Type.PgSQLXML,
      toTypo = (expr, target) => code"$target($expr.getString)"
    ),
    fromTypo = CustomType.FromTypo(
      jdbcType = sc.Type.String,
      fromTypo = (expr, _) => code"$expr.value"
    ),
    fromTypoInArray = Some(
      CustomType.FromTypo(
        jdbcType = sc.Type.PGobject,
        fromTypo = (expr, target) => {
          code"""|{
                 |  val obj = new $target
                 |  obj.setType("xml")
                 |  obj.setValue($expr.value)
                 |  obj
                 |}""".stripMargin
        }
      )
    ),
    toTypoInArray = Some(
      CustomType.ToTypo(
        jdbcType = sc.Type.PGobject,
        toTypo = (expr, target) => code"$target($expr.getValue)"
      )
    )
  )

  def obj(sqlType: String, name: String): CustomType =
    CustomType(
      comment = s"$sqlType (via PGObject)",
      sqlType = sqlType,
      typoType = sc.Type.Qualified(pkg / sc.Ident(name)),
      params = NonEmptyList(
        sc.Param(sc.Ident("value"), sc.Type.String, None)
      ),
      isNull = p => code"$p.getValue == null",
      toTypo = CustomType.ToTypo(
        jdbcType = sc.Type.PGobject,
        toTypo = (expr, target) => code"$target($expr.getValue)"
      ),
      fromTypo = CustomType.FromTypo(
        jdbcType = sc.Type.PGobject,
        fromTypo = (expr, target) => code"""|{
                 |  val obj = new $target
                 |  obj.setType(${sc.StrLit(sqlType)})
                 |  obj.setValue($expr.value)
                 |  obj
                 |}""".stripMargin
      ),
      toTypoInArray = Some(
        CustomType.ToTypo(
          jdbcType = sc.Type.String,
          toTypo = (expr, target) => code"$target($expr)"
        )
      )
    )
  lazy val TypoJson = obj("json", "TypoJson")
  lazy val TypoJsonb = obj("jsonb", "TypoJsonb")
  lazy val TypoInet = obj("inet", "TypoInet").copy(toTypoInArray = None)
  lazy val TypoAclItem = obj("aclitem", "TypoAclItem")
  lazy val TypoAnyArray = obj("anyarray", "TypoAnyArray")
  lazy val TypoInt2Vector = obj("int2vector", "TypoInt2Vector")
  lazy val TypoOidVector = obj("oidvector", "TypoOidVector")
  lazy val TypoPgNodeTree = obj("pg_node_tree", "TypoPgNodeTree")
  lazy val TypoRegclass = obj("regclass", "TypoRegclass")
  lazy val TypoRegconfig = obj("regconfig", "TypoRegconfig")
  lazy val TypoRegdictionary = obj("regdictionary", "TypoRegdictionary")
  lazy val TypoRegnamespace = obj("regnamespace", "TypoRegnamespace")
  lazy val TypoRegoper = obj("regoper", "TypoRegoper")
  lazy val TypoRegoperator = obj("regoperator", "TypoRegoperator")
  lazy val TypoRegproc = obj("regproc", "TypoRegproc")
  lazy val TypoRegprocedure = obj("regprocedure", "TypoRegprocedure")
  lazy val TypoRegrole = obj("regrole", "TypoRegrole")
  lazy val TypoRegtype = obj("regtype", "TypoRegtype")
  lazy val TypoXid = obj("xid", "TypoXid")

  val All: List[CustomType] =
    List(
      TypoAclItem,
      TypoAnyArray,
      TypoBox,
      TypoCircle,
      TypoHStore,
      TypoInet,
      TypoInet,
      TypoInt2Vector,
      TypoInterval,
      TypoJson,
      TypoJson,
      TypoJsonb,
      TypoJsonb,
      TypoLine,
      TypoLineSegment,
      TypoLocalDate,
      TypoLocalDateTime,
      TypoLocalTime,
      TypoMoney,
      TypoOffsetDateTime,
      TypoOffsetTime,
      TypoOidVector,
      TypoPath,
      TypoPgNodeTree,
      TypoPoint,
      TypoPolygon,
      TypoRegclass,
      TypoRegconfig,
      TypoRegdictionary,
      TypoRegnamespace,
      TypoRegoper,
      TypoRegoperator,
      TypoRegproc,
      TypoRegprocedure,
      TypoRegrole,
      TypoRegtype,
      TypoXid,
      TypoXml
    )
}
