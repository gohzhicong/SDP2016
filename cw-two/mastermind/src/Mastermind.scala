package mastermind

class Mastermind (showCode: Boolean) extends GameAbstractImpl(showCode) {

  val colours = new Colours
  val secretCode = randomiser(colours.allAvailableColours, maxLength)
  var successfulAttempts = 0
  var guessHistory = Array.fill[String](maxAttempts+1)("....")
  guessHistory(0) = ".... Secret Code"

  def showIntro: Unit = {
    println(s"Welcome to Mastermind.\n\nThis is a text version of the classic board game Mastermind.\nThe computer will think of a secret code.\nThe code consists of $maxLength coloured pegs.\nThe pegs may be one of ${colours.allAvailableColours.length} colours ${colours.getcoloursAsString}.\nA colour may appear more than once in the code.\n\nYou try to guess what coloured pegs are in the code and what order they are in\nAfter making a guess the result will be displayed.\nA result consists of a black peg for each peg you have exactly correct (colour and position) in your guess.\nFor each peg in the guess that is the correct colour, but is out of position, you get a white peg.\n\nOnly the first letter of the colour is displayed. B for Blue, R for Red, and so forth.\nWhen entering guesses you only need to enter the first character of the colour as a capital letter.\n")
    println(s"You have $maxAttempts to guess the answer or you lose the game.\n")
  }

  override def runGames: Unit = {
    println("Generating secret code ....")

    if (showCode) println(s"The secret code is $secretCode")

    while (successfulAttempts < maxAttempts) {
      println(s"\nYou have ${maxAttempts - successfulAttempts} guesses left.\n")
      val userInput = prompt("What is your next guess?\nType in the characters for your guess and press enter.\nEnter guess: ").toUpperCase

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

        if (results._1 == 0 && results._2 == 0) {
          outputString += " No pegs"
        }

        guessHistory(successfulAttempts) = outputString

        if (results._1 == secretCode.length) {
          outputFinalHistory(guessHistory, successfulAttempts)
          println("\nYou solved the puzzle! Good job.")
          return
        } else {
          if (showCode) println(s"\nThe secret code is $secretCode")
          outputHistory(guessHistory)
        }
      }
    }
    println("\nYou did not solve the puzzle. Too bad.")
  }

  def isValidInput(userInput:String): Boolean = {
    userInput.length match {
      case n if n < maxLength => {
        println(s"\nInsufficient Pegs! Input should have $maxLength pegs")
        false
      }
      case n if n > maxLength => {
        println(s"\nToo Many Pegs! Input should have $maxLength pegs")
        false
      }
      case _ => validateColours(userInput)
    }
  }

  def validateColours(userInput:String): Boolean = {
    var valid = true

    for (c <- userInput){
      if(!colours.isValid(c)){
        println(s"$c is not a valid colour. Please enter colours from ${colours.allAvailableColours} (${colours.getcoloursAsString})")
        valid = false
      }
    }
    valid
  }

  def calculatePegs(userInput:String) = {
    var secretCodeTemp = secretCode
    var userInputExclBlacks = userInput
    var blackCount = 0
    var whiteCount = 0
    var index = 0

    // First, count the number of Black pegs to output
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

    // Secondly, count the number of White pegs to output based on the user input excluding any matched colours
    for (c <- userInputExclBlacks) {
      if (secretCodeTemp.contains(c) && c != '_') {
        val regex = c.toString.r
        secretCodeTemp = regex.replaceFirstIn(secretCodeTemp, "_")
        whiteCount += 1
      }
    }

    // Return with counts of both Black and White pegs
    (blackCount, whiteCount)
  }
}