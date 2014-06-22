package taxassignment


trait Rounding {
  def round(v: Double): Double
}

class RoundUp extends Rounding {
  def round(v: Double): Double = v.ceil
}

class RoundDown extends Rounding {
  def round(v: Double): Double = v.floor
}