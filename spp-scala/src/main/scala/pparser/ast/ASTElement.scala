package pparser.ast

import pparser.Operator

sealed trait ASTElement
case class Op(operator: Operator, arg0: Any, arg1: Any) extends ASTElement
case class Keyword(keyword: String, args: ASTElement*) extends ASTElement
case class And(arg0: ASTElement, arg1: ASTElement) extends ASTElement
case class Or(arg0: ASTElement, arg1: ASTElement) extends ASTElement
case class Num(value: BigDecimal) extends ASTElement
case class Str(value: String) extends ASTElement
case class Var(routes: String*) extends ASTElement {
  override def toString() = routes.mkString(".")
}
