package pparser

import pparser.ast.ASTBuilder
import pparser.ast.Predicate
import pparser.ast.ASTBuilder
import org.scalatest.FunSuite
import org.scalatest.Assertions
import pparser.value.ValuesFactoryImpl

trait ParsingAssertions extends Assertions {
  def assertParse(textExpression: String, predicate: Predicate) {
    val builder = new ASTBuilder()
    PredicateParser.parse(textExpression, ValuesFactoryImpl, builder)
    assert(predicate === builder.build)
  }
}