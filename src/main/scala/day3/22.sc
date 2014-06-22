import scala.util.Random

val xs: Seq[Int] = Seq(7, 2, 4, 8, 3, 1, 6, 5, 9)

xs.take(4)
xs.drop(4)
val (first4, rest) = xs.splitAt(4)
first4
rest
xs.filter(_ > 4)
xs.filterNot(_ > 4)
xs.partition(_ > 4)

xs.takeWhile(_ < 8)
xs.dropWhile(_ < 8)
xs.span(_ < 8)

xs.map(x => x * x)





xs
