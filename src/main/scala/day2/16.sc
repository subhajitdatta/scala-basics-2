
def concat(s1: Option[String], s2: Option[String]): Option[String] = (s1, s2) match {
  case (None, _) => s2
  case (_, None) => s1
  case (Some(v1), Some(v2)) => Some(v1 + v2)
}

concat(Some("s1"), Some("s2"))
concat(None, Some("s2"))
concat(Some("s1"), None)
concat(None, None)

