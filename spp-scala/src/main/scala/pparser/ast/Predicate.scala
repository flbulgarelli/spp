package pparser.ast

import pparser.Operator

sealed trait Predicate
case class Op(operator: Operator, arg0: Any, arg1: Any) extends Predicate
case class Keyword(keyword: String, args: Any*) extends Predicate
case class And(arg0: Predicate, arg1: Predicate) extends Predicate
case class Or(arg0: Predicate, arg1: Predicate) extends Predicate
