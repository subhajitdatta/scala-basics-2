import scala.collection.mutable.ArrayBuffer

def add(a: Int)(b: Int): Int = a + b
def add1(a: Int, b: Int): Int = a + b

add(2)(3)

def transform1(xs: Seq[Int])
                    (transformer: Int => Int): Seq[Int] = {
  val it = xs.iterator
  val result = ArrayBuffer.empty[Int]
  while (it.hasNext) {
    result.+=(transformer(it.next()))
  }
  result.to[List]
}

add(20) _

transform1(Seq(2, 4, 10))(add(20))
transform1(Seq(2, 4, 10))(b => add(20)(b))
transform1(Seq(2, 4, 10))(add1(20, _))
transform1(Seq(2, 4, 10))(b => add1(20, b))

val adder20 = add(20) _
val adder30: Int => Int = add(30)
