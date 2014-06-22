

Seq(9).exists(_ > 8)
Seq(9).forall(_ > 1)
Seq.empty[Int].forall(_ > 100)
Option(9).exists(_ > 18)
Option(9).forall(_ > 8)
Option.empty[Int].exists(_ > 8)
Option.empty[Int].forall(_ > 8)
val xs = Stream.from(1)

  xs.map(x => x * x)
  .filter(_ % 2 == 0)
  .drop(10).head

xs

