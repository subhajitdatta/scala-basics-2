

val pf1: PartialFunction[String, Int] = {
  case str if str.length > 3 => 3
}

val pf2: PartialFunction[(String, Double), Int] = {
  case (str, d) if str.length > 3 && d < 2 => 3
}

val v1 = "asdasdads"

pf1.isDefinedAt("aa")
pf1(v1)
