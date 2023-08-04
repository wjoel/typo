/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_auth_members

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_auth_members` */
case class PgAuthMembersId(roleid: /* oid */ Long, member: /* oid */ Long)
object PgAuthMembersId {
  implicit val decoder: Decoder[PgAuthMembersId] = Decoder.forProduct2[PgAuthMembersId, /* oid */ Long, /* oid */ Long]("roleid", "member")(PgAuthMembersId.apply)(Decoder.decodeLong, Decoder.decodeLong)
  implicit val encoder: Encoder[PgAuthMembersId] = Encoder.forProduct2[PgAuthMembersId, /* oid */ Long, /* oid */ Long]("roleid", "member")(x => (x.roleid, x.member))(Encoder.encodeLong, Encoder.encodeLong)
  implicit val ordering: Ordering[PgAuthMembersId] = Ordering.by(x => (x.roleid, x.member))
}