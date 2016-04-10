import patternmatching.AtomicTest._

//all code for exercises from week 7 found below

val v = Vector(1, 2, 3, 4)
v.map(n => n + 1) is Vector(2, 3, 4, 5)

val v2 = Vector(1, 2, 3, 4)
v2.map(n=>(n*11)+10) is Vector(21, 32, 43, 54)
for (i<-0 to v2.length-1){
  val added = (v2(i)*11)+10
  v2.updated(i,added)
}
v2 is Vector(21, 32, 43, 54)

val v4 = Vector(1, 2, 3, 4)
val v5 = Vector(1, 2, 3, 4)
v4.map(n => n + 1) is Vector(2, 3, 4, 5)
for (i<-0 to v5.length-1){
  val added = v4(i)+1
  v5.updated(i,added)
}

val v6 = Vector(1, 10, 100, 1000)
v6.reduce((sum, n) => sum + n) is 1111
var counter = 0
for (i<-0 to v6.length-1){
  counter = counter + v6(i)
}

def sumIt(input: Int*):Int = {
  val output = input.reduce((sum, n) => sum + n)
  output
}
sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195


sealed trait Shape {
  abstract def sides: Int
  abstract def perimeter: Double
  abstract def area: Double
  abstract def color: Color
}
case class Circle(radius: Double, color: Color) extends Shape {
  val sides = 0
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

trait Rectangular extends Shape {
  def width: Double
  def height: Double
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class Rectangle(width: Double, height: Double, color: Color) extends Rectangular {
}

case class Square(size: Double, color: Color) extends Rectangular {
  val width = size
  val height = size
}

sealed trait Color {
  def red: Double
  def green: Double
  def blue: Double

  def isLight = (red + green + blue) / 3.0 > 0.5

  def isDark = !isLight
}

final case object Red extends Color {
  val red = 1.0
  val green = 0.0
  val blue = 0.0
}

final case object Yellow extends Color {
  val red = 1.0
  val green = 1.0
  val blue = 0.0
}

final case object Pink extends Color {
  val red = 1.0
  val green = 0.75
  val blue = 0.79
}

final case class CustomColour (val red : Double,val green : Double,val blue : Double) extends Color


object Draw{
  def apply(theShape: Shape):String={
    theShape match {
      case Circle(radius, color) =>
        s"A ${Draw(color)} circle of radius ${radius}cm"
      case Rectangle(width, height, color) =>
        s"A ${Draw(color)}rectangle of width ${width}cm and height ${height}cm"
      case Square(size, color) =>
        s"A ${Draw(color)}square of size ${size}cm"
    }
  }
  def apply(color: Color): String = color match {
    // We deal with each of the predefined Colors with special cases:
    case Red => "red"
    case Yellow => "yellow"
    case Pink => "pink"
    case color => if (color.isLight) "light" else "dark"
  }
}

sealed trait divisionResult

object Divide{
  def apply(i1: Int, i2: Int): Double={
      i1/i2
  }
}