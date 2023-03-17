package typo

object names {
  def camelCase(name: db.ColName): sc.Ident =
    sc.Ident(
      name.value
        .split('_')
        .zipWithIndex
        .map {
          case (s, 0) => s
          case (s, _) => s.capitalize
        }
        .mkString("")
    )

  def titleCase(name: String): String =
    name.split('_').map(_.capitalize).mkString("")

  def titleCase(pkg: sc.QIdent, name: db.RelationName, suffix: String): sc.QIdent =
    pkg / sc.Ident(name.schema) / sc.Ident(titleCase(name.name)).appended(suffix)

  def EnumName(pkg: sc.QIdent, name: db.EnumName): sc.QIdent =
    pkg / sc.Ident(name.schema) / sc.Ident(titleCase(name.name)).appended("Enum")

  def field(name: db.ColName): sc.Ident = camelCase(name)
  def enumValue(name: String): sc.Ident = sc.Ident(name)
}