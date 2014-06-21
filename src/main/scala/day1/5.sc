

val xs = Seq(2, 4, 6, 1, 7, 2, 8)

val (greater, lesser) = xs.partition(_ > 3)

greater
lesser

def m(xs: Seq[Int]) = (2, 3)

m(Seq())