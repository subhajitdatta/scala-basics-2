

def m(a: Seq[Int]) = a.sum
def m1(a: Int*) = m2(a: _*)
def m2(a: Int*) = a.product

m1(Seq(1, 2, 3, 4): _*)
m1(1, 2, 3, 4)

Seq(1, 2, 3, 4, 5)
Iterable(1, 2, 3, 4, 5)
Set(1, 2, 3, 4, 5)
IndexedSeq(1, 2, 3, 4, 5)



