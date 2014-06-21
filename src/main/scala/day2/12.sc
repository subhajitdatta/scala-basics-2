
case class Address(line1: String)
case class Person(name: String, age: Int, address: Address)


def size(obj: Any) = obj match {
//  case 1 => 1
//  case 2 | 3 | "asdasd" => 6
//  case "abc" => 3
//  case (1, "abc") => 4
//  case x: Int if x > 100 => x + 5
//  case x: Int => x
//  case x: String if x.length > 4 => 40
//  case (x, y: String) => 22
//  case outer @ (x, inner @ (3, "aaa", y)) => inner
  case Person(name, age, Address(l1)) => {x: Int => l1.length + x}
//  case x => x
}

//size(1)
//size("asdasdasd")
//size((1, "abcd"))
//size((1, 33444))
//size(Seq(3, 88, 45))
//size((12, (3, "aaa", 100)))
size(Person("map", 100, Address("pahsna")))(100)
