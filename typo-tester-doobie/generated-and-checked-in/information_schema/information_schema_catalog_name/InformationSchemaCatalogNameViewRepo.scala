/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package information_schema_catalog_name

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait InformationSchemaCatalogNameViewRepo {
  def select: SelectBuilder[InformationSchemaCatalogNameViewFields, InformationSchemaCatalogNameViewRow]
  def selectAll: Stream[ConnectionIO, InformationSchemaCatalogNameViewRow]
}
