package day4

case class ReverseOrder[T](value: T)

object ReverseOrder {
  implicit def reverseOrdering[T: Ordering]: Ordering[ReverseOrder[T]] =
    Ordering[T].reverse.on(_.value)

  implicit class RichVal[T](x: T) {
    def reverseOrder = ReverseOrder(x)
  }
}
