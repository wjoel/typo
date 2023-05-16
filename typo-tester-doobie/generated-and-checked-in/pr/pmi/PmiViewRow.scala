/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmi

import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import java.time.LocalDateTime

case class PmiViewRow(
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.illustrationid]] */
  illustrationid: Option[IllustrationId],
  /** Points to [[production.productmodelillustration.ProductmodelillustrationRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)


