
object D {

  object @@ {
    def unapply(s: String): Option[(String, String)] = s.split("@") match {
      case Array(pre, post) => Some((pre, post))
      case _                => None
    }

    def apply(pre: String, post: String): String = s"$pre@$post"
  }

  @@("mushtaq", "tw.com")

  "mushtaq@tw.com" match {
    case "sandeep" @@ post     => "sss"
    case _ @@ "tw.com"    => "yyy"
    case x             => x
  }
}
