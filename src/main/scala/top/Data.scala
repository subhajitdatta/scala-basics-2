package top

case class Book1(
  author: String,
  title: String,
  basePrice: Double,
  isImported: Boolean
  )

object Data {

  val books = Seq(
    Book1("odersky", "scala prog", 100, isImported = false),
    Book1("odersky", "complexity", 400, isImported = false),
    Book1("misky", "ocaml prog", 1000, isImported = true),
    Book1("misky", "sml", 88, isImported = false),
    Book1("hickey", "clojure prog", 500, isImported = true)
  )
}
