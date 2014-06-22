package canvasassignment


trait Shape {
  def draw(fillColor: Color) : Map[Point, Color]
}
