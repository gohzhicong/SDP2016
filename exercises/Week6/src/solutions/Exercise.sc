import patternmatching.AtomicTest._

// Return type is inferred:
def inferred(c1: Char, c2: Char, c3: Char) = {
  Vector(c1, c2, c3)
}
// Explicit return type:
def explicit(c1: Char, c2: Char, c3: Char):
Vector[Char] = {
  Vector(c1, c2, c3)
}

//Explicit modified to get explicitDouble
def explicitDouble(c1: Double, c2: Double, c3: Double):
Vector[Double] = {
  Vector(c1, c2, c3)
}

//Explicit modified to get explicitList
def explicitList(c3: Vector[Double]): List[Double] = {
  var out = List(c3(c3.length-1))
  for(x<-2 to c3.length) {
    out = c3(c3.length-x) :: out
  }
  out
}
def explicitSet(c3: Vector[Double]): Set[Double] = {
  var out = Set(c3(0))
  for(x<-1 to c3.length-1) {
    out = out+c3(x)
  }
  out
}
inferred('a', 'b', 'c') is "Vector(a, b, c)"
explicit('a', 'b', 'c') is "Vector(a, b, c)"

explicitDouble(1.0, 2.0, 3.0) is Vector(1.0, 2.0, 3.0)

explicitList(Vector(10.0, 20.0)) is List(10.0, 20.0)
explicitList(Vector(1, 2, 3)) is List(1.0, 2.0, 3.0)

explicitSet(Vector(10.0, 20.0, 10.0)) is Set(10.0, 20.0)
explicitSet(Vector(1, 2, 3, 2, 3, 4)) is Set(1.0, 2.0, 3.0, 4.0)


