package canvasassignment


case class Rectangle(point1: Point, point2: Point) extends Shape {
  def draw(fillColor: Color) : Map[Point, Color] = {
    val (p1, p2) = if (point1 <= point2) (point1, point2) else (point2, point1)

    (for{
      i <- p1.x to p2.x
      j <- p1.y to p2.y
    } yield Point(i, j) -> fillColor).toMap

  }
}
