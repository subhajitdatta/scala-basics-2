package canvasassignment


case class Canvas(width: Int, height: Int, enclosedShapes: List[Shape] = Nil) extends Shape {
  def add(s: Shape): Canvas = Canvas(width, height, enclosedShapes ++ List(s))

  def draw(fillColor: Color) : Map[Point, Color] = {
    enclosedShapes.map(s => s.draw(fillColor))
      .foldLeft(Map.empty[Point, Color])(_ ++ _)
  }

  private def getCanvasBoundaryMap : Map[Point, Color] = {
    val hBoundary = for(i <- 0 to width) yield List(Point(0, i) -> Color.HBoundary, Point(height, i) -> Color.HBoundary)
    val vBoundary = for(i <- 1 to height) yield List(Point(i, 0) -> Color.VBoundary, Point(i, width) -> Color.VBoundary)
    (hBoundary.flatten ++ vBoundary.flatten).toMap
  }

  private def getCanvasMap(canvasObjectsMap : Map[Point, Color]) : Map[Point, Color] = (for{
    j <- 0 to height
    i <- 0 to width
  } yield {
    val p = Point(i, j)
    val pix = canvasObjectsMap.getOrElse(p, Color.Blank)
    p -> pix
  }).toMap

  def show: String = {

    def pointSorting(x : (Point, Color), y : (Point, Color)): Boolean = {
      val (p1: Point, c1: Color) = x
      val (p2: Point, c2: Color) = y
      p1.x <= p2.x || p1.y <= p2.y
    }

    val canvasObjectsMap : Map[Point, Color] = getCanvasBoundaryMap ++ draw(Color.Border)
    val canvasMap : Map[Point, Color] = getCanvasMap(canvasObjectsMap)
    val pointGrpedByXcord : Map[Int, List[(Point, Color)]] = canvasMap.toList.sortWith(pointSorting).groupBy(_._1.x)
      .mapValues(l => l.sortWith(pointSorting))
    val rowsOfColorMap : Map[Int, String] = pointGrpedByXcord.mapValues(ls => ls.map(_._2.value).mkString)
    val entireScreen = rowsOfColorMap.values.mkString("\n")

    println(canvasMap)
    println(pointGrpedByXcord)
    println(rowsOfColorMap)

    entireScreen
  }
}