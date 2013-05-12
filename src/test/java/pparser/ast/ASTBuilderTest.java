package pparser.ast;

import static org.junit.Assert.*;
import static pparser.ast.dsl.DSL.*;
import org.junit.Test;

public class ASTBuilderTest {

  @Test
  public void when_a_predicate_is_detected_a_predicate_object_is_created() {
    ASTBuilder astBuilder = new ASTBuilder();
    astBuilder.keywordPredicate("x", null, null, null);
    assertEquals(KEYWORD("x"), astBuilder.build());
  }

  @Test
  public void when_a_logical_connector_is_detected_previous_predicates_are_connected() {
    ASTBuilder astBuilder = new ASTBuilder();
    astBuilder.keywordPredicate("x", null, null, null);
    astBuilder.keywordPredicate("y", null, null, null);
    astBuilder.andPredicate();
    assertEquals(AND(KEYWORD("x"), KEYWORD("y")), astBuilder.build());
  }

}
