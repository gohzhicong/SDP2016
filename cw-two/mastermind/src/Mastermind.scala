package mastermind

import scala.util.matching.Regex


class Mastermind (showCode: Boolean) extends GameAbstractImpl(showCode) {

  val colours = new Colours
  val secretCode = randomiser(colours.allAvailableColours, maxLength)
  var successfulAttempts = 0
  var guessHistory = Array.fill[String](maxAttempts+1)("....")

  guessHistory(0) = ".... Secret Code"

  override def runGames: Unit = {

    println(s"Welcome to Mastermind.\n\nThis is a text version of the classic board game Mastermind.\nThe computer will think of a secret code.\nThe code consists of $maxLength colored pegs.\nThe pegs may be one of ${colours.getColorsAsString()}.\nA color may appear more than once in the code.\n\nYou try to guess what colored pegs are in the code and what order they are in\nAfter making a guess the result will be displayed.\nA result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\nFor each peg in the guess that is the correct color, but is out of position, you get a white peg.\n\nOnly the first letter of the color is displayed. B for Blue, R for Red, and so forth.\nWhen entering guesses you only need to enter the first character of the color as a capital letter.\n")

    println(s"You have $maxAttempts to guess the answer or you lose the game.\n")
    outputMessage("Generating Secret Code ... ")

    while (successfulAttempts < maxAttempts) {
      if (showCode) outputMessage("The secret code is " + secretCode)
      outputMessage("You have " + (maxAttempts - successfulAttempts) + " attempts left")
      val userInput = prompt("Enter guess: ")

      if (isValidInput(userInput)) {
        successfulAttempts += 1
        val results = calculatePegs(userInput)
        var outputString = userInput + " Result:"

        var counter = 0
        while (counter < results._1) {
          outputString += " Black"
          counter += 1
        }
        counter = 0
        while (counter < results._2) {
          outputString += " White"
          counter += 1
        }
        guessHistory(successfulAttempts) = outputString

        if (results._1 == secretCode.length) {
          outputFinalHistory(guessHistory, successfulAttempts)
          println("\n" + "You solved the puzzle! Good job.")
          return
        } else {
          outputHistory(guessHistory)
        }
      }
    }
    println("You did not solve the puzzle. Too bad.")
  }

  def isValidInput(userInput:String): Boolean = {
    userInput.length match {
      case n if n < maxLength => {
        outputMessage("Insufficient Pegs! Input should have " + maxLength + " pegs")
        false
      }
      case n if n > maxLength => {
        outputMessage("Too Many Pegs! Input should have " + maxLength + " pegs")
        false
      }
      case _ => validateColours(userInput)
    }
  }

  def validateColours(userInput:String): Boolean = {
    var valid = true

    for (c <- userInput){
      if(!colours.isValid(c)){
        outputMessage(c + " is not a valid colour. Please enter colours from "+colours.allAvailableColours)
        valid = false
      }
    }
    valid
  }

  def calculatePegs(userInput:String) = {
    // LOOP THROUGH EACH CHAR IN THE STRING
    var secretCodeTemp = secretCode
    var userInputExclBlacks = userInput
    var blackCount = 0
    var whiteCount = 0
    var index = 0

    for (c <- userInput) {
      if (secretCode(index) == c) {
        blackCount += 1
        val splitStart = Math.max(index, 0).toInt
        val splitEnd = Math.min(index, secretCodeTemp.length - 1).toInt
        val firstPart = secretCodeTemp.substring(0, splitStart)
        val secondPart = "_" + secretCodeTemp.substring(splitEnd + 1)
        secretCodeTemp = firstPart + secondPart
        val firstPartUserInput = userInputExclBlacks.substring(0, splitStart)
        val secondPartUserInput = "_" + userInputExclBlacks.substring(splitEnd + 1)
        userInputExclBlacks = firstPartUserInput + secondPartUserInput
      }
      index += 1
    }

    for (c <- userInputExclBlacks) {
      if (secretCodeTemp.contains(c) && c != '_') {
        val regex = c.toString.r
        secretCodeTemp = regex.replaceFirstIn(secretCodeTemp, "_")
        println("secretCodeTemp: " + secretCodeTemp)
        whiteCount += 1
      }
    }
    (blackCount, whiteCount)
  }
}