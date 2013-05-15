package pparser.ast

import pparser._
import scala.collection.mutable.Stack

class ASTBuilder extends EventHandler {

  val elements = Stack[ASTElement]()

  override def keywordPredicate(operation: String, arity: Int) = {
    val args = for (_ <- 1 to arity)
      yield elements.pop
    elements.push(Keyword(operation, args.reverse : _*))
  }

  override def operatorPredicate(operation: PredicateOperator) =
    mergeWithBinary(Op(operation, _, _))

  override def orPredicate() = mergeWithBinary(Or(_, _))

  override def andPredicate() = mergeWithBinary(And(_, _))

  override def idPredicate() = mergeWithBinary(And(_, _))

  override def operatorExpression(operator: ExpressionOperator) = ???

  override def stringExpression(string: Any) = string match {
    case s: String => elements.push(s)
  }

  override def numberExpression(number: Any) = number match {
    case n: BigDecimal => elements.push(n)
  }

  override def pathExpression(path: Any) = path match {
    case p: Var => elements.push(p)
  }

  override def listExpression(size: Int) = ???

  protected def mergeWithBinary(binary: (ASTElement, ASTElement) => ASTElement) {
    val arg1 = elements.pop
    val arg0 = elements.pop
    elements.push(binary(arg0, arg1))
  }

  def build = elements.pop

}