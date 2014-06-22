
val xs = (1 to 5).toList
val ys = ('a' to 'e').toList

xs.flatMap(x => Seq(x + 1))

xs.flatMap(x => if(x > 2) Seq(x) else Seq())

for {
  x <- xs
  if x > 4
  y <- ys
  if y != 'c'
} yield {
  println(x, y)
}

xs.filter(_ > 4).flatMap { x =>
  ys.filter(_ != 'c').map { y =>
    (x, y)
  }
}

