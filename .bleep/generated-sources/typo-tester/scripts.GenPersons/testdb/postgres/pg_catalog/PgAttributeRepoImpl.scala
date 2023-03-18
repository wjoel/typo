package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgAttributeRepoImpl extends PgAttributeRepo {
  override def selectAll(implicit c: Connection): List[PgAttributeRow] = {
    SQL"""select attrelid, attname, atttypid, attstattarget, attlen, attnum, attndims, attcacheoff, atttypmod, attbyval, attalign, attstorage, attcompression, attnotnull, atthasdef, atthasmissing, attidentity, attgenerated, attisdropped, attislocal, attinhcount, attcollation, attacl, attoptions, attfdwoptions, attmissingval from pg_catalog.pg_attribute""".as(PgAttributeRow.rowParser.*)
  }
  override def selectById(attrelidAndAttnum: PgAttributeId)(implicit c: Connection): Option[PgAttributeRow] = {
    SQL"""select attrelid, attname, atttypid, attstattarget, attlen, attnum, attndims, attcacheoff, atttypmod, attbyval, attalign, attstorage, attcompression, attnotnull, atthasdef, atthasmissing, attidentity, attgenerated, attisdropped, attislocal, attinhcount, attcollation, attacl, attoptions, attfdwoptions, attmissingval from pg_catalog.pg_attribute where attrelid = ${attrelidAndAttnum.attrelid}, attnum = ${attrelidAndAttnum.attnum}""".as(PgAttributeRow.rowParser.singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgAttributeFieldValue[_]])(implicit c: Connection): List[PgAttributeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAttributeFieldValue.attrelid(value) => NamedParameter("attrelid", ParameterValue.from(value))
          case PgAttributeFieldValue.attname(value) => NamedParameter("attname", ParameterValue.from(value))
          case PgAttributeFieldValue.atttypid(value) => NamedParameter("atttypid", ParameterValue.from(value))
          case PgAttributeFieldValue.attstattarget(value) => NamedParameter("attstattarget", ParameterValue.from(value))
          case PgAttributeFieldValue.attlen(value) => NamedParameter("attlen", ParameterValue.from(value))
          case PgAttributeFieldValue.attnum(value) => NamedParameter("attnum", ParameterValue.from(value))
          case PgAttributeFieldValue.attndims(value) => NamedParameter("attndims", ParameterValue.from(value))
          case PgAttributeFieldValue.attcacheoff(value) => NamedParameter("attcacheoff", ParameterValue.from(value))
          case PgAttributeFieldValue.atttypmod(value) => NamedParameter("atttypmod", ParameterValue.from(value))
          case PgAttributeFieldValue.attbyval(value) => NamedParameter("attbyval", ParameterValue.from(value))
          case PgAttributeFieldValue.attalign(value) => NamedParameter("attalign", ParameterValue.from(value))
          case PgAttributeFieldValue.attstorage(value) => NamedParameter("attstorage", ParameterValue.from(value))
          case PgAttributeFieldValue.attcompression(value) => NamedParameter("attcompression", ParameterValue.from(value))
          case PgAttributeFieldValue.attnotnull(value) => NamedParameter("attnotnull", ParameterValue.from(value))
          case PgAttributeFieldValue.atthasdef(value) => NamedParameter("atthasdef", ParameterValue.from(value))
          case PgAttributeFieldValue.atthasmissing(value) => NamedParameter("atthasmissing", ParameterValue.from(value))
          case PgAttributeFieldValue.attidentity(value) => NamedParameter("attidentity", ParameterValue.from(value))
          case PgAttributeFieldValue.attgenerated(value) => NamedParameter("attgenerated", ParameterValue.from(value))
          case PgAttributeFieldValue.attisdropped(value) => NamedParameter("attisdropped", ParameterValue.from(value))
          case PgAttributeFieldValue.attislocal(value) => NamedParameter("attislocal", ParameterValue.from(value))
          case PgAttributeFieldValue.attinhcount(value) => NamedParameter("attinhcount", ParameterValue.from(value))
          case PgAttributeFieldValue.attcollation(value) => NamedParameter("attcollation", ParameterValue.from(value))
          case PgAttributeFieldValue.attacl(value) => NamedParameter("attacl", ParameterValue.from(value))
          case PgAttributeFieldValue.attoptions(value) => NamedParameter("attoptions", ParameterValue.from(value))
          case PgAttributeFieldValue.attfdwoptions(value) => NamedParameter("attfdwoptions", ParameterValue.from(value))
          case PgAttributeFieldValue.attmissingval(value) => NamedParameter("attmissingval", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_attribute where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgAttributeRow.rowParser.*)
    }

  }
  override def updateFieldValues(attrelidAndAttnum: PgAttributeId, fieldValues: List[PgAttributeFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAttributeFieldValue.attrelid(value) => NamedParameter("attrelid", ParameterValue.from(value))
          case PgAttributeFieldValue.attname(value) => NamedParameter("attname", ParameterValue.from(value))
          case PgAttributeFieldValue.atttypid(value) => NamedParameter("atttypid", ParameterValue.from(value))
          case PgAttributeFieldValue.attstattarget(value) => NamedParameter("attstattarget", ParameterValue.from(value))
          case PgAttributeFieldValue.attlen(value) => NamedParameter("attlen", ParameterValue.from(value))
          case PgAttributeFieldValue.attnum(value) => NamedParameter("attnum", ParameterValue.from(value))
          case PgAttributeFieldValue.attndims(value) => NamedParameter("attndims", ParameterValue.from(value))
          case PgAttributeFieldValue.attcacheoff(value) => NamedParameter("attcacheoff", ParameterValue.from(value))
          case PgAttributeFieldValue.atttypmod(value) => NamedParameter("atttypmod", ParameterValue.from(value))
          case PgAttributeFieldValue.attbyval(value) => NamedParameter("attbyval", ParameterValue.from(value))
          case PgAttributeFieldValue.attalign(value) => NamedParameter("attalign", ParameterValue.from(value))
          case PgAttributeFieldValue.attstorage(value) => NamedParameter("attstorage", ParameterValue.from(value))
          case PgAttributeFieldValue.attcompression(value) => NamedParameter("attcompression", ParameterValue.from(value))
          case PgAttributeFieldValue.attnotnull(value) => NamedParameter("attnotnull", ParameterValue.from(value))
          case PgAttributeFieldValue.atthasdef(value) => NamedParameter("atthasdef", ParameterValue.from(value))
          case PgAttributeFieldValue.atthasmissing(value) => NamedParameter("atthasmissing", ParameterValue.from(value))
          case PgAttributeFieldValue.attidentity(value) => NamedParameter("attidentity", ParameterValue.from(value))
          case PgAttributeFieldValue.attgenerated(value) => NamedParameter("attgenerated", ParameterValue.from(value))
          case PgAttributeFieldValue.attisdropped(value) => NamedParameter("attisdropped", ParameterValue.from(value))
          case PgAttributeFieldValue.attislocal(value) => NamedParameter("attislocal", ParameterValue.from(value))
          case PgAttributeFieldValue.attinhcount(value) => NamedParameter("attinhcount", ParameterValue.from(value))
          case PgAttributeFieldValue.attcollation(value) => NamedParameter("attcollation", ParameterValue.from(value))
          case PgAttributeFieldValue.attacl(value) => NamedParameter("attacl", ParameterValue.from(value))
          case PgAttributeFieldValue.attoptions(value) => NamedParameter("attoptions", ParameterValue.from(value))
          case PgAttributeFieldValue.attfdwoptions(value) => NamedParameter("attfdwoptions", ParameterValue.from(value))
          case PgAttributeFieldValue.attmissingval(value) => NamedParameter("attmissingval", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_attribute
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where attrelid = ${attrelidAndAttnum.attrelid}, attnum = ${attrelidAndAttnum.attnum}"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(attrelidAndAttnum: PgAttributeId, unsaved: PgAttributeRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("attname", ParameterValue.from(unsaved.attname))),
      Some(NamedParameter("atttypid", ParameterValue.from(unsaved.atttypid))),
      Some(NamedParameter("attstattarget", ParameterValue.from(unsaved.attstattarget))),
      Some(NamedParameter("attlen", ParameterValue.from(unsaved.attlen))),
      Some(NamedParameter("attndims", ParameterValue.from(unsaved.attndims))),
      Some(NamedParameter("attcacheoff", ParameterValue.from(unsaved.attcacheoff))),
      Some(NamedParameter("atttypmod", ParameterValue.from(unsaved.atttypmod))),
      Some(NamedParameter("attbyval", ParameterValue.from(unsaved.attbyval))),
      Some(NamedParameter("attalign", ParameterValue.from(unsaved.attalign))),
      Some(NamedParameter("attstorage", ParameterValue.from(unsaved.attstorage))),
      Some(NamedParameter("attcompression", ParameterValue.from(unsaved.attcompression))),
      Some(NamedParameter("attnotnull", ParameterValue.from(unsaved.attnotnull))),
      Some(NamedParameter("atthasdef", ParameterValue.from(unsaved.atthasdef))),
      Some(NamedParameter("atthasmissing", ParameterValue.from(unsaved.atthasmissing))),
      Some(NamedParameter("attidentity", ParameterValue.from(unsaved.attidentity))),
      Some(NamedParameter("attgenerated", ParameterValue.from(unsaved.attgenerated))),
      Some(NamedParameter("attisdropped", ParameterValue.from(unsaved.attisdropped))),
      Some(NamedParameter("attislocal", ParameterValue.from(unsaved.attislocal))),
      Some(NamedParameter("attinhcount", ParameterValue.from(unsaved.attinhcount))),
      Some(NamedParameter("attcollation", ParameterValue.from(unsaved.attcollation))),
      Some(NamedParameter("attacl", ParameterValue.from(unsaved.attacl))),
      Some(NamedParameter("attoptions", ParameterValue.from(unsaved.attoptions))),
      Some(NamedParameter("attfdwoptions", ParameterValue.from(unsaved.attfdwoptions))),
      Some(NamedParameter("attmissingval", ParameterValue.from(unsaved.attmissingval)))
    ).flatten

    SQL"""insert into pg_catalog.pg_attribute(attrelid, attnum, ${namedParameters.map(_.name).mkString(", ")})
      values (${attrelidAndAttnum.attrelid}, ${attrelidAndAttnum.attnum}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(attrelidAndAttnum: PgAttributeId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_attribute where attrelid = ${attrelidAndAttnum.attrelid}, attnum = ${attrelidAndAttnum.attnum}""".executeUpdate() > 0
  }
  override def selectByUnique(attrelid: Long, attname: String)(implicit c: Connection): Option[PgAttributeRow] = {
    ???
  }
}
