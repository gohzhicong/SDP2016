package mastermind

import scala.collection.mutable.ListBuffer

class Colours {
  private val colourBank = "BGOPRY"

  def allAvailableColours: String = {
    colourBank
  }

  def isValid(colourToBeCompared: Char): Boolean ={
    colourBank.contains(colourToBeCompared)
  }

  def getcolourName(c: Char): String = {
    c match {
      case 'B' => "blue"
      case 'G' => "green"
      case 'O' => "orange"
      case 'P' => "purple"
      case 'R' => "red"
      case 'Y' => "yellow"
    }
  }

  def getAllcolours: ListBuffer[String] = {
    var colourArray = new ListBuffer[String]()
    for (c <- colourBank) {
      colourArray += getcolourName(c)
    }
    colourArray
  }

  def getcoloursAsString: String = {
    var colourMsg: String = ""
    var i = 0
    for (c <- getAllcolours) {
      if (i == colourBank.length) {
        colourMsg += "or "
      }
      colourMsg += c
      if (i < colourBank.length - 1) {
        colourMsg += ", "
      }
      i += 1
    }
    colourMsg
  }
}


