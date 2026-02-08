package miniscala

import miniscala.parser.Parser
import miniscala.Unparser.*
import miniscala.Ast.*

object Week1 {
  def main(args: Array[String]): Unit = {
    val a1 = BinOpExp(IntLit(2), MinusBinOp(), IntLit(10))
    val a2 = Parser.parse("2-10")
    println("The AST's are equal: " + (a1 == a2))
    
    val ast = Parser.parse("2*((-10)+5)")
    println("Unparsed AST: " + ast);


    val a3 = Parser.parse("{ val a = 42;\n  { val b = b - a;\n    { val c = b;\n      c * b } } }")
    val a3unparsed = Unparser.unparse(a3)
    println(a3)
    println(a3unparsed)

    val test = Unparser.simplify(simplify(a3))
    println(test)
  }
}
