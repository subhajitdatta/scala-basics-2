package taxassignment

import org.specs2.mutable._

class ItemBillingTest extends Specification{

  val bookTaxPercentageMap = Map(
    SalesTax      -> 10.8d,
    ImportDutyTax -> 9.4d
  )

  val medicineTaxPercentageMap = Map(
    SalesTax      -> 2.7d,
    ImportDutyTax -> 10.1d
  )

  "A Normal book" should {
    "have billing computed as Rounded Down Sales Tax + the basic book cost" in {
      val book1 = new Book(120.1d, NormalItem, bookTaxPercentageMap)
      book1.billing must beEqualTo(132.1)
    }
  }

  "An Imported book" should {
    "have billing computed as Rounded Down Sales Tax + Rounded Up Import Duty + the basic book cost" in {
      val book2 = new Book(1004d, ImportedItem, bookTaxPercentageMap)
      book2.billing must beEqualTo(1207.0)
    }
  }

  "A Normal medicine" should {
    "have billing computed as Rounded Down Sales Tax + the basic medicine cost" in {
      val medicine1 = new Medicine(503.3d, NormalItem, medicineTaxPercentageMap)
      medicine1.billing must beEqualTo(516.3)
    }
  }

  "An Imported medicine" should {
    "have billing computed as Rounded Down Sales Tax + Rounded Up Import Duty + the basic medicine cost" in {
      val medicine2 = new Medicine(19.3d, ImportedItem, medicineTaxPercentageMap)
      medicine2.billing must beEqualTo(21.3)
    }
  }

}
