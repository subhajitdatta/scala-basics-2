class Person(age: Int, isFemale: Boolean) {
  def isWise: Boolean = if (isFemale) age > 18 else age > 21
  def canMarry(canDrink: Int => Boolean) =
    isWise && canDrink(age)
}
  ////////////////


def canDrink(age: Int): Boolean = age > 50
val canDrink1: (Int) => Boolean = { age: Int => age > 50 }

val p = new Person(9, true)
p.isWise
p.canMarry(age => age > 30 && age < 70)

p.canMarry(canDrink1)
p.canMarry(canDrink)


canDrink(10)
canDrink1(10)


canDrink1
canDrink _
val x: Int => Boolean = canDrink
canDrink: Int => Boolean
