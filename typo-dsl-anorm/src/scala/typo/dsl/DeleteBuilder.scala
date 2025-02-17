package typo.dsl

import anorm.{Row as _, *}
import typo.dsl.Fragment.FragmentStringInterpolator

import java.sql.Connection
import java.util.concurrent.atomic.AtomicInteger

trait DeleteBuilder[Fields[_], Row] {
  protected def params: DeleteParams[Fields, Row]
  protected def withParams(sqlParams: DeleteParams[Fields, Row]): DeleteBuilder[Fields, Row]

  final def where[N[_]: Nullability](v: Fields[Row] => SqlExpr[Boolean, N, Row]): DeleteBuilder[Fields, Row] =
    whereStrict(f => v(f).?.coalesce(false))

  final def whereStrict(v: Fields[Row] => SqlExpr[Boolean, Required, Row]): DeleteBuilder[Fields, Row] =
    withParams(params.where(v))

  def sql: Option[Fragment]
  def execute()(implicit c: Connection): Int
}

object DeleteBuilder {
  def apply[Fields[_], Row](name: String, structure: Structure.Relation[Fields, ?, Row]): DeleteBuilderSql[Fields, Row] =
    DeleteBuilderSql(name, structure, DeleteParams.empty)

  case class DeleteBuilderSql[Fields[_], Row](
      name: String,
      structure: Structure.Relation[Fields, ?, Row],
      params: DeleteParams[Fields, Row]
  ) extends DeleteBuilder[Fields, Row] {
    override def withParams(params: DeleteParams[Fields, Row]): DeleteBuilder[Fields, Row] =
      copy(params = params)

    def mkSql(counter: AtomicInteger): Fragment = {
      List[Iterable[Fragment]](
        Some(frag"delete from ${Fragment(name)}"),
        params.where
          .map(w => w(structure.fields))
          .reduceLeftOption(_ and _)
          .map { where => Fragment(" where ") ++ where.render(counter) }
      ).flatten.reduce(_ ++ _)
    }

    override def sql: Option[Fragment] = {
      Some(mkSql(new AtomicInteger(1)))
    }

    override def execute()(implicit c: Connection): Int = {
      val frag = mkSql(new AtomicInteger(0))
      SQL(frag.sql).on(frag.params*).executeUpdate()
    }
  }

  case class DeleteBuilderMock[Id, Fields[_], Row](
      params: DeleteParams[Fields, Row],
      fields: Fields[Row],
      map: scala.collection.mutable.Map[Id, Row]
  ) extends DeleteBuilder[Fields, Row] {
    override def withParams(params: DeleteParams[Fields, Row]): DeleteBuilder[Fields, Row] =
      copy(params = params)

    override def sql: Option[Fragment] =
      None

    override def execute()(implicit c: Connection): Int = {
      var changed = 0
      map.foreach { case (id, row) =>
        if (params.where.forall(w => w(fields).eval(row))) {
          map.remove(id)
          changed += 1
        }
      }
      changed
    }
  }
}
