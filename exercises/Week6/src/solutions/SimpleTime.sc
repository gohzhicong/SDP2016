import patternmatching.AtomicTest._
/**
  * Created by gohzh on 10/04/2016.
  */
class SimpleTime (val hours: Int, val minutes: Int) {
}
class SimpleTime2 (val hours: Int, val minutes: Int =0) {
}
val t = new SimpleTime(hours=5, minutes=30)
t.hours is 5
t.minutes is 30

val t2 = new SimpleTime2(hours=5)
t2.hours is 5
t2.minutes is 0

