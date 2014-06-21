object G {

  trait Person {
    def age: Int
    def x = 0
  }
  class Indian extends Person {
    override def x = 88
    def age = {println("indian"); 100}
  }
  class Americal extends Person {
    override val x = 99
    def age = {println("american"); 99}
  }
  val indian: Person = new Indian
  val american: Person = new Americal

  indian.x
  american.x

}

object F {

  class Person (val age: Int = 100, val name: String = "aaa", val gender: String = "Female")

  class OldPerson(override val name: String = "aaa", gender: String = "Female")
    extends Person(100, name, gender)

}
object E {

  class Person private (val age: Int = 100, val name: String = "aaa", val gender: String = "Female")
  object Person {
    def make(s: String) = new Person(10, s, s)
  }
  Person.make("asdasd").age
}

