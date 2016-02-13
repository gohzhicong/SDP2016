package mastermind

import scala.io.StdIn._
import scala.io.Source._

trait Game {
  /**
    * Run a one or more game sof mastermind, until the player
    * quits.
  */
  def maxLength:Int = 4
  def maxAttempts: Int = 12


  def runGames

  def outputMessage(message: String) ={
  println(message)
  }

  def randomiser(inputs: String, outputs: Int): String ={
    val r = scala.util.Random
    var outputString : String = ""
    for (i <- 1 to outputs){
      //create a random number which represents the index of the string to select
      val selectedIndex = r.nextInt(inputs.length)//will give a random int between 0 and length-1
      outputString = outputString+inputs.charAt(selectedIndex).toString
    }
    return outputString
  }

  def prompt(promptMessage: String): String = {
    readLine(promptMessage)
  }
}
