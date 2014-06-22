
val pf1: PartialFunction[String, Int] = {
  case str if str.length > 3 => 3
}

val pf2: PartialFunction[String, Int] = {
  case str if str.length < 2 => 0
}

val pf3 = pf1.orElse(pf2)
val pf4 = pf2.orElse(pf1)

pf3("12345")
pf3("1")

def default(a: String) = 99

pf3.applyOrElse("11", default)

val f = pf3.lift andThen (x => x.getOrElse(99))

f("as")
f("a")
f("aasdasd")
