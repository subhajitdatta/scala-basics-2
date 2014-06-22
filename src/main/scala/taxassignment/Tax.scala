package taxassignment


trait Tax {
  val roundingStrategy:Rounding
  def compute(percentage: Double, basePrice: Double): Double = roundingStrategy.round(percentage * basePrice / 100)
}

object SalesTax extends Tax {
  val roundingStrategy:Rounding = new RoundDown
}

object ImportDutyTax extends Tax {
  val roundingStrategy:Rounding = new  RoundUp
}
