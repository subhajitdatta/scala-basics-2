
def concat(s1: String, s2: String): String =
  if(s1 == null) s2
  else if (s2 == null) s1
  else s1 + s2

concat("s1", "s2")
concat(null, "s2")
concat("s1", null)
concat(null, null)

trait OptionStr
case class SomeStr(value: String) extends OptionStr
case object NoneStr extends OptionStr

def concat1(s1: OptionStr, s2: OptionStr): OptionStr =
  if(s1 == NoneStr) s2
  else if (s2 == NoneStr) s1
  else SomeStr(
    s1.asInstanceOf[SomeStr].value + s2.asInstanceOf[SomeStr].value
  )


concat1(SomeStr("s1"), SomeStr("s2"))
concat1(NoneStr, SomeStr("s2"))
concat1(SomeStr("s1"), NoneStr)
concat1(NoneStr, NoneStr)
