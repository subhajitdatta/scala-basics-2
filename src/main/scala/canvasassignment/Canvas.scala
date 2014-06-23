package canvasassignment


case class Canvas(width: Int, height: Int, enclosedShapes: List[Shape] = Nil) extends Shape {
  def add(s: Shape): Canvas = Canvas(width, height, enclosedShapes ++ List(s))

  def draw(fillColor: Color) : Map[Point, Color] = {
    enclosedShapes.map(s => s.draw(fillColor))
      .foldLeft(Map.empty[Point, Color])(_ ++ _)
  }

  private def getCanvasBoundaryMap : Map[Point, Color] = {
    val hBoundary = for(i <- 0 to width) yield List(Point(i, 0) -> Color.VBoundary, Point(i, height) -> Color.VBoundary)
    val vBoundary = for(i <- 0 to height) yield List(Point(0, i) -> Color.HBoundary, Point(width, i) -> Color.HBoundary)
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


  private def pointSorting(x : (Point, Color), y : (Point, Color)): Boolean = {
    val (p1: Point, c1: Color) = x
    val (p2: Point, c2: Color) = y
    p1.x < p2.x || p1.y < p2.y
  }

  private def entireScreenString(canvasMap : Map[Point, Color]): String = {
    val pointGrpedByXcord : Map[Int, List[(Point, Color)]] = canvasMap.toList.groupBy(_._1.x)
      .mapValues(l => l.sortWith(pointSorting))
    val rowsOfColorMap : Map[Int, String] = pointGrpedByXcord.mapValues(ls => ls.map(_._2.value).mkString)
    val entireScreen = rowsOfColorMap.toList.sortBy(_._1).map(_._2).mkString("\n")
    entireScreen
  }

  def show: String = {
    val canvasObjectsMap : Map[Point, Color] = getCanvasBoundaryMap ++ draw(Color.Border)
    val canvasMap : Map[Point, Color] = getCanvasMap(canvasObjectsMap)
    entireScreenString(canvasMap)
  }

  def bucketFill(p: Point): String = {
    val canvasObjectsMap : Map[Point, Color] = getCanvasBoundaryMap ++ draw(Color.Border)
    val canvasMap : Map[Point, Color] = getCanvasMap(canvasObjectsMap)

    val listOfBoundaryColors = List(Color.Border, Color.Fill, Color.HBoundary, Color.VBoundary)

    def recurseToFindFillPoints(p: Point, canvasMap : Map[Point, Color], acc: Set[Point]) : Set[Point] = {
      val currPointColor = canvasMap.getOrElse(p, Color.Blank)
      if(listOfBoundaryColors.contains(currPointColor)) acc
      else {
        val accWithCurrPoint = acc ++ Set(p)
        val canvasMapWithCurrPoint = canvasMap ++ Map(p -> Color.Fill)
        p.neighbours.flatMap(n => recurseToFindFillPoints(n, canvasMapWithCurrPoint, accWithCurrPoint))
      }
    }

    val fillPointsMap: Map[Point, Color] = recurseToFindFillPoints(p, canvasMap, Set.empty[Point]).toList
      .map(p => p -> Color.Fill).toMap

    entireScreenString(canvasMap ++ fillPointsMap)
  }
}
