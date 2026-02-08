package miniscala

object Week2 {
  sealed abstract class Nat
  case object Zero extends Nat
  case class Succ(n: Nat) extends Nat

  type Var = String
  sealed abstract class VarEnv
  case object NilVarEnv extends VarEnv
  case class ConsVarEnv(x: Var, i: Int, rest: VarEnv) extends VarEnv

  @main
  def test(): Unit = {
    val test1 = Cons(2, Cons(5, Cons(10, Nil)))
    println(square(test1))
    println(ordered(test1))
    println(odd(test1))

    val test2 = Succ(Succ(Succ(Zero)))
    val test3 = Succ(Zero)
    println(decode(test2))
    println(encode(10))

    //
    println("3 times 10")
    println(decode(mult(encode(3), encode(10))))
  }

  def square(x: IntList): IntList = x match {
    case Nil => Nil
    case Cons(x, xs) => Cons(x * x, square(xs))
  }

  def ordered(x: IntList): Boolean = x match {
    case Nil => true
    case Cons(_, Nil) => true
    case Cons(x, xs @ Cons(y, _)) => {
      x <= y && ordered(xs)
    }
  }

  def odd(x: IntList): IntList = x match {
    case Nil => Nil
    case Cons(x, y) => {
      if (x % 2 != 0) Cons(x, odd(y))
      else odd(y)
    }
  }

  def toString(xs: IntList): String = xs match {
    case Nil => ""
    case Cons(x, Nil) => s"$x"
    case Cons(x, xs) => s"$x, ${toString(xs)}"
  }

  // 26
  def decode(n: Nat): Int = n match{
    case Zero => 0
    case Succ(n) => 1 + decode(n)
  }

  def encode(i: Int): Nat = i match {
    case 0 => Zero
    case i if i > 0 => Succ(encode(i - 1))
  }

  def add(a: Nat, b: Nat): Nat = a match {
    case Zero => b
    case Succ(n) => Succ(add(n, b))
  }

  def mult(a: Nat, b: Nat): Nat = a match {
    case Zero => Zero
    case Succ(n) => add(mult(n, b), b)
  }

  def power(a: Nat, b: Nat): Nat = b match{
    case Zero => Succ(Zero)
    case Succ(n) => mult(power(a, n), a)
  }

  // 25
  def varEnvToMap(env: VarEnv): Map[Var, Int] = env match {
    case NilVarEnv => Map()
    case ConsVarEnv(x, i, rest) => varEnvToMap(rest) + (x -> i)
  }

  /*
  def mapToVarEnv(env: Map[Var, Int]): VarEnv = {
    for((x,y) <- env){
       
    }
  }*/
}