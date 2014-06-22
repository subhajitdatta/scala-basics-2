

val set = Set(1, 2, 3, 4, 3)

set(3)

set: Int => Boolean

val seq = Seq(1, 2)

seq: Int => Int

val hashMap = Map(1 -> "a", 2 -> "b")

hashMap: Int => String

hashMap.apply(1)

seq.map(hashMap)

seq.map(_ + 1)


