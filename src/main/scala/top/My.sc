import scala.collection.BitSet
import scala.collection.immutable.HashMap
import scala.collection.mutable.ArrayBuffer

//Strategy Pattern
val allAges = new Function1[Int, Boolean] {
  def apply(age: Int) = true
}

val gujSt = new Function1[Int, Boolean] {
  def apply(age: Int) = false
}

def mahSt = new Function1[Int, Boolean] { age:Int =>
  age > 30
}

class Person(age: Int, isFemale: Boolean) {
  def isWise: Boolean= if(isFemale) age > 18 else age > 21
  def canMarry(canDrink: Function1[Int, Boolean]) = isWise && canDrink(age)
}

val p = new Person(9, true)
p.isWise
p.canMarry(allAges)


//Two type parameters can be written in Infix ntotation

class A[T1, T2](a: T1, b: T2)
val a: A[Int, String] = new A(1, "aa")
val a1: Int A String = new A(1, "aa")

def canDrink(age: Int): Boolean = age > 50
val canDrink1: (Int) => Boolean = { age : Int => age > 50 }

def transform[T1, T2](v: Seq[T1], f: T1 => T2) : Seq[T2] = {

  var res = Seq[T2]()
  for (i <- v ) {
    res = res ++ Seq(f(i))
  }

  res
}

def alterTransform[S, T](xs: Seq[S])(transformer: S => T): Seq[T] = {

  val it = xs.iterator
  var res = Seq.empty[T]

  while(it.hasNext) {
    res = res :+ transformer(it.next())
  }
  res
}

val l = Seq(1,2,3)
transform(l, { x: Int => x * x} )

alterTransform(l)(x => x * x)



def transformRecHelper[T1, T2](v: Iterator[T1], f: T1 => T2, in: Seq[T2]) : Seq[T2] = {
  if(v.hasNext) transformRecHelper(v, f, in :+ f(v.next()))
  else in
}

def transformRec[T1, T2](v: Seq[T1], f: T1 => T2) : Seq[T2] = {
  transformRecHelper(v.iterator, f, Seq.empty[T2])
}


def transformRec1Helper[T1, T2](v: Seq[T1], f: T1 => T2, in: Seq[T2]) : Seq[T2] = {
  if(v.isEmpty) in
  else transformRec1Helper(v.tail, f, in :+ f(v.head))
}

def transformRec1[T1, T2](v: Seq[T1], f: T1 => T2): Seq[T2] = {
  transformRec1Helper(v, f, Seq.empty[T2])
}

transformRec1(l, { x: Int => x * x} )
transformRec1(1 to 100,  { x: Int => x * x})
transformRec1(1 to 1000,  { x: Int => x * x})
transformRec1(1 to 10000,  { x: Int => x * x})



//DSL for While
def While(cond: => Boolean)(body: => Unit): Unit = if(cond) {
  body
  While(cond)(body)
}

var x = 14
While(x > 10) { println(x);x = x - 1;}

def add(a: Int)(b:Int) = a + b
val add20 = add(20) _
val add30 : Int => Int = add(30)

val xs = Seq(2,4,5,6,1,3,5)
val(greater, smaller) = xs.partition(_ > 3)


//Currying in classes
class P(a: Int)(b: Int)
val i = new P(10)(20)


//Class with dafault params
class P1(a: Int = 10, b: Int = 20, c: Int = 30) {
  def print = println("a: " + a + ", b: " + b + ", c: " + c)
}
val p1 = new P1(b = 5)


object G {
  trait Person{
    def age: Int
    def x = 0
  }

  class Indian extends Person {
    override def x = 88
    def age = { println("indian"); 100 }
  }
  class American extends Person {
    override def x = 99
    def age = { println("american"); 99}
  }

  val indian: Person = new Indian
  val american: Person = new American

  indian.age
  american.age

}

