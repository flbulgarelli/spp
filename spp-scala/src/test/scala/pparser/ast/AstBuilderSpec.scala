package pparser.ast

import org.scalatest.FunSuite
class AstBuilderSpec extends FunSuite {

  test("when a predicate is detected a predicate object is created") {
    val astBuilder = new ASTBuilder()
    astBuilder.numberExpression(2 : BigDecimal)
    astBuilder.numberExpression(3 :BigDecimal )
    astBuilder.keywordPredicate("x", 2)
    assert(Keyword("x", 2, 3) === astBuilder.build)
  }

  test("when a logical connector is detected previous predicates are connected") {
    val astBuilder = new ASTBuilder()
    astBuilder.stringExpression("m")
    astBuilder.keywordPredicate("x", 1)
    astBuilder.stringExpression("n")
    astBuilder.keywordPredicate("y", 1)
    astBuilder.andPredicate()
    assert(And(Keyword("x", "m"), Keyword("y", "n")) === astBuilder.build)
  }
  
  

}