package pparser;

import static net.sf.staccatocommons.numbers.Numbers.*;
import static pparser.Operator.*;
import static pparser.ast.dsl.DSL.*;

import org.junit.Test;

import pparser.ast.Predicate;

public class SimpleExpressionParsingTest extends AbstractParsingTest {

  @Test
  public void can_parse_unary_predicates() throws Exception {
    assertParse("f(x)", KEYWORD("f", VAR("x")));
  }

  @Test
  public void can_parse_binary_keyword_predicates() throws Exception {
    assertParse("f(x, y)", KEYWORD("f", VAR("x"), VAR("y")));
  }

  @Test
  public void can_parse_ternary_predicates() throws Exception {
    assertParse("f(x, y, z)", KEYWORD("f", VAR("x"), VAR("y"), VAR("z")));
  }

  @Test
  public void can_parse_predicates_with_string_literals() throws Exception {
    assertParse("f(x, \"y\")", KEYWORD("f", VAR("x"), "y"));
  }

  @Test
  public void can_parse_predicates_with_number_literals() throws Exception {
    assertParse("f(x, 1)", KEYWORD("f", VAR("x"), d(1)));
  }

  @Test
  public void can_parse_predicates_with_parenthesis() throws Exception {
    PredicateParser.tryParse("(f(x) , g(x))");
  }

  @Test
  public void is_whitespace_insensitive() throws Exception {
    assertParse(" ( f ( x ) ) ", KEYWORD("f", VAR("x")));
  }

  @Test
  public void can_parse_neq_predicate() throws Exception {
    Predicate expected = OP(NEQ, VAR("x"), VAR("y"));
    assertParse("x <> y", expected);
    assertParse("x != y", expected);
    assertParse("x \\= y", expected);
    assertParse("x /= y", expected);
  }

  @Test
  public void supports_operator_predicate() throws Exception {
    PredicateParser.tryParse(" x = y ");
    PredicateParser.tryParse(" x > y ");
    PredicateParser.tryParse(" x < y ");
    PredicateParser.tryParse(" x <= y ");
    PredicateParser.tryParse(" x >= y ");
  }


}
