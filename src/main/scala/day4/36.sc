import day4.ReverseOrder.RichVal
import top._
import Data._

books foreach println
books.sortBy(b => (b.author.reverseOrder, b.basePrice)) foreach println

