
def square(a: Int): String =  (a * a).toString
def length(s: String): List[Char] = s.toList

def combined(a: Int) = length(square(a))

combined(12)

val f1 = square _
val f2 = length _

def f12 = f1 andThen f2
def g12 = f2 compose f1

f12(12)
g12(12)
