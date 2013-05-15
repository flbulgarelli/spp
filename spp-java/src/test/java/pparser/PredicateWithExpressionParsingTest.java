package pparser;

import org.junit.Test;

import static org.junit.Assert.*;
import static pparser.PredicateOperator.*;
import static pparser.ExpressionOperator.*;
import static pparser.ast.dsl.DSL.*;

public class PredicateWithExpressionParsingTest extends AbstractParsingTest {

  @Test(expected = IllegalArgumentException.class)
  public void rejects_expresions_as_predicates() {
    PredicateParser.tryParse("x + y");
  }

  @Test
  public void can_parse_predicates_plus_within_operator_expression() {
    assertParse("x + y < 10", OP(LT, OP(PLUS, VAR("x"), VAR("y")), LIT(10)));
  }
  
  @Test
  public void can_parse_operator_expressions_within_operator_predicates() {
    PredicateParser.tryParse("x - y < 10");
    PredicateParser.tryParse("x * y < 10");
    PredicateParser.tryParse("x / y < 10");
  }
  
  @Test
  public void can_parse_plus_expressions_within_keyword_predicates() {
    assertParse("f(x + y)", KEYWORD("f", OP(PLUS, VAR("x"), VAR("y"))));
  }

  @Test
  public void can_parse_operator_expressions_within_keyword_predicates() {
    PredicateParser.tryParse("f(x * y)");
    PredicateParser.tryParse("f(x / y)");
    PredicateParser.tryParse("f(x - y)");
  }

  @Test
  public void can_parse_complex_expressions() {
    PredicateParser.tryParse(" x + y * 2 - 2 = 3");
  }

}
