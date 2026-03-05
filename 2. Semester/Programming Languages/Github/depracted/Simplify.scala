package miniscala

import miniscala.Ast.*
import miniscala.parser.Parser

object Simplify {
  /** *
   * Simplify Expressions
   * * */
  def simplify(e: Exp): Exp = e match {
    // Addition

    case BinOpExp(IntLit(0), PlusBinOp(), r) => simplify(r)
    case BinOpExp(l, PlusBinOp(), IntLit(0)) => simplify(l)

    // Subtraction
    case BinOpExp(l, MinusBinOp(), IntLit(0)) => simplify(l)
    case BinOpExp(IntLit(0), MinusBinOp(), r) => UnOpExp(NegUnOp(), simplify(r))

    // Multiplication
    case BinOpExp(IntLit(0), MultBinOp(), r) => if (safe(r)) IntLit(0) else BinOpExp(IntLit(0), MultBinOp(), simplify(r)) // If no chance for undefined expression
    case BinOpExp(l, MultBinOp(), IntLit(0)) => if (safe(l)) IntLit(0) else BinOpExp(simplify(l), MultBinOp(), IntLit(0))
    case BinOpExp(IntLit(1), MultBinOp(), r) => simplify(r)
    case BinOpExp(l, MultBinOp(), IntLit(1)) => simplify(l)

    // Division
    case BinOpExp(l, DivBinOp(), IntLit(1)) => simplify(l)

    // Modulo
    case BinOpExp(IntLit(0), ModuloBinOp(), IntLit(r)) if r != 0 => IntLit(0)
    case BinOpExp(_, ModuloBinOp(), IntLit(1)) => IntLit(0)

    // Max
    case BinOpExp(l, MaxBinOp(), r) if simplify(l) == simplify(r) => simplify(l)
    case BinOpExp(IntLit(a), MaxBinOp(), IntLit(b)) => IntLit(math.max(a, b))

    // Unary operator
    case BinOpExp(UnOpExp(_, IntLit(0)), op, r) => simplify(BinOpExp(IntLit(0), op, r))
    case BinOpExp(l, op, UnOpExp(_, IntLit(0))) => simplify(BinOpExp(l, op, IntLit(0)))
    case UnOpExp(op, exp) => UnOpExp(op, simplify(exp))

    // Block expressions
    case BlockExp(vals, defs, exp) => {
      BlockExp(
        vals.map(v => v.copy(exp = simplify(v.exp))),
        simplify(exp)
      )
    }

    // General recursion & base cases
    case BinOpExp(l, op, r) => BinOpExp(simplify(l), op, simplify(r))
    case i@IntLit(_) => i
    case v@VarExp(_) => v
  }

  // Checks if an expression contains division or mod anywhere in it. If so, it is not safe, and returns false
  def safe(e: Exp): Boolean = e match {
    case BinOpExp(_, DivBinOp(), _) => false
    case BinOpExp(_, ModuloBinOp(), _) => false

    case BinOpExp(l, _, r) => safe(l) && safe(r)
    case UnOpExp(_, exp) => safe(exp)
    case BlockExp(_, _, exp) => safe(exp)

    case _ => true
  }

  def main(args: Array[String]): Unit = {
    // Simplify tests
    assert(simplify(Parser.parse("0+42")) == Parser.parse("42"))
    assert(simplify(Parser.parse("42*1")) == Parser.parse("42"))
    assert(simplify(Parser.parse("42-0")) == Parser.parse("42"))
    assert(simplify(Parser.parse("42/1")) == Parser.parse("42"))
    assert(simplify(Parser.parse("(-0)+42")) == Parser.parse("42"))
    assert(simplify(Parser.parse("(-0)*42")) == Parser.parse("0"))
    assert(simplify(Parser.parse("42-(-0)")) == Parser.parse("42"))
    assert(simplify(Parser.parse("42*(-0)")) == Parser.parse("0"))
    assert(simplify(Parser.parse("42 max 42")) == Parser.parse("42"))
    assert(simplify(Parser.parse("(42*1) max 42")) == Parser.parse("42"))
    assert(simplify(Parser.parse("0 % 42")) == Parser.parse("0"))
    assert(simplify(Parser.parse("42 % 1")) == Parser.parse("0"))

    // safe tests
    assert(!safe(Parser.parse("42 % 3")))
    assert(!safe(Parser.parse("42 / 3")))
    assert(!safe(Parser.parse("42 + (3+(4/2))")))
    assert(!safe(Parser.parse("-(3/2)")))
    assert(safe(Parser.parse("42+3")))
    assert(safe(Parser.parse("42-30+40*4")))
  }
}
