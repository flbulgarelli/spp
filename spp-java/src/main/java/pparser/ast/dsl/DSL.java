package pparser.ast.dsl;

import pparser.Operator;
import pparser.ast.AndPredicate;
import pparser.ast.KeywordPredicate;
import pparser.ast.OperatorPredicate;
import pparser.ast.OrPredicate;
import pparser.ast.Predicate;
import pparser.value.Path;

public class DSL {
  public static Predicate AND(Predicate p1, Predicate p2) {
    return new AndPredicate(p1, p2);
  }

  public static Predicate OR(Predicate p1, Predicate p2) {
    return new OrPredicate(p1, p2);
  }

  public static Predicate OP(Operator operator, Object arg0, Object arg1) {
    return new OperatorPredicate(operator, arg0, arg1);
  }

  public static Predicate KEYWORD(String keyword, Object... args) {
    return KeywordPredicate.from(keyword, args);
  }

  public static Path VAR(String... routes) {
    return Path.from(routes);
  }

}
