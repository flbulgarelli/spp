package pparser.ast

import pparser._

import scala.collection.mutable.Stack

class ASTBuilder extends EventHandler {

  val predicates = Stack[Predicate]()

  override def keywordPredicate(operation: String, arg0: Any, arg1: Any, arg2: Any) =
    predicates.push(Keyword(operation, Seq(arg0, arg1, arg2).takeWhile(_ != null) : _*))

  override def operatorPredicate(operation: Operator, arg0: Any, arg1: Any) =
    predicates.push(Op(operation, arg0, arg1))

  override def orPredicate() = mergeWithBinary(Or(_, _))

  override def andPredicate() = mergeWithBinary(And(_, _))

  protected def mergeWithBinary(binary: (Predicate, Predicate) => Predicate) {
    val arg1 = predicates.pop
    val arg0 = predicates.pop
    predicates.push(binary(arg0, arg1))
  }
  
  def build = predicates.pop
}