/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ProductmodelproductdescriptioncultureRepoImpl extends ProductmodelproductdescriptioncultureRepo {
  override def delete(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productmodelproductdescriptionculture where productmodelid = ${compositeId.productmodelid} AND productdescriptionid = ${compositeId.productdescriptionid} AND cultureid = ${compositeId.cultureid}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    DeleteBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields)
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow = {
    SQL"""insert into production.productmodelproductdescriptionculture(productmodelid, productdescriptionid, cultureid, modifieddate)
          values (${unsaved.productmodelid}::int4, ${unsaved.productdescriptionid}::int4, ${unsaved.cultureid}::bpchar, ${unsaved.modifieddate}::timestamp)
          returning productmodelid, productdescriptionid, cultureid, modifieddate::text
       """
      .executeInsert(ProductmodelproductdescriptioncultureRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved)(implicit c: Connection): ProductmodelproductdescriptioncultureRow = {
    val namedParameters = List(
      Some((NamedParameter("productmodelid", ParameterValue.from(unsaved.productmodelid)), "::int4")),
      Some((NamedParameter("productdescriptionid", ParameterValue.from(unsaved.productdescriptionid)), "::int4")),
      Some((NamedParameter("cultureid", ParameterValue.from(unsaved.cultureid)), "::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productmodelproductdescriptionculture default values
            returning productmodelid, productdescriptionid, cultureid, modifieddate::text
         """
        .executeInsert(ProductmodelproductdescriptioncultureRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productmodelproductdescriptionculture(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productmodelid, productdescriptionid, cultureid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ProductmodelproductdescriptioncultureRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    SelectBuilderSql("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow] = {
    SQL"""select productmodelid, productdescriptionid, cultureid, modifieddate::text
          from production.productmodelproductdescriptionculture
       """.as(ProductmodelproductdescriptioncultureRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Option[ProductmodelproductdescriptioncultureRow] = {
    SQL"""select productmodelid, productdescriptionid, cultureid, modifieddate::text
          from production.productmodelproductdescriptionculture
          where productmodelid = ${compositeId.productmodelid} AND productdescriptionid = ${compositeId.productdescriptionid} AND cultureid = ${compositeId.cultureid}
       """.as(ProductmodelproductdescriptioncultureRow.rowParser(1).singleOpt)
  }
  override def update(row: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productmodelproductdescriptionculture
          set modifieddate = ${row.modifieddate}::timestamp
          where productmodelid = ${compositeId.productmodelid} AND productdescriptionid = ${compositeId.productdescriptionid} AND cultureid = ${compositeId.cultureid}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    UpdateBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow.rowParser)
  }
  override def upsert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow = {
    SQL"""insert into production.productmodelproductdescriptionculture(productmodelid, productdescriptionid, cultureid, modifieddate)
          values (
            ${unsaved.productmodelid}::int4,
            ${unsaved.productdescriptionid}::int4,
            ${unsaved.cultureid}::bpchar,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productmodelid, productdescriptionid, cultureid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, productdescriptionid, cultureid, modifieddate::text
       """
      .executeInsert(ProductmodelproductdescriptioncultureRow.rowParser(1).single)
    
  }
}
