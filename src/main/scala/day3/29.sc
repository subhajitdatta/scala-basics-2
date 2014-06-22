
Seq(1).map(_ + 1)
collection.immutable.Seq(1).map(_ + 1)
Set(1).map(_ + 1)
Map(1 -> "a").map {case (k, v) => (v, k)}
Map(1 -> "a").map {case (k, v) => v}

val bs = collection.immutable.BitSet(1, 2, 3)

bs.map(_ + 2)
bs.map(_.toString)