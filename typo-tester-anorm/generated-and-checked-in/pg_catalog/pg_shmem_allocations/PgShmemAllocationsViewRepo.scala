/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shmem_allocations

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgShmemAllocationsViewRepo {
  def select: SelectBuilder[PgShmemAllocationsViewFields, PgShmemAllocationsViewRow]
  def selectAll(implicit c: Connection): List[PgShmemAllocationsViewRow]
}
