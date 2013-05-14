package pparser;

import static org.junit.Assert.*;
import pparser.ast.ASTBuilder;
import pparser.ast.ASTElement;
import pparser.value.ValuesFactoryImpl;

public class AbstractParsingTest {
  protected void assertParse(String textExpression, ASTElement predicate) {
    ASTBuilder builder = new ASTBuilder();
    PredicateParser.parse(textExpression, new ValuesFactoryImpl(), builder);
    assertEquals(predicate, builder.build());
  }

}
