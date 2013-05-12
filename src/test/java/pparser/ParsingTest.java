package pparser;

import static net.sf.staccatocommons.numbers.Numbers.d;
import static org.junit.Assert.assertEquals;
import static pparser.Operator.NEQ;

import java.util.Arrays;

import org.junit.Test;
import org.junit.experimental.theories.Theory;

import pparser.ast.ASTBuilder;
import pparser.ast.KeywordPredicate;
import pparser.ast.OperatorPredicate;
import pparser.ast.Predicate;

public class ParsingTest {

  @Test
  public void can_parse_unary_predicates() throws Exception {
    assertParse("f(x)", KeywordPredicate.from("f", Path.from("x")));
  }

  @Test
  public void can_parse_binary_keyword_predicates() throws Exception {
    assertParse("f(x, y)", KeywordPredicate.from("f", Path.from("x"), Path.from("y")));
  }

  @Test
  public void can_parse_ternary_predicates() throws Exception {
    assertParse("f(x, y, z)", KeywordPredicate.from("f", Path.from("x"), Path.from("y"), Path.from("z")));
  }

  @Test
  public void can_parse_conjunction_predicates() throws Exception {
    assertParse("f(x) , g(y)", KeywordPredicate.from("f", Path.from("x")), KeywordPredicate.from("g", Path.from("y")));
  }

  @Test
  public void can_parse_disjunction_predicates() throws Exception {
    PredicateParser.parse("f(x) ; g(y)", new ASTBuilder());
  }

  @Test
  public void can_parse_predicates_with_string_literals() throws Exception {
    assertParse("f(x, \"y\")", KeywordPredicate.from("f", Path.from("x"), "y"));
  }

  @Test
  public void can_parse_predicates_with_number_literals() throws Exception {
    assertParse("f(x, 1)", KeywordPredicate.from("f", Path.from("x"), d(1)));
  }

  @Test
  public void can_parse_predicates_with_parenthesis() throws Exception {
    assertParse("(f(x) , g(x) )", KeywordPredicate.from("f", Path.from("x")));
  }

  @Test
  public void is_whitespace_insensitive() throws Exception {
    assertParse(" ( f ( x ) ) ", KeywordPredicate.from("f", Path.from("x")));
  }
  
  @Theory
  public void can_parse_neq_predicate() throws Exception {
    assertParse("x <> y", OperatorPredicate.from(NEQ, Path.from("x"), Path.from("y")));
    assertParse("x != y", OperatorPredicate.from(NEQ, Path.from("x"), Path.from("y")));
  }
  
  @Test
  public void supports_operator_predicate() throws Exception {
    PredicateParser.tryParse(" x = y ");
    PredicateParser.tryParse(" x > y ");
    PredicateParser.tryParse(" x < y ");
    PredicateParser.tryParse(" x <= y ");
    PredicateParser.tryParse(" x >= y ");
    PredicateParser.tryParse(" x <> y ");
    PredicateParser.tryParse(" x != y ");
  }

  private void assertParse(String textExpression, Predicate ... predicates) {
    ASTBuilder builder = new ASTBuilder();
    PredicateParser.parse(textExpression, builder);
    assertEquals(Arrays.asList(predicates), builder.build());
  }
}
