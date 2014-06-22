package canvasassignment


case class Point(x: Int, y: Int) {

  def neighbours: Set[Point] = Set(
    copy(x, y+1),
    copy(x+1, y),
    copy(x-1, y),
    copy(x, y-1)
  )

  def isEnclosedBy(p1: Point, p2: Point): Boolean = p1 <= this && this <= p2

  def <= (p: Point): Boolean = x <= p.x && y <= p.y
}
