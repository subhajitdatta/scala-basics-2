package day4

import language.implicitConversions

object StringExtensions {

  implicit class RichString(val str: String) extends AnyVal {
    def hello = s"Hello $str"
    def toUpperCase = "111"
  }


  implicit class RichString1(str: String) {
    def goodMorning = s"Good morning $str"
  }

}
