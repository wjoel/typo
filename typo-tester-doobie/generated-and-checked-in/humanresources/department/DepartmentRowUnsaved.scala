/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.Defaulted
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

/** This class corresponds to a row in table `humanresources.department` which has not been persisted yet */
case class DepartmentRowUnsaved(
  /** Name of the department. */
  name: Name,
  /** Name of the group to which the department belongs. */
  groupname: Name,
  /** Default: nextval('humanresources.department_departmentid_seq'::regclass)
      Primary key for Department records. */
  departmentid: Defaulted[DepartmentId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(departmentidDefault: => DepartmentId, modifieddateDefault: => LocalDateTime): DepartmentRow =
    DepartmentRow(
      name = name,
      groupname = groupname,
      departmentid = departmentid match {
                       case Defaulted.UseDefault => departmentidDefault
                       case Defaulted.Provided(value) => value
                     },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object DepartmentRowUnsaved {
  implicit val decoder: Decoder[DepartmentRowUnsaved] =
    (c: HCursor) =>
      for {
        name <- c.downField("name").as[Name]
        groupname <- c.downField("groupname").as[Name]
        departmentid <- c.downField("departmentid").as[Defaulted[DepartmentId]]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield DepartmentRowUnsaved(name, groupname, departmentid, modifieddate)
  implicit val encoder: Encoder[DepartmentRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "name" := row.name,
        "groupname" := row.groupname,
        "departmentid" := row.departmentid,
        "modifieddate" := row.modifieddate
      )}
}