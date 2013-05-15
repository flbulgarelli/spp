package pparser.ast

import pparser._

sealed trait ASTElement
case class Op(operator: PredicateOperator, arg0: ASTElement, arg1: ASTElement) extends ASTElement
case class Keyword(keyword: String, args: ASTElement*) extends ASTElement
case class And(arg0: ASTElement, arg1: ASTElement) extends ASTElement
case class Or(arg0: ASTElement, arg1: ASTElement) extends ASTElement
case class NumberLit(value: BigDecimal) extends ASTElement
case class StringLit(value: String) extends ASTElement
case class Var(routes: String*) extends ASTElement {
  override def toString() = routes.mkString(".")
}
