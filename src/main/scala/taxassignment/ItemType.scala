package taxassignment

sealed abstract class ItemType
case object NormalItem extends ItemType
case object ImportedItem extends ItemType