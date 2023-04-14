/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object DocumentRepoImpl extends DocumentRepo {
  override def delete(documentnode: DocumentId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.document where documentnode = $documentnode""".executeUpdate() > 0
  }
  override def insert(unsaved: DocumentRowUnsaved)(implicit c: Connection): DocumentId = {
    val namedParameters = List(
      Some(NamedParameter("title", ParameterValue.from(unsaved.title))),
      Some(NamedParameter("owner", ParameterValue.from(unsaved.owner))),
      unsaved.folderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("folderflag", ParameterValue.from[Flag](value)))
      },
      Some(NamedParameter("filename", ParameterValue.from(unsaved.filename))),
      Some(NamedParameter("fileextension", ParameterValue.from(unsaved.fileextension))),
      Some(NamedParameter("revision", ParameterValue.from(unsaved.revision))),
      unsaved.changenumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("changenumber", ParameterValue.from[Int](value)))
      },
      Some(NamedParameter("status", ParameterValue.from(unsaved.status))),
      Some(NamedParameter("documentsummary", ParameterValue.from(unsaved.documentsummary))),
      Some(NamedParameter("document", ParameterValue.from(unsaved.document))),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.document(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning documentnode
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[DocumentRow] = {
    SQL"""select title, owner, folderflag, filename, fileextension, revision, changenumber, status, documentsummary, document, rowguid, modifieddate, documentnode from production.document""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[DocumentFieldOrIdValue[_]])(implicit c: Connection): List[DocumentRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case DocumentFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case DocumentFieldValue.owner(value) => NamedParameter("owner", ParameterValue.from(value))
          case DocumentFieldValue.folderflag(value) => NamedParameter("folderflag", ParameterValue.from(value))
          case DocumentFieldValue.filename(value) => NamedParameter("filename", ParameterValue.from(value))
          case DocumentFieldValue.fileextension(value) => NamedParameter("fileextension", ParameterValue.from(value))
          case DocumentFieldValue.revision(value) => NamedParameter("revision", ParameterValue.from(value))
          case DocumentFieldValue.changenumber(value) => NamedParameter("changenumber", ParameterValue.from(value))
          case DocumentFieldValue.status(value) => NamedParameter("status", ParameterValue.from(value))
          case DocumentFieldValue.documentsummary(value) => NamedParameter("documentsummary", ParameterValue.from(value))
          case DocumentFieldValue.document(value) => NamedParameter("document", ParameterValue.from(value))
          case DocumentFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case DocumentFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
          case DocumentFieldValue.documentnode(value) => NamedParameter("documentnode", ParameterValue.from(value))
        }
        val q = s"""select * from production.document where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(documentnode: DocumentId)(implicit c: Connection): Option[DocumentRow] = {
    SQL"""select title, owner, folderflag, filename, fileextension, revision, changenumber, status, documentsummary, document, rowguid, modifieddate, documentnode from production.document where documentnode = $documentnode""".as(rowParser.singleOpt)
  }
  override def selectByIds(documentnodes: List[DocumentId])(implicit c: Connection): List[DocumentRow] = {
    SQL"""select title, owner, folderflag, filename, fileextension, revision, changenumber, status, documentsummary, document, rowguid, modifieddate, documentnode from production.document where documentnode in $documentnodes""".as(rowParser.*)
  }
  override def selectByUnique(rowguid: UUID)(implicit c: Connection): Option[DocumentRow] = {
    selectByFieldValues(List(DocumentFieldValue.rowguid(rowguid))).headOption
  }
  override def update(row: DocumentRow)(implicit c: Connection): Boolean = {
    val documentnode = row.documentnode
    SQL"""update production.document
          set title = ${row.title},
              owner = ${row.owner},
              folderflag = ${row.folderflag},
              filename = ${row.filename},
              fileextension = ${row.fileextension},
              revision = ${row.revision},
              changenumber = ${row.changenumber},
              status = ${row.status},
              documentsummary = ${row.documentsummary},
              document = ${row.document},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where documentnode = $documentnode""".executeUpdate() > 0
  }
  override def updateFieldValues(documentnode: DocumentId, fieldValues: List[DocumentFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case DocumentFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case DocumentFieldValue.owner(value) => NamedParameter("owner", ParameterValue.from(value))
          case DocumentFieldValue.folderflag(value) => NamedParameter("folderflag", ParameterValue.from(value))
          case DocumentFieldValue.filename(value) => NamedParameter("filename", ParameterValue.from(value))
          case DocumentFieldValue.fileextension(value) => NamedParameter("fileextension", ParameterValue.from(value))
          case DocumentFieldValue.revision(value) => NamedParameter("revision", ParameterValue.from(value))
          case DocumentFieldValue.changenumber(value) => NamedParameter("changenumber", ParameterValue.from(value))
          case DocumentFieldValue.status(value) => NamedParameter("status", ParameterValue.from(value))
          case DocumentFieldValue.documentsummary(value) => NamedParameter("documentsummary", ParameterValue.from(value))
          case DocumentFieldValue.document(value) => NamedParameter("document", ParameterValue.from(value))
          case DocumentFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case DocumentFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.document
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where documentnode = $documentnode"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[DocumentRow] =
    RowParser[DocumentRow] { row =>
      Success(
        DocumentRow(
          title = row[String]("title"),
          owner = row[BusinessentityId]("owner"),
          folderflag = row[Flag]("folderflag"),
          filename = row[String]("filename"),
          fileextension = row[Option[String]]("fileextension"),
          revision = row[/* bpchar */ String]("revision"),
          changenumber = row[Int]("changenumber"),
          status = row[Int]("status"),
          documentsummary = row[Option[String]]("documentsummary"),
          document = row[Option[Array[Byte]]]("document"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate"),
          documentnode = row[DocumentId]("documentnode")
        )
      )
    }
  val idRowParser: RowParser[DocumentId] =
    SqlParser.get[DocumentId]("documentnode")
}
