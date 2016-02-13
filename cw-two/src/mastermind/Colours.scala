package mastermind

class Colours{
  private val colourBank = "BGOPRY"

  def allAvailableColours: String ={
    colourBank
  }

  def isValid(colourToBeCompared: Char): Boolean ={
    colourBank.contains(colourToBeCompared)
  }


}


