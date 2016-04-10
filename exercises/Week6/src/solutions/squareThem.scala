package solutions
import patternmatching.AtomicTest._

/**
  * Created by gohzh on 10/04/2016.
  */
class squareThem {
  squareThem(2) is 4
  squareThem(2,4) is 20
  squareThem(1,2,4) is 21

  def squareThem(x: Int*): Int = {
    var square = 0
    for (i <- x) {
      square = square + i * i
    }
    square
  }
}

