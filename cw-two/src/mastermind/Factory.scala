package mastermind

object Factory {
  def getInstance(c: Class[_], b: Boolean): Game = {
    //need to validate that the rquried class is the mastermind/game class
    new Mastermind(b)
  }
}
