package mastermind

import scala.io.StdIn._


object MastermindDriver {
  def main(args: Array[String]) {
    var g: Game = Factory.getInstance(classOf[Game], true)

    g.runGames
    g = Factory.getInstance(classOf[Game], false)

    Iterator.continually(readLine("Enter Y for another game or anything else to quit: ")).takeWhile(_ == "Y").foreach {
      msg => g.runGames
    }
  }
}
