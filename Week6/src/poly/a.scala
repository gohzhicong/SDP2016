package poly

sealed trait A {
  def foo:String="It's a A!"
}
final case class B() extends A{
  override def foo: String ="its a B" //need to do override else doesn't work coz foo is already defined in A
}
final case class C() extends A{
  override def foo: String ="its a C" //need to do override else doesn't work
}

object TestMyPoly extends  App{
  val anA: A=B()
  println(anA.foo)
  val anotherA = C()
  println(anotherA.foo)
}
/**
 * Created by zgoh01 on 11/02/2016.
 */

