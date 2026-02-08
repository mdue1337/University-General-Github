package miniscala

import miniscala.Ast.*
import Interpreter.trace
import miniscala.parser.Parser

/**
  * Unparser for MiniScala.
  */
object Unparser {
  def simplify(e: Exp): Exp = e match{
    // Addition
    case BinOpExp(IntLit(0), PlusBinOp(), r) => simplify(r)
    case BinOpExp(l, PlusBinOp(), IntLit(0)) => simplify(l)

    // Substraction
    case BinOpExp(l, MinusBinOp(), IntLit(0)) => simplify(l)
    case BinOpExp(IntLit(0), MinusBinOp(), r) => UnOpExp(NegUnOp(), simplify(r))

    // Multiplication
    case BinOpExp(IntLit(0), MultBinOp(), _) => IntLit(0)
    case BinOpExp(_, MultBinOp(), IntLit(0)) => IntLit(0)
    case BinOpExp(IntLit(1), MultBinOp(), r) => simplify(r)
    case BinOpExp(l, MultBinOp(), IntLit(1)) => simplify(l)

    // Division
    case BinOpExp(l, DivBinOp(), IntLit(1)) => simplify(l)

    // Modulo
    case BinOpExp(IntLit(0), ModuloBinOp(), IntLit(r)) if r != 0 => IntLit(0)
    case BinOpExp(_, ModuloBinOp(), IntLit(1)) => IntLit(0)

    // Max
    case BinOpExp(l, MaxBinOp(), r) if l == r => simplify(l)
    case BinOpExp(IntLit(a), MaxBinOp(), IntLit(b)) => IntLit(math.max(a, b))

    // Unary operator
    case UnOpExp(op, exp) => UnOpExp(op, simplify(exp))

    // Block expressions
    case BlockExp(vals, exp) => {
      BlockExp(
        vals.map(v => v.copy(exp = simplify(v.exp))),
        simplify(exp)
      )
    }

    // General recursion & base cases
    case BinOpExp(l, op, r) => BinOpExp(simplify(l), op, simplify(r))
    case i @ IntLit(_) => i
    case v @ VarExp(_) => v
  }


  /**
    * Unparse function.
    * Used for all kinds of AstNode objects, including Exp objects (see Ast.scala).
    */
  def unparse(n: AstNode): String = n match{
    case (e: Exp) => {
      e match {
        case BinOpExp(leftexp, binop, rightexp) => {
          trace("BinOpExp")
          val left = unparse(leftexp)
          val op = unparse(binop)
          val right = unparse(rightexp)
          s"$left $op $right"
        }
        case UnOpExp(op, exp) => {
          trace("UnOpExp")
          val opval = op
          var expval = exp
          s"$opval $expval"
        }
        case IntLit(c) =>{
          trace("IntLit")
          c.toString
        }
        case VarExp(x) =>{
          trace("VarExp")
          s"$x"
        }
        case BlockExp(vals, exp) => {
          trace("BlockExp")
          var str = ""
          for (vDecl <- vals) {
            str += s"{val = ${vDecl.x} = ${unparse(vDecl.exp)}; "
          }
          str += unparse(exp)
          for (_ <- vals){
            str += "}"
          }
          str
        }
      }
    }
    case (op: BinOp) => op match{
      case PlusBinOp() => {
        trace("Addition")
        "+"
      }
      case MinusBinOp() => {
        trace("Subtraction")
        "+"
      }
      case MultBinOp() => {
        trace("Multiplication")
        "*"
      }
      case DivBinOp() => {
        trace("Division")
        "/"
      }
      case ModuloBinOp() => {
        trace("Modulo")
        "%"
      }
      case MaxBinOp() => {
        trace("max")
        "max"
      }
    }
    case (uop: UnOp) => uop match{
      case NegUnOp() => {
        trace("NegUnOp")
        "-"
      }
    }
  }
}
