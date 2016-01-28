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
//Question 1

val r = 1 to 10
println(r.step)
val r2 = 1 to 10 by 2
println(r2.step)

object s1{
  val name: String = "Sally"

  def equals (arg1:String): Unit ={
    if(name == arg1) "s1 and s2 are equal" else "s1 and s2 are not equal"
  }
}

object s2{
  val name: String = "Sally"
}

s1.equals(s2)
