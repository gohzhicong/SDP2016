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
val celcius = ((temperature-32)*5/9)
val fahrenheit = (celcius*9/5)+32

/*Methods*/
//Question 1
def getSquared(number:Int): Double ={
      return number*number
}

val a = getSquared(3)
assert(a==3*3)

val b = getSquared(6)
assert(b == 6*6)

val c = getSquared(5)
assert(c==5*5)

//Question 2
def isArg1GreaterThanArg2(arg1:Double,arg2:Double):Boolean={
  val answer = if(arg1>arg2)true else false
  println(answer)
}

val t1 =  isArg1GreaterThanArg2(4.1,4.12)
assert (t1)

val t2 = isArg1GreaterThanArg2(2.1,1.2)
assert(t2)