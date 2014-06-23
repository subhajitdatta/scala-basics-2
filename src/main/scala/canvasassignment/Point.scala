package canvasassignment


case class Point(x: Int, y: Int) {

  //Four connected fill can be modified for eight connected fill
  def neighbours: Set[Point] = Set(
    copy(x, y+1),
    copy(x+1, y),
    copy(x-1, y),
    copy(x, y-1)
  )

  def <= (p: Point): Boolean = x <= p.x && y <= p.y
}
