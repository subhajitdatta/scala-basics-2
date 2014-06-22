package canvasassignment


case class Color(value: Char)

object Color extends (Char => Color) {
  val Blank = Color(' ')
  val Border = Color('x')
  val Fill = Color('o')
  val HBoundary = Color('-')
  val VBoundary = Color('|')
}
//
//
//trait Display{
//  def color: Color
//  override def toString = color.value.toString
//}
//
//case class Border(color: Color) extends Display
//
//case class Fill(color: Color) extends Display
//
//object Display {
//  val Default = Fill(Color.Blank)
//}
