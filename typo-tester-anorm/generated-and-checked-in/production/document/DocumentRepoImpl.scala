/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Flag
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object DocumentRepoImpl extends DocumentRepo {
  override def delete(documentnode: DocumentId)(implicit c: Connection): Boolean = {
    SQL"""delete from production."document" where documentnode = $documentnode""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[DocumentFields, DocumentRow] = {
    DeleteBuilder("production.document", DocumentFields)
  }
  override def insert(unsaved: DocumentRow)(implicit c: Connection): DocumentRow = {
    SQL"""insert into production."document"(title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate, documentnode)
          values (${unsaved.title}, ${unsaved.owner}::int4, ${unsaved.folderflag}::"public"."Flag", ${unsaved.filename}, ${unsaved.fileextension}, ${unsaved.revision}::bpchar, ${unsaved.changenumber}::int4, ${unsaved.status}::int2, ${unsaved.documentsummary}, ${unsaved.document}::bytea, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp, ${unsaved.documentnode})
          returning title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
       """
      .executeInsert(DocumentRow.rowParser(1).single)
    
  }
  override def insert(unsaved: DocumentRowUnsaved)(implicit c: Connection): DocumentRow = {
    val namedParameters = List(
      Some((NamedParameter("title", ParameterValue.from(unsaved.title)), "")),
      Some((NamedParameter("owner", ParameterValue.from(unsaved.owner)), "::int4")),
      Some((NamedParameter("filename", ParameterValue.from(unsaved.filename)), "")),
      Some((NamedParameter("fileextension", ParameterValue.from(unsaved.fileextension)), "")),
      Some((NamedParameter("revision", ParameterValue.from(unsaved.revision)), "::bpchar")),
      Some((NamedParameter("status", ParameterValue.from(unsaved.status)), "::int2")),
      Some((NamedParameter("documentsummary", ParameterValue.from(unsaved.documentsummary)), "")),
      Some((NamedParameter("document", ParameterValue.from(unsaved.document)), "::bytea")),
      unsaved.folderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("folderflag", ParameterValue.from[Flag](value)), """::"public"."Flag""""))
      },
      unsaved.changenumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("changenumber", ParameterValue.from[Int](value)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      },
      unsaved.documentnode match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("documentnode", ParameterValue.from[DocumentId](value)), ""))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production."document" default values
            returning title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
         """
        .executeInsert(DocumentRow.rowParser(1).single)
    } else {
      val q = s"""insert into production."document"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(DocumentRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[DocumentFields, DocumentRow] = {
    SelectBuilderSql("production.document", DocumentFields, DocumentRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[DocumentRow] = {
    SQL"""select title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
          from production."document"
       """.as(DocumentRow.rowParser(1).*)
  }
  override def selectById(documentnode: DocumentId)(implicit c: Connection): Option[DocumentRow] = {
    SQL"""select title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
          from production."document"
          where documentnode = $documentnode
       """.as(DocumentRow.rowParser(1).singleOpt)
  }
  override def selectByIds(documentnodes: Array[DocumentId])(implicit c: Connection): List[DocumentRow] = {
    SQL"""select title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
          from production."document"
          where documentnode = ANY($documentnodes)
       """.as(DocumentRow.rowParser(1).*)
    
  }
  override def update(row: DocumentRow)(implicit c: Connection): Boolean = {
    val documentnode = row.documentnode
    SQL"""update production."document"
          set title = ${row.title},
              "owner" = ${row.owner}::int4,
              folderflag = ${row.folderflag}::"public"."Flag",
              filename = ${row.filename},
              fileextension = ${row.fileextension},
              revision = ${row.revision}::bpchar,
              changenumber = ${row.changenumber}::int4,
              status = ${row.status}::int2,
              documentsummary = ${row.documentsummary},
              "document" = ${row.document}::bytea,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where documentnode = $documentnode
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[DocumentFields, DocumentRow] = {
    UpdateBuilder("production.document", DocumentFields, DocumentRow.rowParser)
  }
  override def upsert(unsaved: DocumentRow)(implicit c: Connection): DocumentRow = {
    SQL"""insert into production."document"(title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate, documentnode)
          values (
            ${unsaved.title},
            ${unsaved.owner}::int4,
            ${unsaved.folderflag}::"public"."Flag",
            ${unsaved.filename},
            ${unsaved.fileextension},
            ${unsaved.revision}::bpchar,
            ${unsaved.changenumber}::int4,
            ${unsaved.status}::int2,
            ${unsaved.documentsummary},
            ${unsaved.document}::bytea,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp,
            ${unsaved.documentnode}
          )
          on conflict (documentnode)
          do update set
            title = EXCLUDED.title,
            "owner" = EXCLUDED."owner",
            folderflag = EXCLUDED.folderflag,
            filename = EXCLUDED.filename,
            fileextension = EXCLUDED.fileextension,
            revision = EXCLUDED.revision,
            changenumber = EXCLUDED.changenumber,
            status = EXCLUDED.status,
            documentsummary = EXCLUDED.documentsummary,
            "document" = EXCLUDED."document",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
       """
      .executeInsert(DocumentRow.rowParser(1).single)
    
  }
}
