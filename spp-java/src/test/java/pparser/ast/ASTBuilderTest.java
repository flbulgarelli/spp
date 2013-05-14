package pparser.ast;

import static org.junit.Assert.*;
import static pparser.ast.dsl.DSL.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ASTBuilderTest {

  @Test
  public void when_a_predicate_is_detected_a_predicate_object_is_created() {
    ASTBuilder astBuilder = new ASTBuilder();
    astBuilder.numberExpression(BigDecimal.valueOf(2));
    astBuilder.numberExpression(BigDecimal.valueOf(3));
    astBuilder.keywordPredicate("x", 2);
    assertEquals(KEYWORD("x", LIT(2), LIT(3)), astBuilder.build());
  }

  @Test
  public void when_a_logical_connector_is_detected_previous_predicates_are_connected() {
    ASTBuilder astBuilder = new ASTBuilder();
    astBuilder.stringExpression("m");
    astBuilder.keywordPredicate("x", 1);
    astBuilder.stringExpression("n");
    astBuilder.keywordPredicate("y", 1);
    astBuilder.andPredicate();
    assertEquals(AND(KEYWORD("x", LIT("m")), KEYWORD("y", LIT("n"))), astBuilder.build());
  }

}
