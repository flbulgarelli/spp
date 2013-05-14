package pparser.ast.dsl;

import java.math.BigDecimal;

import pparser.Operator;
import pparser.ast.ASTElement;
import pparser.ast.AndPredicate;
import pparser.ast.IdPredicate;
import pparser.ast.KeywordPredicate;
import pparser.ast.NumberExpression;
import pparser.ast.OperatorPredicate;
import pparser.ast.OrPredicate;
import pparser.ast.StringExpression;
import pparser.value.Path;

/**
 * Small DSL for creating AST elements in a convenient manner
 * 
 * @author flbulgarelli
 */
public class DSL {
  
  public static ASTElement LIT(Number value) {
    return new NumberExpression(new BigDecimal(value.toString()));
  }
  
  public static ASTElement LIT(String value) {
    return new StringExpression(value);
  }
  
  public static ASTElement AND(ASTElement p1, ASTElement p2) {
    return new AndPredicate(p1, p2);
  }

  public static ASTElement OR(ASTElement p1, ASTElement p2) {
    return new OrPredicate(p1, p2);
  }

  public static ASTElement OP(Operator operator, ASTElement arg0, ASTElement arg1) {
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
