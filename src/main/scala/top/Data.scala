package top

case class Book1(
  author: String,
  title: String,
  basePrice: Double,
  isImported: Boolean
  )

object Data {

  val books = Seq(
    Book1("odersky", "scala prog", 100, false),
    Book1("odersky", "complexity", 400, false),
    Book1("misky", "ocaml prog", 1000, true),
    Book1("misky", "sml", 88, false),
    Book1("hickey", "clojure prog", 500, true)
  )
}
