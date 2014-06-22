
Seq(9)
Seq(8)
Seq(9).flatMap(x => Seq(8).map(y => x + y))

def adder(xs: Seq[Int], ys: Seq[Int]) = for {
  x <- xs
  y <- ys
} yield x + y


adder(Seq(9), Seq(8))

Seq.empty[Int]
def square(xs: Seq[Int]) = xs.map(x => x * x)
square(Seq(9))
square(Seq.empty)

Option(9)
Option.empty[Int]
def square1(xs: Option[Int]) = xs.map(x => x * x)
square1(Option(9))
square1(Option.empty[Int])

def adder1(xs: Option[Int], ys: Option[Int]) = for {
  x <- xs
  y <- ys
} yield x + y

adder1(Option(9), Option(8))
