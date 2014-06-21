package top

object O {

  class C1 extends A with B
  new C1 with A with B
  class C2 extends B with A
  new A with B
  new B with A

  val c: C1 = new C1
  val c1: A = new C1
  val c2: B = new C1
  val c3: A with B = new C1
  val c4: B with A = new C1

  trait AA
  new AA{}

  trait A {
    val ee = 99
    def m1: Int
    def m2 = m1 + 10
  }

  trait B {
    def m2: Int
    def m1 = 100
  }


}

trait Item {
  def basePrice: Double
  def isImported: Boolean
}

class Book(val name: String, val basePrice: Double, val isImported: Boolean) extends Item
class Medicine(val brand: String, val basePrice: Double, val isImported: Boolean) extends Item

trait Tax {
  def rate: Double
  def round(value: Double) : Double
  def compute(basePrice: Double): Double = round((basePrice * rate)/100)
}

trait RoundingUp {
  def round(value: Double) = value.ceil
}

trait RoundingDown {
  def round(value: Double) = value.floor
}

class SalesTax(val rate: Double) extends Tax with RoundingUp
class ImportDuty(val rate: Double) extends Tax with RoundingDown


class Receipt(items: Seq[Item]) extends RoundingUp {
  def compute = {

  }
}
