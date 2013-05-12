package pparser;

import static net.sf.staccatocommons.numbers.Numbers.d;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import pparser.ast.ASTBuilder;
import pparser.ast.Expression;

public class ParsingTest {

  @Test
  public void canParseUnaryExpressions() throws Exception {
    assertParse("f(x)", Expression.from("f", Path.from("x")));
  }

  @Test
  public void canParseBinaryExpressions() throws Exception {
    assertParse("f(x, y)", Expression.from("f", Path.from("x"), Path.from("y")));
  }

  @Test
  public void canParseTernaryExpressions() throws Exception {
    assertParse("f(x, y, z)", Expression.from("f", Path.from("x"), Path.from("y"), Path.from("z")));
  }

  @Test
  public void canParseConjunctionExpressions() throws Exception {
    assertParse("f(x) , g(y)", Expression.from("f", Path.from("x")), Expression.from("g", Path.from("y")));
  }

  @Test
  public void canParseDisjunctionExpressions() throws Exception {
    PredicateParser.parse("f(x) ; g(y)", new ASTBuilder());
  }

  @Test
  public void canParseExpressionsWithStringLiterals() throws Exception {
    assertParse("f(x, \"y\")", Expression.from("f", Path.from("x"), "y"));
  }

  @Test
  public void canParseExpressionsWithNumberLiterals() throws Exception {
    assertParse("f(x, 1)", Expression.from("f", Path.from("x"), d(1)));
  }

  @Test
  public void canParseExpressionsWithParenthesis() throws Exception {
    assertParse("(f(x))", Expression.from("f", Path.from("x")));
  }

  @Test
  public void is_whitespace_insensitive() throws Exception {
    assertParse(" ( f ( x ) ) ", Expression.from("f", Path.from("x")));
  }

  private void assertParse(String textExpression, Expression... expressions) {
    ASTBuilder builder = new ASTBuilder();
    PredicateParser.parse(textExpression, builder);
    assertEquals(Arrays.asList(expressions), builder.build());
  }
}
