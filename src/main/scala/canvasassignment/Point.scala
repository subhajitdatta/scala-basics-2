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

//case class Neighbours(current: Set[Point], history: List[Set[Point]]) {
//  def next: Set[Point] = current.map(p => p.copy(p.x + 1, p.y + 1))
//
//  def update(newCurrent: Set[Point]): Neighbours = copy(current = newCurrent)
//
//  private def inHistory(p: Point): Boolean = ??? //history.map(l => l.contains(p))
//}
