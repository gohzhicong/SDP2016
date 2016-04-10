
sealed trait LinkedList[A] {
  def head: A

  def tail: LinkedList[A]

  def length: Int =
    this match {
      case Pair(head, tail) => 1 + tail.length
      case Empty() => 0
    }

  def apply(index: Int): A =
    this match {
      case Pair(head, tail) =>
        if (index == 0) head
        else
          tail(index - 1)
      case Empty() =>
        throw new IndexOutOfBoundsException
    }
}

final case class Pair[A](head: A,  tail: LinkedList[A]) extends LinkedList[A]

final case class Empty[A]() extends LinkedList[A]{}

object Main extends App {
  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Empty())))
  assert(list.isInstanceOf[LinkedList[Int]])
  assert(list.head == 1)
  assert(list.tail.head == 1)
  assert(list.tail.tail == Pair(3, Empty()))

}

  /* Created by gohzh on 10/04/2016.
  */

