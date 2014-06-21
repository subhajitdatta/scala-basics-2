

def While(cond: => Boolean)(body: => Unit): Unit = if(cond) {
  body
  While(cond)(body)
}

var x = 0
While(x < 10) {
  println(x)
  x = x + 1
}
