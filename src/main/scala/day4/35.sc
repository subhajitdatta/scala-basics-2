

Seq(1, 2, 3).sum
Seq(1.0, 2, 3).sum


def sum[T](xs: Seq[T])(implicit nm: Numeric[T]) =
  xs.foldLeft(nm.zero)(nm.plus)

val xs: Seq[Double] = Seq(1.0, 2.0)
val ys: Seq[Int] = Seq(1, 2)

sum(ys)
sum(xs)
