
val pf1: PartialFunction[String, Int] = {
  case str if str.length > 3 => 3
  case str if str.length < 0 => 0
}


new PartialFunction[String, Int] {
  def isDefinedAt(x: String) =
    x.length > 3 || x.length < 0

  def apply(v1: String) =
    if(v1.length > 3) 3
    else if(v1.length < 0) 0
    else throw new MatchError()
}