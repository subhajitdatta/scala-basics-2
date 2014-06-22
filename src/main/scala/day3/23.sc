
import top._
import Data._

books.filter(_.author == "odersky") foreach println

books.map(_.basePrice).sum

def totalPrice(bs: Seq[Book1]) = bs.map(_.basePrice).sum

books
  .groupBy(_.author)
  .mapValues(bs => totalPrice(bs)) foreach println


books.sortBy(b => (b.author, b.basePrice)) foreach println
books.sortWith(_.author > _.author) foreach println

Seq(10, 2, 3, 4).sorted