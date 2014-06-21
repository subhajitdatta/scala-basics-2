object D {


  class A
  val a = new A

  object X {
    val url = "asdasd"
  }

  X.url

  class Person(val age: Int, val name: String) {
    private val y = 99
    Person.x
    //  def this(age: Int) = {
    //    this(age, "NoName")
    //  }

  }

  object Person {
    private val x = 10


    def make(s: String) = new Person(s.length, s)
  }

  val p = Person.make("asdasdasdasd")

  p.name
  p.age

}
