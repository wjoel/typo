/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package bom

import java.sql.Connection

trait BomRepo {
  def selectAll(implicit c: Connection): List[BomRow]
  def selectByFieldValues(fieldValues: List[BomFieldOrIdValue[_]])(implicit c: Connection): List[BomRow]
}