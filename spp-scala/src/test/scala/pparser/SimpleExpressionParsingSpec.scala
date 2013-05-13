package pparser

import org.scalatest.FunSuite
import pparser.ast.Keyword
import ast._

import Operator._
class SimpleExpressionParsingSpec extends FunSuite with ParsingAssertions {

  test("can parse unary predicates") {
    assertParse("f(x)", Keyword("f", Var("x")))
  }

  test("can parse binary Keyword predicates") {
    assertParse("f(x, y)", Keyword("f", Var("x"), Var("y")))
  }

  test("can parse ternary predicates") {
    assertParse("f(x, y, z)", Keyword("f", Var("x"), Var("y"), Var("z")))
  }

  test("can parse predicates with string literals") {
    assertParse("""f(x, "y")""", Keyword("f", Var("x"), "y"))
  }

  test("can parse predicates with number literals") {
    assertParse("f(x, 1)", Keyword("f", Var("x"), 1 : BigDecimal))
  }

  test("can parse predicates with parenthesis") {
    PredicateParser.tryParse("(f(x) and g(x))")
  }

  test("is whitespace insensitive") {
    assertParse(" ( f ( x ) ) ", Keyword("f", Var("x")))
  }

  test("can parse neq predicate") {
    val expected = Op(NEQ, Var("x"), Var("y"))
    assertParse("x <> y", expected)
    assertParse("x != y", expected)
    assertParse("x \\= y", expected)
    assertParse("x /= y", expected)
  }

  test("can parse operator predicate") {
    PredicateParser.tryParse(" x = y ")
    PredicateParser.tryParse(" x > y ")
    PredicateParser.tryParse(" x < y ")
    PredicateParser.tryParse(" x <= y ")
    PredicateParser.tryParse(" x >= y ")
  }

  test("can parse paths wih dots") {
    assertParse("f(x.y)", Keyword("f", Var("x", "y")))
  }
}