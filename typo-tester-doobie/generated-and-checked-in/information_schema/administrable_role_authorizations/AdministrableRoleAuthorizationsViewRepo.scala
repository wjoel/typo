/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package administrable_role_authorizations

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait AdministrableRoleAuthorizationsViewRepo {
  def select: SelectBuilder[AdministrableRoleAuthorizationsViewFields, AdministrableRoleAuthorizationsViewRow]
  def selectAll: Stream[ConnectionIO, AdministrableRoleAuthorizationsViewRow]
}
