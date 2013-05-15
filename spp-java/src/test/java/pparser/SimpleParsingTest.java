package pparser;

import static pparser.PredicateOperator.*;
import static pparser.ast.dsl.DSL.*;

import org.junit.Test;

import pparser.ast.ASTElement;

public class SimpleParsingTest extends AbstractParsingTest {

  @Test
  public void can_parse_id_predicates()  {
    assertParse("x", ID(VAR("x")));
  }
  
  @Test
  public void can_parse_id_predicates_with_dots()  {
    assertParse("x.y", ID(VAR("x", "y")));
  }
  
  @Test
  public void can_parse_unary_predicates()  {
    assertParse("f(x)", KEYWORD("f", VAR("x")));
  }

  @Test
  public void can_parse_binary_keyword_predicates()  {
    assertParse("f(x, y)", KEYWORD("f", VAR("x"), VAR("y")));
  }

  @Test
  public void can_parse_ternary_predicates()  {
    assertParse("f(x, y, z)", KEYWORD("f", VAR("x"), VAR("y"), VAR("z")));
  }

  @Test
  public void can_parse_predicates_with_string_literals()  {
    assertParse("f(x, \"y\")", KEYWORD("f", VAR("x"), LIT("y")));
  }

  @Test
  public void can_parse_predicates_with_number_literals()  {
    assertParse("f(x, 1)", KEYWORD("f", VAR("x"), LIT(1)));
  }

  @Test
  public void can_parse_predicates_with_parenthesis()  {
    PredicateParser.tryParse("(f(x) and g(x))");
  }

  @Test
  public void is_whitespace_insensitive()  {
    assertParse(" ( f ( x ) ) ", KEYWORD("f", VAR("x")));
  }

  @Test
  public void can_parse_neq_predicate()  {
    ASTElement expected = OP(NEQ, VAR("x"), VAR("y"));
    assertParse("x <> y", expected);
    assertParse("x != y", expected);
    assertParse("x \\= y", expected);
    assertParse("x /= y", expected);
  }

  @Test
  public void can_parse_operator_predicate()  {
    PredicateParser.tryParse(" x = y ");
    PredicateParser.tryParse(" x > y ");
    PredicateParser.tryParse(" x < y ");
    PredicateParser.tryParse(" x <= y ");
    PredicateParser.tryParse(" x >= y ");
  }
  
  @Test
  public void can_parse_paths_wih_dots()  {
    assertParse("f(x.y)", KEYWORD("f", VAR("x", "y")));
  }


}
