package pparser;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

  @Test
  public void canParseUnaryExpressions() throws Exception {
    PredicateParser.parse("f(x)", new DummyEventHandler());
  }

  @Test
  public void canParseBinaryExpressions() throws Exception {
    PredicateParser.parse("f(x, y)", new DummyEventHandler());
  }

  @Test
  public void canParseTernaryExpressions() throws Exception {
    PredicateParser.parse("f(x, y, z)", new DummyEventHandler());
  }

  @Test
  public void canParseConjunctionExpressions() throws Exception {
    PredicateParser.parse("f(x), g(y)", new DummyEventHandler());
  }

  @Test
  public void canParseDisjunctionExpressions() throws Exception {
    PredicateParser.parse("f(x) ; g(y)", new DummyEventHandler());
  }

  @Test
  public void canParseExpressionsWithStringLiterals() throws Exception {
    PredicateParser.parse("f(x, 'y')", new DummyEventHandler());
  }
  
  @Test
  public void canParseExpressionsWithNumberLiterals() throws Exception {
    PredicateParser.parse("f(x, 1)", new DummyEventHandler());
  }
  
  
}
