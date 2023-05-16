/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_detail

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.syntax.string.toSqlInterpolator
import doobie.util.query.Query0
import java.sql.ResultSet

object PersonDetailSqlRepoImpl extends PersonDetailSqlRepo {
  override def apply(businessentityid: /* nullability unknown */ Option[Int]): Query0[PersonDetailSqlRow] = {
    val sql =
      sql"""SELECT s.businessentityid,
                   p.title,
                   p.firstname,
                   p.middlename,
                   p.lastname,
                   e.jobtitle,
                   a.addressline1,
                   a.city,
                   a.postalcode
            FROM sales.salesperson s
                     JOIN humanresources.employee e ON e.businessentityid = s.businessentityid
                     JOIN person.person p ON p.businessentityid = s.businessentityid
                     JOIN person.businessentityaddress bea ON bea.businessentityid = s.businessentityid
                     JOIN person.address a ON a.addressid = bea.addressid
            where s.businessentityid = $businessentityid
         """
    sql.query[PersonDetailSqlRow]
  
  }
  implicit val read: Read[PersonDetailSqlRow] =
    new Read[PersonDetailSqlRow](
      gets = List(
        (Get[BusinessentityId], Nullability.NoNulls),
        (Get[String], Nullability.Nullable),
        (Get[Name], Nullability.NoNulls),
        (Get[Name], Nullability.Nullable),
        (Get[Name], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls),
        (Get[String], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PersonDetailSqlRow(
        businessentityid = Get[BusinessentityId].unsafeGetNonNullable(rs, i + 0),
        title = Get[String].unsafeGetNullable(rs, i + 1),
        firstname = Get[Name].unsafeGetNonNullable(rs, i + 2),
        middlename = Get[Name].unsafeGetNullable(rs, i + 3),
        lastname = Get[Name].unsafeGetNonNullable(rs, i + 4),
        jobtitle = Get[String].unsafeGetNonNullable(rs, i + 5),
        addressline1 = Get[String].unsafeGetNonNullable(rs, i + 6),
        city = Get[String].unsafeGetNonNullable(rs, i + 7),
        postalcode = Get[String].unsafeGetNonNullable(rs, i + 8)
      )
    )
  

}
