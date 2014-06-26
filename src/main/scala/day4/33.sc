import day4.Monoid

def sum[T](xs: Seq[T])(monoid: Monoid[T]) =
    xs.foldLeft(monoid.zero)(monoid.add)

sum(Seq(1, 2, 3))(Monoid.intM)
sum(Seq("a", "b", "c"))(Monoid.strM)

sum(Seq(
  Option("a"),
  Option.empty[String],
  Option("c"))
)(Monoid.optM(Monoid.strM))

sum(Seq(
  Option(1),
  Option.empty[Int],
  Option(3))
)(Monoid.optM(Monoid.intM))

sum(Seq(
  ("a", 1),
  ("b", 2),
  ("c", 3)
))(Monoid.tupleM(Monoid.strM, Monoid.intM))

sum(Seq(
  (Option("a"), Option(1)),
  (Option.empty[String], Option(2)),
  (Option("c"), Option.empty)
))(Monoid.tupleM(
  Monoid.optM(Monoid.strM),
  Monoid.optM(Monoid.intM)
))

