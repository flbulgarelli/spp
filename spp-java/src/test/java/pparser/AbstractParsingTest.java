package pparser;

import static org.junit.Assert.*;
import pparser.ast.ASTBuilder;
import pparser.ast.Predicate;
import pparser.value.ValuesFactoryImpl;

public class AbstractParsingTest {
  protected void assertParse(String textExpression, Predicate predicate) {
    ASTBuilder builder = new ASTBuilder();
    PredicateParser.parse(textExpression, new ValuesFactoryImpl(), builder);
    assertEquals(predicate, builder.build());
  }

}
