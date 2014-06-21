import scala.collection.mutable.ArrayBuffer

def transform3[S, T](xs: Seq[S])
                   (transformer: S => T): Seq[T] = {

  if(xs.isEmpty) Seq.empty[T]
  else transformer(xs.head) +: transform3(xs.tail)(transformer)
}

def transform4[S, T](xs: Seq[S])
                   (transformer: S => T): Seq[T] = {

  def loop(remaining: Seq[S], acc: Seq[T]): Seq[T] =
    if(remaining.isEmpty) acc
    else loop(remaining.tail, acc :+ transformer(remaining.head))

  loop(xs, Seq.empty)
}

def loop[S, T](remaining: Seq[S], acc: Seq[T])(transformer: S => T): Seq[T] =
  if(remaining.isEmpty) acc
  else loop(remaining.tail, acc :+ transformer(remaining.head))(transformer)

transform4(1 to 1000000)(x => x * x)
def transform[S, T](xs: Seq[S])
                   (transformer: S => T): Seq[T] = {
  val it = xs.iterator
  var result = Seq.empty[T]
  while (it.hasNext) {
    result = result :+ transformer(it.next())
  }
  result
}
def transform1[S, T](xs: Seq[S])
                    (transformer: S => T): Seq[T] = {
  val it = xs.iterator
  val result = ArrayBuffer.empty[T]
  while (it.hasNext) {
    result.+=(transformer(it.next()))
  }
  result.to[List]
}
transform(Seq(3, 2, 6))(x => x * 10)
val ys = transform1(Seq(3, 2, 6))(x => x * 10)
ys.asInstanceOf[ArrayBuffer[Int]] += 100
ys

