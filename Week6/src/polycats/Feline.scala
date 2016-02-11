package polycats

sealed trait Feline{
  def dinner: Food
}
final case class Lion() extends Feline{
  def dinner: Food=Antelope
}
final case class Tiger() extends Feline{
  def dinner: Food=Antelope
}
final case class Panther() extends Feline{
  def dinner: Food=Antelope
}
final case class Cat(FavouriteFood:String) extends Feline{
  def dinner: Food=Antelope
}

sealed trait Food
final case object Antelope extends Food
final case object TigerFood extends Food
final case object Humans extends Food
final case object CatFood(food: String) extends Food






/**
 * Created by zgoh01 on 11/02/2016.
 */

