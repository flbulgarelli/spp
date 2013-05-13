package pparser.ast

import org.scalatest.FunSuite

class AstBuilderSpec extends FunSuite {

  test("when a predicate is detected a predicate object is created") {
    val astBuilder = new ASTBuilder()
    astBuilder.keywordPredicate("x", null, null, null)
    assert(Keyword("x") === astBuilder.build)
  }

  test("when a logical connector is detected previous predicates are connected") {
    val astBuilder = new ASTBuilder()
    astBuilder.keywordPredicate("x", null, null, null)
    astBuilder.keywordPredicate("y", null, null, null)
    astBuilder.andPredicate()
    assert(And(Keyword("x"), Keyword("y")) === astBuilder.build)
  }
}