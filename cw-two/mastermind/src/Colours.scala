package mastermind

import scala.collection.mutable.ListBuffer

class Colours{
  private val colourBank = "BGOPRY"

  def allAvailableColours: String ={
    colourBank
  }

  def isValid(colourToBeCompared: Char): Boolean ={
    colourBank.contains(colourToBeCompared)
  }

  /**
    *
    * six colors: blue, green , orange, purple, red, or yellow
    */
  def getColorName(c: Char): String = {
    c match {
      case 'B' => "blue"
      case 'G' => "green"
      case 'O' => "orange"
      case 'P' => "purple"
      case 'R' => "red"
      case 'Y' => "yellow"
    }
  }

  def getAllColors(): ListBuffer[String] = {
    var colorArray = new ListBuffer[String]()
    for (c <- colourBank) {
      colorArray += getColorName(c)
    }
    colorArray
  }

  def getColorsAsString(): String = {
    var colorMsg: String = colourBank.length + " colors: "
    var i = 0
    for (c <- getAllColors()) {
      if (i == colourBank.length) {
        colorMsg += "or "
      }
      colorMsg += c
      if (i < colourBank.length - 1) {
        colorMsg += ", "
      }
      i += 1
    }
    colorMsg
  }
}


