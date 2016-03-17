package mastermind

import scala.io.StdIn._


object MastermindDriver {
  def main(args: Array[String]) {
    var g: Game = Factory.getInstance(classOf[Game], true)

    // Output the introductory text and rules for the game
    g.showIntro

    // Run the game once, with "show code" enabled
    g.runGames

    // Get a new instance of the game with "show code" disabled
    g = Factory.getInstance(classOf[Game], false)

    // Offer the user a choice of another game repeatedly until they enter something other than "Y/y"
    Iterator.continually(readLine("Enter Y for another game or anything else to quit: ")).takeWhile(_.toUpperCase == "Y").foreach {
      msg => g.runGames
    }
  }
}
