package day4

trait Monoid[T] {
  def zero: T
  def add(a: T, b: T): T
}

object Monoid {

  implicit val intM = new Monoid[Int] {
    def zero = 0
    def add(a: Int, b: Int) = a + b
  }

  implicit val strM = new Monoid[String] {
    def zero = ""
    def add(a: String, b: String) = a + b
  }

  implicit def optM[T](implicit tM: Monoid[T]) = new Monoid[Option[T]] {
    def zero = None

    def add(a: Option[T], b: Option[T]) = {
      val all = a ++ b
      if(all.isEmpty) None else Some(all.foldLeft(tM.zero)(tM.add))
    }
  }

  implicit def tupleM[T1, T2](implicit t1M: Monoid[T1], t2M: Monoid[T2]) = new Monoid[(T1, T2)] {
    def zero = (t1M.zero, t2M.zero)
    def add(a: (T1, T2), b: (T1, T2)) = (t1M.add(a._1, b._1), t2M.add(a._2, b._2))
  }

}
