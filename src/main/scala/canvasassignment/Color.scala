package canvasassignment


case class Color(value: Char)

object Color extends (Char => Color) {
  val Blank = Color(' ')
  val Border = Color('x')
  val Fill = Color('o')
  val HBoundary = Color('-')
  val VBoundary = Color('|')
}

