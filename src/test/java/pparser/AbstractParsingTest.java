package pparser;

import static org.junit.Assert.*;
import pparser.ast.ASTBuilder;
import pparser.ast.Predicate;

public class AbstractParsingTest {
  protected void assertParse(String textExpression, Predicate predicate) {
    ASTBuilder builder = new ASTBuilder();
    PredicateParser.parse(textExpression, builder);
    assertEquals(predicate, builder.build());
  }

}
