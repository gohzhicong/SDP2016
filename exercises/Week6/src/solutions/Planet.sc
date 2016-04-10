import patternmatching.AtomicTest._
/**
  * Created by gohzh on 10/04/2016.
  */
class Planet (val name: String, val description: String,val moons:Int=0) {

  def hasMoon:Boolean={
    if(moons==0){false}
    else{true}
  }
}

val p = new Planet(name = "Mercury",
description = "small and hot planet", moons = 0)
p.hasMoon is false

val earth = new Planet(moons = 1, name = "Earth",
  description = "a hospitable planet")
earth.hasMoon is true

//did not need to change code
