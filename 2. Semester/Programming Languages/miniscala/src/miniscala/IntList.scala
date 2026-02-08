package miniscala

sealed abstract class IntList
case object Nil extends IntList
case class Cons(x: Int, xs: IntList) extends IntList
