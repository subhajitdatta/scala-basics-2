
//object D {
//
//  sealed trait OptionStr
//  case class SomeStr(value: String) extends OptionStr
//  case object NoneStr extends OptionStr
//  def concat(s1: OptionStr, s2: OptionStr): OptionStr = (s1, s2) match {
//    case (NoneStr, _) => s2
//    case (_, NoneStr) => s2
//    case (SomeStr(v1), SomeStr(v2)) => SomeStr(v1 + v2)
//  }
//  concat(SomeStr("s1"), SomeStr("s2"))
//  concat(NoneStr, SomeStr("s2"))
//  concat(SomeStr("s1"), NoneStr)
//  concat(NoneStr, NoneStr)
//}

object E {

  sealed trait OptionStr {
    def concat(s2: OptionStr): OptionStr
  }

  case class SomeStr(value: String) extends OptionStr {
    def concat(s2: OptionStr): OptionStr = s2 match {
      case NoneStr => this
      case SomeStr(v2) => SomeStr(value + v2)
    }
  }
  case object NoneStr extends OptionStr {
    def concat(s2: OptionStr): OptionStr = s2
  }


  SomeStr("s1").concat(SomeStr("s2"))
  NoneStr.concat(SomeStr("s2"))
  SomeStr("s1").concat(NoneStr)
  NoneStr.concat(NoneStr)
}
