package top

import org.specs2.mutable.Specification

class DemoTest extends Specification {

  "addition" should {

    "integer addition" in {
      1 + 1 mustEqual 2
    }

    "string" in {
      "abc" + "123" mustEqual "abc123"
    }
  }

}
