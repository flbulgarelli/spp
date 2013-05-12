package pparser.ast.dsl;

import pparser.Operator;
import pparser.Path;
import pparser.ast.KeywordPredicate;
import pparser.ast.OperatorPredicate;
import pparser.ast.Predicate;

public class DSL {
  public static Predicate AND(Predicate p1, Predicate p2) {
    return null;
  }

  public static Predicate OR(Predicate p1, Predicate p2) {
    return null;
  }

  public static Predicate OP(Operator operator, Object arg0, Object arg1) {
    return OperatorPredicate.from(operator, arg0, arg1);
  }

  public static Predicate KEYWORD(String keyword, Object... args) {
    return KeywordPredicate.from(keyword, args);
  }

  public static Path VAR(String... routes) {
    return Path.from(routes);
  }

}
