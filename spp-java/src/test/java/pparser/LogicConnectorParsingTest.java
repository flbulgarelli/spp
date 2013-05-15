package pparser;

import static pparser.ast.dsl.DSL.*;

import org.junit.Test;

public class LogicConnectorParsingTest extends AbstractParsingTest {

  @Test(expected=ParseException.class)
  public void rejects_illegal_connector() throws Exception {
    PredicateParser.tryParse("f(x) ord g(y)");
  }

  
  @Test
  public void can_parse_disjunction_predicates() throws Exception {
    assertParse("f(x) or g(y)", OR(KEYWORD("f", VAR("x")), KEYWORD("g", VAR("y"))));
  }

  @Test
  public void can_parse_conjunction_predicates() throws Exception {
    assertParse("f(x) and g(y)", AND(KEYWORD("f", VAR("x")), KEYWORD("g", VAR("y"))));
  }

  
  @Test
  public void disjunction_takes_precedende_over_conjunction() throws Exception {
    assertParse("f(x) or g(x) and h(x)", //
      OR( //
        KEYWORD("f", VAR("x")), //
        AND( //
          KEYWORD("g", VAR("x")), //
          KEYWORD("h", VAR("x")))));
  }

  @Test
  public void parenthesis_change_asociativity() throws Exception {
    assertParse("f(x) and (g(x) or h(x))", //
      AND( //
        KEYWORD("f", VAR("x")), //
        OR( //
          KEYWORD("g", VAR("x")), //
          KEYWORD("h", VAR("x")))));
  }
}
