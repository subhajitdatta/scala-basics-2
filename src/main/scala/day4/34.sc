import day4.Monoid

def sum[T](xs: Seq[T])(implicit monoid: Monoid[T]) =
    xs.foldLeft(monoid.zero)(monoid.add)

sum(Seq(1, 2, 3))
sum(Seq("a", "b", "c"))

sum(Seq(
  Option("a"),
  Option.empty[String],
  Option("c"))
)(Monoid.optM(Monoid.strM))

sum(Seq(
  Option(1),
  Option.empty[Int],
  Option(3))
)

sum(Seq(
  ("a", 1),
  ("b", 2),
  ("c", 3)
))

{
  implicit val intM = new Monoid[Int] {
    def zero = 100
    def add(a: Int, b: Int) = a + b
  }

  sum(Seq(
    (Option("a"), Option(1)),
    (Option.empty[String], Option(2)),
    (Option("c"), Option.empty)
  ))
}
