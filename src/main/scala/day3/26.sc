
val xs = (1 to 10).toList

xs.sum

def add(x: Int, y: Int) = x + y

xs.foldLeft(0)(_ + _)

xs.foldLeft(0) { (acc, elm) =>
  acc + elm
}

xs.foldLeft(List.empty[Int]) { (acc, elm) =>
  elm :: acc
}

xs.foldLeft("")((acc, elm) => acc + elm)

xs.foldRight("")((elm, acc) => acc + elm)

xs.reduceLeft(_ + _)


