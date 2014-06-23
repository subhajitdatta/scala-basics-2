package canvasassignment


import org.specs2.mutable._

class CanvasShowTest extends Specification{

  "An Empty Canvas" should {
    "show an empty display with the canvas boundary" in {
      val canvas = Canvas(6,5)

      canvas.show must beEqualTo(
        """------
           ||    |
           ||    |
           ||    |
           ||    |
           ||    |
           |------""".stripMargin)
    }
  }

  "A Canvas with a horizontal line" should {
    "display the horizontal line with the canvas boundary" in {
      val canvas = Canvas(5, 5).add(Line(Point(1,2), Point(1,3)))

      canvas.show must beEqualTo(
        """------
          || xx |
          ||    |
          ||    |
          ||    |
          |------""".stripMargin)
    }
  }

  "A Canvas with a vertical line" should {
    "display the vertical line with the canvas boundary" in {
      val canvas = Canvas(5, 5).add(Line(Point(1,2), Point(4,2)))

      canvas.show must beEqualTo(
        """------
          || x  |
          || x  |
          || x  |
          || x  |
          |------""".stripMargin)
    }
  }

  "A Canvas with a rectangle" should {
    "display the rectangle with the canvas boundary" in {
      val canvas = Canvas(8, 8).add(Rectangle(Point(5,2), Point(7,4)))

      canvas.show must beEqualTo(
        """---------
          ||       |
          ||       |
          ||       |
          ||       |
          || xxx   |
          || x x   |
          || xxx   |
          |---------""".stripMargin)
    }
  }

  "A Canvas with a horizontal line and rectangle" should {
    "display the horizontal line and rectangle with the canvas boundary" in {
      val canvas = Canvas(8, 8)
        .add(Line(Point(1,2), Point(1,3)))
        .add(Rectangle(Point(5,2), Point(7,4)))

      canvas.show must beEqualTo(
        """---------
          || xx    |
          ||       |
          ||       |
          ||       |
          || xxx   |
          || x x   |
          || xxx   |
          |---------""".stripMargin)
    }
  }

  "A Canvas with a vertical line and rectangle" should {
    "display the vertical line and rectangle with the canvas boundary" in {
      val canvas = Canvas(8, 8)
        .add(Line(Point(1,2), Point(4,2)))
        .add(Rectangle(Point(5,2), Point(7,4)))

      canvas.show must beEqualTo(
        """---------
          || x     |
          || x     |
          || x     |
          || x     |
          || xxx   |
          || x x   |
          || xxx   |
          |---------""".stripMargin)
    }
  }

}
