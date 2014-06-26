import scala.util.matching.Regex


val date: Regex = """(\d+)-(\d+)-(\d+)""".r

val date(day, month, year) = "20-04-2013"

"20-04-2013" match {
  case date(day, month, year) => year
}

val X = 100

{_: Int => 10 }

type T[F[_]] = F[Int]

Option(1): T[Option]

