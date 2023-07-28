/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.production.workorder.WorkorderId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `production.workorderrouting` */
case class WorkorderroutingId(workorderid: WorkorderId, productid: Int, operationsequence: Int)
object WorkorderroutingId {
  implicit val decoder: Decoder[WorkorderroutingId] = Decoder.forProduct3[WorkorderroutingId, WorkorderId, Int, Int]("workorderid", "productid", "operationsequence")(WorkorderroutingId.apply)(WorkorderId.decoder, Decoder.decodeInt, Decoder.decodeInt)
  implicit val encoder: Encoder[WorkorderroutingId] = Encoder.forProduct3[WorkorderroutingId, WorkorderId, Int, Int]("workorderid", "productid", "operationsequence")(x => (x.workorderid, x.productid, x.operationsequence))(WorkorderId.encoder, Encoder.encodeInt, Encoder.encodeInt)
  implicit val ordering: Ordering[WorkorderroutingId] = Ordering.by(x => (x.workorderid, x.productid, x.operationsequence))
}
