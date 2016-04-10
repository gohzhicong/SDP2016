import patternmatching.AtomicTest._

class ClothesWasher(modelName: String, capacity: Double) {

  def this(modelName: String) = {
    this(modelName, 2)
  }
  def this(capacity: Double) = {
    this("Unknown", capacity)
  }
  def this() = {
    this("Unknown", 2)
  }
}

class ClothesWasher2(val modelName: String="Unknown", val capacity: Double=2) {
}

object ClothesWasherTest extends App {

  val washer1 = new ClothesWasher2
  washer1.capacity is 2D
  washer1.modelName is "Unknown"

  val washer2 = new ClothesWasher2("AllInOne")
  washer2.capacity is 2D
  washer2.modelName is "AllInOne"

  val washer3 = new ClothesWasher2(capacity =3.6D)
  washer3.capacity is 3.6D
  washer3.modelName is "Unknown"


}