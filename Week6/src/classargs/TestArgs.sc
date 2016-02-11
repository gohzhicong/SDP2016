package classargs

import patternmatching.AtomicTest._

class Family(names: String*){
def familySize():Int= {
  var count = 0
  for (str <- names) {
    count = count + 1
  }
  count
  }

}

class FlexibleFamily(mom: String,dad:String, kids: String*){
  def familySize():Int={
    var count=2//
    for (k<-kids){
      count=count+1
    }
    count
  }
}
object TestArgs extends App{
  val family1 = new Family("Mum","Dad","Sally","Dick")
  family1.familySize() is 4
}

