package patternmatching

import patternmatching.AtomicTest._

object MyForecastTest extends App{
  forecast(100) is "Sunny"
  forecast(80) is "Mostly Sunny"
  forecast(50) is "Partly Sunny"
  forecast(20)is "Mostly Sunny"
  forecast(0)is "Cloudy"
  forecast(15) is "Unknown"


  val sunnyData =Vector(100, 80, 50, 20, 0, 15)
  for (i <- sunnyData){
    println (forecast(i))
  }


  def forecast(temp:Int): String={
    temp match{
      case 100=>"Sunny"
      case 80=>"Sunny"
      case 50=>"Sunny"
      case 20=>"Sunny"
      case 0=>"Sunny"
      case _=>"Sunny"
    }
    /*
    originial attempt
    if (temp ==100) {"Sunny"}
    else if (temp == 80){ "Mostly Sunny"}
    else if (temp == 50){ "Partly Sunny"}
    else if (temp == 20){ "Mostly Cloudy"}
    else if (temp == 0){ "Cloudy"}
    else "Unknown"*/
  }




}/**
 * Created by zgoh01 on 11/02/2016.
 */

