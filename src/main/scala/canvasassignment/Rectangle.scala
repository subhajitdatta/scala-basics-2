package canvasassignment


case class Rectangle(point1: Point, point2: Point) extends Shape {
  def draw(fillColor: Color) : Map[Point, Color] = {
    val (p1, p2) = if (point1 <= point2) (point1, point2) else (point2, point1)

    val hBoundary = for(i <- p1.y to p2.y) yield List(Point(p1.x, i) -> fillColor, Point(p2.x, i) -> fillColor)
    val vBoundary = for(i <- p1.x to p2.x) yield List(Point(i, p1.y) -> fillColor, Point(i, p2.y) -> fillColor)
    (hBoundary.flatten ++ vBoundary.flatten).toMap

  }
}
