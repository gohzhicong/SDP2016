package mastermind

class Mastermind (showCode: Boolean) extends GameAbstractImpl(showCode) {

  val colours = new Colours

  override def runGames: Unit ={
    outputMessage("Wellcome to Mastermind")
    //copy and past instructions?
    val secretCode = randomiser(colours.allAvailableColours, maxLength)
    outputMessage("Generating Secret Code ... ")
    for (i <- 1 to maxAttempts) {
      if (showCode) outputMessage(secretCode)
      outputMessage("You have " + (maxAttempts - i) + " attempts left")
      val userInput = prompt("Enter guess: ")
      outputResponse(userInput)

    }


  }
  def outputResponse(userInput:String): Unit = {
    userInput.length match {
      case n if n < maxLength => outputMessage("Insufficient Pegs! Input should have " + maxLength + " pegs")
      case n if n > maxLength => outputMessage("Too Many Pegs! Input should have " + maxLength + " pegs")
      case _ => validateColours(userInput)
    }
  }

  def validateColours(userInput:String): Unit = {
    var errors = false
    for (c <- userInput){
      if(!colours.isValid(c)){
        outputMessage(c+" is not a valid colour. Please enter colours from "+colours.allAvailableColours)
        errors=true
      }
    }
    if (!errors)
      calculatePegs(userInput)
  }

  def calculatePegs(userInput:String): Unit = {


  }
  /*
   1) intro - get from output class
   2) generate secret code length & color bank to be specified by constructor
   3) get user input
   4) validate user input fro length and applicability
     a) if invalid, return msg from output class to state valid colors and valid length
   5) calculate number and color of output pegs
   6) output the peg colours
   7) count increase where max count specified in constructor
   8) loop back to 3 for next guess until count get to max count
   9) do you want a new game. if Yes loop back to 2 if no quit

    *
    */
  /*: Unit = {
   // print(Output.welcomemessage)
    println("Generating Secret Code")
    println("Type in the characters for your guess and press enter.")

  }*/
  /*
  def prompt(): Unit = {
    processInput(readLine("Enter guess: "))
  }

  def processInput (userinput: String)={
    userinput.length match{
      case n if n < maxLength => Output.errorMessage("Insufficient Pegs! Input should have "+ maxLength +" pegs")
    }



  }
*/
}/**
 * Created by zgoh01 on 13/02/2016.
 */

