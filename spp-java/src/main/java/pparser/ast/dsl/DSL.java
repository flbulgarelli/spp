package pparser.ast.dsl;

import java.math.BigDecimal;

import pparser.ExpressionOperator;
import pparser.PredicateOperator;
import pparser.ast.ASTElement;
import pparser.ast.AndPredicate;
import pparser.ast.Expression;
import pparser.ast.IdPredicate;
import pparser.ast.KeywordPredicate;
import pparser.ast.NumberExpression;
import pparser.ast.OperatorExpression;
import pparser.ast.OperatorPredicate;
import pparser.ast.OrPredicate;
import pparser.ast.Path;
import pparser.ast.StringExpression;

/**
 * Small DSL for creating AST elements in a convenient manner
 * 
 * @author flbulgarelli
 */
public class DSL {
  
  public static Expression LIT(Number value) {
    return new NumberExpression(new BigDecimal(value.toString()));
  }
  
  public static Expression LIT(String value) {
    return new StringExpression(value);
  }
  
  public static ASTElement AND(ASTElement p1, ASTElement p2) {
    return new AndPredicate(p1, p2);
  }

  public static ASTElement OR(ASTElement p1, ASTElement p2) {
    return new OrPredicate(p1, p2);
  }
  
  public static ASTElement OP(ExpressionOperator operator, Expression arg0, Expression arg1) {
    return new OperatorExpression(operator, arg0, arg1);
  }

  public static ASTElement OP(PredicateOperator operator, ASTElement arg0, ASTElement arg1) {
    return new OperatorPredicate(operator, arg0, arg1);
  }

  public static ASTElement KEYWORD(String keyword, ASTElement ... args) {
    return KeywordPredicate.from(keyword, args);
  }

  public static Path VAR(String... routes) {
    return Path.from(routes);
  }
  
  public static ASTElement ID(Path path) {
    return new IdPredicate(path);
  }

}
