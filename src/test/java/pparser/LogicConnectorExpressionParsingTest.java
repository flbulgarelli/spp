package pparser;

import static pparser.ast.dsl.DSL.*;

import org.junit.Test;

public class LogicConnectorExpressionParsingTest extends AbstractParsingTest {

  @Test
  public void can_parse_disjunction_predicates() throws Exception {
    assertParse("f(x) ; g(y)", OR(KEYWORD("f", VAR("x")), KEYWORD("g", VAR("y"))));
  }

  @Test
  public void can_parse_conjunction_predicates() throws Exception {
    assertParse("f(x) , g(y)", AND(KEYWORD("f", VAR("x")), KEYWORD("g", VAR("y"))));
  }

  @Test
  public void disjunction_takes_precedende_over_conjunction() throws Exception {
    assertParse("f(x) ; g(x) , h(x)", //
      OR( //
        KEYWORD("f", VAR("x")), //
        AND( //
          KEYWORD("g", VAR("x")), //
          KEYWORD("h", VAR("x")))));
  }

  @Test
  public void can_parse_nested_logical_connector_predicates() throws Exception {
    PredicateParser.tryParse("f(x) , (g(x) ; h(x))");
  }
}
