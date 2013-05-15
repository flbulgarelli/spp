package pparser.ast.dsl;

import java.math.BigDecimal;

import pparser.ExpressionOperator;
import pparser.PredicateOperator;
import pparser.ast.ASTElement;
import pparser.ast.AndPredicate;
import pparser.ast.Expression;
import pparser.ast.IdPredicate;
import pparser.ast.KeywordPredicate;
import pparser.ast.NumberLiteral;
import pparser.ast.OperatorExpression;
import pparser.ast.OperatorPredicate;
import pparser.ast.OrPredicate;
import pparser.ast.Path;
import pparser.ast.Predicate;
import pparser.ast.StringLiteral;

/**
 * Small DSL for creating AST elements in a convenient manner
 * 
 * @author flbulgarelli
 */
public class DSL {

  public static Expression LIT(Number value) {
    return new NumberLiteral(new BigDecimal(value.toString()));
  }

  public static Expression LIT(String value) {
    return new StringLiteral(value);
  }

  public static Predicate AND(Predicate p1, Predicate p2) {
    return new AndPredicate(p1, p2);
  }

  public static Predicate OR(Predicate p1, Predicate p2) {
    return new OrPredicate(p1, p2);
  }

  public static Expression OP(ExpressionOperator operator, Expression arg0, Expression arg1) {
    return new OperatorExpression(operator, arg0, arg1);
  }

  public static Predicate OP(PredicateOperator operator, Expression arg0, Expression arg1) {
    return new OperatorPredicate(operator, arg0, arg1);
  }

  public static Predicate KEYWORD(String keyword, Expression... args) {
    return KeywordPredicate.from(keyword, args);
  }

  public static Path VAR(String... routes) {
    return Path.from(routes);
  }

  public static ASTElement ID(Path path) {
    return new IdPredicate(path);
  }

}
