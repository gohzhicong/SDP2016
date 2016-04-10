package forecast

import patternmatching.AtomicTest._


object MyForecastTest extends App {
  forecast(100) is "Sunny"
  forecast(80) is "Mostly Sunny"
  forecast(50) is "Partly Sunny"
  forecast(20) is "Mostly Sunny"
  forecast(0) is "Cloudy"
  forecast(15) is "Unknown"

  def forecast(temp: Int): String = {
    temp match {
      case 100 => "Sunny"
      case 80 => "Mostly Sunny"
      case 50 => "Partly Sunny"
      case 20 => "Mostly Cloudy"
      case 0 => "Cloudy"
      case _ => "Unknown"
    }
  }
  val sunnyData = Vector (100,80,50,20,0,15)
  for(x<-0 to sunnyData.length-1){
  val datalocation = sunnyData(x)
  val weather = forecast(datalocation)
  println (weather)
  }
}


