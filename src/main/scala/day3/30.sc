
1 :: 2 :: 3 :: Nil
Nil.::(3).::(2).::(1) match {
  case head :: tail => head + 1
}

val xs = Seq(1, 2, 3, 4, 5, 6)

xs.filter(_ > 3).map(_ + 3)

xs.collect {
  case x if x > 3 => x + 3
}

val pf: PartialFunction[Int, Int] = {
  case x if x > 3 => x + 3
}

xs
  .filter(x => pf.isDefinedAt(x))
  .map(x => pf(x))

import top._
import Data._

books.collect {
  case Book1(_, _, bp , true) => bp
}

val js = new java.util.ArrayList[Int]()
js.add(1)
js.add(10)
js.add(100)
js

import collection.JavaConverters._
val sl = js.asScala.toList
