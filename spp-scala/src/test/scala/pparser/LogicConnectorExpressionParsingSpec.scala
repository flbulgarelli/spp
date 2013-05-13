package pparser
import ast._
import org.scalatest.FunSuite

class LogicConnectorExpressionParsingSpec extends FunSuite with ParsingAssertions {

  test("can parse disjunction predicates") {
    assertParse("f(x) or g(y)", Or(Keyword("f", Var("x")), Keyword("g", Var("y"))))
  }

  test("can parse conjunction predicates") {
    assertParse("f(x) and g(y)", And(Keyword("f", Var("x")), Keyword("g", Var("y"))))
  }

  test("disjunction takes precedende over conjunction") {
    assertParse("f(x) or g(x) and h(x)",
      Or(
        Keyword("f", Var("x")),
        And(
          Keyword("g", Var("x")),
          Keyword("h", Var("x")))))
  }

  test("parenthesis change asociativity") {
    assertParse("f(x) and (g(x) or h(x))",
      And(
        Keyword("f", Var("x")),
        Or(
          Keyword("g", Var("x")),
          Keyword("h", Var("x")))))
  }
}