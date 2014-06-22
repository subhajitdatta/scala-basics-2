package taxassignment


object ItemTypeTaxTypeMapping {

  val map : Map[ItemType, List[Tax]] = Map(
    NormalItem    ->  List(SalesTax),
    ImportedItem  ->  List(SalesTax, ImportDutyTax)
  )

}
