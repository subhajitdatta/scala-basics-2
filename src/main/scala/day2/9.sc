type T <: String

object D {


  trait C { me: T =>

  }

  trait A { me: B =>
    def m2 = m1 + 10
  }

  trait B { me: A =>
    def m1 = 99
  }

  new A with B
}
