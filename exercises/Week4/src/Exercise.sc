//All code for week 4 exercises can be found here

/*REPL*/
val value =17
val value2 = "ABCD1234"
println(value2)
val value3 = 15.56
println(value3)
/*Expressions*/
val sky = "Sunny"
val temperature = 90.toDouble
if (sky=="Sunny"&&temperature>80) "true" else "false"
if (sky=="Sunny"||sky=="Part Cloudy"&&temperature>80) "true" else "false"
if (sky=="Sunny"||sky=="Part Cloudy"&&temperature>80||temperature<20) "true" else "false"
val celcius = (temperature-32)*5/9
val fahrenheit = (celcius*9/5)+32
/*Methods*/
//Question 1
def getSquared(number:Int): Double ={
       number*number
}
val a = getSquared(3)
assert(getSquared(3)==9)
val b = getSquared(6)
assert(getSquared(6) == 36)
val c = getSquared(5)
assert(getSquared(5)==25)
//Question 2
def isArg1GreaterThanArg2(arg1:Double,arg2:Double):Boolean={
  if(arg1>arg2)true else false
}
val t1 =  isArg1GreaterThanArg2(4.1,4.12)
assert (t1==false)
val t2 = isArg1GreaterThanArg2(2.1,1.2)
assert(t2==true)
//Question 3
def manyTimesString(arg1:String,arg2:Int):String={
  arg1*arg2
}
val m1 = manyTimesString("abc",3)
assert("abcabcabc"=="abcabcabc","This is not correct")
val m2 = manyTimesString("123",2)
assert("123123"==m2,"This is not correct")
/*Classes and Objects*/
val r = 1 to 10
println(r.step)
val r2 = 1 to 10 by 2
println(r2.step)
object s1{
  val name: String = "Sally"

  def equals (arg1:String): Unit ={
    if(name == arg1) {
      "s1 and s2 are equal"}
    else {
      "s1 and s2 are not equal"
    }
  }
}
object s2{
  val name: String = "Sally"
}
s1.equals(s2)
/*Creating classes*/
class Hippo{}
class Lion{}
class Tiger{}
class Giraffe{}
class Monkey{}
val hippo1 = new Hippo
val lion1 = new Lion
val tiger1 = new Tiger
val giraffe1 = new Giraffe
val monkey1  = new Monkey
println (hippo1)
println (lion1)
println (tiger1)
println (giraffe1)
println (monkey1)
val lion2 = new Lion
val giraffe2 = new Giraffe
val giraffe3 = new Giraffe
println (lion2)
println (giraffe2)
println (giraffe3)
//they differ by each having a unique ugly number
/*Methods inside classes*/
class Sailboat{
  def raise(): String = {
    print("Sails raised")
    "Sails raised"
  }
  def lower(): String = {
    print("Sails lowered")
    "Sails lowered"
  }
  def signal(): String = {
    val flare = new Flare
    val f1 = flare.light()
    return f1
  }
}
class Motorboat{
  def on(): String = {
    print("Motor on")
    "Motor on"
  }
  def off(): String = {
    print("Motor off")
    "Motor off"
  }
  def signal(): String = {
    val flare = new Flare
    val f1 = flare.light()
    return f1
  }
}
val sailboat = new Sailboat
val r4 = sailboat.raise()
assert(r4 == "Sails raised", "Expected Sails raised, Got " + r4)
val r5 = sailboat.lower()
assert(r5 == "Sails lowered", "Expected Sails lowered, Got " + r5)
val motorboat = new Motorboat
val s3 = motorboat.on()
assert(s3 == "Motor on", "Expected Motor on, Got " + s3)
val s4 = motorboat.off()
assert(s4 == "Motor off", "Expected Motor off, Got " + s4)
class Flare{
  def light(): String = {
    "Flare used!"
  }
}
val flare = new Flare
val f1 = flare.light
assert(f1 == "Flare used!", "Expected Flare used!, Got " + f1)
val sailboat2 = new Sailboat
val signal = sailboat2.signal()
assert(signal == "Flare used!", "Expected Flare used! Got " + signal)
val motorboat2 = new Motorboat
val flare2 = motorboat2.signal()
assert(flare2 == "Flare used!", "Expected Flare used!, Got " + flare2)
/*Fields in classes*/
class Cup {
  var percentFull = 0
  val max = 100
  val min = 0
  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    }
    else if (percentFull<min){
      percentFull=min
    }
    print("i am "+percentFull+" percent full")
    percentFull // Return this value
  }
  def set(value:Int):Unit={
    if (value <= max && value >= min)
      percentFull=value
    else if(value>max)
      percentFull=max
    else
      percentFull=min
  }
  def get():Int={
    percentFull
  }
}

val cup = new Cup
cup.add(45)
cup.add(-15)
cup.add(-50)

cup.percentFull = 56

/*Vectors*/
val vec1 = Vector(3,2,1)
val vec4 = Vector(4.0,5.0,6.0)
val vec2 = Vector("a","b","c")
val veccomb = Vector(vec1,vec2)
val vec3 = Vector("The"," dog"," visited"," the"," fire"," station")
var sentence = new String()
for (i <- 0 to vec3.length-1){
  val currentword = vec3(i)
  sentence = sentence.concat(currentword)
}
sentence.toString()

vec1.sum
vec1.max
vec1.min

vec4.sum
vec4.max
vec4.min

val myVector1 = Vector(1,2,3,4,5,6)
val myVector2 = Vector(1,2,3,4,5,6)
//myVector1 is myVector2
