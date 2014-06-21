
case class Address(line1: String)
case class Person(name: String, age: Int, address: Address) {
}

val p = new Person("aa", 10, Address("pashan"))

p.copy(age = 100)

p.copy(address = p.address.copy("line2"))


val x: Null = null