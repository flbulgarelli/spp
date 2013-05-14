package pparser;

import org.junit.Test;

public class PredicateWithExpressionParsingTest extends AbstractParsingTest {

  @Test
  public void can_parse_addition_expressions_within_operator_predicates() {
    PredicateParser.tryParse("x + y < 10");
  }

  @Test
  public void can_parse_addition_expressions_within_keyword_predicates() {
    PredicateParser.tryParse("f(x + y)");
  }


}
