package pparser;

import static pparser.Operator.*;
import static pparser.ast.dsl.DSL.*;

import org.junit.Test;

import pparser.ast.AndPredicate;
import pparser.ast.KeywordPredicate;
import pparser.ast.OperatorPredicate;
import pparser.ast.OrPredicate;
import pparser.ast.PredicateVisitor;

public class VisitorTest {

  @Test
  public void testName() throws Exception {
    AND(OR(OP(GT, 1, VAR("z")), OP(EQ, VAR("y"), 4)), KEYWORD("f", VAR("x"))).accept(
      new PredicateVisitor<Void>() {
        public Void visit(KeywordPredicate predicate) {
          System.out.print(predicate.getKeyword() + "(" + ")");
          return null;
        }

        public Void visit(OperatorPredicate predicate) {
          System.out.print(predicate.getArg0() + " " + predicate.getOperator() + " " + predicate.getArg1());
          return null;
        }

        public Void visit(AndPredicate andPredicate) {
          System.out.print("(");
          andPredicate.getArg0().accept(this);
          System.out.print(" and ");
          andPredicate.getArg1().accept(this);
          System.out.print(")");
          return null;
        }

        public Void visit(OrPredicate orPredicate) {
          System.out.print("(");
          orPredicate.getArg0().accept(this);
          System.out.print(" or ");
          orPredicate.getArg1().accept(this);
          System.out.print(")");
          return null;
        }
      });
  }

}
