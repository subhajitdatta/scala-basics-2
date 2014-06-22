package taxassignment


trait TaxableItem {
  val cost: Double
  val itemType: ItemType
  val taxPercentages: Map[Tax, Double]

  def billing: Double = {
    val applicableTaxes = ItemTypeTaxTypeMapping.map.getOrElse(itemType, List())

    val taxAmount = applicableTaxes.map(t => {
      val taxPercentage = taxPercentages.getOrElse(t, 0d)
      t.compute(taxPercentage, cost)
    }).foldLeft(0d)(_ + _)

    cost + taxAmount
  }

}

class Book(val cost: Double, val itemType: ItemType, val taxPercentages: Map[Tax, Double]) extends TaxableItem

class Medicine(val cost: Double, val itemType: ItemType, val taxPercentages: Map[Tax, Double]) extends TaxableItem

