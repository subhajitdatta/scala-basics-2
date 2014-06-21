
class Person(private var _age: Int, name: String) {
  println("outer")


  {
    println("inner")
    10

    {
      println(x)
    }

    100

  }

  lazy val x = 10


  def age = _age

  def age_=(other: Int) = _age = other

}

val p = new Person(34, "ashoka")

p.age
p.age = 100
p.age_=(101)

p.age
